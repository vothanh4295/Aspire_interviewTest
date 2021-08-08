package pages;

import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IdentityDetailsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Get Started']")
	private WebElement btnIdentityGetStarted;

	@FindBy(xpath = "//span[text()='Begin Verification']")
	private WebElement btnIdentityBeginVerification;

	@FindBy(css = "input[name='nric']")
	private WebElement tbxIdentityCardNo;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnIdentitySubmit;

	@FindBy(xpath = "//div[contains(text(),'You are amazing and you know it')]")
	private WebElement txtIdentitySuccessfulMessage;
	
	@FindBy(xpath = "//span[text()='Continue']")
	private WebElement btnIdentityContinue;
	
	@FindBy(xpath = "//div[contains(text(),'We are on it')]")
	private WebElement txtIdentitySuccessfulMessage2;
	
	@FindBy(xpath = "//div[contains(text(),'Information needed')]")
	private WebElement txtIdentityTitle;

	public IdentityDetailsPage() {
		// TODO Auto-generated constructor stub
	}

	public IdentityDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void fillIdentityDetail(String txt_IdentityCardNo) {
		btnIdentityGetStarted.click();
		btnIdentityBeginVerification.click();

		// Sleep 30s for manual executing
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Go on
		tbxIdentityCardNo.sendKeys(txt_IdentityCardNo);
		btnIdentitySubmit.click();
	}

	public boolean verifySuccessfullySubmit() {
		if (txtIdentitySuccessfulMessage.isDisplayed()) {
			btnIdentityContinue.click();
			return txtIdentitySuccessfulMessage2.isDisplayed();
		}
		return false;
	}
	
	public boolean verifyTitle() {
		wait.until(ExpectedConditions.visibilityOf(txtIdentityTitle));
		return txtIdentityTitle.isDisplayed();
	}
}
