package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage() {
		// TODO Auto-generated constructor stub
	}

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
	}

}
