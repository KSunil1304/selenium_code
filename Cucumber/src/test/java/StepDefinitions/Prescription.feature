Feature: Registering a patient and booking doctor consultation

  Scenario: Booking doctor consultation
    Given User navigates to the web portal
    When User enter the email  "sunilcm@gmail.com"
    And User enter the password  "Demo@1234"
    And click on the signin button
    Then user will select role
    And user successfully login with the role
    Then deleting the existing patient through search
    When user clicks on the add patient icon
    Then registration form will open
    When user select the title automatically it will select the gender
    And user enter the firstname "Cucumber"
    And user enter the lastname "Prescription"
    And user enter the age "30"
    When user selects the country code
    Then user enter the phonenumber "8798912818"  and gmail "presc123@gmail.com"
    And user enter the addresslineone "Test" , addresslinetwo "Test2" , Landmark "Testlandmark"
    And user select the state and country
    Then user click on the add button for referred by
    And user select the self option
    Then user click on the Choose file for profile picture and uploads picture
    And user clicks on the Choose file for Id card and uploads picture
    When user click on the submit button1
    Then it will take to the user to the patientprofile page
    And user click on the Book Doctor Appointment
    Then avaible doctors list will open and click on Book Appointment
    And select the type clinic
    Then select the location
    When user click on tomorrow slots will shown
    And select the slot time
    Then user select the notify patient checkboxes
    When user clicks on the submit button2
    Then it will redirect to the proforma invoice page
    When user select the radio button from payment methods
    Then the cursor will move to the transaction amount field
    When user enter the cash
    Then receipt comment icon will enable and click on it
    And enter the "test receipt comment" and click on ok
    When user clicks on the submit button3
    Then it will redirect to the invoice page
    And downloading invoice by clicking on the print icon
    And downloading receipt by clicking on the receipt id
    And downloading pdf by clicking on the total advance pdf icon
    And downloading invoice by clicking on the print icon in the page bottom
    When user click on the share invoice
    And clearing the already given mail and mobile number
    Then enter the emails "sunil.kommayella@nanohealth.in"
    And click on submit button4
    Then user click on the back button
    And user click on confirmed status 
    When user click on the first appointment id 
    Then pop-up will open
    And click on the Add Vitals
    Then enter the bp_complaint_examination
    And click on save as draft button
    When user clicks on save as draft button it will redirect to the pop-up page
    And closes the pop-up
    When user click on the profile img 
    Then from options click on signout
    When user navigates to the url
   Then login page opens 
   And enter the doctorrole mail "dr@yourclinic.com"
   Then enter the doctorrole password "Demo@123"
   And click on signin button
   When doctor signedup sucessfully
   Then click on the week button from the doctor dashboard
   And click on the patient name
   And click on the add prescription button
   Then add prescription pages opens
   And selects the consultation type
   Then enter the accompained by
   And enter the patient history
   Then selects the symptoms from the suggestions
   When symptom selected cursor goes to the duration field
   And enter the duration 
   Then clicks on dropdown and selects the week
   And select another symptom using leftandright arrowkeys
   Then enters duration
   And clicks on symptoms field and search with name
   Then click enter
   And enter duration
   Then remove last two added symptoms
   When doctor click on symptoms field it will show the suggestions
   And clicks on escape button to hide suggestion
   Then click on the diagnosis field to select
   When diagnosis field is clicked it will show the suggestions
   And select diagnosis by clicking enter button
   Then enter duration and select duration from the dropdown
   And select another diagnosis by using left and right arrow keys and select by clicking enter
   Then enter duration and select duration from the dropdown for diagnosis2
   And select another diagnosis and remove the last added diagnosis
   When enter the following details into the vitals field from the prescription
   |Pulse (bpm)|100|   
   |Height|180|
   |Weight|77|
    
    Then adding history of line
   And selecting the medication clicking enter button
   Then clicking on medication notes icons and closing it
   And adding another medicine using enter
   Then click on medication notes icons and closing it
   And removing last added medication scrolling page down
   #Then click on the plus button for notes
   #And enter the notes1 and click on plus again to add new notes2 row
   #Then enter the notes2 and click on plus again to add new notes3 row
   #And enter the notes3 and remove the last added notes
   Then entering duration for next visit date
   And selecting nextvisittype
   Then selecting labs using search
   And clicking enter to select lab
   When doctor clicks on labs suggestions will show
   And selecting labs from suggestions using enter button
   Then removing the labs 
   And enter the free text for labs and click enter button
   When clicking on request button popup will opens
   And clicking on the request button
   Then entering comments
   And selecting procedures using searching
   Then selecting the procedures using cursor
   And removing added procedures
   And enter the free text for procedures 
   Then select the pain scale emoji
   And enter the investigation
   
   Then enter the advice in the prescription form 
   And click on the attachment present at top right middle
   When attachment is clicked attach files popup will opened
   Then from the attach files popup send the file and click on the ok button
   When ok button is clicked attach files popup will be closed
   And click on the health information present at bottom right side
   When health information is clicked it will open the health information
   Then give the necessary health information and submit
   And close the health information popup
   Then click on the doctor notes present bottom of health information
   When doctor notes is clicked it will open the popup for notes
   Then enter the message for notes 
   And enable the checkboxes if necessary click on the save button
   Then close the notes popup in the prescription
   And click on the favourite prescription and close it
   Then click on the past prescription 
   When past prescription is clicked it will open the recently saved prescription
   And click on the lab reports and close it 
   When doctor clicks on saveasdraft it will redirect to the patient profile 
   And clicking Add Prescription and saving
   Then Scrolling pagedown and downloading pdfs
   And sharing the prescription to mailid1 "sunil.kommayella@nanohealth.in"
   When doctor click on edit button
   Then prescription opens 
   And editing the nextvisitdate duration
   Then clicking on save button for prescription
   And Scrolling pagedown and download pdfs
   Then sharing the prescription to emailid2 "sunil.kommayella@nanohealth.in"
   And clicking on the close button of prescription
   When doctor clicks on close it will redirect to the patient profile
   And click on the medical conditions icon
   When medical condition icon is clicked it will download the medical pdf contains medicine
   Then clicks on historybutton
   When history open then prescription row will display
   And downloads pdfs and share to the mailid3 "sunil.kommayella@nanohealth.in"
   Then click on the load prescription from history of patientprofile
   When load prescription is clicked it will open prescription
   Then click on the save button after opening prescription
   And download the pdfs and share invoice after loading prescription
   Then click on the patient name from the prescription after saving loaded prescription
   And click on the history from the patientprofile 
   When history is clicked there will be two rows for prescription
   Then download the pdfs from the prescription row from history
   And clicking on the diagnostic trends
   Then select the diagnostic trend from the dropdown and search
   When search is clicked then it will show the weight in the graph
   And click on the table to show the weight in the table
   Then click on the medicine chart
 