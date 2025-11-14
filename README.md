# CDI-TestFramework-BFSI-BrowserStack
A repository consisting of tests to run on BrowserStack's finstack website.

**Finstack Automation Tests**

There are two main test suites:

login-test → Runs FinstackTest.java (Login + Create Account Flow)

loan-test → Runs FinstackLoanTest.java (End-to-End Loan Payment Flow)

1. Clone the repository

2. Replace YOUR_USERNAME and YOUR_ACCESS_KEY with your BrowserStack access credentials in browserstack.yml or browserstack_login.yml

3. Upload the .mp4 video file present in the repo and update the `media url` in the browserstack.yml or browserstack_login.yml. Steps - https://www.browserstack.com/docs/automate/selenium/camera-injection?fw-lang=java

4. Install dependencies - `mvn compile`


5. **Running Tests**

Run Login Test Suite

------> Runs FinstackTest.java (Login + Create Account)

   `mvn test -P login-test -Dbrowserstack.config="browserstack_login.yml"`
 
Run Loan Test Suite

------> Runs FinstackLoanTest.java (E2E Loan Payment Flow)

  `mvn test -P loan-test`
