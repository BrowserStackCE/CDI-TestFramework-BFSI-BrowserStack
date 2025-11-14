# CDI-TestFramework-BFSI-BrowserStack
A repository consisting of tests to run on BrowserStack's finstack website.
**Finstack Automation Tests**

There are two main test suites:

login-test → Runs FinstackTest.java (Login + Create Account Flow)

loan-test → Runs FinstackLoanTest.java (End-to-End Loan Payment Flow)

Clone the repository
Replace YOUR_USERNAME and YOUR_ACCESS_KEY with your BrowserStack access credentials in browserstack.yml or browserstack_login.yml
Install dependencies - mvn compile


**Running Tests**
Run Login Test Suite

Runs FinstackTest.java (Login + Create Account)

mvn test -P login-test -Dbrowserstack.config="browserstack_login.yml"

Run Loan Test Suite

Runs FinstackLoanTest.java (E2E Loan Payment Flow)

mvn test -P loan-test
