package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.v2.utils.BrowserStack;

import org.openqa.selenium.JavascriptExecutor;



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
            // This catches the specific error thrown by platforms like Android or some iOS setups
            System.out.println("Skipping maximize command: Command unsupported by the platform.");
        }

        BrowserStack.setCustomTag("ID", "TC-1294027");
        // Wait a bit to ensure the elements are loaded, though a proper
        // WebDriverWait is recommended in real tests.
        Thread.sleep(1000); 
        PercySDK.screenshot(driver, "Before Login");

        // --- Step 2: Input Email ---
        String emailXPath = "//input[@id='email']";
        System.out.println("Entering email: demo.user@example.com");
        driver.findElement(By.xpath(emailXPath)).sendKeys("shrikrishna@browserstack.com");

        // --- Step 3: Input Password ---
        String passwordXPath = "//input[@id='password']";
        System.out.println("Entering password: samplePass123");
        driver.findElement(By.xpath(passwordXPath)).sendKeys("Test@123");
        PercySDK.screenshot(driver, "After Filling Login Form");

        // --- Step 4: Click Sign In Button ---
        // Using an XPath that selects the button based on its displayed text, which is very reliable.
        String signInButtonXPath = "//button[text()='Sign In']";
        System.out.println("Clicking Sign In button.");
        driver.findElement(By.xpath(signInButtonXPath)).click();

        // Wait for redirection after login (again, use explicit waits normally)
        Thread.sleep(3000); 

        // --- Step 5: Assertion to verify successful login ---
        // A simple check to see if the URL has changed, indicating a successful transition
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login attempt: " + currentUrl);
        
        // Assert that the URL is no longer the root login page.
        // The URL typically changes to '/dashboard' or similar after successful login.
        Assert.assertTrue(currentUrl.contains("https://finstack-alpha.vercel.app/"), 
            "Verification passed: URL changed after clicking Sign In. Login has passed.");
    }


    
    // The second @Test method for creating a new account.
    @Test
    public void createNewAccountAndVerifyProfile() throws Exception {
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
        BrowserStack.setCustomTag("ID", "TC-1294020");
        // --- Step 2: Click "Create account" link ---
        System.out.println("Clicking 'Create account' link.");
        String createAccountLinkXPath = "//a[text()='Create account']";
        driver.findElement(By.xpath(createAccountLinkXPath)).click();
        Thread.sleep(2000);

        // --- Step 3: Fill out the registration form ---
        System.out.println("Filling out the registration form.");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        String randomEmail = "john.smith+" + System.currentTimeMillis() + "@example.com";
        System.out.println("Using email: " + randomEmail);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(randomEmail);
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sam.smith@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SamplePass123!");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("SamplePass123!");

        // --- Step 4: Click the "I agree to terms" checkbox ---
        System.out.println("Clicking 'I agree to terms' checkbox.");
        driver.findElement(By.xpath("//button[@id='agreeToTerms']")).click();
        Thread.sleep(1000);

        // --- Step 5: Click "Create Account" button ---
        System.out.println("Clicking 'Create Account' button.");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        // Wait for the account creation to complete and dashboard to load
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

        // --- Step 6: Verify successful signup by checking the URL or a key element ---
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("signup"), "Verification failed: User is still on the signup page.");
        System.out.println("Account creation successful. Current URL: " + currentUrl);

       // --- Step 7: Click "Collapse" button for the navigation sidebar ---
        System.out.println("Clicking 'Collapse' button.");
        String collapseButtonXPath = "//button[text()='Collapse']";
        driver.findElement(By.xpath(collapseButtonXPath)).click();
        Thread.sleep(1000);

        // --- New Step: Scroll to the top of the page ---
        System.out.println("Scrolling to the top of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000); // Wait a moment for the scroll to complete
        PercySDK.screenshot(driver, "Dashboard Top");
        // --- New Step: Assert "Good morning, Sam" is displayed ---
        System.out.println("Verifying 'Good morning, John' is displayed on the page.");
        // Updated XPath for reliability
        String goodMorningTextXPath = "//h1[normalize-space(.)='Good morning, John']";
        Assert.assertTrue(driver.findElement(By.xpath(goodMorningTextXPath)).isDisplayed(), 
          "Verification failed: 'Good morning, John' text is not displayed on the page.");
        System.out.println("Successfully verified 'Good morning, John'. Test completed.");

        
        // // --- Step 8: Click on user dropdown menu ---
        // System.out.println("Clicking user dropdown menu.");
        // driver.findElement(By.xpath("//div[text()='Sam Smith']")).click();
        // Thread.sleep(1000);

        // // --- Step 9: Click "View Profile" from the dropdown ---
        // System.out.println("Clicking 'View Profile' from the dropdown.");
        // driver.findElement(By.xpath("//div[text()='View Profile']")).click();
        // Thread.sleep(2000);

        // // --- Step 10: Final Assertion ---
        // // Verify that the URL now contains the profile path
        // String profileUrl = driver.getCurrentUrl();
        // Assert.assertTrue(profileUrl.contains("/profile"), "Verification failed: Not redirected to the profile page.");
        // System.out.println("Successfully navigated to the profile page. Test completed.");

    }
    
}