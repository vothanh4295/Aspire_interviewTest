package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

	@FindBy(css = "input[name='full_name']")
	private WebElement tbxRegisterFullName;

	@FindBy(css = "input[name='email']")
	private WebElement tbxRegisterEmail;

	@FindBy(css = "input[name='phone']")
	private WebElement tbxRegisterPhone;

	@FindBy(css = "input[type='search']")
	private WebElement tbxRegisterHearAbtUs;

	@FindBy(xpath = "//input[@type='checkbox']/parent::div")
	private WebElement cbxRegisterTerms;

	@FindBy(css = "button[type='button']")
	private WebElement btnContinue;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement txtLogin;

	@FindBy(xpath = "//div[contains(text(),'Wohoo!')]")
	private WebElement txtSuccessRegister;

	public RegisterPage() {
		// TODO Auto-generated constructor stub
	}

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public BusinessRolePage registerNewAccount(String txt_fullName, String txt_email, String txt_phone,
			String txt_pinNo) {
		tbxRegisterFullName.sendKeys(txt_fullName);
		tbxRegisterEmail.sendKeys(txt_email);
		tbxRegisterPhone.sendKeys(txt_phone);
		tbxRegisterHearAbtUs.click();

		By xpath_hearAbotUsItem = By.xpath("//div[@class='q-item__label'][contains(text(),'Brochure')]");
		WebElement tbxRegisterHearAbtUsSelectedItem = driver.findElement(xpath_hearAbotUsItem);
		tbxRegisterHearAbtUsSelectedItem.click();

		cbxRegisterTerms.click();
		btnContinue.click();
		new OtpPage(driver);

		if (verifySuccessfullyRegister()) {
			btnContinue.click();
			return new BusinessRolePage(driver);
		}

		return null;
	}

	public boolean verifySuccessfullyRegister() {
		wait.until(ExpectedConditions.visibilityOf(txtSuccessRegister));
		return txtSuccessRegister.isDisplayed();
	}

	public LandingPage backtoLogin() {
		txtLogin.click();
		return new LandingPage();
	}
}
