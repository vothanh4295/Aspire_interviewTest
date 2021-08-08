package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessDetailsPage extends BasePage {

	private String regEx_businessNo = "^([0-9]{8,9}[a-zA-Z]{1})$";

	// Page 1
	@FindBy(xpath = "//input[contains(@placeholder,'business name')]")
	private WebElement tbxBusinessDetailFullName;

	@FindBy(xpath = "//div[@label='Entity category']//input")
	private WebElement tbxBusinessDetailCategory;

	@FindBy(xpath = "//div[@label='Entity type']//input")
	private WebElement tbxBusinessDetailType;

	@FindBy(xpath = "//div[contains(@label,'Business registration number')]//input")
	private WebElement tbxBusinessDetailBusinessNo;

	@FindBy(xpath = "//div[@label='Industry']//input")
	private WebElement tbxBusinessDetailIndustry;

	@FindBy(xpath = "//div[@label='Sub-Industry']//input")
	private WebElement tbxBusinessDetailSubIndustry;

	@FindBy(xpath = "//span[text()='Continue']")
	private WebElement btnContinue;

	// Page 2
	@FindBy(xpath = "//div[@label='Business activity']//input")
	private WebElement tbxBusinessDetailActivity;

	@FindBy(xpath = "//div[contains(@label,'detailed example')]//input")
	private WebElement tbxBusinessDetailExample;

	@FindBy(xpath = "//div[contains(@label,'business website')]//input")
	private WebElement tbxBusinessDetailWebsite;

	@FindBy(xpath = "//div[contains(@aria-label,'don’t have a website')]//input")
	private WebElement tbxBusinessDetailWebsiteCheckbox;

	@FindBy(xpath = "//div[contains(@label,'Number of employees')]//input")
	private WebElement tbxBusinessDetailNoOfEmployees;

	@FindBy(xpath = "//div[contains(@label,'Annual turnover')]//input")
	private WebElement tbxBusinessDetailAnnualTurnover;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnSubmit;

	public BusinessDetailsPage() {
		// TODO Auto-generated constructor stub
	}

	public BusinessDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(btnContinue));
	}

	public boolean verifyBusinessNo(String txt_businessNo) {
		return txt_businessNo.matches(regEx_businessNo);
	}

	public void fillBusinessDetail(String txt_businessName, String txt_businessCategory, String txt_businessType,
			String txt_businessNo, String txt_businessIndustry, String txt_businessSubIndustry) {
		if (!verifyBusinessNo(txt_businessNo))
			return;
		// Fill business name
		tbxBusinessDetailFullName.sendKeys(txt_businessName);

		// Select business type
		tbxBusinessDetailCategory.click();
		WebElement tbxBusinessDetailCategoryItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessCategory + "')]"));
		tbxBusinessDetailCategoryItem.click();

		// Select following
		tbxBusinessDetailType.click();
		WebElement tbxBusinessDetailTypeItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessType + "')]"));
		tbxBusinessDetailTypeItem.click();

		// Input business number
		tbxBusinessDetailBusinessNo.sendKeys(txt_businessNo);

		// Select Industry
		tbxBusinessDetailIndustry.click();
		WebElement tbxBusinessDetailIndustryItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessIndustry + "')]"));
		tbxBusinessDetailIndustryItem.click();

		// Select Sub-Industry
		tbxBusinessDetailSubIndustry.click();
		WebElement tbxBusinessDetailSubIndustryItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessSubIndustry + "')]"));
		tbxBusinessDetailSubIndustryItem.click();

		// Continue
		btnContinue.click();
	}

	public void fillMoreDetail(String txt_businessActivity, String txt_businessExample, String txt_businessWebsite,
			String txt_businessNoOfEmployee, String txt_businessAnnualTurnover) {
		// Input activity, examples, website
		tbxBusinessDetailActivity.sendKeys(txt_businessActivity);
		tbxBusinessDetailExample.sendKeys(txt_businessExample);
		tbxBusinessDetailWebsite.sendKeys(txt_businessWebsite);

		// Select number of employees
		tbxBusinessDetailNoOfEmployees.click();
		WebElement tbxBusinessDetailNoOfEmployeesItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessNoOfEmployee + "')]"));
		tbxBusinessDetailNoOfEmployeesItem.click();

		// Select annual turnover
		tbxBusinessDetailAnnualTurnover.click();
		WebElement tbxBusinessDetailAnnualTurnoverItem = driver
				.findElement(By.xpath("//div[contains(text(),'" + txt_businessAnnualTurnover + "')]"));
		tbxBusinessDetailAnnualTurnoverItem.click();

		// Continue
		btnSubmit.click();
	}

	public void fillQuestionaire(String txt_optionYesNo) {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//wait.until(ExpectedConditions.invisibilityOf(btnSubmit));
		By cssPath_radioBox = By.cssSelector("div[aria-label='" + txt_optionYesNo + "']");
		List<WebElement> rbxBusinessDetailQuestionaire = driver.findElements(cssPath_radioBox);
		for (WebElement questionaire : rbxBusinessDetailQuestionaire) {
			questionaire.click();
		}
		btnContinue.click();
	}

	public IdentityDetailsPage fillAllBusinessDetail(String txt_businessName, String txt_businessCategory,
			String txt_businessType, String txt_businessNo, String txt_businessIndustry, String txt_businessSubIndustry,
			String txt_businessActivity, String txt_businessExample, String txt_businessWebsite,
			String txt_businessNoOfEmployee, String txt_businessAnnualTurnover, String txt_optionYesNo) {
		fillBusinessDetail(txt_businessName, txt_businessCategory, txt_businessType, txt_businessNo,
				txt_businessIndustry, txt_businessSubIndustry);
		fillMoreDetail(txt_businessActivity, txt_businessExample, txt_businessWebsite, txt_businessNoOfEmployee,
				txt_businessAnnualTurnover);
		fillQuestionaire(txt_optionYesNo);
		return new IdentityDetailsPage(driver);
	}
}
