import 'Actions.dart';

class Rejection {
  String _code;
  int _codeInteger;
  String _textCode;

  String _definition;

  String _helpText;
  Action _actionByStaff;
  String _actionText;

  String get code => _code;
  int get codeInteger => _codeInteger;
  String get textCode => _textCode;
  String get definition => _definition;
  String get helpText => _helpText;
  String get actionByStaff => actionToString(_actionByStaff);
  String get actionText => _actionText;

  Rejection(
    this._code, {
    String textCode = "",
    String definition = "",
    String helpText = "",
    Action action = Action.NONE,
  }) {
    this._codeInteger = int.tryParse(_code);
    assert(this.codeInteger != null);

    this._textCode = textCode;
    this._definition = definition;
    this._helpText = helpText;
    this._actionByStaff = action;
  }
}
