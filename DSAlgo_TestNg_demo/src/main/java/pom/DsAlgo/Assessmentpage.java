package pom.DsAlgo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Assessmentpage extends utils.TestBase_Dsalgo {

	public  Assessmentpage() throws IOException {
		super();
	}
	
	@FindBy(xpath="//body//div//div[6]")
	@CacheLookup
	WebElement input_box;
	
	
	@FindBy( css ="button[type='button']")
	@CacheLookup
	WebElement Run_btn;
}
