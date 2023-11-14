package dev.davwheat.railway.gateline_errors.models

enum class ActionByStaff {

  NONE,
  TO_TICKET_OFFICE,
  IRREG_TRAVEL,
  TOP_UP_CARD,
  HELPDESK,
  CHECK_CARD,
  ALTN_PAYMENT,
  REFER_CARD_ISSUER,
  TRY_AGAIN,
  TRY_AGAIN_CARD,
  TRY_AGAIN_ONE_CARD,
  CHECK_RCI,
  CONTACT_CTS,
  DISABLE_TEST_MODE,
  REPLACE_TICKET,
  REPLACE_ITSO_CARD,
  REPRESENT_ONE_CARD,
  SEEK_ASSISTANCE,
  TFL_CHECK_JOURNEY_HISTORY,
  USE_OTHER,
  CHECK_VALIDITY_THEN_TO;

  override fun toString(): String {
    return when (this) {
      TO_TICKET_OFFICE -> "Refer to ticket office or seek assistance"
      IRREG_TRAVEL -> "Suspicious or irregular travel - seek assistance from staff"
      TOP_UP_CARD -> "Top up Oyster or smartcard PAYG balance"
      HELPDESK -> "Refer to helpdesk"
      CHECK_CARD -> "Manually check card validity"
      ALTN_PAYMENT -> "Use alternative payment method"
      REFER_CARD_ISSUER -> "Refer to card issuer"
      TRY_AGAIN -> "Try again or seek assistance"
      TRY_AGAIN_CARD -> "Represent card"
      TRY_AGAIN_ONE_CARD -> "Represent only one card"
      CHECK_RCI -> "Check RCI list - seek assistance"
      CONTACT_CTS ->
        "Seek assistance - Staff: contact the Cubic Transportation Systems Report Centre"

      DISABLE_TEST_MODE -> "Disable test mode - seek assistance"
      REPLACE_TICKET -> "Replace ticket - seek assistance"
      REPLACE_ITSO_CARD -> "You need a replacement smartcard - seek assistance"
      REPRESENT_ONE_CARD -> "Represent one card only"
      SEEK_ASSISTANCE -> "Seek assistance from a member of staff"
      TFL_CHECK_JOURNEY_HISTORY -> "TfL: check journey history at tfl.gov.uk"
      USE_OTHER -> "Use another card or ticket"
      CHECK_VALIDITY_THEN_TO -> "Ensure the ticket is not valid, then see ticket office"
      NONE -> "No action needed"
    }
  }
}
