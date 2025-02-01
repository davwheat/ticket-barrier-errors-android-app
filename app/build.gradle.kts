import java.io.FileInputStream
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.util.Date
import java.util.Properties

plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
}

val versionMajor = 2
val versionMinor = 1
val versionPatch = 0

fun getBuildNumber(): Int {
  val df = SimpleDateFormat("yyyyMMdd")
  val date = LocalDateTime.now()
  val seconds =
    (Duration.between(date.withSecond(0).withMinute(0).withHour(0), date).seconds / 86400.0) * 99.0
  val twoDigitSuffix = seconds.toInt()

  return Integer.parseInt(df.format(Date()) + String.format("%02d", twoDigitSuffix))
}

android {
  namespace = "dev.davwheat.railway.gateline_errors"
  compileSdk = 35

  defaultConfig {
    applicationId = "dev.davwheat.railway.gateline_errors"
    minSdk = 24
    targetSdk = 35
    versionCode = getBuildNumber()
    versionName = "$versionMajor.$versionMinor.$versionPatch"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables { useSupportLibrary = true }
  }

  signingConfigs {
    create("release") {
      val properties = Properties()
      properties.load(FileInputStream(project.rootProject.file("local.properties")))

      storeFile = file(properties.getProperty("signing.storeFilePath"))
      storePassword = properties.getProperty("signing.storePassword")
      keyAlias = properties.getProperty("signing.keyAlias")
      keyPassword = properties.getProperty("signing.keyPassword")
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
      isDebuggable = false

      manifestPlaceholders["sentryEnvironment"] = "production"
    }

    debug {
      signingConfig = signingConfigs.getByName("debug")
      isDebuggable = true
      applicationIdSuffix = ".debug"

      manifestPlaceholders["sentryEnvironment"] = "development"
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions { jvmTarget = "1.8" }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  composeOptions { kotlinCompilerExtensionVersion = "1.5.1" }
  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies {
  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))

  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.material3)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)

  implementation(libs.timber)

  implementation(libs.play.services.ads)
  implementation(libs.ump.user.messaging.platform)
}
