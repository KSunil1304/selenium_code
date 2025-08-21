Feature: Registering a patient and booking doctor consultation

  @register
  Scenario: registering a patient and booking doctor consultation
    Given navigate to the NanoHealth portal website
    Then enter the emailormobileforcm  "sunilcm@gmail.com" passwordforcm "Demo@1234"
    And click on the sign in button to login into the clinicmanager dashboard
    Then select the role of clinicmanager as NH_IP_OP
    And deleting the already existing patient from clinicmanager NH_IP_OP
    Then click on the add patient icon from the clinicmanger NH_IP_OP
    And select title_of_the_patient
    When user enters the following details into registration form from the NH_IP_OP clinicmanager role
      | firstname    | Cucum                |
      | lastname     | Gynec                |
      | age          |                   55 |
      | phone        |           7781110021 |
      | email        | cucumgynec@gmail.com |
      | addressline1 | ameerpet             |
      | addressline2 | ameerpet             |
      | landmark     | metro station        |
      | aadharcard   |         123456789012 |
    Then select the radio_buttons in the registration form from the clinicmanager role
    And click on the submit_button_to_register_the_new_patient from the NH_IP+OP
    When patient is registered it will navigate to the patient profile
    Then click on book doctor appointment from the booking services section
    And search and book appointment to the doctor
    Then select the type of the appointment
    And select the location for the appointment
    And select the slot time for the appointment
    Then select the neccessary checkboxes in the payment popup
    And click on the submit button from the payment popup
    Then select the payment method radio button
    And enter the amount for the appointment
    When amount is entered then receipt comment is enabled
    Then click on the receipt comment and enter the comment click on the ok button
    And click on the submit_button from the proforma invoice page
    Then click on the print invoice icon
    And click on the receipt id total advance icons
    Then click on the print and prescription buttons in the bottom of the page
    And share the invoice by clicking share invoice button in the bottom of page
    Then logout from the role
    And naviagate_ to_the NH_Web_portal application
    Then enter the emailormobile3 "gynec@nh.com" password3 "Demo@123"
    And click sign_in_button to login
    When doctor dashboard will be opened
    Then from the dashboard click on the week from the list view
    When week is clicked it will show list of appointments for this week
    Then click on the patient name to add gynec prescription
    And click on the add prescription from the patient profile
    When add prescription is clicked it will open the prescription form page
    Then write the clinical examination
    And click on the enter button to add new clinical examination
    When enter button is clicked then in new line will be opened with bullet point
    Then enter the new clinical examination text
    And select the menustral history radio button
    Then select the LMP date
    And select the EDD date
    Then enter the menustral history
    And click on the enter button to add new menustral history
    When enter button is clicked then in new line will be opened with bullet point for menustral history
    Then enter the new menustral history text
    And enter the obsteric history
    Then click on the enter button to add new obsteric history
    When enter button is clicked then in new line will be opened with bullet point for obsteric history
    Then enter the another obsteric history
    When enter the following into the vitals in the gynec prescription
      | Temp             | 102 |
      | Pulse            | 100 |
      | Respiratory rate |  20 |
      | Bp               | 120 |
      | BP               |  90 |
      | Spo2             | 100 |
      | Height           | 180 |
      | Weight           |  75 |
    Then select the pain scale from the gynec prescription
    And click on the medicine field in gynec prescription
    When medicine field is clicked it will show the medicine suggestions
    Then select the medicine using enter button
    And click on the notes icon to show notes and close it
    Then click on the medicine field again to add new medicine
    And using right and left arrow keys select medicine by clicking enter button
    Then click on the notes icon again to show notes and close it
    #And select third medicine and remove it
    Then enter the next visit date
    When next visit date is entered then visit date will be displayed beside calendar icon
    Then select next visit type radio button
    And click on the labs field from the gynec prescription
    When labs field is clicked it will show lab suggestions
    Then select lab using enter button
    And select another using search and click enter button
    Then select the third lab
    And remove one of the labs from the selected labs
    Then click on the request button for labs
    When request button is clicked it will open a popup
    Then click on the request button from the popup
    When request button from the popup is clicked popup will be closed
    Then click on the procedures field from the gynec prescription
    When procedures field is clicked it will show the suggestions
    And select the procedure by clicking enter button in gynec prescription
    Then select the another procedure using search and clicking enter button
    And select the procedures and remove the last added procedure
    Then enter the comments in the comments field
    And click on the enter button in the comments field
    When comments field enter button is clicked it will show a new bullet point
    Then enter the comments again
    And click on the attachment present at top right middle in gynec prescription
    When attachment is clicked attach files popup will opened in gynec prescription
    Then from the attach files popup send the file and click on the ok button in gynec prescription
    When ok button is clicked attach files popup will be closed in gynec prescription
    And click on the health information present at bottom right side in gynec prescription
    When health information is clicked it will open the health information in gynec prescription
    Then give the necessary health information and submit in gynec prescription
    And close the health information popup in gynec prescription
    Then click on the doctor notes present bottom of health information in gynec prescription
    When doctor notes is clicked it will open the popup for notes in gynec prescription
    Then enter the message for notes in gynec prescription
    And enable the checkboxes if necessary click on the save button in gynec prescription
    Then close the notes popup in the prescription in gynec prescription
    And click on the favourite prescription and close it in gynec prescription
    Then click on the past prescription in gynec prescription
    When past prescription is clicked it will open the recently saved prescription in gynec prescription
    And click on the lab reports and close it in gynec prescription
    When doctor clicks on saveasdraft for gynec prescription it redirect to patient profile
    And clicking on the  Add Prescription and saving gynec prescription
    Then Scrolling pagedown and downloading pdfs in the gynec preview prescription page
    And sharing the gynec prescription to mailid1 "sunil.kommayella@nanohealth.in"
    When doctor click on edit button in the gynec prescription
    Then gynec prescription form opens
    And editing the nextvisitdate for gynec prescription duration
    Then clicking on save button for saving gynec prescription
    And Scrolling pagedown and download pdfs in the gynec prescription preview page
    Then sharing the gynec prescription to emailid2 "sunil.kommayella@nanohealth.in"
    And clicking on the close button of gynec prescription
    When doctor clicks close it will redirect to patient profile
    And click on the medical conditions icon from the patient profile
    When medical condition icon is clicked it will download the medical pdf
    Then clicks on historybutton in  patient profile
    When history open then gynec prescription row will display
    Then click on the Gynec Prescription middle of the first row
    And download the with and without header footers from the first row
    Then share the gynec prescription to mail using share prescription
    And click on the load prescription button from the first row
    When load prescription is clicked it will load and open gynec prescription form
    Then make changes if any in the load prescription
    And click on the save button in the gynec prescription form after loading
    When load prescription is saved then it will create another row in the patients history
    Then download the header footer pdfs from the preview page
    And share the pdf using share prescription from the preview page
    Then click on the patients name from the preview page
    And click on the history button again in the patient profile after loading prescription
    Then click on the Gynec Prescription middle of the first row after saving load prescription
    And download the with and without header footers from the first row after saving load prescription
    Then share the gynec prescription to mail using share prescription after saving load prescription
