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
        
        // IMPORTANT: Set this to 'false' for the Baseline run.
        // Set this to 'true' for the Demo/Healed run.
        boolean triggerHeal = false; 

        if (triggerHeal) {
            System.out.println("DEMO MODE: Clicking 'Enable' to change the UI from 'Sign In' to 'Login'.");
            // Verified locator based on your provided HTML
            String enableButtonXPath = "//button[text()='Enable']"; 
            driver.findElement(By.xpath(enableButtonXPath)).click();
            
            // Short wait to allow the UI to update the button text from Sign In -> Login
            Thread.sleep(1500); 
        }
        // ====================================================================

        // --- Step 4: Click Sign In Button ---
        // We ALWAYS use the "Sign In" locator here to force a failure during the demo run,
        // which gives BrowserStack the opportunity to heal the locator and click "Login".
        String signInButtonXPath = "//button[text()='Sign In']";
        System.out.println("Clicking Sign In button using original locator...");
        driver.findElement(By.xpath(signInButtonXPath)).click();

        // Wait for redirection after login
        Thread.sleep(3000); 

        // --- Step 5: Assertion to verify successful login ---
        System.out.println("Verifying successful login via dashboard element...");
        
        // Replace this XPath with something that definitely appears after login, 
        // such as a "Log Out" button, a profile icon, or a Welcome message.
        String postLoginElementXPath = "//h1[contains(text(), 'Good morning')]"; 
        
        // Wait a moment for the page to render the new state
        Thread.sleep(2000); 
        
        boolean isLoginSuccessful = driver.findElement(By.xpath(postLoginElementXPath)).isDisplayed();
        Assert.assertTrue(isLoginSuccessful, "Verification failed: Could not find the dashboard element after login.");
        
        System.out.println("Login verification passed successfully!");
    }
