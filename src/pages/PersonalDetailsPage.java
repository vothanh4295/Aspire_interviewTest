package pages;

import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalDetailsPage extends BasePage {
	@FindBy(css = "input[name='email']")
	private WebElement tbxPersonalDetailEmail;

	@FindBy(xpath = "//input[contains(@placeholder,'date of birth')]")
	private WebElement tbxPersonalDetailDob;

	@FindBy(xpath = "//input[contains(@placeholder,'Nationality')]")
	private WebElement tbxPersonalDetailNationality;

	private By xpathIconLeftArrow = By.xpath("//i[contains(@class,'fa-chevron-left')]//ancestor::button");

	@FindBy(xpath = "//input[contains(@placeholder,'gender')]")
	private WebElement tbxPersonalDetailGender;
	
	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnSubmit;
	
	public PersonalDetailsPage() {
		// TODO Auto-generated constructor stub
	}

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public BusinessDetailsPage fillPersonalDetail(String txt_nationality, String txt_gender) throws InterruptedException {
		tbxPersonalDetailDob.click();

		//Select DOB
		LocalDateTime now = LocalDateTime.now();
		int currentYear = now.getYear();
		int yearOfBirth = currentYear - 19; // Age: 18 - can read from test data
		int day = now.getDayOfMonth();

		WebElement txtCurrentYear = driver.findElement(By.xpath("//span[contains(text(),'" + currentYear + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(txtCurrentYear));
		txtCurrentYear.click();

		By xpathYearOfBirth = By.xpath("//span[contains(text(),'" + yearOfBirth + "')]");
		boolean isPresentYearOfAge;
		WebElement icoLeftArrow = null;

		do {
			isPresentYearOfAge = driver.findElements(xpathYearOfBirth).size() > 0;
			if (!isPresentYearOfAge) {
				icoLeftArrow = driver.findElement(xpathIconLeftArrow);
				icoLeftArrow.click();
			}
		} while (!isPresentYearOfAge);

		WebElement txtYearOfBirth = driver.findElement(xpathYearOfBirth);
		txtYearOfBirth.click();

		WebElement txtDayOfBirth = driver.findElement(By.xpath("//span[text()='" + day + "']"));
		txtDayOfBirth.click();

		//Select Nationality
		tbxPersonalDetailNationality.sendKeys(txt_nationality);
		WebElement txtPersonalDetailNationalityItem = driver
				.findElement(By.xpath("//div[text()='" + txt_nationality + "']"));
		txtPersonalDetailNationalityItem.click();
		
		//Select Gender
		tbxPersonalDetailGender.click();
		WebElement txtPersonalDetailGenderItem = driver
				.findElement(By.xpath("//div[text()='" + txt_gender + "']"));
		txtPersonalDetailGenderItem.click();
		
		//Submit
		btnSubmit.click();
		Thread.sleep(1000);
		new OtpPage(driver);
		Thread.sleep(1000);
		return new BusinessDetailsPage(driver);
	}
	
}
