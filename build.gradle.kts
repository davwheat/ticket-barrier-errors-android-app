plugins {
  alias(libs.plugins.androidApplication) apply false
  alias(libs.plugins.kotlinAndroid) apply false
  id("com.diffplug.spotless") version "6.25.0"
}

spotless {
  java {
    target("app/src/**/*.java", "data/src/**/*.java")
    googleJavaFormat("1.22.0").reflowLongStrings()
    formatAnnotations()
  }

  kotlin {
    target("app/src/**/*.kt", "data/src/**/*.kt")
    ktfmt("0.54").kotlinlangStyle()
  }
}
