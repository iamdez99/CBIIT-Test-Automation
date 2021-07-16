package ServiceNow.AppTracker.StepsImplementation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.nci.automation.utils.CucumberLogUtils;
import com.nci.automation.utils.MiscUtils;
import com.nci.automation.web.CommonUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.JavascriptUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

import ServiceNow.AppTracker.Pages.VacancyManagerUserPage;
import appsCommon.PageInitializer;

public class VacancyManagerUserStepsImpl extends PageInitializer {

	public void verifyVacancyDashboardHeader() throws TestingException {
		String actualText = vacancyManagerUserPage.vacancyDashboardPageHeader.getText();
		CucumberLogUtils.logScreenShot();
		String expectedText = "Vacancy Dashboard";
		MiscUtils.sleep(2000);
		Assert.assertEquals("Verifying Vacancy Manager sees Vacancy Dashboard text", expectedText, actualText);
	}

	public void verifyHomePageHeader() throws TestingException {
		String actualText = vacancyManagerUserPage.homePageHeader.getText();
		CucumberLogUtils.logScreenShot();
		String expectedText = "Senior Scientific Careers at NCI";
		MiscUtils.sleep(2000);
		Assert.assertEquals("Verifying Home Page Header", expectedText, actualText);
	}

	public void selectNumRecomendationLetters(Integer num) {;
		switch (num) {
		case 0:
			CommonUtils.click(WebDriverUtils.getWebDriver()
					.findElement(By.xpath("(//span[@class='ant-slider-mark-text ant-slider-mark-text-active'])[1]")));
			MiscUtils.sleep(3000);
			CommonUtils.click(vacancyManagerUserPage.reviewSection);
			JavascriptUtils.scrollUp(600);
			MiscUtils.sleep(2000);
			Assert.assertEquals(vacancyManagerUserPage.numberOfLettersOfRecommendation0.getAttribute("innerText"),
						"0" + " recommendations");
			break;
		case 1:
			CommonUtils.click(WebDriverUtils.getWebDriver()
					.findElement(By.xpath("(//span[@class='ant-slider-mark-text ant-slider-mark-text-active'])[2]")));
			MiscUtils.sleep(3000);
			CommonUtils.click(vacancyManagerUserPage.reviewSection);
			JavascriptUtils.scrollUp(600);
			MiscUtils.sleep(2000);
			Assert.assertEquals(vacancyManagerUserPage.numberOfLettersOfRecommendation1.getAttribute("innerText"),
					"1" + " recommendations");
			break;
		case 2:
			CommonUtils.click(WebDriverUtils.getWebDriver()
					.findElement(By.xpath("(//span[@class='ant-slider-mark-text ant-slider-mark-text-active'])[3]")));
			MiscUtils.sleep(3000);
			CommonUtils.click(vacancyManagerUserPage.reviewSection);
			JavascriptUtils.scrollUp(600);
			MiscUtils.sleep(2000);
			Assert.assertEquals(vacancyManagerUserPage.numberOfLettersOfRecommendation2.getAttribute("innerText"),
					"2" + " recommendations");
			break;
		case 3:
			MiscUtils.sleep(3000);
			CommonUtils.click(vacancyManagerUserPage.reviewSection);
			JavascriptUtils.scrollUp(600);
			MiscUtils.sleep(2000);
			Assert.assertEquals(vacancyManagerUserPage.numberOfLettersOfRecommendation3.getAttribute("innerText"),
					"3" + " recommendations");
		break;
		default:
			break;
		}
	}

	public void verifyTabsOnVacancyManagerPage(List<String> names) {
		List<WebElement> namesList = WebDriverUtils.webDriver.findElements(By.xpath("//p[@class='vacancy-desc']"));
		System.out.println("size of all tabs " + namesList.size());

		for (WebElement each : namesList) {
			System.out.println("each tab name " + each.getText());

			if (names.contains(each.getText())) {
				System.out.println("true");

			} else {
				System.out.println("false");
			}

		}
	}

