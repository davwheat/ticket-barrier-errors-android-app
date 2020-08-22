import 'package:firebase_admob/firebase_admob.dart';
import 'package:flutter/material.dart';
import 'package:gateline_errors/helpers/ad_manager.dart';
import 'screens/enterCode.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    _initAdMob();

    return MaterialApp(
      title: 'Gateline Errors',
      theme: ThemeData(
        primarySwatch: Colors.orange,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: FutureBuilder<void>(
        future: _initAdMob(),
        builder: (
          BuildContext context,
          AsyncSnapshot<void> snapshot,
        ) {
          if (snapshot.hasData) {
            return Scaffold(
              appBar: AppBar(
                title: Text("Gateline Errors"),
              ),
              body: EnterGatelineCodePage(),
            );
          } else {
            return Scaffold(
              appBar: AppBar(
                title: Text("Gateline Errors"),
              ),
              body: Center(
                child: SizedBox(
                  child: CircularProgressIndicator(),
                  width: 48,
                  height: 48,
                ),
              ),
            );
          }
        },
      ),
    );
  }

  Future<void> _initAdMob() {
    return FirebaseAdMob.instance.initialize(appId: AdManager.appId);
  }
}
