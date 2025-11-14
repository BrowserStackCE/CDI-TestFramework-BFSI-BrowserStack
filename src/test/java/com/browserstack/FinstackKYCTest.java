package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.v2.utils.BrowserStack;

import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
//import com.browserstack.PercySDK;

public class FinstackKYCTest extends SeleniumTest {

    @Test
    public void kycCheck() throws Exception {

//        MutableCapabilities capabilities = new MutableCapabilities();
//        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//        browserstackOptions.put("uploadMedia", "media://e04dba4ddc6f868c763613224182f81b2d57f393");
//        capabilities.setCapability("bstack:options", browserstackOptions);

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
//        BrowserStack.setCustomTag("ID", "TC-1294587");


        BrowserStack.setCustomTag("ID", "TC-1294020");
        // --- Step 2: Click "Create account" link ---
        System.out.println("Clicking 'Create account' link.");
        String createAccountLinkXPath = "//a[text()='Create account']";
        driver.findElement(By.xpath(createAccountLinkXPath)).click();
        Thread.sleep(2000);
//        PercySDK.screenshot(driver, "Before Filling the Form");

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
//        PercySDK.screenshot(driver, "After Filling the Form");
        // --- Step 4: Click the "I agree to terms" checkbox ---
        System.out.println("Clicking 'I agree to terms' checkbox.");
        driver.findElement(By.xpath("//button[@id='agreeToTerms']")).click();
        Thread.sleep(1000);

        // --- Step 5: Click "Create Account" button ---
        System.out.println("Clicking 'Create Account' button.");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        Thread.sleep(10000);
//        WebElement uploadElement = driver.findElement(By.xpath("//video[@autoplay]"));
//        uploadElement.sendKeys("C:\\Users\\hello\\Documents\\images\\bfsi.png");
//        ((JavascriptExecutor) driver).executeScript("document.getElementById('readTermsOfUse').click();");


        System.out.println("Clicking 'Capture Image' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Capture Image']")).click();
        Thread.sleep(2000);

//         --- Step 8: Click "Complete Verification" Button ---
        System.out.println("Clicking 'Complete Verification' button.");
        driver.findElement(By.xpath("//button[normalize-space()='Complete Verification']")).click();
//        WebElement uploadElement = driver.findElement(By.xpath("//video[@autoplay]"));
//        uploadElement.sendKeys("C:\\Users\\hello\\Documents\\images\\bfsi.png");
//        ((JavascriptExecutor) driver).executeScript("document.getElementById('readTermsOfUse').click();");

    }

}
