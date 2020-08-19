package ServiceNow.COVIDCode.StepsImplementation;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.nci.automation.utils.CucumberLogUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.JavascriptUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

import appsCommon.PageInitializer;

public class ServicePortalEQPageImpl extends PageInitializer{
	
	public void covidCodeServicePortalLogin() throws TestingException {
		WebDriverUtils.webDriver.get(EnvUtils.getApplicationUrl("Code"));
		CucumberLogUtils.logScreenShot();
		covidCodeLoginPage.AcceptandCompleteQuestionnaireButton.click();
		CucumberLogUtils.logScreenShot();
		loginImpl.loginToITrust();	
	}
	
	public static void group1EQSubmissionWithoutDiseaseCourseAndRiskFactorsInfo(String groupUserID, String consent) {
		groupUserAndConsent(groupUserID, consent);
		requiredDemographicsInfo();
		submittingEQ();
	}
	
	public static void groupUserAndConsent(String groupUserID, String consent) {

		covidCodeEQPage.userGroupIdDropdown.click();
		List<WebElement> groupIDs = covidCodeEQPage.dropDownValues;
		for (WebElement element : groupIDs) {
			if (element.getText().contains(groupUserID)) {
				element.click();
				break;
			}
		}
		// scrolling down page
		JavascriptUtils.scrollDown(700);
		covidCodeEQPage.consentDropdown.click();
		List<WebElement> consentValues = covidCodeEQPage.dropDownValues;
		for (WebElement value : consentValues) {
			if (value.getText().contains(consent)) {
				value.click();
				break;
			}
		}

	}

	/**
	 * 
	 * This method fills out full name, required information labeled with *, and
	 * Demographics information Values are hard coded and can be changed accordingly
	 */
	public static void requiredDemographicsInfo() {

		covidCodeEQPage.patientLastNameTextBox.sendKeys("AutomatedLN");
		covidCodeEQPage.patientFirstNameTextBox.sendKeys("AutomatedFN");
		covidCodeEQPage.patientMiddletNameTextBox.sendKeys("M");
		covidCodeEQPage.patientEmailAddressTextBox.sendKeys("email@email.com");
		covidCodeEQPage.patientPhoneNumberTextBox.sendKeys("1112223333");
		covidCodeEQPage.patientStreetAddress1TextBox.sendKeys("123 street");
		JavascriptUtils.scrollDown(700);
		covidCodeEQPage.patientCityTextBox.sendKeys("Rockville");
		covidCodeEQPage.patientStateTextBox.sendKeys("MD");
		covidCodeEQPage.patientZipCodeTextBox.sendKeys("12345");
		JavascriptUtils.scrollDown(300);
		JavascriptUtils.selectDateByJS(covidCodeEQPage.dateFormCompleted, "04-06-2020");
		JavascriptUtils.selectDateByJS(covidCodeEQPage.DOBCalendar, "04-01-2000");
		covidCodeEQPage.biologicalSexDropdown.click();
		List<WebElement> biologicalSexValues = covidCodeEQPage.dropDownValues;
		for (WebElement value : biologicalSexValues) {
			System.out.println(value);
			if (value.getText().contains("Male")) {
				value.click();
				break;
			}
		}
		covidCodeEQPage.currentWeightDropdown.click();
		List<WebElement> currentWeightValues = covidCodeEQPage.dropDownValues;
		for (WebElement value : currentWeightValues) {
			if (value.getText().contains("Pounds")) {
				value.click();
				break;
			}
		}
		covidCodeEQPage.weightTextBox.sendKeys("200");
		covidCodeEQPage.raceDropdown.click();
		List<WebElement> raceValues = covidCodeEQPage.dropDownValues;
		for (WebElement value : raceValues) {
			if (value.getText().contains("Asian")) {
				value.click();
				break;
			}
		}
		covidCodeEQPage.hispanicOrLatinoDropdown.click();
		List<WebElement> hispanicOrLatinoValues = covidCodeEQPage.dropDownValues;
		for (WebElement value1 : hispanicOrLatinoValues) {
			if (value1.getText().contains("Yes")) {
				value1.click();
				break;
			}
		}
		covidCodeEQPage.currentHeightDropdown.click();
		List<WebElement> heightDropdownValues = covidCodeEQPage.dropDownValues;
		for (WebElement value : heightDropdownValues) {
			if (value.getText().contains("Foot/Inches")) {
				value.click();
				break;
			}
		}
		covidCodeEQPage.feetTextBox.sendKeys("5");
		covidCodeEQPage.inchesTextBox.sendKeys("10");
		// selectDateByJS(EQPage.whenDevelopSymptoms, "04-01-2020");
		covidCodeEQPage.whenDevelopSymptoms.sendKeys("04-01-2020");
		// selectDateByJS(EQPage.whenOfficiallyDiagnosed, "04-04-2020");
		covidCodeEQPage.whenOfficiallyDiagnosed.sendKeys("04-04-2020");
	}

	/**
	 * This method clicks on submit button and clicks on yes on the submission pop
	 * up
	 */
	public static void submittingEQ() {
		covidCodeEQPage.submitButton.click();
		covidCodeEQPage.YesButton.click();
	}


}