package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessRolePage extends BasePage {
	
	@FindBy(xpath = "//div[contains(text(),'Tell us more about yourself')]")
	private WebElement txtBusinessRole;

	public BusinessRolePage() {
		// TODO Auto-generated constructor stub
	}

	public BusinessRolePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(txtBusinessRole));
	}

	public AdditionalDetailsPage selectBusinessRole(String txt_businessRole) {
		By xpath_role = By.xpath("//img[contains(@src,'" + txt_businessRole + "')]");
		WebElement txtRole = driver.findElement(xpath_role);
		txtRole.click();
		return new AdditionalDetailsPage(driver);
	}
}
