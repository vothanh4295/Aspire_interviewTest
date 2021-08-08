package tests;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver = null;
	public WebDriverWait wait = null;
	public final String url = "https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/config/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,20);
	}

//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}
}
