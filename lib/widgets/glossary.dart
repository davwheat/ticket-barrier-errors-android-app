import 'package:flutter/material.dart';

List<Map<String, String>> glossaryData = [
  {
    "code": "DDDD",
    "meaning": "Destination station code",
  },
  {
    "code": "OOOO",
    "meaning": "Origin station code",
  },
  {
    "code": "DDMMYY",
    "meaning": "Date",
  },
  {
    "code": "FFFF",
    "meaning": "Fare",
  },
  {
    "code": "LLLL",
    "meaning": "London Underground station code",
  },
  {
    "code": "PP",
    "meaning": "Passenger type",
  },
  {
    "code": "PZ",
    "meaning": "Ticket pass zone",
  },
  {
    "code": "RR",
    "meaning": "Special rule number",
  },
  {
    "code": "TTTT",
    "meaning": "Ticket type",
  },
  {
    "code": "YY",
    "meaning": "London Underground ticket type",
  },
  {
    "code": "XX",
    "meaning": "National Rail ticket type",
  },
];

class NRKeyGlossary extends StatelessWidget {
  const NRKeyGlossary({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Card(
        elevation: 2,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(8),
        ),
        child: Padding(
          padding: EdgeInsets.fromLTRB(24, 16, 24, 16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    child: Icon(Icons.info_outline),
                    padding: EdgeInsets.only(right: 8),
                  ),
                  Flexible(
                    child: Text(
                      "For error codes above 100, the key below applies.",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
              ListView.builder(
                shrinkWrap: true,
                physics: NeverScrollableScrollPhysics(),
                itemCount: 11,
                padding: EdgeInsets.only(top: 16),
                itemBuilder: (BuildContext context, int index) {
                  return Container(
                    padding: EdgeInsets.symmetric(vertical: 2),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        Text(
                          glossaryData[index]["code"],
                          style: TextStyle(fontFamily: "VT323", fontSize: 18),
                        ),
                        Flexible(
                          child: Text(
                            glossaryData[index]["meaning"],
                          ),
                        ),
                      ],
                    ),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
