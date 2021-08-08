package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationMethodPage extends BasePage {

	@FindBy(xpath = "//div[contains(text(),'Standard Registration')]/parent::div/following-sibling::button")
	private WebElement btnStandardRegis;

	@FindBy(xpath = "//div[contains(text(),'Register via Myinfo Business')]/parent::div/following-sibling::button")
	private WebElement btnMyinfoRegis;

	public RegistrationMethodPage() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationMethodPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(btnStandardRegis));
	}

	public void registerWithMyInfo() {
		btnMyinfoRegis.click();
	}

	public PersonalDetailsPage registerStandard() {
		btnStandardRegis.click();
		return new PersonalDetailsPage(driver);
	}
}
