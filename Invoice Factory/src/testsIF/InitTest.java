package testsIF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class InitTest {
	 static WebDriver driver;
	  @BeforeSuite
	  public static void SetUp() {
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
	  }
//	  @AfterTest
//	  public static void clearCookies()
//	  {
//	  driver.manage().deleteAllCookies();
//	  }
	  @AfterSuite
	  public void tearDown() {
		  driver.close();
	  }
}
