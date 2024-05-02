package genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.genericutilities.JavaUtility;
import com.vtiger.objectRepositories.LoginPage;

public class Baseclass {
	public PropertyFileUtility pu=new PropertyFileUtility();
	public ExcelFileUtility eu=new ExcelFileUtility();
	public JavaUtility ju=new JavaUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public WebDriver driver=null;//for run time polymorphism
	
	@BeforeSuite
	public void bsconfig() {
		System.out.println("...DB CONNECTION...");
	}
	@AfterSuite
	public void asconfig() {
		System.out.println("....DB DISCONNECTION....");
		
	}
	@BeforeClass
	public void bcconfig() throws Throwable {
		String BROWSER=pu.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		String URL=pu.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			System.out.println("edge driver is launched");
		
		}
		else if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("chrome driver is launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
       driver.get(URL);
       wu.getScreenshot(driver, "LoginPage");
       wu.maximizeBrowserWindow(driver);
       wu.WaitForPageload(driver);
	}
       @AfterClass
       public void terDown() {
    	   driver.quit();
       }
       @BeforeMethod
       public void bmconfig() throws Throwable {
    	   String UN=pu.readDataFromPropertyFile("un");
    	   String PWD=pu.readDataFromPropertyFile("pwd");
    	   LoginPage lp=new LoginPage(driver);
    	   lp.loginToApp(UN, PWD);
    	   wu.getScreenshot(driver, "HomePage");
       }
       @AfterMethod
       public void amconfig() {
    	   System.out.println("log out from app");
       
    	   
       }
		
		
	}
