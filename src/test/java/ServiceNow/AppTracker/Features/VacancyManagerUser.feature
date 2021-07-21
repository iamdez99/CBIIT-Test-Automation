Feature: Vacancy Manager Workflow

Background: common steps
Given User is on AppTracker home page and user is "AppTracker Vacancy Manager"

@Regression @Ticket88
Scenario: verify vacancy description without copy/paste
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
Then User should see "Basic Vacancy Information" text as
 """
•	Determines customers’ needs and desires by specifying the research needed to obtain market information.
•	Recommends the nature and scope of present and future product lines by reviewing product specifications and requirements; appraising new product ideas and/or product or packaging changes.
•	Assesses market competition by comparing the company’s product to competitors’ products.
•	Provides source data for product line communications by defining product marketing communication objectives.
•	Obtains product market share by working with sales director to develop product sales strategies.
•	Assesses product market data by calling on customers with field salespeople and evaluating sales call results.

 """
 
@Ticket89-1 @Regression
Scenario: Verify Letters of Recommendation persistent in Basic Information
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab 
When User clicks on Create Vacancy button
And User enters the vacancy title
Then User selects recommendation as 2 


@Ticket91
Scenario: Verify create vacancy form
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab 
When User clicks on Create Vacancy button
And User enters the vacancy title
And User can see the Create Vacancy form opens with below left menu items
| Basic Vacancy Information |
| Mandatory Statements      |
| Vacancy Committee         |
| Email Templates           |
| Review and Finalize       |
And User click on "Vacancy Committee" without entering any value in previous field
Then User should able to navigate to the "Basic Vacancy Information" without any error


@Ticket93
Scenario: Verify the Vacancy Manager dashboard landing page
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab
And User can see the dashboard page displaying tabs as below 
|pre-flight vacancies|live vacancies|closed vacancies|
Then User can see count of each tabs


		
@Ticket93-1
Scenario: Verify dashboard page sub filters
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab
When User clicks on live vacancies tab
And User can see the "All", "Live", "Extended" sub filters on live vacancies
When User is on pre-flight vacancies tab
And User can see the "All", "Draft", "Finalized" sub filters on pre-flight vacancies tab
When User clicks on closed vacancies tab
Then User can see the "All", "Triaged", "Individual Scored", "Committee Review", "Voting Complete" sub filters on closed vacancies


@Satya7Ticket94
Scenario: Verify set vacancy date functionality
And User should see Vacancy Manager Home Page
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
Then User should able to navigate to the "Basic Vacancy Information" without any error
And User clicks on the Open date field to see calendar past dates disabled
And User clicks on the Close Date field to see calendar past dates disabled
And User selects date same as today's date 
Then User can see the under Close Date field message displays with "Please pick a close date that is after the open date."
When User selects the Open date as greater than the Close date 
Then User can see the under Open Date field message displays with "Please pick an open date that is before the close date."
And User clicks on the Mandatory Statements section
When User comes back to Basic information tab
And User picks open date and close date
And User clicks on the Mandatory Statements section
When User comes back to Basic information tab
Then User can see the selected Open & Closed date displaying as the same


@Satya10Ticket101 
Scenario: Verify the Mandatory Statements Page
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
And User clicks on the Mandatory Statements section
Then User can verify "Equal Opportunity Employer","Standards of Conduct/Financial Disclosure", "Foreign Education", "Reasonable Accommodation" toggle buttons
And User can see pre-filled rich text area on each of the field

@Satya11Ticket101
Scenario Outline: Verify the on/off for the buttons in the mandatory statements
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
And User clicks on the Mandatory Statements section
And User toggles off "<buttons>" as below
Examples: buttons
|buttons| 
|Foreign Education|
|Reasonable Accommodation|

@Satya12Ticket101
Scenario: Verify the Mandatory Statements persistence on editing text
And User clicks on vacancy dashboard tab
And User clicks on Create Vacancy button
And User enters the vacancy title
And User clicks on the Mandatory Statements section
And User edits Equal Opportunity Employer text by adding "This position requires traveling overseas"
And User toggles off/on Equal Opportunity Employer button
And User toggles off Standards of Conduct/Financial Disclosure button
Then User can see the updated value displays in the text field

