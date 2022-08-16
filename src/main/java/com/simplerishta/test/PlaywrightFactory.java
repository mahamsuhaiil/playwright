package com.simplerishta.test;

import com.microsoft.playwright.*;

import java.awt.*;

public class PlaywrightFactory{

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

     public Page initBrowser(String browserName,String url){
         playwright = Playwright.create();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int width = (int)screenSize.getWidth();
         int height = (int)screenSize.getHeight();

         switch (browserName.toLowerCase()){
             case "chromium":
                 browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                 break;
             default:
                 break;
         }
         browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
         page = browserContext.newPage();
         page.navigate(url);
         return page;
     }
}