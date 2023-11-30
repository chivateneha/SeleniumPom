package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage {

	
			
			public HomePage(WebDriver driver) {
				super(driver);
			}
			
			@FindBy(xpath = "//*[@id='userNavButton']")
			WebElement UserMenu;
			
			
			public WebElement Username() {
				return UserMenu;
			}


		public String getText(WebDriver driver) {
				String data= driver.getTitle();
				return data;
			}
			

}
