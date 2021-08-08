package tests;

import org.junit.Assert;
import org.junit.Test;

import pages.*;

public class Testcase extends TestBase {

	@Test
	public void end2end() throws InterruptedException {
		LandingPage step0 = new LandingPage(driver);
		RegisterPage step1 = step0.register();
		BusinessRolePage step2 = step1.registerNewAccount("Thanh Vo", "vothanh0031@gmail.com", "00000031", "1234");
		AdditionalDetailsPage step3 = step2.selectBusinessRole("director");
		RegistrationMethodPage step4 = step3.fillAdditionalDetails();
		PersonalDetailsPage step5 = step4.registerStandard();
		BusinessDetailsPage step6 = step5.fillPersonalDetail("Singapore", "Male");
		IdentityDetailsPage step7 = step6.fillAllBusinessDetail("Aspire Company Singapore Investing In Tomorrow", "Limited companies",
				"Limited partnership", "123456789m", "Business Services", "Education", "We help companies pay, manage, and earn smarter",
				"by doing more than a bank, bookkeeper, or reward program could ever do alone",
				"https://aspireapp.com/", "51-200", "$1,331", "No");
		Assert.assertTrue(step7.verifyTitle());
	}

}
