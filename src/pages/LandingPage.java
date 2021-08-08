package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {
	@FindBy(xpath = "//div[contains(text(),'Login to Aspire')]")
	private WebElement txtLoginAspire;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement tbxPhone;

	@FindBy(xpath = "//div[contains(@style,'flags')]")
	private WebElement lstFlags;

	// @FindBy(xpath = "//a[contains(text(),'Register')]")
	
	//@FindBy(linkText = "Register")
	@FindBy(xpath = "//a[contains(@class,'register-link')]")
	private WebElement txtRegister;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;

	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public LandingPage() {
	};

	public OtpPage loginWithPhone(String txt_phoneNo, String txt_pinNo) {
		tbxPhone.sendKeys(txt_phoneNo);
		btnLogin.click();
		return new OtpPage(driver);
	}

	public RegisterPage register() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtRegister.click();
		return new RegisterPage(driver);
	}
}
