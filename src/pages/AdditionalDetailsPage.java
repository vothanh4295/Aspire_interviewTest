package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AdditionalDetailsPage extends BasePage {

	@FindBy(xpath = "(//div[contains(@label,'solutions')]/label//div)[4]")
	private WebElement tbxSolution;

	@FindBy(xpath = "//div[contains(text(),'Additional details')]")
	private WebElement txtAdditionDetails;

//	@FindBy(xpath = "//div[contains(@class,'q-item')][contains(@class,'ellipsis')]")
//	private By xpath_lstSolutionItems;

	private int numberOfSolutions = 3;

	@FindBy(css = "button[type='button']")
	private WebElement btnContinue;

	public AdditionalDetailsPage() {
		// TODO Auto-generated constructor stub
	}

	public AdditionalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(txtAdditionDetails));
	}

	public RegistrationMethodPage fillAdditionalDetails() throws InterruptedException {
		Thread.sleep(2000);
		tbxSolution.click();
		By xpath_lstSolutionItems = By.xpath("//div[contains(@class,'q-item')][contains(@class,'ellipsis')]");
		List<WebElement> lstSolutionItems = driver.findElements(xpath_lstSolutionItems);
		if (numberOfSolutions < lstSolutionItems.size()) {
			for (int i = 0; i < numberOfSolutions; i++) {
				lstSolutionItems.get(i).click();
			}
			btnContinue.click();
			return new RegistrationMethodPage(driver);
		}
		return null;
	}
}
