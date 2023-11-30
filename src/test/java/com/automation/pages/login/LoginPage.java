package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage{

	
	@FindBy(xpath = "//input[@id='username']")
    WebElement usernameEle;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordEle;
	@FindBy(xpath = "//div[@id='error']")
	WebElement errormessage;
	@FindBy(xpath = "//*[@id='Login']")
	WebElement loginButtonEle;
	@FindBy(xpath = "//*[@id='rememberUn']")
	WebElement RememberMeCheckBox;
	@FindBy(xpath = "//*[@id='forgot_password_link']")
	WebElement forgotPassword;
	@FindBy(xpath = ".//*[@id='un']")
	WebElement resetPasswordUsername;
	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueButton;
	@FindBy(xpath="//div[@id='error']")
	WebElement invalidusernameandpassword;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	 
	public WebElement errormessage() {
		return invalidusernameandpassword;
	}
	public WebElement enterIntoUsername(String data) {
		
		enterText(usernameEle,data,"username textbox");
		return usernameEle;

		
	}

	public WebElement enterIntoPassword(String data) {
		enterText(passwordEle, data, "password Textbox");
		return passwordEle;
	}
	public WebDriver LoginButton(WebDriver driver) {
		clickElement(loginButtonEle,"login button");
		return driver;
	}

	public WebDriver checkRememberme(WebDriver driver) {
		selectCheckBox(RememberMeCheckBox, "remember me");
		return driver;
	}

	public WebDriver forgotPassword(WebDriver driver) {
		clickElement(forgotPassword, "forgot password link");
		return driver;
	}
	public  WebDriver ResetPassword(WebDriver driver) {
		enterText(resetPasswordUsername,"chirag@home.com", "UserName box");
		return driver;
	}
	public  WebDriver Continue(WebDriver driver) {
		clickElement(continueButton, "Continue Button");
		return driver;
	}

	public String getPageTitle() {
		return getTitleOfPage();
	}
}