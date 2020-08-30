import 'package:flutter/material.dart';

import '../helpers/rejectHelpers.dart';
import '../models/RejectCode.dart';
import '../themes/typography.dart';

class GatelineCodeInfo extends StatelessWidget {
  GatelineCodeInfo(this.code, {Key key}) : super(key: key);

  final int code;

  @override
  Widget build(BuildContext context) {
    Rejection gatelineRejection;
    bool isValidCode;

    if (this.code != -1) {
      gatelineRejection = getRejectByCodeInt(this.code);
    } else {
      gatelineRejection = null;
    }

    if (gatelineRejection == null) {
      isValidCode = false;
    } else {
      isValidCode = true;
    }

    if (this.code == -1) {
      return Card(
        elevation: 2,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(8),
        ),
        child: Container(
          padding: EdgeInsets.fromLTRB(24, 16, 24, 16),
          width: double.infinity,
          child: Text(
            "Enter any gateline error code in the box above.",
            textAlign: TextAlign.center,
          ),
        ),
      );
    }

    if (!isValidCode) {
      return Card(
        elevation: 2,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(8),
        ),
        child: Container(
          padding: EdgeInsets.fromLTRB(24, 16, 24, 16),
          width: double.infinity,
          child: Text(
            "Code $code isn't in our database at the moment.",
            textAlign: TextAlign.center,
          ),
        ),
      );
    }

    return Container(
      child: Card(
        elevation: 2,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(8),
        ),
        child: Padding(
          padding: EdgeInsets.fromLTRB(24, 16, 24, 16),
          child: Column(
            children: <Widget>[
              Container(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: <Widget>[
                    Flexible(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: <Widget>[
                          Text(
                            "Seek assistance " + gatelineRejection.code,
                            style: InfoDataMonoTextTheme.apply(
                              fontSizeFactor: 1.5,
                              color: Color(0xFF456144),
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.only(top: 8),
                            child: Text(
                              "Text Error",
                              style:
                                  InfoTitleTextTheme.apply(heightFactor: 0.9),
                            ),
                          ),
                          Text(
                            gatelineRejection.textCode,
                            style: InfoDataMonoTextTheme.apply(
                              color: Color(0xFF456144),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: <Widget>[
                  Flexible(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Text(
                          "Definition",
                          style: InfoTitleTextTheme,
                        ),
                        Text(
                          gatelineRejection.definition ?? "Unknown",
                          style: InfoDataTextTheme,
                        ),
                      ],
                    ),
                  ),
                ],
              ),
              Padding(
                padding: EdgeInsets.only(top: 12),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: <Widget>[
                    Flexible(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text(
                            "Explanation",
                            style: InfoTitleTextTheme,
                          ),
                          Text(
                            gatelineRejection.helpText ?? "Unknown",
                            style: InfoDataTextTheme,
                            softWrap: true,
                          ),
                        ],
                      ),
                    )
                  ],
                ),
              ),
              (gatelineRejection.laymansReason != null
                  ? Padding(
                      padding: EdgeInsets.only(top: 12),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.start,
                        children: <Widget>[
                          Flexible(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: <Widget>[
                                Text(
                                  "Possible reason(s)",
                                  style: InfoTitleTextTheme,
                                ),
                                Text(
                                  gatelineRejection.laymansReason,
                                  style: InfoDataTextTheme,
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    )
                  : SizedBox.shrink()),
              Padding(
                padding: EdgeInsets.only(top: 12),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: <Widget>[
                    Flexible(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text(
                            "Action needed",
                            style: InfoTitleTextTheme,
                          ),
                          Text(
                            gatelineRejection.actionByStaff ?? "None",
                            style: InfoDataTextTheme,
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
