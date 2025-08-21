Feature: Patient role 

Background:
Given open browswer for login
When navigate to nh url and login with below details
|email   |Sunilk@nh.com|
|password|Chakra@1|

Then click on signin button to open profile page
And select the patient role from the profile page
When patient role homepage opens

@icons
Scenario: patient profile icons
#patient role icons
#adding address
Then mouse-hovering to the existing address home icon in patient role 
And clicking on the address icon to add new address
Then click on the plus button to add new address in patient role
And enter the following details to add new address in patient role
|Address line1 |Indira nagar|
|Address line2 |Banjara Hills|
|Landmark      |Ameerpet|
|District      |Khairatabad|

And select city from the dropdown for new address in patient role
Then entering the pincode for new address in patient role
When user click on the save button for new address in patient role
Then it will redirect to the addresses page popup in patient role
And deleting the already existing address in patient role
Then updating the pincode for the new address in patient role
And clicking on the save button for new address in edit address page from patient role
Then closing the addresses popup in patient role

#adding contact
Then mouse-hovering to the existing contact home icon in patient role 
And clicking on the contact icon to add new contact
Then click on the plus button to add new contact in patient role
And enter the contact type for new contact
Then select the country code for new contact
And enter the following details in the new contact popup
|Mobile number| 9812312398|
|Email        |cucumpat@gmail.com|

Then click on the save button from the new contact popup
And updating the mobile number from the contact
Then clicking on the save button for contact in edit contact page from patient role
And close the contact popup in patient role 


#patientchat
Then click on the patient chat in the patient role
And enter the message in the patient chat popup
Then click on the send message icon to send chat
And close the patient chat popup

#insurance
Then mouse-hovering to the insurance icon in the patient role
And click on the insurance icon in the patient role
When insurance popup opens from the patient role
And click on the plus button to add new insurance
And select the insurance radio button from the new insurer
Then enter the following in the insurance popup in patient role
|ID Number|90|
|Policy no|87900|
And select the start and end date for insurance
Then click on save button to save the insurance in patient role
Then edit and update the added insurance in patient role
And click on save button from edit insurance popup in patient role
Then adding another insurance
Then delete the existing insurance in the patient role
When insurance is deleted in the patient role
Then closing the popup of the insurance popup 

@bookdoctorapt
Scenario: booking doctor appointment from patient role
When patient dashboard is opened from patient role to book doctor appointment
Then click on book doctor appointment from book appointment section
And click on the book appointment button to book doctor appointment 
Then select the type for booking doctor appointment 
And select the location to book doctor appointment
Then select the date and slot for doctor appointment
And click on the add to cart button for doctor appointment
When add to cart is clicked it will open cart to summary page
Then click on the submit button to book doctor appointment
When submit is clicked then it will open the payment method page
Then navigate to patient dashboard from doctor apt payment method page1

@bookvaccineapt
Scenario: booking vaccine appointment from patient role
When patient dashboard is opened from patient role to book vaccine appointment
Then click on book vaccine appointment from book appointment section
And click on the plus button to add vaccine to book appointment section
Then click on plus button to add another vaccine and remove it
And click on checkout from cart summary to book vaccine appointment
Then Agree the consent text for booking vaccine appointment
And select the type for booking vaccine appointment
Then select the location for booking vaccine appointment
And select the date and slot booking vaccine appointment
Then select the healthcoach from dropdown to book vaccine
And click on continue button to book vaccine appointment
Then click on add to cart button book vaccine appointment
Then click on the submit button to book vaccine appointment
When submit is clicked then it will open the payment method page to book vaccine appointment
Then navigate to patient dashboard from doctor apt payment method page2

@bookingprogramapt
Scenario: booking program appointment from patient role
When patient dashboard is opened from patient role to book program appointment
Then click on book program appointment from book appointment section
And click on the plus button to add program to book appointment section
Then click on plus button again to add another program and remove it
And click on the checkout button from cart summary to book program appointment
Then select the referred by by searching to book program 
And select the program start date to book program
When start date is selected as today
Then end date is automatically selected according to the program end date
When end date is selected according to the program end date
And click on the add to cart button to book program
When add to cart button is clicked from activity list
Then it will redirect to the patient dashboard from program activity list page 

@bookingdiagnosticapt
Scenario: booking diagnostic appointment from patient role
When patient dashboard is opened from patient role to book diagnostic appointment
Then click on book diagnostic appointment from book appointment section
And click on the plus button to add diagnostic to book appointment section
Then click on plus button again to add another diagnostic and remove it
And click on the checkout button from cart summary to book diagnostic appointment
Then select the type to book diagnostic appointment 
And select the slot for booking diagnostic appointment 
Then click on the add to cart button to book diagnostic appointment 
Then click on the submit button to book diagnostic appointment
When submit is clicked then it will open the payment method page to book diagnostic appointment
Then navigate to patient dashboard from doctor apt payment method page3

@uploadreports
Scenario: uploading reports of the patient
#doctorvisit
And mousehovering to the uploadreports to upload reports
Then mousehovering and clicking on the upload doctor visit
When Doctor visit popup opens in patientrole
Then enter the doctor first and last name
And select the hospital name from the dropdown
Then upload the prescription for upload doctor visit
And select the diagnosis by searching 
Then enter the notes for uploading doctor visit
And click on the submit to upload doctor visit
When doctor visit report is uploaded in patient role

#uploaddieticianvisit
Then mousehovering and clicking on the upload dietician visit
When Dietician visit popup opens in patientrole
Then select the dietician visit date by clicking on Dietician Visit Date
And enter the dietician first and last name
Then select the hospital name from the dropdown to upload dietician report
And upload the dietician visit report
Then click on the submit to upload the dietician visit
When dietician visit report is uploaded in patient role

#uploadlabreport
Then mousehovering and clicking on the upload labreport visit
When Lab report popup opens in patientrole
Then select the test date of the diagnostic
And select the lab name to upload labreport
Then upload the labreport to uploaddiagnosticreport
Then enter the notes of lab report
And click on the submit to upload diagnostic report
When lab report is uploaded in patient role

#uploaddischargesummary
Then mosuehovering and click on upload discharge summary
When upload discharge summary popup opened
Then select the date for upload discharge summary
And upload the discharge summary pdf
Then click on the submit button to upload dischargesummary
When discharge summary is uploaded

#notes
Then clicking on the notes icon beside the upload reports icon
And entering the message to upload notes
Then uploading the file in patient role
And enabling the checkboxes to whom its viewable
Then clicking on the save button to upload notes
And close the notes popup in patient role

#History
Then clicking on the history button after page downing
And Scrolling down to show the uploaded reports

