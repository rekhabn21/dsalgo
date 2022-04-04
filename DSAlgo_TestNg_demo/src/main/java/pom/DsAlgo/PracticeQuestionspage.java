package pom.DsAlgo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.ExecutionError;

import utils.DsAlgo.TestBase_Dsalgo;





public class PracticeQuestionspage extends TestBase_Dsalgo
{

	public PracticeQuestionspage() throws IOException {
		super();

		try {
			PageFactory.initElements(driver, this);
			}
			catch (ExecutionError e)
			{
				System.out.println(e.getMessage());
			}
	
	}

	
	
	
	
}
