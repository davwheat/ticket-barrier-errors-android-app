package dev.davwheat.railway.gateline_errors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import dev.davwheat.railway.gateline_errors.composable.MainUi
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme
import java.util.concurrent.atomic.AtomicBoolean
import timber.log.Timber

class MainActivity : ComponentActivity() {
    private lateinit var consentInformation: ConsentInformation
    private var isMobileAdsInitializeCalled = AtomicBoolean(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            var showAds by rememberSaveable { mutableStateOf(false) }

            LaunchedEffect(true) {
                obtainAdsConsent {
                    Timber.d("Ads consent obtained")
                    showAds = true
                }
            }

            AppTheme { MainUi(modifier = Modifier, showAds = showAds) }
        }
    }

    private fun obtainAdsConsent(callback: () -> Unit) {
        val params = ConsentRequestParameters.Builder().setTagForUnderAgeOfConsent(false).build()

        consentInformation = UserMessagingPlatform.getConsentInformation(this)
        consentInformation.requestConsentInfoUpdate(
            this,
            params,
            {
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(this@MainActivity) {
                    loadAndShowError ->
                    // Consent gathering failed.
                    Timber.w(
                        String.format(
                            "%s: %s",
                            loadAndShowError?.errorCode,
                            loadAndShowError?.message,
                        )
                    )

                    // Consent has been gathered.
                    initializeMobileAdsSdk(callback)
                }
            },
            { requestConsentError ->
                // Consent gathering failed.
                Timber.w(
                    String.format(
                        "%s: %s",
                        requestConsentError.errorCode,
                        requestConsentError.message,
                    )
                )
            },
        )

        if (consentInformation.canRequestAds()) {
            initializeMobileAdsSdk(callback)
        }
    }

    private fun initializeMobileAdsSdk(callback: () -> Unit) {
        if (isMobileAdsInitializeCalled.getAndSet(true)) {
            callback()
            return
        }

        // Initialize the Google Mobile Ads SDK.
        MobileAds.initialize(this)

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(
                    if (BuildConfig.DEBUG) listOf("077F865A83D45A5C09CB4C8C845ADCA1") else null
                )
                .build()
        )

        callback()
    }
}
