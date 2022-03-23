package pom.DsAlgo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DsAlgo.TestBase_Dsalgo;

public class portalhomepage extends TestBase_Dsalgo {

// find the webelements in the portal home page

	@FindBy(xpath = "//a[@href='/home']//button")
	@CacheLookup
	WebElement getstarted_btn;

	

	
	public portalhomepage() throws IOException {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	
	public void getstarted() throws IOException, InterruptedException {
 				
		String pgtitle = driver.getTitle();
		System.out.println("Page title is " + pgtitle);
		
		getstarted_btn.isDisplayed();
		getstarted_btn.click();
		
		Thread.sleep(3000);
		 
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", getstarted_btn);
		
		//driver.navigate().forward();
		//assertEquals(driver.getTitle(),"Numpy Ninja");
		
		System.out.println("=== navigating to Homepage===");
		
		

	}	
}