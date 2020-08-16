import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import '../widgets/codeInfo.dart';
import '../widgets/glossary.dart';

class EnterGatelineCodePage extends StatefulWidget {
  EnterGatelineCodePage({Key key}) : super(key: key);

  @override
  _EnterGatelineCodePageState createState() => _EnterGatelineCodePageState();
}

class _EnterGatelineCodePageState extends State<EnterGatelineCodePage> {
  final _formKey = GlobalKey<FormState>();

  int _code;

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    int c = _code ?? -1;
    GatelineCodeInfo codeInfo = GatelineCodeInfo(c);

    return Scaffold(
      appBar: AppBar(
        title: Text("Gateline Errors"),
      ),
      body: Container(
        width: double.infinity,
        height: double.infinity,
        child: SingleChildScrollView(
          clipBehavior: Clip.antiAliasWithSaveLayer,
          physics: BouncingScrollPhysics(),
          child: Padding(
            padding: EdgeInsets.all(12),
            child: Column(
              children: <Widget>[
                Card(
                  elevation: 2,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  child: Padding(
                    padding: EdgeInsets.fromLTRB(24, 16, 24, 16),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: <Widget>[
                        Form(
                          key: _formKey,
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              TextFormField(
                                maxLength: 3,
                                onChanged: (value) {
                                  try {
                                    int code = int.parse(value);

                                    setState(() {
                                      this._code = code;
                                    });
                                  } catch (e) {
                                    if (value == "") {
                                      // set code to -1 when field is empty
                                      setState(() {
                                        this._code = -1;
                                      });
                                    }
                                  }
                                },
                                decoration:
                                    InputDecoration(hintText: "Gateline code"),
                                autocorrect: false,
                                keyboardType: TextInputType.numberWithOptions(
                                  signed: false,
                                  decimal: false,
                                ),
                                inputFormatters: [
                                  WhitelistingTextInputFormatter.digitsOnly
                                ],
                                autofocus: true,
                              )
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
                codeInfo,
                c >= 100 ? NRKeyGlossary() : SizedBox.shrink(),
              ],
            ),
          ),
        ),
      ),

      // floatingActionButton: FloatingActionButton(
      //   onPressed: () {},
      //   tooltip: 'Increment',
      //   child: Icon(Icons.add),
      // ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
