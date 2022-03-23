package utils.DsAlgo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Testutils;

public class TestBase_Dsalgo {

	public static WebDriver  driver;
	public static Properties prop;
	
	
	public TestBase_Dsalgo() throws IOException {
	
		try {
		prop= new Properties();
		FileInputStream FIS = new FileInputStream("C:\\Users\\rekha\\selenium-ws\\DS-Algodemo\\src\\main\\java\\config_Dsalgo\\config.properties");
		prop.load(FIS);
	} 
				catch(IOException e) {
				e.getCause();
			}
	}
		
	public static void Intialization() {
		  	
			String browserName = prop.getProperty("browser");
			System.out.println("Browser : " + browserName);
			
			if (browserName.equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",Testutils.chromepath);
				driver= new ChromeDriver();	
			}
			else if (browserName.equals("FF")) {
				
				System.setProperty("webdriver.chrome.driver",Testutils.firefoxpath);
				driver= new FirefoxDriver();	
			}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutils.Page_Load_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutils.Implicity_wait, TimeUnit.SECONDS);
		
		System.out.println("opens new chrome Browser");
		 	
	}
	
	
	
	}

	
	

