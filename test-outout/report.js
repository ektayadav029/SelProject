$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/EktaYadav/Documents/workspace/SeleniumProject/Feat/test.feature");
formatter.feature({
  "line": 1,
  "name": "Gmail Login Feature",
  "description": "",
  "id": "gmail-login-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login",
  "description": "",
  "id": "gmail-login-feature;login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 4,
      "value": "#Given User has naviagted to the URL"
    }
  ],
  "line": 5,
  "name": "User has entered login credentials",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User will compose the email",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPage.user_has_entered_login_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ComposePage.user_will_compose_the_email()"
});
formatter.result({
  "status": "skipped"
});
});