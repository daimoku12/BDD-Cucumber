$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "CRM login test",
  "description": "Verify CRM login page functionality",
  "id": "crm-login-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 18581543246,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Testing use of background",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "print test case started",
  "keyword": "Then "
});
formatter.match({
  "location": "LogInTest.print_test_case_started()"
});
formatter.result({
  "duration": 540132912,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Test Login with valid credentials",
  "description": "",
  "id": "crm-login-test;test-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I am on CRM login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter valid username and password and click on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should successfully login",
  "keyword": "Then "
});
formatter.match({
  "location": "LogInTest.i_am_on_CRM_login_page()"
});
formatter.result({
  "duration": 131486840,
  "status": "passed"
});
formatter.match({
  "location": "LogInTest.i_enter_invalid_username_and_password()"
});
formatter.result({
  "duration": 13682670532,
  "status": "passed"
});
formatter.match({
  "location": "LogInTest.i_should_successfully_login()"
});
formatter.result({
  "duration": 144165,
  "status": "passed"
});
formatter.after({
  "duration": 1590505268,
  "status": "passed"
});
});