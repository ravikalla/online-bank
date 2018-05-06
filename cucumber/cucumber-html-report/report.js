$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CheckingsAccountActivities.feature");
formatter.feature({
  "line": 1,
  "name": "Check money deposited can be withdrawn from Checkings account in all possible cases",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Check if the money deposited can be withdrawn from CheckingsAccount in all positive scenarios",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Checkings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of \u003cDepositAmount\u003e dollars in CheckingsAccount",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from CheckingsAccount",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in CheckingsAccount",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "DepositAmount",
        "WithdrawAmount",
        "RemainingAmount"
      ],
      "line": 12,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;1"
    },
    {
      "cells": [
        "1700.00",
        "1000",
        "500",
        "2200.00"
      ],
      "line": 13,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;2"
    },
    {
      "cells": [
        "2200.00",
        "1000000",
        "0",
        "1002200.00"
      ],
      "line": 14,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;3"
    },
    {
      "cells": [
        "1002200.00",
        "1000",
        "5000",
        "998200.00"
      ],
      "line": 15,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;4"
    },
    {
      "cells": [
        "998200.00",
        "0",
        "998200.00",
        "0.00"
      ],
      "line": 16,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 172690113,
  "status": "passed"
});
formatter.before({
  "duration": 12440448,
  "status": "passed"
});
formatter.before({
  "duration": 13095083,
  "status": "passed"
});
formatter.before({
  "duration": 10928766,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Check if the money deposited can be withdrawn from CheckingsAccount in all positive scenarios",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Checkings account is 1700.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 500 dollars from CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 2200.00 dollars in CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 157608156,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1700.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 1184405645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 187876561,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 75054152,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2200.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 99813590,
  "status": "passed"
});
formatter.before({
  "duration": 14592456,
  "status": "passed"
});
formatter.before({
  "duration": 9155083,
  "status": "passed"
});
formatter.before({
  "duration": 7511896,
  "status": "passed"
});
formatter.before({
  "duration": 8722100,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Check if the money deposited can be withdrawn from CheckingsAccount in all positive scenarios",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Checkings account is 2200.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000000 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 0 dollars from CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 1002200.00 dollars in CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 634687,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2200.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 48770506,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 45491952,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 52314324,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1002200.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 90734021,
  "status": "passed"
});
formatter.before({
  "duration": 6896937,
  "status": "passed"
});
formatter.before({
  "duration": 5373439,
  "status": "passed"
});
formatter.before({
  "duration": 5094773,
  "status": "passed"
});
formatter.before({
  "duration": 10683918,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Check if the money deposited can be withdrawn from CheckingsAccount in all positive scenarios",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Checkings account is 1002200.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 5000 dollars from CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 998200.00 dollars in CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 748190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1002200.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 66730183,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 52017637,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 54173666,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "998200.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 76578406,
  "status": "passed"
});
formatter.before({
  "duration": 24084881,
  "status": "passed"
});
formatter.before({
  "duration": 14072917,
  "status": "passed"
});
formatter.before({
  "duration": 9804751,
  "status": "passed"
});
formatter.before({
  "duration": 10205742,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Check if the money deposited can be withdrawn from CheckingsAccount in all positive scenarios",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-the-money-deposited-can-be-withdrawn-from-checkingsaccount-in-all-positive-scenarios;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Checkings account is 998200.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 0 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 998200.00 dollars from CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 0.00 dollars in CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 119814,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "998200.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 49147791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 33025400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "998200.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 97801913,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 53346266,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Check if overdraft is possible in CheckingsAccount",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-checkingsaccount",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Initial balance in Checkings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from CheckingsAccount",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in CheckingsAccount",
  "keyword": "Then "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-checkingsaccount;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "WithdrawAmount",
        "RemainingAmount"
      ],
      "line": 26,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-checkingsaccount;;1"
    },
    {
      "cells": [
        "0.00",
        "500",
        "-500.00"
      ],
      "line": 27,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-checkingsaccount;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4301175,
  "status": "passed"
});
formatter.before({
  "duration": 3565783,
  "status": "passed"
});
formatter.before({
  "duration": 19960846,
  "status": "passed"
});
formatter.before({
  "duration": 4725626,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Check if overdraft is possible in CheckingsAccount",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-checkingsaccount;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Initial balance in Checkings account is 0.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Withdraw money of 500 dollars from CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Check remaining amount -500.00 dollars in CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 93967,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 40287037,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 32688255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 53861248,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 30,
  "name": "Check if huge amounts of money can be deposited and withdrawn in CheckingsAccount",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Checkings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of \u003cDepositAmount\u003e dollars in CheckingsAccount",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in CheckingsAccount",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from CheckingsAccount",
  "keyword": "And "
});
formatter.examples({
  "line": 37,
  "name": "",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "DepositAmount",
        "RemainingAmount",
        "WithdrawAmount"
      ],
      "line": 38,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;;1"
    },
    {
      "cells": [
        "-500.00",
        "1000",
        "500.00",
        "0.00"
      ],
      "line": 39,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;;2"
    },
    {
      "cells": [
        "500.00",
        "1000000000000000",
        "1000000000000500.00",
        "1000000000000500.00"
      ],
      "line": 40,
      "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 16096722,
  "status": "passed"
});
formatter.before({
  "duration": 4731230,
  "status": "passed"
});
formatter.before({
  "duration": 8669014,
  "status": "passed"
});
formatter.before({
  "duration": 4661511,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Check if huge amounts of money can be deposited and withdrawn in CheckingsAccount",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Checkings account is -500.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of 1000 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount 500.00 dollars in CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Withdraw money of 0.00 dollars from CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 87758,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-500.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 93197437,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 45155744,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 52675585,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 41669244,
  "status": "passed"
});
formatter.before({
  "duration": 10184723,
  "status": "passed"
});
formatter.before({
  "duration": 4205500,
  "status": "passed"
});
formatter.before({
  "duration": 4135881,
  "status": "passed"
});
formatter.before({
  "duration": 4103376,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Check if huge amounts of money can be deposited and withdrawn in CheckingsAccount",
  "description": "",
  "id": "check-money-deposited-can-be-withdrawn-from-checkings-account-in-all-possible-cases;check-if-huge-amounts-of-money-can-be-deposited-and-withdrawn-in-checkingsaccount;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Checkings account is 500.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of 1000000000000000 dollars in CheckingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount 1000000000000500.00 dollars in CheckingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Withdraw money of 1000000000000500.00 dollars from CheckingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DepositCheckCheckAccStep.java:75"
});
formatter.result({
  "duration": 582712,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 51190429,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000000",
      "offset": 17
    }
  ],
  "location": "DepositCheckCheckAccStep.java:92"
});
formatter.result({
  "duration": 47016207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 66489985,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000500.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckCheckAccStep.java:103"
});
formatter.result({
  "duration": 71559091,
  "status": "passed"
});
formatter.uri("features/SavingsAccountActivities.feature");
formatter.feature({
  "line": 1,
  "name": "Check of money deposited can be withdrawn from Savings account in all possible cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of \u003cDepositAmount\u003e dollars in SavingsAccount",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from SavingsAccount",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in SavingsAccount",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "DepositAmount",
        "WithdrawAmount",
        "RemainingAmount"
      ],
      "line": 12,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;1"
    },
    {
      "cells": [
        "4250.00",
        "1000",
        "500",
        "4750.00"
      ],
      "line": 13,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;2"
    },
    {
      "cells": [
        "4750.00",
        "1000000",
        "0",
        "1004750.00"
      ],
      "line": 14,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;3"
    },
    {
      "cells": [
        "1004750.00",
        "1000",
        "5000",
        "1000750.00"
      ],
      "line": 15,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;4"
    },
    {
      "cells": [
        "1000750.00",
        "0",
        "1000750.00",
        "0.00"
      ],
      "line": 16,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13584547,
  "status": "passed"
});
formatter.before({
  "duration": 21666443,
  "status": "passed"
});
formatter.before({
  "duration": 21323492,
  "status": "passed"
});
formatter.before({
  "duration": 7737584,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is 4250.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 500 dollars from SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 4750.00 dollars in SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 713986,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4250.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 79788772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 114584453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 29734535,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4750.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 32762895,
  "status": "passed"
});
formatter.before({
  "duration": 7724134,
  "status": "passed"
});
formatter.before({
  "duration": 5650173,
  "status": "passed"
});
formatter.before({
  "duration": 6284393,
  "status": "passed"
});
formatter.before({
  "duration": 6810356,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is 4750.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000000 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 0 dollars from SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 1004750.00 dollars in SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 136622,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4750.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 50211844,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 42049597,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 52539066,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1004750.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 40649920,
  "status": "passed"
});
formatter.before({
  "duration": 24662815,
  "status": "passed"
});
formatter.before({
  "duration": 6578097,
  "status": "passed"
});
formatter.before({
  "duration": 21122417,
  "status": "passed"
});
formatter.before({
  "duration": 9776351,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is 1004750.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 1000 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 5000 dollars from SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 1000750.00 dollars in SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 16367083,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1004750.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 48743441,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 49801808,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 42318537,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000750.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 35827458,
  "status": "passed"
});
formatter.before({
  "duration": 9805412,
  "status": "passed"
});
formatter.before({
  "duration": 14988196,
  "status": "passed"
});
formatter.before({
  "duration": 13763855,
  "status": "passed"
});
formatter.before({
  "duration": 12767693,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-the-money-that-is-deposited-money-can-be-withdrawn-from-savingsaccount-in-general-cases;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is 1000750.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Deposit money of 0 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Withdraw money of 1000750.00 dollars from SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Check remaining amount 0.00 dollars in SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 102992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000750.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 32355706,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 56030571,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000750.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 38309926,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 49345254,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Check if overdraft is possible in SavingsAccount",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-savingsaccount",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Initial balance in Savings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from SavingsAccount",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in SavingsAccount",
  "keyword": "Then "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-savingsaccount;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "WithdrawAmount",
        "RemainingAmount"
      ],
      "line": 26,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-savingsaccount;;1"
    },
    {
      "cells": [
        "0.00",
        "500",
        "-500.00"
      ],
      "line": 27,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-savingsaccount;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 15156439,
  "status": "passed"
});
formatter.before({
  "duration": 12282914,
  "status": "passed"
});
formatter.before({
  "duration": 10580890,
  "status": "passed"
});
formatter.before({
  "duration": 12459050,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Check if overdraft is possible in SavingsAccount",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-overdraft-is-possible-in-savingsaccount;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Initial balance in Savings account is 0.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Withdraw money of 500 dollars from SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Check remaining amount -500.00 dollars in SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 94079,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 36102835,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 56669028,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 36889934,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 30,
  "name": "Check if large amounts of money can be deposited in SavingsAccount",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Savings account is \u003cInitialBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of \u003cDepositAmount\u003e dollars in SavingsAccount",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount \u003cRemainingAmount\u003e dollars in SavingsAccount",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Check if transaction count of SavingsAccount is greater than 0",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Withdraw money of \u003cWithdrawAmount\u003e dollars from SavingsAccount",
  "keyword": "And "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;",
  "rows": [
    {
      "cells": [
        "InitialBalance",
        "DepositAmount",
        "RemainingAmount",
        "WithdrawAmount"
      ],
      "line": 39,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;;1"
    },
    {
      "cells": [
        "-500.00",
        "1000",
        "500.00",
        "0.00"
      ],
      "line": 40,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;;2"
    },
    {
      "cells": [
        "500.00",
        "1000000000000000",
        "1000000000000500.00",
        "1000000000000500.00"
      ],
      "line": 41,
      "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6254317,
  "status": "passed"
});
formatter.before({
  "duration": 24941544,
  "status": "passed"
});
formatter.before({
  "duration": 17887805,
  "status": "passed"
});
formatter.before({
  "duration": 5623869,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Check if large amounts of money can be deposited in SavingsAccount",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Savings account is -500.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of 1000 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount 500.00 dollars in SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Check if transaction count of SavingsAccount is greater than 0",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Withdraw money of 0.00 dollars from SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 85186,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-500.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 36978292,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 36099760,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 35358969,
  "status": "passed"
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:129"
});
formatter.result({
  "duration": 53478552,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 37019648,
  "status": "passed"
});
formatter.before({
  "duration": 20804272,
  "status": "passed"
});
formatter.before({
  "duration": 5263111,
  "status": "passed"
});
formatter.before({
  "duration": 15071689,
  "status": "passed"
});
formatter.before({
  "duration": 5481030,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Check if large amounts of money can be deposited in SavingsAccount",
  "description": "",
  "id": "check-of-money-deposited-can-be-withdrawn-from-savings-account-in-all-possible-cases;check-if-large-amounts-of-money-can-be-deposited-in-savingsaccount;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Common user logged in for Savings Account",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Initial balance in Savings account is 500.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Deposit money of 1000000000000000 dollars in SavingsAccount",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Check remaining amount 1000000000000500.00 dollars in SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Check if transaction count of SavingsAccount is greater than 0",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Withdraw money of 1000000000000500.00 dollars from SavingsAccount",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:76"
});
formatter.result({
  "duration": 100818,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 53071668,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 49432821,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 92633198,
  "status": "passed"
});
formatter.match({
  "location": "DepositCheckSavAccStep.java:129"
});
formatter.result({
  "duration": 34480190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000000000500.00",
      "offset": 18
    }
  ],
  "location": "DepositCheckSavAccStep.java:109"
});
formatter.result({
  "duration": 51950994,
  "status": "passed"
});
formatter.uri("features/TransferActivities.feature");
formatter.feature({
  "line": 1,
  "name": "Check account transfer activities between own accounts",
  "description": "",
  "id": "check-account-transfer-activities-between-own-accounts",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Check if the money can be transferred from Checkings account to Savings account",
  "description": "",
  "id": "check-account-transfer-activities-between-own-accounts;check-if-the-money-can-be-transferred-from-checkings-account-to-savings-account",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for account transfer",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is \u003cInitialSavingsBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Initial balance in Checkings account is \u003cInitialCheckingsBalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Deposit money of \u003cSavingsDeposit\u003e dollars in SavingsAccount",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Transfer money of \u003cTransferAmount\u003e from Savings to Checkings account",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Check remaining amount \u003cRemainingSavingsBalance\u003e dollars in SavingsAccount",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Check remaining amount \u003cRemainingCheckingsBalance\u003e dollars in CheckingsAccount",
  "keyword": "And "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "check-account-transfer-activities-between-own-accounts;check-if-the-money-can-be-transferred-from-checkings-account-to-savings-account;",
  "rows": [
    {
      "cells": [
        "InitialSavingsBalance",
        "InitialCheckingsBalance",
        "SavingsDeposit",
        "TransferAmount",
        "RemainingSavingsBalance",
        "RemainingCheckingsBalance"
      ],
      "line": 14,
      "id": "check-account-transfer-activities-between-own-accounts;check-if-the-money-can-be-transferred-from-checkings-account-to-savings-account;;1"
    },
    {
      "cells": [
        "0.00",
        "0.00",
        "1000",
        "500",
        "500.00",
        "500.00"
      ],
      "line": 15,
      "id": "check-account-transfer-activities-between-own-accounts;check-if-the-money-can-be-transferred-from-checkings-account-to-savings-account;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6333899,
  "status": "passed"
});
formatter.before({
  "duration": 5768692,
  "status": "passed"
});
formatter.before({
  "duration": 14370690,
  "status": "passed"
});
formatter.before({
  "duration": 5822908,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Check if the money can be transferred from Checkings account to Savings account",
  "description": "",
  "id": "check-account-transfer-activities-between-own-accounts;check-if-the-money-can-be-transferred-from-checkings-account-to-savings-account;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Common user logged in for account transfer",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Initial balance in Savings account is 0.00",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Initial balance in Checkings account is 0.00",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Deposit money of 1000 dollars in SavingsAccount",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Transfer money of 500 from Savings to Checkings account",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Check remaining amount 500.00 dollars in SavingsAccount",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Check remaining amount 500.00 dollars in CheckingsAccount",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.match({
  "location": "TransferActivitiesStep.java:73"
});
formatter.result({
  "duration": 130595,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 38
    }
  ],
  "location": "DepositCheckSavAccStep.java:84"
});
formatter.result({
  "duration": 37994100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 40
    }
  ],
  "location": "DepositCheckCheckAccStep.java:82"
});
formatter.result({
  "duration": 34044516,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 17
    }
  ],
  "location": "DepositCheckSavAccStep.java:98"
});
formatter.result({
  "duration": 37686598,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 18
    }
  ],
  "location": "TransferActivitiesStep.java:80"
});
formatter.result({
  "duration": 48280279,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckSavAccStep.java:119"
});
formatter.result({
  "duration": 43075625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500.00",
      "offset": 23
    }
  ],
  "location": "DepositCheckCheckAccStep.java:113"
});
formatter.result({
  "duration": 35213195,
  "status": "passed"
});
formatter.uri("features/UserRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "Check if new users can be registered",
  "description": "",
  "id": "check-if-new-users-can-be-registered",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Simple user registration",
  "description": "",
  "id": "check-if-new-users-can-be-registered;simple-user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User registered with details \u003cfirstName\u003e, \u003clastName\u003e, \u003cphone\u003e, \u003cemail\u003e, \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User logged in after registration with \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Check if user details \u003cfirstName\u003e, \u003clastName\u003e, \u003cphone\u003e, \u003cemail\u003e, \u003cusername\u003e and \u003cpassword\u003e are properly stored in DB",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "check-if-new-users-can-be-registered;simple-user-registration;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "phone",
        "email",
        "username",
        "password"
      ],
      "line": 10,
      "id": "check-if-new-users-can-be-registered;simple-user-registration;;1"
    },
    {
      "cells": [
        "Ravi",
        "Kalla",
        "1111111111",
        "ravi@ravi.com",
        "ravi",
        "ravi"
      ],
      "line": 11,
      "id": "check-if-new-users-can-be-registered;simple-user-registration;;2"
    },
    {
      "cells": [
        "Raj",
        "Kumar",
        "2222222222",
        "raj@raj.com",
        "Raj",
        "Raj"
      ],
      "line": 12,
      "id": "check-if-new-users-can-be-registered;simple-user-registration;;3"
    },
    {
      "cells": [
        "Matt",
        "Damon",
        "3333333333",
        "matt@matt.com",
        "Matt",
        "Matt"
      ],
      "line": 13,
      "id": "check-if-new-users-can-be-registered;simple-user-registration;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9227780,
  "status": "passed"
});
formatter.before({
  "duration": 9664938,
  "status": "passed"
});
formatter.before({
  "duration": 7831246,
  "status": "passed"
});
formatter.before({
  "duration": 13572938,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Simple user registration",
  "description": "",
  "id": "check-if-new-users-can-be-registered;simple-user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User registered with details Ravi, Kalla, 1111111111, ravi@ravi.com, ravi and ravi",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User logged in after registration with ravi and ravi",
  "matchedColumns": [
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Check if user details Ravi, Kalla, 1111111111, ravi@ravi.com, ravi and ravi are properly stored in DB",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Ravi",
      "offset": 29
    },
    {
      "val": "Kalla",
      "offset": 35
    },
    {
      "val": "1111111111",
      "offset": 42
    },
    {
      "val": "ravi@ravi.com",
      "offset": 54
    },
    {
      "val": "ravi",
      "offset": 69
    },
    {
      "val": "ravi",
      "offset": 78
    }
  ],
  "location": "UserRegistrationStep.java:90"
});
formatter.result({
  "duration": 559995303,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ravi",
      "offset": 39
    },
    {
      "val": "ravi",
      "offset": 48
    }
  ],
  "location": "UserRegistrationStep.java:82"
});
formatter.result({
  "duration": 545688,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ravi",
      "offset": 22
    },
    {
      "val": "Kalla",
      "offset": 28
    },
    {
      "val": "1111111111",
      "offset": 35
    },
    {
      "val": "ravi@ravi.com",
      "offset": 47
    },
    {
      "val": "ravi",
      "offset": 62
    },
    {
      "val": "ravi",
      "offset": 71
    }
  ],
  "location": "UserRegistrationStep.java:120"
});
formatter.result({
  "duration": 26730477,
  "status": "passed"
});
formatter.before({
  "duration": 6186295,
  "status": "passed"
});
formatter.before({
  "duration": 5242880,
  "status": "passed"
});
formatter.before({
  "duration": 5400623,
  "status": "passed"
});
formatter.before({
  "duration": 5137850,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Simple user registration",
  "description": "",
  "id": "check-if-new-users-can-be-registered;simple-user-registration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User registered with details Raj, Kumar, 2222222222, raj@raj.com, Raj and Raj",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User logged in after registration with Raj and Raj",
  "matchedColumns": [
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Check if user details Raj, Kumar, 2222222222, raj@raj.com, Raj and Raj are properly stored in DB",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Raj",
      "offset": 29
    },
    {
      "val": "Kumar",
      "offset": 34
    },
    {
      "val": "2222222222",
      "offset": 41
    },
    {
      "val": "raj@raj.com",
      "offset": 53
    },
    {
      "val": "Raj",
      "offset": 66
    },
    {
      "val": "Raj",
      "offset": 74
    }
  ],
  "location": "UserRegistrationStep.java:90"
});
formatter.result({
  "duration": 457747272,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Raj",
      "offset": 39
    },
    {
      "val": "Raj",
      "offset": 47
    }
  ],
  "location": "UserRegistrationStep.java:82"
});
formatter.result({
  "duration": 172162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Raj",
      "offset": 22
    },
    {
      "val": "Kumar",
      "offset": 27
    },
    {
      "val": "2222222222",
      "offset": 34
    },
    {
      "val": "raj@raj.com",
      "offset": 46
    },
    {
      "val": "Raj",
      "offset": 59
    },
    {
      "val": "Raj",
      "offset": 67
    }
  ],
  "location": "UserRegistrationStep.java:120"
});
formatter.result({
  "duration": 11802912,
  "status": "passed"
});
formatter.before({
  "duration": 5892706,
  "status": "passed"
});
formatter.before({
  "duration": 5008347,
  "status": "passed"
});
formatter.before({
  "duration": 4945542,
  "status": "passed"
});
formatter.before({
  "duration": 5069844,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Simple user registration",
  "description": "",
  "id": "check-if-new-users-can-be-registered;simple-user-registration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User registered with details Matt, Damon, 3333333333, matt@matt.com, Matt and Matt",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User logged in after registration with Matt and Matt",
  "matchedColumns": [
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Check if user details Matt, Damon, 3333333333, matt@matt.com, Matt and Matt are properly stored in DB",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Matt",
      "offset": 29
    },
    {
      "val": "Damon",
      "offset": 35
    },
    {
      "val": "3333333333",
      "offset": 42
    },
    {
      "val": "matt@matt.com",
      "offset": 54
    },
    {
      "val": "Matt",
      "offset": 69
    },
    {
      "val": "Matt",
      "offset": 78
    }
  ],
  "location": "UserRegistrationStep.java:90"
});
formatter.result({
  "duration": 463622711,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Matt",
      "offset": 39
    },
    {
      "val": "Matt",
      "offset": 48
    }
  ],
  "location": "UserRegistrationStep.java:82"
});
formatter.result({
  "duration": 164604,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Matt",
      "offset": 22
    },
    {
      "val": "Damon",
      "offset": 28
    },
    {
      "val": "3333333333",
      "offset": 35
    },
    {
      "val": "matt@matt.com",
      "offset": 47
    },
    {
      "val": "Matt",
      "offset": 62
    },
    {
      "val": "Matt",
      "offset": 71
    }
  ],
  "location": "UserRegistrationStep.java:120"
});
formatter.result({
  "duration": 14177103,
  "status": "passed"
});
});