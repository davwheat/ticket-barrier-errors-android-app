enum Action {
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
}

String actionToString(Action action) {
  if (action == Action.TO_TICKET_OFFICE)
    return "Refer to ticket office or seek assistance";
  else if (action == Action.IRREG_TRAVEL)
    return "Suspicious or irregular travel - seek assistance";
  else if (action == Action.TOP_UP_CARD)
    return "Top up Oyster or Smartcard PAYG balance";
  else if (action == Action.HELPDESK)
    return "Refer to helpdesk";
  else if (action == Action.CHECK_CARD)
    return "Manually check card validity";
  else if (action == Action.ALTN_PAYMENT)
    return "Use alternative payment method";
  else if (action == Action.REFER_CARD_ISSUER)
    return "Refer to card issuer";
  else if (action == Action.TRY_AGAIN)
    return "Try again or seek assistance";
  else if (action == Action.TRY_AGAIN_CARD)
    return "Represent card";
  else if (action == Action.TRY_AGAIN_ONE_CARD)
    return "Present only one card";
  else if (action == Action.CHECK_RCI)
    return "Check RCI list - seek assistance";
  else if (action == Action.CONTACT_CTS)
    return "Seek assistance - Staff: contact the Cubic Transportation Systems Report Centre";
  else if (action == Action.DISABLE_TEST_MODE)
    return "Disable test mode - seek assistance";
  else if (action == Action.REPLACE_TICKET)
    return "Replace ticket - seek assistance";
  else if (action == Action.REPLACE_ITSO_CARD)
    return "You need a replacement Smartcard - seek assistance";
  else if (action == Action.REPRESENT_ONE_CARD)
    return "Represent one card only";
  else if (action == Action.SEEK_ASSISTANCE)
    return "Seek assistance from a member of staff";
  else if (action == Action.NONE)
    return "No action needed";
  else
    return null;
}
