Feature: registering a patient and paying advance amount

  @admit
  Scenario: Registering a patient and filling up the admission detail form to admit as ip patient
    Given naviagate to the NH_Web_portal application
    When the nanohealth login page opens
    Then enter the emailormobile "sunilcm@gmail.com" password "Demo@1234"
    And click on the sign in button to login into the nanohealth portal
    When select the profile when the popup opens
    Then select the role as CDPAdmin
    When CDPAdmin dashboard opens
    And deleting the already existing patient in the CDPAdmin role
     Then selecting the role as IP_Billing_Manager
    Then click on the add patient icon from the IP_Billing_Manager
    Then select title_of_ip_patient
    When user enters the following details into registration form from the IP_Billing_Manager
      | firstname    | Cucum              |
      | lastname     | Dissummary         |
      | age          |                 45 |
      | phone        |         7788110022 |
      #| email        | cucumdsm@gmail.com |
      | addressline1 | ameerpet           |
      | addressline2 | ameerpet           |
      | landmark     | metro station      |
      | city         | test               |
      | district     | test               |
      | pincode      |             878787 |
      #| aadharcard   |       123456789012 |
    Then selecting the radio_buttons in the registration form
    And click on the submit_button_to_register from the IP_Billing_Manager
    Then it will open the patient profile from the IP_Billing_Manager
    And click on the advance button present in the right side
    When advance is clicked load amount popup opens
    Then enter the amount of the advance payment
    And select the payment method radio button after entering advance amount
    Then click on the save button to save advance amount
    When save is clicked it will show the loaded amount in the advance field button
    Then returning advance amount
    And deleting the already existing family member
    And click on the brandlogo and select the IpBillingManager role
    Then search and open the patient that want to admit from IpBillingManager role
    Then click on the admission detail button under the bookappointments section
    And click on the add family member icon from primary attendant field
    When add family member popup opens enter the following details1
      | First name  | Cucum        |
      | Second name | Familymember |
    Then select the sex of the family member for the family member
    When add family member popup opens enter the following details2
      | Age    |         70 |
      | Mobile | 7676676767 |
    And select the relation from the dropdown from the add family member
    Then click on the submit button to addfamily member
    And select the paymentmode as self radio button
    And select the department from the dropdown
    Then select the single from the roomtype dropdown
    And select the lead doctor from the dropdown
    And select the admission type radio button
    Then select NH_IP Ward from the dropdown on clicking admission site
    And click on the submit button
    
  @ip
  Scenario: booking ip procedures and assigning room and bed to the ip patient
    Given naviagate to the NH_Web_portal application2
    When the nanohealth login page opens2
    Then enter the emailormobile1 "sunilcm@gmail.com" password1 "Demo@1234"
    And click on the sign in button to login into the nanohealth portal2
    When select the profile when the popup opens2
    Then select the role as IpBillingManager2
    And mouse hover to the reports and click on the patients
    When patient is clicked it will show all the ip list
    Then click on the patients name from the ip list
    When patient status is updated then ipprocedures icon and assignroom icons will enabled
    And a new invoice will be generated on the ip number invoice mouse hover on it and click on it
    Then adding one of the service from here and doing pay later
    And again clicking on the opening invoice id to add other services
    Then add OT Charges service using opening invoice id 
    And add ER Charges service using opening invoice id 
    Then sync the data and selecting previous dates
    And add investigation lab service by searching the charge code
    And add minor procedure service by searching charge code
    And add radiology test using opening invoice id
    And add miscellaneous using opening invoice id
    And add room_nursing charges using opening invoice id
    And click on the patient name to open patients profile
     And clicking on the IP Number in the patient profile
    Then clicking on the QR Code icon and Admission detail pdf icon
    And download the consent forms for ippatient
    And closing the ip forms popup
    Then click on the ipprocedures icon under bookappointments section
    Then select the procedures and removing one of the selected ip procedures
    And click on the checkout button from the selected ip procedures page
    Then select the discharge date and click on the continue button
    And select the supporting doctor from the dropdown and click on continue button
    Then select the procedure start and end date from the procedure rooms popup
    And selecting the procedure room no and table no
    When procedure room is selected table no will automatically selected
    Then click on the continue button from the procedure rooms page
    And click on the submit button from the review and save page
    #When proforma invoice page is opened for cucum dissummary patient
    #Then click on plus button present at the top right
    #When add services popup opens
    #Then selecting the date as today from the add services popup
    #Then select the room&nursing service type from dropdown
    #And selecting the room from service dropdown
    #When room is selected it will open a popup of admission details
    #And select the single room from the room type
    #Then select the room no from the room no drop down
    #And select the bed no from the drop down
    #Then click on the alloteddate and select today
    #When today date is selected from the admission details
    #Then click on the assign button from the admission details bed page
    #And click on the submit button from the invoice page
    #Then click on the add service button again to add previous dates service
    #Then click on the submit again from the add services popup
    And select the paylater option radio button to paylater for ippatient 
   	#When redeem is clicked automatically bill amount will be entered
    Then click on the submit button from the proforma invoice page
    And clicking on the print invoice to download poinvoice
    Then click on the receipt id and total advance pdf icon and print button to download
    And click on the share invoice at the bottom of the invoice page
    Then remove and enter the mail id to share invoice
    And click on the submit button to share invoice to mail
    Then clicking on the patients name in the IpBillingManager role
    And mouse hovering to the ip icon which is present beside patients name
    #Then mouse hovering to the assign room icon under the book appointments section
     
  @ds
  Scenario: writing discharge summary for the ip patient
    Given naviagating to the NH_Web_portal application
    When the nanohealth login page opened
    Then enter the emailormobile2 "dr@yourclinic.com" password2 "Demo@123"
    And click on sign_in_button to login into the nanohealth portal
    Then mouse hovering to the iplist module and selecting NH_IP Ward
    And ip patients from NH_IP Ward will be displayed
    Then clicking on the patients name to write the discharge summary
    And click on the discharge summary button
    When discharge summary button is clicked it will open the discharge summary form
    Then enter the provisional diagnosis at the time of admission
    And click on the enter then bullet point will come
    Then enter the provisional diagnosis again
    And click on the final diagnosis field
    When diagnosis suggestions will be shown1
    Then click on the enter button to select the first diagnosis from the suggestions
    And enter the duration of the finaldiagnosis1
    Then clicking on the notes icon for finaldiagnosis1
    And enter the notes for final diagnosis1
    Then click on the notes icon again to close for final diagnosis1
    When diagnosis suggestions will be shown2
    Then click on the right and left keys and click on the enter button to select the final diagnosis2
    And enter the duration of the finaldiagnosis2
    Then clicking on the notes icon for finaldiagnosis2
    And enter the notes for final diagnosis2
    Then click on the notes icon again to close for final diagnosis2
    And clicking on the final diagnosis to add final diagnosis3
    Then enter the oral and then clicking on the enter button
    And enter the duration of the finaldiagnosis3
    Then removing the last added final diagnosis3
    And click on the patient history and enter the history
    Then click on the enter to add the patienthistory2
    When enter clicked bullet point will be created in patienthistory field
    Then enter another line of patienthistory2
    And click on the enter to add the patienthistory3
    Then enter another line of patienthistory3
    And clicking on the up key to see the upper history data
    Then reducing the screensize1 in dischargesummary
    And clicking on the reason for admission_symptoms_clinicalfindings and clicking enter button
    Then selecting the duration from the dropdown for admissionreason1
    And click on the admission_symptoms_clinicalfindings to add admissionreason2
    Then click on the right and left keys and click on the enter button to select the admissionreason2
    And selecting the duration from the dropdown for admissionreason2
    Then selecting the admissionreason3 by searching in the field
    And entering the duration for admissionreason3
    Then removing the last added admissionreason3
    And entering the hospital course in dischargesummary
    Then reducing the screensize2 in dischargesummary
    And click on the plus button to add medication1 given during hospitalization
    When plus button is clicked then it will add a new row
    And click on the medicine field for adding medication1 given during hospitalization
    Then select the medication1 given during hospitalization1
    And click on the plus button to add medication2 and click on the medicine field to select medicine
    And select the medication2 given during hospitalization2
    Then remove the recent added medication given during hospitalization2
    And enter the condition on discharge1 in discharge summary
    Then click on the enter button from the condition on discharge
    When enter button is clicked it will show bullet point for next line
    Then enter the condition on discharge2 in discharge summary
    #entered discharge medicine in the field of medicine given during hospitilization
    When enter the following details into the vitals field
      | Height      | 170 |
      |BP						|	120	|
      |BP						|	90	| 
    And enter the advice on discharge in discharge summary
    Then click on the enter button to add new line
    And enter the advice2 in the new line
    Then click on the medicine field in the discharge medication1
    When medication field is clicked it will show the suggestions of the avaible medicines
    Then mousehover on the medicine name and selecting the medicine1
    And click on the notes icons and close for medicine1
    Then click on the medicine field in the discharge medication2
    And using right and left keys select the medicine2 by clicking enter button
    Then click on the notes icons and close for medicine2
    And click on the medicine field in the discharge medication3
    Then click on the enter button to select the medicine
    When enter button is clicked medicine will be selected
    Then remove one of the medicine from the discharge medication
    And clicking on the labs field in discharge summary
    When field is clicked then labs suggestions will show
    Then click on the enter button to select the lab
    And search and select the lab in discharge summary
    Then select the another lab clicking enter button
    And remove one of the selected lab in discharge summary
    Then enter the free text test for lab and click on ok button
    Then click on the request button in discharge summary
    When request button is clicked then popup will be opened
    Then click on the request button present in the popup
    And click on the procedures field in the discharge summary
    Then select the procedure by clicking enter button
    And search and select the procedure in discharge summary
    Then select the another procedure by clicking enter button
    And remove one of the selected procedure
    Then enter the free text test for procedure and click on ok button
    Then click on the duration field of next visit date
    And click on the calendar icon for next visit date in discharge summary
    When calendar icon is clicked it will open calendar
    Then click on the cancel button in the calendar popup
    And enter the duration in the field and select the duration from the dropdown
    Then select the next visit type radio button in discharge summary
    And enter the comments in discharge summary
    Then click on enter button to add new comment
    And enter the another comment in discharge summary
    Then enter the doctors attended in discharge summary
    And click on the Attachment icon present at the right top of the page
    Then upload the file and click on the save button from the attachment popup
    And Health information icon below the attachment icon
    When icon is clicked popup will be opened about health information
    Then add the necessary health information and save by clicking save button
    And click on the doctor notes from the discharge summary
    Then enter the message and upload the file for doctor notes
    And enable the necessary checkboxes and click on save button
    Then close the popup for doctor notes
    And click on the favourite discharge summary and close it
    Then click on the last prescription and close it
    And click on the lab reports in discharge summary and close it
    Then click on the save as draft in the discharge summary page
    When save as draft is clicked it will navigate to the patient profile
    And click on the discharge summary button from the patient profile
    And click on the save button in the discharge summary page
    Then click on the edit button from the preview discharge summary
    And enter the comments by pagedowning in the edit discharge summary
    Then click on the save button again to save edited discharge summary
    And click on the print with header_footer in discharge summary
    Then click on the print without header_footer discharge summary
    And click on the share invoice button in discharge summary
    Then enter email id and click on the submit button to send the discharge summary to given mailid
    And click on the close button in discharge summary
    When close is clicked it will take to the patient profile from discharge summary preview
    And click on the history button in the patient profile
    Then download the pdfs of the discharge summary
    And click on the load discharge summary from the history of the patient profile
    When load discharge summary is clicked it will load discharge summary
    Then edit the necessary changes from the load discharge summary page
    And click on the save button after editing from the load discharge summary page
    Then download the pdfs with_without header_footer and share the ds
    And click on the patient name from the discharge summary
    Then click on the history button in the patient profile after saving load prescription
    When history is clicked a new discharge summary row will create
    Then download the pdfs with_without header_footer from the history of patient profile
