package dev.davwheat.railway.gateline_errors.data

import dev.davwheat.railway.gateline_errors.models.ActionByStaff
import dev.davwheat.railway.gateline_errors.models.Rejection

val ErrorCodes =
  listOf(
    Rejection(
      "00",
      textCode = "Unknown",
      definition = "Valid ticket/smartcard",
      laymansReason = "You've got a perfectly valid ticket. Woohoo!",
      helpText = "Your ticket is valid for entry/exit through this gateline.",
    ),
    Rejection(
      "01",
      textCode = "BAD TABLE",
      definition = "Gateline error: invalid table data",
      laymansReason =
      "It's not you, it's them. The ticket barrier you're using is faulty.",
      helpText = "This gateline has a faulty database.",
      action = ActionByStaff.CONTACT_CTS,
    ),
    Rejection(
      "02",
      textCode = "TYPE/DIR",
      definition = "Wrong ticket type or direction",
      laymansReason =
      "Are you using a platform ticket? These can often only be used once, on one platform or set of platforms only.",
      helpText =
      "Your ticket is invalid for entry/exit through this gateline. Are you entering the wrong platform?",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "03",
      textCode = "TYPE OOR",
      definition = "Ticket type out of table's range",
      laymansReason =
      "It's not you, it's them. The ticket barrier you're using doesn't understand your ticket type. This is fairly common, especially if you're using uncommon tickets such as 'super off-peak' or rovers.",
      helpText =
      "Your ticket type isn't in the barrier's database of valid ticket types.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "04",
      textCode = "CHK ERROR",
      definition = "Gateline error: check table error",
      laymansReason =
      "It's not you, it's them. This ticket barrier has a faulty database.",
      helpText = "This gateline has a fault.",
      action = ActionByStaff.CONTACT_CTS,
    ),
    Rejection(
      "05",
      textCode = "TEST MODE",
      definition =
      "Underground: customer ticket inserted while gate in test mode.\n\nOther: Test mode ticket inserted.",
      helpText =
      "The gateline is set to testing mode which refuses real transport tickets.",
      action = ActionByStaff.DISABLE_TEST_MODE,
    ),
    Rejection(
      "06",
      textCode = "NOT TST MD",
      definition =
      "Underground: test ticket/smartcard inserted while gate not in test mode.\n\nOther: Engineer signed on.",
      helpText = "Your ticket isn't valid for travel because it is a test ticket.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "07",
      textCode = "UNREAD TK",
      definition = "Ticket magnetic code unreadable",
      helpText =
      "Ticket's magnetic strip couldn't be read. Did you insert the ticket the right way round?",
      action = ActionByStaff.TRY_AGAIN,
    ),
    Rejection(
      "08",
      textCode = "VRF FAIL",
      definition = "Ticket re-coding error",
      helpText =
      "Something went wrong when updating info on your ticket. Try again or seek assistance for a ticket replacement.",
      action = ActionByStaff.REPLACE_TICKET,
    ),
    Rejection(
      "09",
      textCode = "INVAL CHK",
      definition = "Ticket code read error",
      helpText =
      "Ticket magnetic strip unreadable. Ticket is usually bent, demagnetised or corrupted. Seek assistance to get it replaced.",
      action = ActionByStaff.REPLACE_TICKET,
    ),
    Rejection(
      "10",
      textCode = "Unknown",
      definition = "Carnet validated",
      helpText = "Your carnet ticket was successfully validated.",
    ),
    Rejection(
      "11",
      textCode = "DATE EXP",
      definition = "Ticket/card expired",
      helpText = "Your ticket has expired. Buy a new one at a ticket machine/office.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "12",
      textCode = "TIME O DAY",
      definition = "Ticket not yet valid",
      helpText =
      "Ticket isn't valid at this time of day. E.g. trying to use a freedom pass before 9 AM.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "13",
      textCode = "EXCESS",
      definition = "Additional fare due/excess to pay",
      helpText =
      "You might need to pay an extra charge as you're travelling beyond the validity of your ticket (exiting/entering during peak with an off-peak ticket).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "14",
      textCode = "HR NO ACC",
      definition = "Ticket not valid and no applicable excess charge",
      helpText =
      "Your ticket isn't valid and there's no applicable excess fee to charge you.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "15",
      textCode = "NO ON VAL",
      definition = "No onward validity",
      helpText =
      "Your ticket isn't valid and there's no applicable excess fee to charge you.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "16",
      textCode = "OUT ZONE",
      definition = "Card/ticket not valid in this zone",
      helpText = "Your ticket isn't valid in this travel zone.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "17",
      textCode = "NOT ISS HR",
      definition = "Ticket not issued here",
      helpText = "You're trying to use a platform ticket issued at another station.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "18",
      textCode = "INVAL STN",
      definition = "Card/ticket not valid at this station",
      helpText =
      "You're trying to use a station permit which was issued at another station.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "19",
      textCode = "NOT YET VL",
      definition = "Ticket used before start date",
      helpText = "Your ticket isn't valid yet. Check the travel date on your ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "20",
      textCode = "EXPIRED",
      definition = "Card/ticket expired",
      helpText = "Your Oyster, smartcard or ticket has expired. Please renew it.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "21",
      textCode = "DOUBLE ENT",
      definition = "Double entry attempted",
      laymansReason =
      "Your smartcard has already been used to enter this station recently. Have you tapped in more than once?",
      helpText = "Your Oyster or smartcard has already touched in.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "22",
      textCode = "DOUBLE EXI",
      definition = "Double exit attempted",
      laymansReason =
      "Your smartcard has already been used to exit at this station recently. Have you tapped out more than once?",
      helpText = "Your Oyster or smartcard has already touched out.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "23",
      textCode = "CARNET NVL",
      definition = "Carnet ticket not validated",
      helpText =
      "Your carnet ticket wasn't put though a ticket machine at the start of your journey, meaning it wasn't validated.",
    ),
    Rejection(
      "24",
      textCode = "LOW SV-NZ1",
      definition = "Low PAYG balance - with non-Zone 1 prepaid ticket",
      helpText =
      "Your Oyster or smartcard was used for a journey not covered by its prepaid ticket, and were charged for a PAYG fare bringing your card into a negative balance.",
      action = ActionByStaff.TOP_UP_CARD,
    ),
    Rejection(
      "25",
      textCode = "NOT ENTERD",
      definition = "Unstarted journey",
      helpText =
      "You didn't touch in at the start of your journey or the touch in failed.",
      action = ActionByStaff.TFL_CHECK_JOURNEY_HISTORY,
    ),
    Rejection(
      "26",
      textCode = "SM ENT EXT",
      definition = "Entry and exit at same station",
      laymansReason =
      "You've tapped in and out at the same station within a short amount of time. Did you decide not to travel?",
      helpText = "You touched in and touched out at the same station.",
      action = ActionByStaff.TFL_CHECK_JOURNEY_HISTORY,
    ),
    Rejection(
      "27",
      textCode = "TNP DIS ZN",
      definition = "PAYG disabled in this zone",
      helpText = "PAYG isn't enabled for this zone/gateline.",
      action = ActionByStaff.USE_OTHER,
    ),
    Rejection(
      "28",
      textCode = "SV DISBLD",
      definition = "PAYG capability disabled.",
      helpText = "Cannot add PAYG to this Oyster or smartcard.",
      action = ActionByStaff.USE_OTHER,
    ),
    Rejection(
      "29",
      textCode = "PPT DISBLD",
      definition = "Prepaid ticket disabled",
      helpText =
      "Cannot add your prepaid ticket (travelcard, season, etc.) to this Oyster or smartcard.",
      action = ActionByStaff.USE_OTHER,
    ),
    Rejection(
      "30",
      textCode = "CARD DIS",
      definition = "Oyster or smartcard disabled",
      laymansReason =
      "Have you reported your smartcard lost/stolen and found it again? You'll need to get a replacement as the other smartcard will have been deactivated.",
      helpText =
      "This Oyster or smartcard has been disabled as it's been reported lost, stolen, it was misused, the payment card is due to expire, or an auto top-up has failed.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "31",
      textCode = "F INV OSI",
      definition = "Illogical validation at out of station interchange.",
      helpText = "Seek assistance.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "32",
      textCode = "TO INV OSI",
      definition = "Illogical validation at out of station interchange.",
      helpText = "Seek assistance.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "33",
      textCode = "ILLOG OSI",
      definition = "Illogical validation at out of station interchange.",
      helpText = "Seek assistance.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "34",
      textCode = "EXT DISALL",
      definition = "Exit not allowed - PAYG not validated on journey.",
      helpText = "Seek assistance.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "35",
      textCode = "LOW SV-Z1",
      definition = "Low PAYG balance - with Zone 1 prepaid ticket",
      helpText =
      "Your Oyster or smartcard was used for a journey not covered by its prepaid ticket, and were charged for a PAYG fare bringing your card into a negative balance.",
      action = ActionByStaff.TOP_UP_CARD,
    ),
    Rejection(
      "36",
      textCode = "LOW SV",
      definition = "Insufficient PAYG credit",
      laymansReason =
      "Not expecting to see a low balance? Check your journey history at a ticket machine. You might have been charged for an incomplete journey if you've forgotten to tap in or out.",
      helpText =
      "Your Oyster or smartcard has a negative or insufficient balance and you have no valid prepaid ticket. Please top up before beginning your journey.",
      action = ActionByStaff.TOP_UP_CARD,
    ),
    Rejection(
      "37",
      textCode = null,
      definition = "Oyster photocard expired",
      helpText = "Your Oyster photocard has expired, so you cannot make a journey.",
      action = ActionByStaff.USE_OTHER,
    ),
    Rejection(
      "38",
      textCode = null,
      definition = "Insufficient PAYG credit",
      laymansReason =
      "Not expecting to see a low balance? Check your journey history at a ticket machine. You might have been charged for an incomplete journey if you've forgotten to tap in or out.",
      helpText =
      "Your Oyster or smartcard has a negative or insufficient balance and you have no valid prepaid ticket. Please top up before beginning your journey.",
      action = ActionByStaff.TOP_UP_CARD,
    ),
    Rejection(
      "40",
      textCode = null,
      definition = "Invalid contactless card",
      helpText =
      "Your contactless payment card isn't valid for travel. Contact your card issuer to check whether it's compatible for use on TfL services.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "41",
      textCode = "PASSB THRU",
      definition = "Pass back through",
      laymansReason =
      "If you touch in and out a few times at a station within a short amount of time, the barriers won't let you through as they think you might be handing the ticket back to other people.",
      helpText =
      "Attempt to touch in after a touch in and and touch out at the same station, or attempt to touch out after a touch out and touch in at the same station.",
    ),
    Rejection(
      "42",
      textCode = "PASSB OVER",
      definition = "Pass back",
      laymansReason =
      "If you touch in and out a few times at a station within a short amount of time, the barriers won't let you through as they think you might be handing the ticket back to other people.\n\nUsing Interail? Unless the ticket barriers have been explicitly set up for this (which they've probably not been), you'll see this error when scanning your pass's barcode. Show your ticket to a member of staff instead.",
      helpText =
      "Oyster or smartcard just used in the same direction at the same station.",
    ),
    Rejection(
      "43",
      textCode = "INVAL PSNG",
      definition = "Invalid passenger count",
      laymansReason =
      "For some reason, your smartcard has become corrupted, meaning you'll need a replacement smartcard. Contact the company you got it from to get a new one.",
      helpText =
      "Smartcard total passenger count is not equal to 1. Possible corrupted smartcard.",
      action = ActionByStaff.REPLACE_ITSO_CARD,
    ),
    Rejection(
      "44",
      textCode = "NO RIDES",
      definition =
      "ITSO: There are no rides remaining on an IPE where that IPE is the only valid IPE on the card",
      laymansReason =
      "There's no valid ticket on your smartcard. Any loaded tickets are either no longer valid",
      helpText = "No valid smartcard ticket. Check your loaded tickets.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "45",
      textCode = "INVAL IPE",
      definition = "ITSO: Invalid IPE field value",
      helpText =
      "Corrupt loaded ticket. Try reloading onto your smartcard, or order a replacement card.",
      action = ActionByStaff.REPLACE_ITSO_CARD,
    ),
    Rejection(
      "46",
      textCode = "INVAL ENTL",
      definition =
      "ITSO: Valid Entitlement on card doesn't provide Free travel (needs STR to go with it)",
      helpText = "Corrupted smartcard. Order a replacement card.",
      action = ActionByStaff.REPLACE_ITSO_CARD,
    ),
    Rejection(
      "47",
      textCode = "IPE SEAL",
      definition = "ITSO: IPE Seal Error",
      helpText = "Corrupted smartcard. Order a replacement card.",
      action = ActionByStaff.REPLACE_ITSO_CARD,
    ),
    Rejection(
      "48",
      textCode = "IPE ICHANGE",
      definition = "ITSO: Too long on interchange",
      helpText = "You took too long to make your interchange.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "49",
      textCode = "IPE TR TL",
      definition = "ITSO: Too long on tram-rail interchange",
      helpText = "You took too long to make your interchange between tram and rail.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "50",
      textCode = "IPE TR NA",
      definition = "ITSO: Tram-rail interchange not allowed here",
      helpText = "Interchanges between tram and rail at this station are not allowed.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "51",
      textCode = "ALREADY USED",
      definition = "Ticket has already been used",
      helpText =
      "You have already used this ticket. (e.g. you're trying to use a single twice)",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "52",
      textCode = "BLACK PASS",
      definition = "Blacklisted staff pass",
      helpText =
      "This is a lost/stolen staff pass. Return it to a ticket office immediately.",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "53",
      textCode = "BLACK PERM",
      definition = "Blacklisted travel permit",
      helpText =
      "This is a lost/stolen travel permit. Return it to a ticket office immediately.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "54",
      textCode = "ENIGMA",
      definition =
      "Valid ticket, but for a journey shorter than that travelled OR Cancelled due to use before start date",
      helpText = "You've travelled further than your ticket is valid for.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "55",
      textCode = "USED JOURN",
      definition = "Already used",
      helpText = "Your ticket has already been used for travel.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "56",
      textCode = "OUTOFTERM",
      definition = "Scholar Pass out of term",
      helpText =
      "Your student pass cannot be used outside of school term dates. Please buy a valid ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "57",
      textCode = "PPT INVLD",
      definition = "Prepaid ticket not valid",
      helpText = "Station not covered by prepaid ticket (season, travelcard, etc.).",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "58",
      textCode = "ITSO ZONES",
      definition = "ITSO: Insufficient Zones",
      helpText =
      "You haven't got enough zones on your Oyster or smartcard to begin/complete this journey.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "60",
      textCode = "ITSO OSI",
      definition = "ITSO: Too long on OSI",
      helpText =
      "Too long at interchange (too long spent changing stations during journey).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "61",
      textCode = "LONG OSI",
      definition = "Too long at interchange",
      helpText =
      "Too long at interchange (too long spent changing stations during journey).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "62",
      textCode = "LONG JOURN",
      definition = "Too long on journey",
      helpText = "Too long on journey (too long between journey start and end).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "63",
      textCode = "LONG PLAT",
      definition = "Too long on platform",
      helpText =
      "Too long on platform (too long spent on platform, with a platform ticket).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "64",
      textCode = "LONG XCESS",
      definition = "Too long on excess",
      helpText =
      "Too long on excess (too long between journey start and end, for which the excess fee applied).",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "65",
      textCode = "ENT TIM XC",
      definition = "Entry time exceeded",
      helpText = "You haven't passed though the gateline in time for your ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "67",
      textCode = "CPC DECLINE",
      definition = "Payment card declined",
      helpText = "Contactless payment was declined.",
      action = ActionByStaff.HELPDESK,
    ),
    Rejection(
      "69",
      textCode = "CPC DECLINE",
      definition = "Payment card declined",
      helpText = "Contactless payment was declined.",
      action = ActionByStaff.HELPDESK,
    ),
    Rejection(
      "70",
      textCode = "PRSNTN ERR",
      definition = "Unspecified Oyster/smartcard",
      helpText = "Card not read/processed correctly.",
      action = ActionByStaff.TRY_AGAIN_ONE_CARD,
    ),
    Rejection(
      "71",
      textCode = "TOO MANY",
      definition = "Card clash - multiple cards detected",
      helpText = "Multiple Oyster cards, smartcards, or contactless cards detected.",
      action = ActionByStaff.REPRESENT_ONE_CARD,
    ),
    Rejection(
      "72",
      textCode = null,
      definition = "Contactless mobile device error",
      helpText = "Check your mobile device to ensure it can be used for travel.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "73",
      textCode = "EMERG INV",
      definition = "Emergency not valid here",
      helpText = "Ticket returned for emergency use not valid at this station",
    ),
    Rejection(
      "74",
      textCode = "CARD BLOCK",
      definition = "Payment card is blocked by transport authority",
      helpText =
      "TfL have blocked this contactless payment card, likely due to a failed payment. You'll need to contact TfL to use this payment card again.",
      action = ActionByStaff.HELPDESK,
    ),
    Rejection(
      "75",
      textCode = "OYST UNSUP",
      definition = "Oyster card capability unsupported",
      helpText = "Oyster cards are not supported at this gateline/station.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "76",
      textCode = "PAYC UNSUP",
      definition = "Contactless payment unsupported",
      helpText =
      "Contactless payments are not supported at this gateline/station. Check tfl.gov.uk/contactless to check if your card type is supported.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "77",
      textCode = "ITSO UNSUP",
      definition = "ITSO: ITSO smartcard capability unsupported",
      helpText = "smartcards are not supported at this gateline/station.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "78",
      textCode = "UNKN PCARD",
      definition = "Unknown payment card type",
      helpText =
      "Contactless payment card type not recognised. Try again, or contact your card issuer.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "79",
      textCode = "VAL FAIL",
      definition = "Payment card validation failure",
      helpText =
      "Make sure you're holding your card flat against the validator. If it still doesn't work, contact your card issuer.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "80",
      textCode = "ISSR BLOCK",
      definition = "Payment card blocked by issuer",
      helpText =
      "Your card issuer declined your last transaction. Contact your card issuer for more information.",
      action = ActionByStaff.REFER_CARD_ISSUER,
    ),
    Rejection(
      "81",
      textCode = "GROSS OVER",
      definition = "Illogical use of ticket",
      helpText = "",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "82",
      textCode = "INV HIST",
      definition = "Illogical use of ticket",
      helpText = "Invalid journey history.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "83",
      textCode = "INV TIME",
      definition = "Illogical use of ticket",
      helpText = "Invalid time.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "84",
      textCode = "INV GEOG",
      definition = "Invalid geography",
      helpText = "",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "85",
      textCode = "PCARD EXPD",
      definition = "Contactless payment card expired",
      helpText = "Your payment card has expired.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "86",
      textCode = "AID BIN",
      definition = "Payment Card has an invalid AID or BIN",
      helpText = "Invalid payment card.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "87",
      textCode = "TXN TIMOUT",
      definition = "Contactless Payment transaction timeout",
      helpText = "Transaction timed out.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "88",
      textCode = "WRONG TYPE",
      definition = "Wrong system type",
      helpText = "",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "89",
      textCode = "CARD TYPE",
      definition = "Unknown card type",
      helpText = "Presented card type not recognised.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "90",
      textCode = "REJECT MON",
      definition = "Rejecting monitored tickets",
      helpText =
      "Nothings wrong with your ticket. Sometimes ticket types are added to a list of those to be monitored (manually validated). This can often be the case with railcard tickets where a valid railcard and/or photocard should be checked.",
    ),
    Rejection(
      "91",
      textCode = "NOTYET VAL",
      definition = "Contactless Payment Card not yet valid",
      helpText = "Contactless payment card isn't valid yet. Use another payment card.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "92",
      textCode = "CARD DIR",
      definition = "Card directory corrupt",
      helpText =
      "Oyster/smartcard/Payment card corrupted or failed to read correctly. Try again.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "93",
      textCode = "CARD CONT",
      definition = "Card contents corrupt",
      helpText =
      "Oyster/smartcard/Payment card corrupted or failed to read correctly. Try again.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "94",
      textCode = "CARD COMMS",
      definition = "Card read failed",
      helpText =
      "Reading of card failed. Did you remove it before the green light showed?",
      action = ActionByStaff.TRY_AGAIN_CARD,
    ),
    Rejection(
      "95",
      textCode = "PROC FAIL",
      definition = "Contactless payment processing failed",
      helpText =
      "Payment might be declined. Use another payment method and contact your bank.",
      action = ActionByStaff.ALTN_PAYMENT,
    ),
    Rejection(
      "96",
      textCode = "RDR INIT",
      definition = "Card reader initialisation failed",
      helpText = "Try again or use another barrier.",
      action = ActionByStaff.TRY_AGAIN_CARD,
    ),
    Rejection(
      "97",
      textCode = "REM EARLY",
      definition = "Payment card removed too early",
      helpText = "You removed your contactless card too early.",
      action = ActionByStaff.TRY_AGAIN_CARD,
    ),
    Rejection(
      "98",
      textCode = "AUTH REQD",
      definition = "Payment card needs online authorisation",
      helpText = "Contact your card issuer to learn more information.",
      action = ActionByStaff.REFER_CARD_ISSUER,
    ),
    Rejection(
      "99",
      textCode = "CHK TIME",
      definition =
      "Payment card processing or magnetic stripe ticket check took too long",
      helpText = "Try again or use another gateline.",
      action = ActionByStaff.TRY_AGAIN,
    ),
    Rejection(
      "100",
      textCode = "DELIVERY",
      definition = "Ticket issued in delivery mode",
      helpText = "Your ticket isn't valid for travel.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "101",
      textCode = "TECH",
      definition = "Ticket issued in technician mode",
      helpText = "Your ticket isn't valid for travel.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "102",
      textCode = "TRAINING",
      definition = "Ticket issued in training mode",
      helpText = "Your ticket isn't valid for travel.",
      laymansReason =
      "This ticket was printed by a ticket office, but the machine was in training mode, which is usually used to teach new staff members how to use the system.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "103",
      textCode = "BAD TDATA",
      definition = "Ticket had invalid data",
      helpText = "Your ticket has invalid data. Ask a ticket office for a replacement",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "105",
      textCode = "XX INV",
      definition = "Invalid rail ticket type",
      helpText = "Your ticket type is invalid.",
      laymansReason =
      "The ticket barrier you're using doesn't understand your ticket type. This is fairly common, especially if you're using less common tickets such as 'super off-peak' or rangers/rovers.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "106",
      textCode = "XX REJECT",
      definition = "Always to be rejected",
      helpText =
      "Something about your ticket is set to always be rejected by the barriers.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "107",
      textCode = "XX TTTT",
      definition = "Time restraint applied to this ticket type",
      helpText =
      "You're attempting to pass through the barriers with a time limited ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "108",
      textCode = "PP TTTT",
      definition = "Time restraint applied to this passenger type",
      helpText =
      "You're attempting to pass through the barriers with a time limited ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "109",
      textCode = "XX TTTT",
      definition =
      "Time restraint specified by London Underground data on your National Rail ticket",
      helpText =
      "You're attempting to pass through the barriers with a time limited ticket.",
      laymansReason =
      "Some tickets are restricted to certain times of day, such as off-peak. " +
              "Ask at a ticket office for the time restrictions on your ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "111",
      textCode = "XX ZONES",
      definition = "National Rail ticket not valid in this zone",
      helpText =
      "Your ticket is not valid in your current zone. Buy a new ticket at the ticket office.",
      laymansReason =
      "Some London tickets are limited to specific zones (e.g. 1-3, 1-6, or 1-9). " +
              "Are you trying to pass through the barriers outside one of these zones?",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "112",
      textCode = "XX DDMMYY",
      definition = "Single/return ticket not valid until date shown",
      helpText = "Your ticket is not valid yet. Buy a new ticket at the ticket office.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "113",
      textCode = "XX DDMMYY",
      definition = "Single/return ticket not valid after date shown",
      helpText =
      "Your season/rover ticket has expired. Check the date on your ticket and/or buy a new one at a ticket office.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "114",
      textCode = "XX DDMMYY",
      definition = "Season/rover ticket not valid until date shown",
      helpText =
      "Your season/rover ticket is not valid yet. Check the date on your ticket and/or buy a new one at a ticket office.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "115",
      textCode = "XX DDMMYY",
      definition = "Season/rover ticket not valid after date shown",
      helpText =
      "Your season/rover ticket has expired. Check the date on your ticket and/or buy a new one at a ticket office.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "116",
      textCode = "XX OOOO",
      definition = "Station not listed for entry/exit with this National Rail ticket",
      helpText = "Your ticket cannot be used for travel to/from this station.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "117",
      textCode = "XX DDMMYY",
      definition = "National Rail ticket ceased to be valid after date shown",
      helpText =
      "Your ticket cannot be used for travel anymore. Please buy a new ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "118",
      textCode = "XX DDMMYY",
      definition = "National Rail ticket is not valid until date shown",
      helpText = "Your ticket cannot be used for travel yet. Please buy another ticket.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "119",
      textCode = "XX DDMMYY",
      definition = "National Rail pass is not valid until date shown",
      helpText = "Your pass cannot be used for travel yet.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "120",
      textCode = "XX DDMMYY",
      definition = "National Rail pass expired on date shown",
      helpText = "Your pass cannot be used for travel anymore: it has expired.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "121",
      textCode = "XX PZ",
      definition = "National Rail pass is not valid here",
      helpText = "Your pass cannot be used at this station or zone.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "122",
      textCode = "XX YY",
      definition = "London Underground ticket not valid here",
      helpText = "Your London Underground ticket, or ticket with London Underground validity, cannot be used to travel on National Rail services at this location.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "123",
      textCode = "XX ROUTE",
      definition = "National Rail ticket prohibits travel via this station",
      helpText =
      "Travel via this station isn't allowed with your ticket. Check your ticket for a URL to see the restrictions for travel.",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "124",
      textCode = "PP PASNGR",
      definition = "National Rail",
      helpText =
      "Your London Underground ticket cannot be used to travel on National Rail services.",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "125",
      textCode = "XX DDDD",
      definition = "National Rail ticket cannot be used to exit here",
      helpText = "This station isn't a permitted destination for your ticket. If you're breaking your journey, you might inadvertently see this error.",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "126",
      textCode = "XX OOOO",
      definition = "National Rail ticket cannot be used to enter here",
      helpText = "This station isn't a permitted origin for your ticket. If you're breaking your journey, you might inadvertently see this error.",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "127",
      textCode = "XX DDMMYY",
      definition = "National Rail ticket not valid today",
      helpText = "The validity period of your ticket doesn't include today's date. If a validity easement is in place due to industrial action or a 'Do Not Travel' warning, this won't be followed by ticket barriers.",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "128",
      textCode = "XX LLLL",
      definition = "Ticket valid at London Underground stations only",
      helpText = "Your ticket can only be used at London Underground stations.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "129",
      textCode = "XX",
      definition = "National Rail ticket wrong direction",
      helpText =
      "Your ticket isn't valid for travel in this direction. Are you using the wrong set of barriers?",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "130",
      textCode = "XX SSSS",
      definition = "Ticket valid at London Underground stations only",
      helpText =
      "Your ticket can only be used at London Underground stations.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "131",
      textCode = "XX FFFF",
      definition = "National Rail ticket has insufficient fare",
      helpText =
      "Meaning unknown. Maybe travelled too far, with an off-peak ticket during peak, or a fake ticket?",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "132",
      textCode = "XX",
      definition = "London Underground route",
      helpText = "Meaning unknown.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "133",
      textCode = "XX TTTT",
      definition = "Ticket pass-back prevention",
      helpText = "This ticket was just used in this direction. Are you being naughty?",
      action = ActionByStaff.IRREG_TRAVEL,
    ),
    Rejection(
      "134",
      textCode = "XX DDMMYY",
      definition = "Expired ticket",
      laymansReason =
      "If you ticket still appears in-date, your cross-London transfer may have been used prior to this date or you've already " +
              "started your journey on a previous day, which confuses some barriers. Seek assistance from staff if this is the case.",
      helpText = "Your ticket has expired.",
      action = ActionByStaff.CHECK_VALIDITY_THEN_TO,
    ),
    Rejection(
      "135",
      textCode = "XX RR",
      definition = "National Rail ticket/smartcard special rules",
      laymansReason = "Some train operators set their gatelines to reject all tickets of a certain type or with a particular discount. This is common to impose \"Railcard blocks\" for manual verification of your discount.",
      helpText = "The gateline has been told to reject your ticket despite it likely being valid in order to perform a manual check.",
      action = ActionByStaff.SEEK_ASSISTANCE,
    ),
    Rejection(
      "136",
      textCode = "XX TTTT",
      definition = "National Rail ticket direction of travel time restriction",
      helpText =
      "You can't travel with this ticket type in this direction at this time. Are you trying to use a railcard discounted ticket during peak?",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
    Rejection(
      "137",
      textCode = "XX TTTT",
      definition = "National Rail passenger type direction of travel time restriction",
      helpText =
      "You can't travel with this ticket type in this direction at this time. Are you trying to use a railcard discounted ticket during peak?",
      action = ActionByStaff.TO_TICKET_OFFICE,
    ),
  )
    .associateBy { it.integerCode }
