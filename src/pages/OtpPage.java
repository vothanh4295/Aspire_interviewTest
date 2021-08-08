package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OtpPage extends BasePage {
	private final String txt_pinNo = "1234";
	@FindBy(xpath = "//input[@inputmode='numeric']")
	protected WebElement tbxPin;

	@FindBy(xpath = "//div[contains(@class,'digit-input')][contains(@class,'cursor')]")
	protected List<WebElement> tbxPinIndex;

	public OtpPage() {
		// TODO Auto-generated constructor stub
		inputOtp();
	}

	public OtpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		inputOtp();
	}

	public void inputOtp() {
		wait.until(ExpectedConditions.visibilityOfAllElements(tbxPinIndex));
		tbxPin.sendKeys(txt_pinNo);
		wait.until(ExpectedConditions.invisibilityOfAllElements(tbxPinIndex));
	}
	
	public List<WebElement> getOtpIndex() {
		return tbxPinIndex;
	}
	
	public WebElement getOtpInput() {
		return tbxPin;
	}
}
