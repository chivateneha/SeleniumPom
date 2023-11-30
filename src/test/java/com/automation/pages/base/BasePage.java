package com.automation.pages.base;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

		  static WebDriver driver = new ChromeDriver();
		static WebDriverWait wait=null;
		

		public BasePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);	
		}
			
		



		public static void goToUrl(String url) {
			driver.get(url);
			System.out.println(url+ "is entered");
		}
		
		public static void maximiseBrowser() {
			driver.manage().window().maximize();
			System.out.println("browser window has maximized");
		}
		public static String getTextFromElement(WebElement ele,String objectName) {
			String data=ele.getText();
			System.out.println("extracted the text from"+objectName);
			return data;
		}
		
		public static void closeBrowser() {
			driver.close();
		}
		public static void quitBrowser() {
			driver.quit();
		}
		public String getTitleOfPage() {
			return driver.getTitle();
		}
		
		
		public static void enterText(WebElement ele,String data,String ObjectName) {
			if (ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(data);
				System.out.println(data+ " is entered in the "+ObjectName);
			} else {
				System.out.println(ObjectName+" element is not displayed");
			}
		}
		
		public static void clickElement(WebElement ele,String ObjectName) {
			if(ele.isEnabled()) {
				ele.click();
				System.out.println(ObjectName+"button is clicked");
				}
				else {
					System.out.println("button element is not enabled");
				}
		}
		
		public static void waitForVisibility(WebElement ele,int time,int pollingtime,String objectName) {
			FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(time))
			.pollingEvery(Duration.ofSeconds(pollingtime))
			.ignoring(ElementNotInteractableException.class);
			
			wait.until(ExpectedConditions.visibilityOf(ele));
			System.out.println(objectName+" is waited for visibility using fluent wait");
		}
		
		public static void waitForVisibility(WebElement ele,int time,String objectNam) {
			wait=new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
		
		public static void SelectfromDropDown (WebElement ele, int index) {
		  Select select = new Select (ele);
		  select.selectByIndex(index);
}

		public static void SelectfromDropDown (WebElement ele, String text) {
		  Select select = new Select (ele);
		 select.selectByVisibleText(text);
		  ArrayList<WebElement> list= (ArrayList<WebElement>)select.getOptions();
		  for(WebElement ele1: list) {
				System.out.println(ele1.getText());	
			}
		}	  
		  public static void switchFrame(WebElement ele, String ObjectName) {
				 
			    if(ele.isDisplayed()) {
			     driver.switchTo().frame(ele);
			     System.out.println("Pass: we can switch to the frame");
			     
			    }else {
			     System.out.println("fail: we can't switch to the frame");
			    }
		  }	    
			    public static void SwitchTodefaultFrame(WebDriver driver){
			    
			    driver.switchTo().defaultContent();
			    System.out.println("we can switch to the  back to frame");
			    
			    
			    }
			    
			    public static void mouseOver(WebDriver driver,WebElement ele) {
			    	if(ele.isDisplayed()) {
			       Actions action=new Actions(driver);
			       action.moveToElement(ele).build().perform();
			    	System.out.println("Pass is present");
			    	}
			     else {
			    		System.out.println("Element is not present.Please chk application");
   	}
			    }
			    public static void switchFrameid(WebDriver driver,String ObjectName) {
			    	 driver.switchTo().frame(ObjectName);
			         System.out.println("we can switch to the "+ObjectName+ " frame");
			         
			        }	
			

              public static void switchtoAlert(WebDriver driver) {
            	  driver.switchTo().alert().accept();
            		 System.out.println("Pass: alert is present and accept");
            	}  
       
              public static void selectCheckBox(WebElement obj, String objName) {
          		
          		if(obj.isDisplayed()) {
          			
          			if(obj.isSelected()) {
          				System.out.println("Pass: "+objName+" is already selected");
          			}else{
          			obj.click();
          			System.out.println("Pass: "+objName+" is selected");

          		    }}
          			else {
          			System.out.println("Fail:"+objName+" is not present.Please chk application");	

          		}	
          	}
}

	
		
	