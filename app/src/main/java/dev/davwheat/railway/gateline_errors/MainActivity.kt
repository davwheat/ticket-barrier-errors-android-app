package dev.davwheat.railway.gateline_errors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import dev.davwheat.railway.gateline_errors.composable.AdmobBanner
import dev.davwheat.railway.gateline_errors.composable.ErrorCodeDisplay
import dev.davwheat.railway.gateline_errors.composable.ErrorCodeEntry
import dev.davwheat.railway.gateline_errors.composable.NrValidationGlossary
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean

class MainActivity : ComponentActivity() {
  private lateinit var consentInformation: ConsentInformation
  private var isMobileAdsInitializeCalled = AtomicBoolean(false)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      var errorCodeEntry by rememberSaveable { mutableStateOf("") }
      var showAds by rememberSaveable { mutableStateOf(false) }

      var adHeight by remember { mutableIntStateOf(0) }
      val adHeightDp = with(LocalDensity.current) { adHeight.toDp() }

      val intErrorCode =
          try {
            errorCodeEntry.toInt()
          } catch (e: NumberFormatException) {
            null
          }

      LaunchedEffect(true) {
        obtainAdsConsent {
          Timber.d("Ads consent obtained")
          showAds = true
        }
      }

      AppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
          Box(modifier = Modifier.safeDrawingPadding()) {
            Column(
                modifier =
                    Modifier.fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = 24.dp,
                            top = 24.dp,
                            end = 24.dp,
                            bottom = 24.dp + adHeightDp,
                        ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
              ErrorCodeEntry(
                  modifier = Modifier.fillMaxWidth(),
                  value = errorCodeEntry,
                  onInput = { text -> errorCodeEntry = text },
              )
              ErrorCodeDisplay(
                  modifier = Modifier.fillMaxWidth(),
                  errorCode = errorCodeEntry,
              )

              AnimatedVisibility(
                  visible = (intErrorCode ?: -1) >= 100,
                  enter = fadeIn() + expandVertically(),
                  exit = fadeOut() + shrinkVertically(),
              ) {
                NrValidationGlossary()
              }
            }

            if (showAds) {
              AdmobBanner(
                  modifier =
                      Modifier.fillMaxWidth().align(Alignment.BottomCenter).onGloballyPositioned {
                        adHeight = it.size.height
                      },
              )
            }
          }
        }
      }
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
                String.format("%s: %s", loadAndShowError?.errorCode, loadAndShowError?.message))

            // Consent has been gathered.
            initializeMobileAdsSdk(callback)
          }
        },
        { requestConsentError ->
          // Consent gathering failed.
          Timber.w(
              String.format("%s: %s", requestConsentError.errorCode, requestConsentError.message))
        })

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
                if (BuildConfig.DEBUG)
                    listOf(
                        "077F865A83D45A5C09CB4C8C845ADCA1",
                    )
                else null,
            )
            .build(),
    )

    callback()
  }
}
