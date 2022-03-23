package pom.DsAlgo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.ExecutionError;

public class TimeComplexitypage extends utils.TestBase_Dsalgo {

	public TimeComplexitypage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
			}
			catch (ExecutionError e)
			{
				System.out.println(e.getMessage());
			}
		
		
		
	}
		@FindBy(xpath ="//body//div//div//div//strong//p")
		@CacheLookup
		WebElement timecomplexity_header;
		
		@FindBy( css ="a[href='/tryEditor']")
		@CacheLookup
		WebElement	tryHere_btn	;
		
	
		
		
	}


