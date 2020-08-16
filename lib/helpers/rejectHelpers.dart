import '../data/codeData.dart';
import '../models/RejectCode.dart';

Rejection getRejectByCodeString(String code) {
  Rejection r;

  r = allRejectCodes.firstWhere(
    (rej) => rej.code == code,
    orElse: () => null,
  );

  return r;
}

Rejection getRejectByCodeInt(int code) {
  Rejection r;

  r = allRejectCodes.firstWhere(
    (rej) => rej.codeInteger == code,
    orElse: () => null,
  );

  return r;
}
