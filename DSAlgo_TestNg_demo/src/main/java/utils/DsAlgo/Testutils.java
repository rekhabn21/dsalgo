package utils.DsAlgo;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Testutils {

	public static  int Page_Load_TIMEOUT =20;
	public static  int  Implicity_wait=20;

		
	public static String chromepath= "C:\\Users\\rekha\\selenium-ws\\DS-Algodemo\\src\\test\\drivers\\chromedriver.exe";
	public static String firefoxpath= "C:\\Users\\rekha\\selenium-ws\\DS-Algodemo\\src\\test\\drivers\\geckodriver.exe";
	
	public static String Base_URL = "https://dsportalapp.herokuapp.com";
	public static String Base_path_register = "/register";
	public static String Base_path_login = "/login";
	public static String Base_path_home = "/home";
	
	public static String excelFileLocation=	"C:\\Users\\rekha\\selenium-ws\\DSAlgo_TestNg_demo\\test data\\DSAlgo test.xlsx";
	public static String  Registrationdata = "Registrationdata";
	public static String Logindata= "Logindata";
	
}



