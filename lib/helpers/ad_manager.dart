import 'dart:io';

import 'package:flutter/foundation.dart';

class AdManager {
  static String get appId {
    if (Platform.isAndroid) {
      return "<YOUR_ANDROID_ADMOB_APP_ID>";
    } else if (Platform.isIOS) {
      return "<YOUR_IOS_ADMOB_APP_ID>";
    } else {
      throw new UnsupportedError("Unsupported platform");
    }
  }

  static String get bannerAdUnitId {
    if (Platform.isAndroid) {
      if (kDebugMode) {
        // TEST AD ID
        return "ca-app-pub-3940256099942544/6300978111";
      }

      // REAL AD ID
      return "ca-app-pub-2701335557132384/6293742813";
    } else {
      return "";
    }
  }

  // static String get interstitialAdUnitId {
  //   if (Platform.isAndroid) {
  //     return "<YOUR_ANDROID_INTERSTITIAL_AD_UNIT_ID>";
  //   } else if (Platform.isIOS) {
  //     return "<YOUR_IOS_INTERSTITIAL_AD_UNIT_ID>";
  //   } else {
  //     throw new UnsupportedError("Unsupported platform");
  //   }
  // }

  // static String get rewardedAdUnitId {
  //   if (Platform.isAndroid) {
  //     return "<YOUR_ANDROID_REWARDED_AD_UNIT_ID>";
  //   } else if (Platform.isIOS) {
  //     return "<YOUR_IOS_REWARDED_AD_UNIT_ID>";
  //   } else {
  //     throw new UnsupportedError("Unsupported platform");
  //   }
  // }
}
