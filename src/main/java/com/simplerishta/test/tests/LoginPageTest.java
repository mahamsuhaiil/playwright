package com.simplerishta.test.tests;

import com.microsoft.playwright.Page;
import com.simplerishta.test.PlaywrightFactory;
import com.simplerishta.test.pages.Login;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    PlaywrightFactory playwrightFactory;
    Page page;

    Login login;

    @BeforeTest
    public void setup(){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chromium","https://app.simplerishta.com/login");
        login = new Login(page);
    }

    @Test
    public void authenticate(){
        String title = login.authentcate("abc@khired.com","admin");
        Assert.assertEquals(title,"Dashboard");
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
