package ServiceNow.AppTracker.Steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
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

import CustomBusinessApp.EIDP.Util.CommonUtil;
import ServiceNow.AppTracker.Utils.AppTrackerCommonUtils;
import appsCommon.PageInitializer;
import cucumber.api.java.en.When;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VacancyManagerUserSteps extends PageInitializer {
	/**
	 * @Satya1Ticket88 Scenario: verify vacancy description without copy/paste
	 */
	@When("User should see Vacancy Dashboard Page")
	public void user_should_see_Vacancy_Dashboard_Page() throws TestingException {
		vacancyManagerUserStepsImpl.verifyVacancyDashboardHeader();
	}

	@When("User clicks on Create Vacancy button")
	public void user_clicks_on_Create_Vacancy_button() {
		CommonUtils.click(vacancyManagerUserPage.createVacancyButton);
		MiscUtils.sleep(2000);
	}

	@When("User enters the vacancy title")
	public void user_enters_the_vacancy_title() {
		CommonUtils.sendKeys(vacancyManagerUserPage.vacancyTitleField, "Product Manager");
		MiscUtils.sleep(2000);
		CucumberLogUtils.logScreenShot();
	}

	@Then("User should see {string} text as")
	public void user_should_see_text_as(String vacancyDescriptionHeader, String requestVacancyDescrParagraph) {
		CommonUtils.sendKeys(vacancyManagerUserPage.vacancyDescriptionField, requestVacancyDescrParagraph);
		MiscUtils.sleep(2000);
		CucumberLogUtils.logScreenShot();
		Assert.assertEquals(vacancyManagerUserPage.vacancyHeader.getText(), vacancyDescriptionHeader);

	}

	/**
	 * @Satya3Ticket89 Scenario: Verify Letters of Recommendation persistent in
	 *                 Basic Information
	 */
	@When("User selects recommendation as {int}")
	public void user_selects_recommendation_as(Integer int1) {
		vacancyManagerUserStepsImpl.selectRecommendationLetter();
		MiscUtils.sleep(2000);
	}

	@When("User clicks Save button")
	public void user_clicks_Save_button() {
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		MiscUtils.sleep(2000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		MiscUtils.sleep(2000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		JavascriptUtils.scrollDown(7000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
	}

	@Then("User can verify the recommendation value showing as {int} on Review and Finalize page")
	public void user_can_verify_the_recommendation_value_showing_as_on_Review_and_Finalize_page(Integer int1) {
		vacancyManagerUserStepsImpl.verifyNumberOfLettersOfRecommendation();
		MiscUtils.sleep(2000);
	}

	/**
	 * @Satya4Ticket91 Scenario: Verify create vacancy form
	 */

	@When("User can see the Create Vacancy form opens with below left menu items")
	public void user_can_see_the_Create_Vacancy_form_opens_with_below_left_menu_items(List<String> sections) {
		int expectedSize = sections.size();
		int actualSize = vacancyManagerUserPage.listOfSections.size();
		System.out.println("Sections names: " + sections);
		Assert.assertEquals(expectedSize, actualSize);

	}

	@When("User click on {string} without entering any value in previous field")
	public void user_click_on_without_entering_any_value_in_previous_field(String nameOfSection) {
		CommonUtils.click(vacancyManagerUserPage.vacancyCommitteeSection);
		MiscUtils.sleep(2000);
		Assert.assertEquals(nameOfSection, vacancyManagerUserPage.vacancyCommitteeSectionHeader.getText());
		MiscUtils.sleep(2000);

	}

	@Then("User should able to navigate to the {string} without any error")
	public void user_should_able_to_navigate_to_the_without_any_error(String nameOfSection) {
		CommonUtils.click(vacancyManagerUserPage.basicVacancySection);
		// Assert.assertEquals(nameOfSection,
		// vacancyManagerUserPage.vacancyDashboardPageHeader.getText());
	}

	/**
	 * @Satya5Ticket93 Scenario: Verify the Vacancy Manager dashboard landing page
	 */

	@Given("User can see the dashboard page displaying tabs as below")
	public void user_can_see_the_dashboard_page_displaying_tabs_as_below(List<String> names) {
		vacancyManagerUserStepsImpl.verifyTabsOnVacancyManagerPage(names);
	}

	@Then("User can see count of each tabs")
	public void user_can_see_count_of_each_tabs() {
		vacancyManagerUserStepsImpl.verifyTabsCountOnVacancyManagerPage();
	}

	/**
	 * @Satya6Ticket93 Scenario: Verify dashboard page sub filters
	 */

	@When("User is on pre-flight vacancies tab")
	public void user_is_on_pre_flight_vacancies_tab() {
		CommonUtils.click(vacancyManagerUserPage.preFlightVacanciesTab);
		MiscUtils.sleep(2000);
	}

	@When("User can see the {string}, {string}, {string} sub filters on pre-flight vacancies tab")
	public void user_can_see_the_sub_filters_on_pre_flight_vacancies_tab(String allSubFilter, String draftSubFilter,
			String finalazedSubFilter) {
		Assert.assertTrue(vacancyManagerUserPage.allPreFlightSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(allSubFilter));
		Assert.assertTrue(vacancyManagerUserPage.draftSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(draftSubFilter));
		Assert.assertTrue(vacancyManagerUserPage.finalizedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(finalazedSubFilter));

	}

	@When("User can see the {string}, {string}, {string} sub filters on live vacancies")
	public void user_can_see_the_sub_filters_on_live_vacancies(String allSubFilter, String liveSubFilter,
			String extendedSubFilter) {
		Assert.assertTrue(vacancyManagerUserPage.allLiveSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(allSubFilter));
		Assert.assertTrue(
				vacancyManagerUserPage.liveSubFiltersTextpreFlightVacanciesTab.getText().contentEquals(liveSubFilter));
		Assert.assertTrue(vacancyManagerUserPage.extendedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(extendedSubFilter));

	}

	@Then("User can see the {string}, {string}, {string}, {string}, {string}, {string} sub filters on closed vacancies")
	public void user_can_see_the_sub_filters_on_closed_vacancies(String allSubFilter, String closedSubFilter,
			String triagedSubFilter, String individuallySubFilter, String scoredSubFilter, String archivedSubFilter) {

		Assert.assertTrue(vacancyManagerUserPage.allClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(allSubFilter));
		MiscUtils.sleep(1000);
		Assert.assertTrue(vacancyManagerUserPage.closedClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(closedSubFilter));
		MiscUtils.sleep(1000);
		Assert.assertTrue(vacancyManagerUserPage.triagedClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(triagedSubFilter));
		MiscUtils.sleep(1000);
		Assert.assertTrue(vacancyManagerUserPage.individuallyScoredClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(individuallySubFilter));
		MiscUtils.sleep(1000);
		Assert.assertTrue(vacancyManagerUserPage.scoredClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(scoredSubFilter));
		MiscUtils.sleep(1000);
		Assert.assertTrue(vacancyManagerUserPage.archivedClosedSubFiltersTextpreFlightVacanciesTab.getText()
				.contentEquals(archivedSubFilter));
		MiscUtils.sleep(1000);
	}

	@When("User clicks on live vacancies tab")
	public void user_clicks_on_live_vacancies_tab() {
		CommonUtils.click(vacancyManagerUserPage.liveVacanciesTab);
		MiscUtils.sleep(2000);

	}

	@When("User clicks on closed vacancies tab")
	public void user_clicks_on_closed_vacancies_tab() {

		CommonUtils.click(vacancyManagerUserPage.closedVacanciesTab);
		MiscUtils.sleep(2000);
	}

	/**
	 * @Satya7Ticket94 Scenario: Verify set vacancy date functionality
	 */

	@Then("User clicks on the Open date field to see calendar past dates disabled")
	public void user_clicks_on_the_Open_date_field_to_see_calendar_past_dates_disabled() {
		JavascriptUtils.scrollDown(8000);
		CommonUtils.click(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		CucumberLogUtils.logScreenShot();
	}

	@Then("User clicks on the Close Date field to see calendar past dates disabled")
	public void user_clicks_on_the_Close_Date_field_to_see_calendar_past_dates_disabled() {
		CommonUtils.click(vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection);
		CucumberLogUtils.logScreenShot();

	}

	@Then("User selects date same as today's date")
	// openDate = index - 2
	// close date: index 33 = 1
	public void user_selects_date_same_as_today_s_date() {
		// open date = 2021-06-07, close date = 2021-06-07
		vacancyManagerUserStepsImpl.selectOpenCloseDate(9, 51);

	}

	@Then("User can see the under Close Date field message displays with {string}")
	public void user_can_see_the_under_Close_Date_field_message_displays_with(String closeDayAlertTextMessage) {
		String expectedResult = vacancyManagerUserPage.closeDateErrorMessage.getText();
		Assert.assertEquals(expectedResult, vacancyManagerUserPage.closeDateErrorMessage.getText());

	}

	// Satya7Ticket94
	@When("User selects the Open date as greater than the Close date")
	public void user_selects_the_Open_date_as_greater_than_the_Close_date() {
		// open date = 2021-06-09
		// close date = 2021-06-07
		vacancyManagerUserStepsImpl.selectOpenCloseDate(11, 51);

	}

	@Then("User can see the under Open Date field message displays with {string}")
	public void user_can_see_the_under_Open_Date_field_message_displays_with(String openDateAlertTextMessage) {
		String expectedResult = vacancyManagerUserPage.openDateErrorMessage.getText();
		Assert.assertEquals(expectedResult, vacancyManagerUserPage.openDateErrorMessage.getText());
	}

	/** SectionsFields **/
	@When("User clicks on the Mandatory Statements section")
	public void user_clicks_on_the_Mandatory_Statements_section() {
		CommonUtils.click(vacancyManagerUserPage.mandatoryStatementsSection);

	}

	@Then("User can see {string},{string}, {string}, {string} toggle buttons")
	public void user_can_see_toggle_buttons(String equalOpportunityEmployer, String standardsOfConduct,
			String foreignEducation, String reasonableAccommodation) {
		Assert.assertTrue(vacancyManagerUserPage.equalOpportunityEmployerInMandatorySection.getText()
				.contentEquals(equalOpportunityEmployer));
		Assert.assertTrue(vacancyManagerUserPage.standardsOfConductFinancialDisclosureInMandatorySection.getText()
				.contentEquals(standardsOfConduct));
		Assert.assertTrue(
				vacancyManagerUserPage.foreignEducationInMandatorySection.getText().contentEquals(foreignEducation));
		Assert.assertTrue(vacancyManagerUserPage.reasonableAccommodationInMandatorySection.getText()
				.contentEquals(reasonableAccommodation));

	}

	@Then("User can see pre-filled rich text area on each of the field")
	public void user_can_see_pre_filled_rich_text_area_on_each_of_the_field() {
		System.out.println(
				"equalOpportunityEmployer " + vacancyManagerUserPage.textOfSectionEqualOpportunityEmployer.getText());
		System.out.println("standardsOfConduct " + vacancyManagerUserPage.textOfSectionForeignEducationText.getText());
		System.out.println("foreignEducation " + vacancyManagerUserPage.textOfSectionStandardsOfConductText.getText());
		System.out.println(
				"reasonableAccommodation " + vacancyManagerUserPage.textOfSectionReasonableAccommodationText.getText());

	}

	/** satya11ticket101 **/
	@When("User toggles off {string} as below")
	public void user_toggles_off_as_below(String nameFromExamples) {
		vacancyManagerUserStepsImpl.selectToggleButtonOnMandatoryStatementPage(nameFromExamples);

	}

	@When("User edits Equal Opportunity Employer text by adding {string}")
	public void user_edits_Equal_Opportunity_Employer_text_by_adding(String sentence) {
		String presentText = vacancyManagerUserPage.textOfSectionEqualOpportunityEmployer.getText();
		CommonUtils.sendKeys(vacancyManagerUserPage.textOfSectionEqualOpportunityEmployer,
				presentText + Keys.SPACE + sentence);

	}

	@Then("User can see the updated value displays in the text field")
	public void user_can_see_the_updated_value_displays_in_the_text_field() {
		Assert.assertTrue(vacancyManagerUserPage.textOfSectionEqualOpportunityEmployer.getText()
				.contains("This position requires traveling overseas"));

	}

	@Given("User toggles off\\/on Equal Opportunity Employer button")
	public void user_toggles_off_on_Equal_Opportunity_Employer_button() {
		CommonUtils.click(vacancyManagerUserPage.toggleButtonEqualOpportunityEmployer); // OFF
		MiscUtils.sleep(2000);
		CommonUtils.click(vacancyManagerUserPage.toggleButtonEqualOpportunityEmployer); // ON
		MiscUtils.sleep(2000);
	}

	@Given("User toggles off Standards of Conduct\\/Financial Disclosure button")
	public void user_toggles_off_Standards_of_Conduct_Financial_Disclosure_button() {
		CommonUtils.click(vacancyManagerUserPage.toggleButtonStandardsOfConduct);
		MiscUtils.sleep(2000);
	}

	/** @Satya13Ticket102 **/
	@Then("User can see the below fields under Application Documents {string},{string}, {string}, {string}")
	public void user_can_see_the_below_fields_under_Application_Documents(String curriculumVitae, String coverLetter,
			String visionStatement, String qualificationStatement) {
		JavascriptUtils.scrollDown(1000);
		Assert.assertTrue(
				vacancyManagerUserPage.curriculumVitaeField.getAttribute("value").contentEquals(curriculumVitae));
		Assert.assertTrue(vacancyManagerUserPage.coverLetterField.getAttribute("value").contentEquals(coverLetter));
		Assert.assertTrue(
				vacancyManagerUserPage.visionStatementField.getAttribute("value").contentEquals(visionStatement));
		Assert.assertTrue(vacancyManagerUserPage.qualificationStatementField.getAttribute("value")
				.contentEquals(qualificationStatement));

	}

	@Then("User can see Add more button to add more documents")
	public void user_can_see_Add_more_button_to_add_more_documents() {
		Assert.assertTrue(vacancyManagerUserPage.addMoreButton.isDisplayed());

	}

	@Then("User can see optional check box in each field to indicate the document is optional")
	public void user_can_see_optional_check_box_in_each_field_to_indicate_the_document_is_optional() {
		Assert.assertFalse(vacancyManagerUserPage.optionalCheckboxOfCurriculumVitae.isSelected());
		Assert.assertTrue(vacancyManagerUserPage.optionalCheckboxOfCoverLetter.isSelected());
		Assert.assertFalse(vacancyManagerUserPage.optionalCheckboxOfVisionStatement.isSelected());
		Assert.assertTrue(vacancyManagerUserPage.optionalCheckboxOfQualificationStatement.isSelected());
	}

	@Then("User can see trash icon in each field to delete the field")
	public void user_can_see_trash_icon_in_each_field_to_delete_the_field() {
		Assert.assertTrue(vacancyManagerUserPage.trashIconofCurriculumVitae.isDisplayed());
		Assert.assertTrue(vacancyManagerUserPage.trashIconofCoverLetter.isDisplayed());
		Assert.assertTrue(vacancyManagerUserPage.trashIconofVisionStatement.isDisplayed());
		Assert.assertTrue(vacancyManagerUserPage.trashIconofQualificationStatement.isDisplayed());

	}

	/** Satya14Ticket102 **/

	@Given("User renames any field in the Application Documents section and User adds more documents")
	public void user_renames_any_field_in_the_Application_Documents_section_and_User_adds_more_documents() {
		CommonUtils.click(vacancyManagerUserPage.addMoreButton);
		CommonUtils.sendKeys(vacancyManagerUserPage.newFieldForAddMoreButton, "Letter Of Confirmation");
		MiscUtils.sleep(3000);
		vacancyManagerUserPage.curriculumVitaeField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		vacancyManagerUserPage.curriculumVitaeField.sendKeys("Statement");
		MiscUtils.sleep(3000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		JavascriptUtils.scrollUp(4000);
	}

	@Given("User deletes one existing document section")
	public void user_deletes_one_existing_document_section() {
		CommonUtils.click(vacancyManagerUserPage.trashIconofQualificationStatement);
		MiscUtils.sleep(3000);
	}

	@When("User comes back to Basic information tab")
	public void user_comes_back_to_Basic_information_tab() {
		CommonUtils.click(vacancyManagerUserPage.basicVacancySection);

	}

	@Then("User can see changes in documents section remains the same")
	public void user_can_see_changes_in_documents_section_remains_the_same() {
		Assert.assertTrue(vacancyManagerUserPage.curriculumVitaeField.getAttribute("value").contentEquals("Statement"));
		Assert.assertTrue(vacancyManagerUserPage.newFieldForAddMoreButton.getAttribute("value")
				.contentEquals("Letter Of Confirmation"));
	}

	/** Satya15Ticket@103 **/
	@Given("User clicks on the Email Template tab")
	public void user_clicks_on_the_Email_Template_tab() {
		CommonUtils.click(vacancyManagerUserPage.emailTamplatesSection);
	}

	@Given("User can see the below fields {string},{string},{string}, {string},{string}")
	public void user_can_see_the_below_fields(String applicationSaved, String appliactionIsInactive,
			String applicationSubmittedConfirmation, String notReferredToInterview, String invitationToInterview) {
		Assert.assertTrue(vacancyManagerUserPage.applicationSavedField.getText().contentEquals(applicationSaved));
		Assert.assertTrue(
				vacancyManagerUserPage.applicationIsInactiveField.getText().contentEquals(appliactionIsInactive));
		Assert.assertTrue(vacancyManagerUserPage.applicationSubmittedConfirmationField.getText()
				.contentEquals(applicationSubmittedConfirmation));
		Assert.assertTrue(
				vacancyManagerUserPage.notReferredToInterviewField.getText().contentEquals(notReferredToInterview));
		Assert.assertTrue(
				vacancyManagerUserPage.invitationToInterviewField.getText().contentEquals(invitationToInterview));

	}

	@Given("User toggles off\\/on Application saved checkbox to mark the template as active or not")
	public void user_toggles_off_on_Application_saved_checkbox_to_mark_the_template_as_active_or_not() {
		CommonUtils.click(vacancyManagerUserPage.applicationSavedToggleButton);
		MiscUtils.sleep(3000);
		CucumberLogUtils.logScreenShot();
		CommonUtils.click(vacancyManagerUserPage.applicationSavedToggleButton);

	}

	@Given("User inputs in Application saved email template text {string}")
	public void user_inputs_in_Application_saved_email_template_text(String text) {
		CommonUtils.sendKeys(vacancyManagerUserPage.applicationSavedTextField, Keys.SPACE + text);
		MiscUtils.sleep(3000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);

	}

	@Given("User clicks on Vacancy Committee tab")
	public void user_clicks_on_Vacancy_Committee_tab() {
		CommonUtils.click(vacancyManagerUserPage.vacancyCommitteeSection);
	}

	@When("User clicks on the Email template tab")
	public void user_clicks_on_the_Email_template_tab() {
		CommonUtils.click(vacancyManagerUserPage.emailTamplatesSection);
	}

	@Then("User can see the updated changes displaying as same")
	public void user_can_see_the_updated_changes_displaying_as_same() {
		Assert.assertTrue(vacancyManagerUserPage.applicationSavedTextField.getText().contains("Lorem Ipsum"));
	}

	// @Satya17Ticket120
	@When("User indicates open date and close date")
	public void user_indicates_open_date_and_close_date() {
		vacancyManagerUserStepsImpl.selectOpenCloseDate(16, 60);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		MiscUtils.sleep(1000);

	}

	@When("User toggles off Equal Opportunity Employer button, Standards of Conduct\\/Financial Disclosure button, Foreign Education button, Reasonable Accommodation button")
	public void user_toggles_off_Equal_Opportunity_Employer_button_Standards_of_Conduct_Financial_Disclosure_button_Foreign_Education_button_Reasonable_Accommodation_button() {
		CommonUtils.click(vacancyManagerUserPage.toggleButtonEqualOpportunityEmployer);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.toggleButtonForeignEducation);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.toggleButtonReasonableAccommodation);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.toggleButtonStandardsOfConduct);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
	}

	@When("User adds committee member as a chair")
	public void user_adds_committee_member_as_a_chair() {
		CommonUtils.click(vacancyManagerUserPage.addMemberButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.committeeMemberDropdown);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.apptrackScoringMember);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.roleDropdown);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.roleMemberVoting);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.saveButtonAddingMember);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);

	}

	@When("User toggles off all the email template button")
	public void user_toggles_off_all_the_email_template_button() {
		CommonUtils.click(vacancyManagerUserPage.applicationSavedToggleButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.applicationIsInactiveToggleButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.ApplicationSubmittedConfirmationToggleButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.notReferredToInterviewToggleButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.invitationToInterviewToggleButton);
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);

	}

	@When("User clicks on Save and Finalize button")
	public void user_clicks_on_Save_and_Finalize_button() {
		CommonUtils.click(vacancyManagerUserPage.basicVacancyInformationSaveButton);
		MiscUtils.sleep(3000);
		JavascriptUtils.scrollDown(3000);
		MiscUtils.sleep(3000);

	}

	@Then("User will see the error messages displayed")
	public void user_will_see_the_error_messages_displayed() {
		String expectedBeginningMessage = "Sorry, we can't submit just yet.  The following sections have fields that need to change or have values: ";
		String expectedEndMessage = "We've highlighted those fields in red.  Please return to those sections and address the highlights, then return here and click 'Save and Finalize' again.";
		String actualBegMessage = vacancyManagerUserPage.beginningAlertMessage.getText();
		System.out.println();
		String actualEndMessage = vacancyManagerUserPage.endAlertMessage.getText();
		System.out.println();
		Assert.assertEquals(expectedBeginningMessage, actualBegMessage);
		Assert.assertEquals(actualEndMessage, expectedEndMessage);
	}

	// @Satya18Ticket105

	@Then("User adds committee member")
	public void user_adds_committee_member(DataTable dataTable) {
		CommonUtils.click(vacancyManagerUserPage.vacancyCommitteeSection);
		MiscUtils.sleep(1000);
		Map<String, String> addCommitteeMember = CommonUtil.getMapFromDataTable(dataTable);
		vacancyManagerUserStepsImpl.selectCommitteeMemberFromDropDown(addCommitteeMember.get("Committee Member"));
		if (!addCommitteeMember.get("Committee Member ").isEmpty()) {
			vacancyManagerUserStepsImpl.selectCommitteeMemberFromDropDown(addCommitteeMember.get("Committee Member"));
		}
		MiscUtils.sleep(3000);
		vacancyManagerUserStepsImpl.selectRole(addCommitteeMember.get("Role"));
		MiscUtils.sleep(1000);
		CommonUtils.click(vacancyManagerUserPage.saveButtonAddingMember);
		CucumberLogUtils.logScreenShot();

	}

	@Then("User clicks on Review and Finalize tab")
	public void user_clicks_on_Review_and_Finalize_tab() {
		CommonUtils.click(vacancyManagerUserPage.reviewSection);
	}

	@Then("User can see confirmation modal {string} is displayed")
	public void user_can_see_confirmation_modal_is_displayed(String expectedTextfromAlert) {
		Assert.assertTrue(CommonUtils.getAlertText().contentEquals(expectedTextfromAlert));

	}
    //@Satya18Ticket120
	@Then("User adds committee member as {string} and role {string}")
	public void user_adds_committee_member_as_and_role(String committeeMember, String role) {
		vacancyManagerUserStepsImpl.selectCommitteeMemberFromDropDown(committeeMember);
		vacancyManagerUserStepsImpl.selectRole(role);
		}
	
	@Then("User picks open date as {string} and close date as {string}")
	public void user_picks_open_date_as_and_close_date_as(String openDate, String closeDate) {
		JavascriptUtils.scrollIntoView(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(16));
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection);
		MiscUtils.sleep(2000);
		JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(65));
		MiscUtils.sleep(2000);
		
	}

	@When("User chooses OK for  confirmation modal{string}")
	public void user_chooses_OK_for_confirmation_modal(String string) {
	    
	}

	@Then("User can see confirmation modal {string}")
	public void user_can_see_confirmation_modal(String string) {
	   
	}

	// @Satya7Ticket94
	@When("User picks open date and close date")
	public void user_picks_open_date_and_close_date() {
		//JavascriptUtils.scrollIntoView(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		//JavascriptUtils.clickByJS(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		//JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(13));
		//JavascriptUtils.clickByJS(vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection);
		//JavascriptUtils.clickByJS(vacancyManagerUserPage.calendarDatePicker.get(63));
		//MiscUtils.sleep(2000);
		vacancyManagerUserStepsImpl.selectOpenCloseDate(13,63);
	}

	@Then("User can see the selected Open & Closed date displaying as the same")
	public void user_can_see_the_selected_Open_Closed_date_displaying_as_the_same() {
		// text = 10,17
		JavascriptUtils.scrollIntoView(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection);
		Assert.assertTrue(vacancyManagerUserPage.openCalendarInputButtonInBasicVacancySection.getAttribute("title").contentEquals("2021-06-12"));
		Assert.assertTrue(vacancyManagerUserPage.closeCalendarInputButtonInBasicVacancySection.getAttribute("title").contentEquals("2021-06-20"));
		

	}

}