	public void verifyTabsCountOnVacancyManagerPage() {
		List<WebElement> countList = WebDriverUtils.webDriver.findElements(By.xpath("//p[@class='num-count']"));
		System.out.println("count of all tabs " + countList.size());
		for (WebElement each : countList) {
			System.out.println("each count of all tabs " + each.getText());

		}
	}

	public void selectOpenDate(String date) {
		vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection.sendKeys(date);
		MiscUtils.sleep(2000);

	}

	public void selectCloseDate(String date) {
		vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection.sendKeys(date);
		MiscUtils.sleep(2000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
	}

	public void selectToggleButtonOnMandatoryStatementPage(String nameButton) {
		if (nameButton.equals("Equal Opportunity Employer")) {
			CommonUtils.click(vacancyManagerUserPage.toggleButtonEqualOpportunityEmployer);
			CucumberLogUtils.logScreenShot();

		} else if (nameButton.equals("Standards of Conduct/Financial Disclosure")) {
			CommonUtils.click(vacancyManagerUserPage.toggleButtonStandardsOfConduct);
			CucumberLogUtils.logScreenShot();

		} else if (nameButton.equals("Foreign Education")) {

			CommonUtils.click(vacancyManagerUserPage.toggleButtonForeignEducation);
			CucumberLogUtils.logScreenShot();

		} else if (nameButton.equals("Reasonable Accommodation")) {
			CommonUtils.click(vacancyManagerUserPage.toggleButtonReasonableAccommodation);
			CucumberLogUtils.logScreenShot();
		}
	}

	public void selectCommitteeMemberFromDropDown(String searchOption) {
		if (searchOption.equals("Abdullah Sharif")) {
			CommonUtils.click(vacancyManagerUserPage.addMemberButton);
			CommonUtils.click(vacancyManagerUserPage.committeeMemberDropdown);
			CommonUtils.click(vacancyManagerUserPage.abdullahSharifMember);
			MiscUtils.sleep(1000);
		} else if (searchOption.equals("Connor Scoring")) {
			CommonUtils.click(vacancyManagerUserPage.addMemberButton);
			CommonUtils.click(vacancyManagerUserPage.committeeMemberDropdown);
			CommonUtils.click(vacancyManagerUserPage.connorScoringMember);
			MiscUtils.sleep(1000);
		} else if (searchOption.equals("APPTRACK VACANCY MANAGER")) {
			CommonUtils.click(vacancyManagerUserPage.addMemberButton);
			CommonUtils.click(vacancyManagerUserPage.committeeMemberDropdown);
			CommonUtils.click(vacancyManagerUserPage.apptrackVacancyManager);
			MiscUtils.sleep(1000);
		}
	}

	public void selectRole(String roleOption) {
		if (roleOption.equals("Chair")) {
			CommonUtils.click(vacancyManagerUserPage.roleDropdown);
			CommonUtils.click(vacancyManagerUserPage.roleChair);
			MiscUtils.sleep(1000);
			CommonUtils.click(vacancyManagerUserPage.saveButtonAddingMember);
		} else if (roleOption.equals("Executive Secretary")) {
			CommonUtils.click(vacancyManagerUserPage.roleDropdown);
			CommonUtils.click(vacancyManagerUserPage.roleExecutiveSecretary);
			MiscUtils.sleep(1000);
			CommonUtils.click(vacancyManagerUserPage.saveButtonAddingMember);
		} else if (roleOption.equals("Member (voting)")) {
			CommonUtils.click(vacancyManagerUserPage.roleDropdown);
			CommonUtils.click(vacancyManagerUserPage.roleMemberVoting);
			CommonUtils.click(vacancyManagerUserPage.saveButtonAddingMember);
		}

	}

	public void selectOpenCloseDate(int openDate, int closeDate) {
		JavascriptUtils.scrollIntoView(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(openDate));
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection);
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(closeDate));
		MiscUtils.sleep(2000);
		

	}
}
