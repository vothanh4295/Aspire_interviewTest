# Project Name - Author
ASPIRE's CHALLENGE - Thanh Vo (vothanh4295@gmail.com)

## Enviroment
MacOS 11.5

## Usage
This project executed on Aspire app (URL: https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/) and following Page Object Model.
Source folder:
- "pages" package: contains all pages, locators and methods in application
- "test" package: contains setup/teardown suite, driver's configuration and main testcase
- "config" folder: contains Chrome driver
- "data" folder: contains test data

## Test Steps
1. Go to Aspire App's url
2. Register new account > Fill registery data then input default OTP (1234)
3. In business role page, select Role = "Director"
4. Fulfill additional information
5. Select Registration Method
6. Fulfill Business Details (03 pages in total)
7. Go to Identity page and verify the title (it marked TESTED referred into challenge's question)

## Execution
To execute the test, go to ..src/tests/Testcase.java and click Run Test.

Note: the test contains 03 dynamic parameters (user's gmail, user's phone number and business number) which need to be change after each execution.