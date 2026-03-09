package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.browserstack.v2.utils.BrowserStack;
import org.openqa.selenium.JavascriptExecutor;
import com.browserstack.PercySDK;

public class FinstackTest extends SeleniumTest {

    @Test
    public void loginTest() throws Exception {
        // --- Step 1: Navigate to the login page ---
        System.out.println("Navigating to https://finstack-alpha.vercel.app/");
        driver.get("https://finstack-alpha.vercel.app/");
        try {
            System.out.println("Attempting to maximize browser window...");
            driver.manage().window().maximize();
            System.out.println("Browser window maximized successfully.");
        } 
        catch (org.openqa.selenium.UnsupportedCommandException e) {
            System.out.println("Skipping maximize command: Command unsupported by the platform.");
        }

        BrowserStack.setCustomTag("ID", "TC-1294027");
        Thread.sleep(1000); 
        PercySDK.screenshot(driver, "Before Login");

        // --- Step 2: Input Email ---
        String emailXPath = "//input[@id='email']";
        System.out.println("Entering email: shrikrishna@browserstack.com");
        driver.findElement(By.xpath(emailXPath)).sendKeys("shrikrishna@browserstack.com");

        // --- Step 3: Input Password ---
        String passwordXPath = "//input[@id='password']";
        System.out.println("Entering password...");
        driver.findElement(By.xpath(passwordXPath)).sendKeys("Test@123");
        PercySDK.screenshot(driver, "After Filling Login Form");

        // ====================================================================
        // --- BROWSERSTACK SELF-HEALING DEMO LOGIC ---
        // ====================================================================
        
        // This is permanently set to true for this specific demo branch!
        boolean triggerHeal = true; 

        if (triggerHeal) {
            System.out.println("DEMO MODE: Clicking 'Enable' to change the UI from 'Sign In' to 'Login'.");
            String enableButtonXPath = "//button[text()='Enable']"; 
            driver.findElement(By.xpath(enableButtonXPath)).click();
            Thread.sleep(5000); // Wait for the button text to change
        }
        // ====================================================================

        // --- Step 4: Click Sign In Button ---
        // BrowserStack knows this locator from the master branch runs. 
        // Here, it will fail (because we clicked Enable), and BrowserStack will heal it!
        String signInButtonXPath = "//button[text()='Sign In']";
        System.out.println("Clicking Sign In button using original locator...");
        driver.findElement(By.xpath(signInButtonXPath)).click();

        Thread.sleep(3000); 

        // --- Step 5: Assertion to verify successful login ---
        System.out.println("Verifying successful login via dashboard element...");
        Thread.sleep(2000); 
        
        String postLoginElementXPath = "//h1[contains(text(), 'Good morning')]"; 
        boolean isLoginSuccessful = driver.findElement(By.xpath(postLoginElementXPath)).isDisplayed();
        Assert.assertTrue(isLoginSuccessful, "Verification failed: Could not find the dashboard element after login.");
        
        System.out.println("Login verification passed successfully!");
    }

    
    // The second @Test method for creating a new account (Unchanged from original).
    @Test
    public void createNewAccountAndVerifyProfile() throws Exception {
        System.out.println("Navigating to https://finstack-alpha.vercel.app/");
        driver.get("https://finstack-alpha.vercel.app/");
        try {
            System.out.println("Attempting to maximize browser window...");
            driver.manage().window().maximize();
            System.out.println("Browser window maximized successfully.");
        } 
        catch (org.openqa.selenium.UnsupportedCommandException e) {
            System.out.println("Skipping maximize command: Command unsupported by the platform.");
        }
       
        Thread.sleep(2000);
        BrowserStack.setCustomTag("ID", "TC-1294020");
        
        System.out.println("Clicking 'Create account' link.");
        String createAccountLinkXPath = "//a[text()='Create account']";
        driver.findElement(By.xpath(createAccountLinkXPath)).click();
        Thread.sleep(2000);

        System.out.println("Filling out the registration form.");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        String randomEmail = "john.smith+" + System.currentTimeMillis() + "@example.com";
        System.out.println("Using email: " + randomEmail);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SamplePass123!");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("SamplePass123!");

        System.out.println("Clicking 'I agree to terms' checkbox.");
        driver.findElement(By.xpath("//button[@id='agreeToTerms']")).click();
        Thread.sleep(1000);

        System.out.println("Clicking 'Create Account' button.");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        Thread.sleep(10000);

        System.out.println("Clicking 'Collapse' button.");
        String in_collapseButtonXPath = "//button[text()='Collapse']";
        driver.findElement(By.xpath(in_collapseButtonXPath)).click();
        Thread.sleep(1000);

        System.out.println("Clicking 'Capture Image' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Capture Image']")).click();
        Thread.sleep(2000);

        System.out.println("Clicking 'Complete Verification' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Complete Verification']")).click();

        System.out.println("Clicking 'Expand' button.");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/button")).click();
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("signup"), "Verification failed: User is still on the signup page.");
        System.out.println("Account creation successful. Current URL: " + currentUrl);

        System.out.println("Clicking 'Collapse' button.");
        String collapseButtonXPath = "//button[text()='Collapse']";
        driver.findElement(By.xpath(collapseButtonXPath)).click();
        Thread.sleep(1000);

        System.out.println("Scrolling to the top of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000); 
        PercySDK.screenshot(driver, "Dashboard Top");
        
        System.out.println("Verifying 'Good morning, John' is displayed on the page.");
        String goodMorningTextXPath = "//h1[normalize-space(.)='Good morning, John']";
        Assert.assertTrue(driver.findElement(By.xpath(goodMorningTextXPath)).isDisplayed(), 
          "Verification failed: 'Good morning, John' text is not displayed on the page.");
        System.out.println("Successfully verified 'Good morning, John'. Test completed.");
    }
}
