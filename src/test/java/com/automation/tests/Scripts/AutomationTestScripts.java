package com.automation.tests.Scripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.tests.Utilities.PropertiesUtilPage;
import com.automation.tests.base.BaseTest;

public class AutomationTestScripts extends BaseTest {
  static WebDriver driver;

@Test	
	
public static void LoginToSalesForce() {
	System.out.println("******login_to_salesforce automation script started***********");
	String expected="Home Page ~ Salesforce - Developer Edition";
	PropertiesUtilPage pro=new PropertiesUtilPage();
	Properties p=pro.createPropertyObject();
	pro.loadFile("application.properties",p);
	String username=pro.getPropertyValue("login.valid.userid",p);
	String password=pro.getPropertyValue("login.valid.password",p);
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterIntoUsername(username);
	loginPage.enterIntoPassword(password);
	driver=loginPage.LoginButton(driver);
	
	HomePage homePage=new HomePage(driver);
	String actual=homePage.getText(driver);
	Assert.assertEquals(actual, expected);
	
	
	
	
}
	
}
 
	

