package com.simplerishta.test.pages;

import com.microsoft.playwright.Page;

public class Login {

    private Page page;

    // locators
    private String userName = "input[name='username']";
    private String password = "input[name='password']";
    private String loginButton = "/html/body/sr-main/div/div/div[2]/sr-login/div/div/form/button";

    public Login(Page page) {
        this.page = page;
    }
    public String getDashboardPageTitle(){
           return page.title();
    }
    public String getDashboardPageUrl()  {
           return page.url();
    }
    public String authentcate(String uname, String pass){
        page.fill(userName,uname);
        page.fill(password,pass);
        page.locator("xpath="+loginButton).click();
        return "Dashboard";
    }
}