@Satya13Ticket102
Scenario: Verify create vacancy documents upload functionality
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
Then User can see the below fields under Application Documents "Curriculum Vitae (CV)","Cover Letter", "Vision Statement", "Qualification Statement"
And User can see Add more button to add more documents
And User can see optional check box in each field to indicate the document is optional 
And User can see trash icon in each field to delete the field

@Satya14Ticket102
Scenario:Verify the rename & persistence of functionality in documents section
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
And User deletes one existing document section
And User renames any field in the Application Documents section and User adds more documents
And User clicks on the Mandatory Statements section
When User comes back to Basic information tab
Then User can see changes in documents section remains the same

@Satya15Ticket103
Scenario: Verify the email template in create vacancy form
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
When User clicks on the Email Template tab
And User can see the below fields "Application saved","Application is inactive","Application submitted confirmation"
When User toggles off/on Application saved checkbox to mark the template as active or not
And User inputs in Application saved email template text "Lorem Ipsum"
And User clicks on Vacancy Committee tab
When User clicks on the Email template tab
Then User can see the updated changes displaying as same


@Satya15Ticket119
Scenario: Verify Vacancy Committee form
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
And User clicks on Vacancy Committee tab
And User can see the Vacancy Committee table and add member button
And User clicks on the add member button
When User can see Member & Role dropdown list
Then User can see Save & Cancel button in Action column

@Satya16Ticket119
Scenario: Verify add/cancel/edit member functionality
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
And User clicks on Vacancy Committee tab
And User clicks on the add member button
Then User can  pull up NIH username from the VMS User Table by typing "Bob Barber"
And User assigns "Member (voting)" role to Bob Barber
And User can see Save & Cancel button in Action column
And User can cancel that Chair member by clickng Cancel button
And User adds committee member as "Connor Scoring" and role "Executive Secretary"
Then User can verify that committee member name and role are displayed
And User adds committee member as "Abdullah Sharif" and role "Chair"
And User edits role and name of Abdullah Sharif as "APPTRACK VACANCY MANAGER"
And User removes "Abdullah Sharif"




#unfinished
@Satya17Ticket120
Scenario: Verify the Review & Finalize screen with negative input
When User clicks on Create Vacancy button
And User enters the vacancy title
And User indicates open date and close date
And User toggles off Equal Opportunity Employer button, Standards of Conduct/Financial Disclosure button, Foreign Education button, Reasonable Accommodation button
And User adds committee member as a chair
And User toggles off all the email template button
Then User will see the error messages displayed
And User comes back to Basic information tab
And User clicks on the Mandatory Statements section
And User clicks on Vacancy Committee tab
And User clicks on the Email template tab


@Satya18Ticket120
Scenario: Verify the Review & Finalize screen with positive input
And User clicks on vacancy dashboard tab
When User clicks on Create Vacancy button
And User enters the vacancy title
Then User should see "Basic Vacancy Information" text as
 """
•	Determines customers’ needs and desires by specifying the research needed to obtain market information.
•	Recommends the nature and scope of present and future product lines by reviewing product specifications and requirements; appraising new product ideas and/or product or packaging changes.
•	Assesses market competition by comparing the company’s product to competitors’ products.
•	Provides source data for product line communications by defining product marketing communication objectives.
•	Obtains product market share by working with sales director to develop product sales strategies.
•	Assesses product market data by calling on customers with field salespeople and evaluating sales call results.
 """
And User clicks on the Open date field to see calendar past dates disabled
And User clicks on the Close Date field to see calendar past dates disabled
And User picks open date and close date
Then User selects recommendation as 2
And User clicks on Vacancy Committee tab
And User adds committee member as "Abdullah Sharif" and role "Chair"
And User adds committee member as "Connor Scoring" and role "Executive Secretary"
And User clicks on Review and Finalize tab
And User clicks on the Mandatory Statements section
And User clicks on Review and Finalize tab
When User clicks on Save and Finalize button
Then User can see confirmation modal appear
When User chooses OK for confirmation modal"Ready to finalize vacancy?"
Then User can see confirmation modal Vacancy Finalized!












