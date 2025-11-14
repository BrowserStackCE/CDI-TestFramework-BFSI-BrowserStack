package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.v2.utils.BrowserStack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.browserstack.PercySDK;



public class FinstackLoanTest extends SeleniumTest {


     //public void introduceVisualBug(WebElement element, String styleChange) {
    //     try {
    //         JavascriptExecutor js = (JavascriptExecutor) driver;
    //         js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, styleChange);
    //         Thread.sleep(500); // Small pause to ensure style is applied before screenshot
    //     } catch (Exception e) {
    //         System.out.println("Could not apply visual bug: " + e.getMessage());
    //     }
    // }

    @Test
    public void loansPayment() throws Exception {
        // --- Step 1: Navigate to the home page ---
        System.out.println("Navigating to https://finstack-alpha.vercel.app/");
        driver.get("https://finstack-alpha.vercel.app/");
        try {
            System.out.println("Attempting to maximize browser window...");
            driver.manage().window().maximize();
            System.out.println("Browser window maximized successfully.");
        } 
        catch (org.openqa.selenium.UnsupportedCommandException e) {
            // This catches the specific error thrown by platforms like Android or some iOS setups
            System.out.println("Skipping maximize command: Command unsupported by the platform.");
        }

        Thread.sleep(2000);
        BrowserStack.setCustomTag("ID", "TC-1294587");


        // BrowserStack.setCustomTag("ID", "TC-1294020");
        // --- Step 2: Click "Create account" link ---
        System.out.println("Clicking 'Create account' link.");
        String createAccountLinkXPath = "//a[text()='Create account']";
        driver.findElement(By.xpath(createAccountLinkXPath)).click();
        Thread.sleep(10000);

        //         // VISUAL BUG: Change the background color of the 'First Name' input field to be noticeable.
        // WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
        // introduceVisualBug(firstNameInput, "background-color: #FFDDC1;"); // Light orange background

 // VISUAL BUG: Change the background color of the 'email' input field to be noticeable.
        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        // introduceVisualBug(emailInput, "background-color: #320b56ff;"); // purple background

        PercySDK.screenshot(driver, "Before Filling the Form");

        // --- Step 3: Fill out the registration form ---
        System.out.println("Filling out the registration form.");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sam");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        String randomEmail = "sam.smith+" + System.currentTimeMillis() + "@example.com";
        System.out.println("Using email: " + randomEmail);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(randomEmail);
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sam.smith@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SamplePass123!");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("SamplePass123!");
        
        //         // VISUAL BUG: Increase the font size of the 'Create Account' button to make it oversized.
        // WebElement createAccountButton = driver.findElement(By.xpath("//button[text()='Create Account']"));
        // introduceVisualBug(createAccountButton, "font-size: 25px; padding: 20px;");


        PercySDK.screenshot(driver, "After Filling the Form");
        // --- Step 4: Click the "I agree to terms" checkbox ---
        System.out.println("Clicking 'I agree to terms' checkbox.");
        driver.findElement(By.xpath("//button[@id='agreeToTerms']")).click();
        Thread.sleep(1000);

        
        // --- Step 5: Click "Create Account" button ---
        System.out.println("Clicking 'Create Account' button.");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        Thread.sleep(10000);

        System.out.println("Clicking 'Collapse' button.");
        String in_collapseButtonXPath = "//button[text()='Collapse']";
        driver.findElement(By.xpath(in_collapseButtonXPath)).click();
        Thread.sleep(1000);

// KYC step
        System.out.println("Clicking 'Capture Image' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Capture Image']")).click();
        Thread.sleep(2000);

//  Click "Complete Verification" Button ---
        System.out.println("Clicking 'Complete Verification' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Complete Verification']")).click();

        System.out.println("Clicking 'Expand' button.");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/button")).click();
        Thread.sleep(1000);

        // --- Step 2: Navigate to the Loans tab ---
        System.out.println("Navigating to the Loans tab.");
        String loansTabXPath = "//span[text()='Loans']";
        driver.findElement(By.xpath(loansTabXPath)).click();
        Thread.sleep(2000);
            // VISUAL BUG: Change the color of the "Loans" page header.
        // WebElement pageHeader = driver.findElement(By.xpath("//span[text()='Loans']"));
        // introduceVisualBug(pageHeader, "color: purple;");
        
        PercySDK.screenshot(driver, "Loans Tab");

        // --- New Step: Click the "Collapse" button for the navigation sidebar ---
        System.out.println("Clicking 'Collapse' button.");
        String collapseButtonXPath = "//button[text()='Collapse']";
        driver.findElement(By.xpath(collapseButtonXPath)).click();
        Thread.sleep(1000);
         // VISUAL BUG: Add a large, ugly border to the 'Make Payment' button.
        // WebElement makePaymentBtn = driver.findElement(By.xpath("//button[text()='Make Payment']"));
        // introduceVisualBug(makePaymentBtn, "border: 5px dashed red;");

        PercySDK.screenshot(driver, "Without Sidebar");

        // --- Step 3: Click the "Make Payment" button ---
        System.out.println("Clicking 'Make Payment' button.");
        String makePaymentButtonXPath = "//button[text()='Make Payment']";
        driver.findElement(By.xpath(makePaymentButtonXPath)).click();
        Thread.sleep(1000);
        PercySDK.screenshot(driver, "Make Payment Modal");

        // --- Step 4: Enter the payment amount ---
        System.out.println("Entering payment amount: 2000.");
        String paymentAmountInputXPath = "//input[@id='payment-amount']";
        driver.findElement(By.xpath(paymentAmountInputXPath)).sendKeys("2000");
        Thread.sleep(1000);

        // --- Step 5: Select the first account option from the dropdown ---
        System.out.println("Selecting the first account from the dropdown.");
        String selectAccountButtonXPath = "//button[./span[text()='Select account']]";
        driver.findElement(By.xpath(selectAccountButtonXPath)).click();
        Thread.sleep(1000);

        // XPath to select the first dropdown option
        System.out.println("Selecting 'Main Checking - $12,450.75' from the dropdown.");
        driver.findElement(By.xpath("//div[normalize-space(.)='Main Checking - $12,450.75']")).click();
        Thread.sleep(1000);
        PercySDK.screenshot(driver, "Loan Payment Details");

        // --- New Step: Click the final "Make Payment" button ---
        System.out.println("Clicking the final 'Make Payment' button.");
        String finalMakePaymentButtonXPath = "/html/body/div[3]/form/div[2]/button[2]";
        driver.findElement(By.xpath(finalMakePaymentButtonXPath)).click();
        Thread.sleep(3000); // Wait for the payment to process and the page to update

        // --- Final Assertion (Optional, to verify success) ---
        // Assert that a confirmation message or success element is displayed
        System.out.println("Payment process completed. Add your final assertion here.");
        // --- Assertion: Verify the new amount is displayed ---
        // Assert that the element with text '$243,000' is present and displayed.
        String finalAmountXPath = "/html/body/div/div[1]/div[2]/main/div/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div[1]/p[2]";
        Assert.assertTrue(driver.findElement(By.xpath(finalAmountXPath)).isDisplayed(), 
            "The element with text '$243,000' was not found or is not displayed.");

        System.out.println("Assertion successful: The loan amount has been updated to $243,000.");
        PercySDK.screenshot(driver, "Final Loan Amount");
    }

}
