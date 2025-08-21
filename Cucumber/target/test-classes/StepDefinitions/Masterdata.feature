Feature: Masterdata

  Background: 
    Given naviagate to the NH_Web_portal
    When loginpage opens
    Then enter emailormobile "Sunilk@nh.com" password "Chakra@1"
    And click on the sign in button
    When select a profile popup opens
    Then select the role as clinic manager
    When dashboard opens mousehover on the reports
    Then click on the master data
    When master_data_dashboard opens

  @hm
  Scenario: Hospital masters from the Facility Digital Twin
    Then click on the facility digital twin from the masterdata
    And mouse hover on to the clinic_hopsital
    Then drag and drop to add a new clinic_hospital
    And enter the details of the clinic_hospital with mouse hover actions
    Then add invoice pdf configuration header and footer from create new hospital
    Then click on the submit button to create a new hospital
    When hospital is created successfully alert will come
    Then search the hospital from the search bar
    When searched hospital appears on the UI
    Then double click on the hospital name and click on the edit button
    And add the address contact and save again
    Then alert with the updation will appear
    And search the hospital and mouse hover on to the hospital
    When team details icon is visible click on it
    And team details is clicked then user details
    Then add new doctor from the user details
    When doctor is added and hospital is active then hospital will be darken

  @doctormaster
  Scenario: doctor master from dashboard
    When the masterdata dashboard
    Then click on the doctors button
    When doctor masters page open
    Then click on the add button to add a new doctor master
    And enter the following details in the new doctor popup page1
      | First name | Cucumber |
      | Last name  | Doctor   |
    Then select the gender radiobutton for the doctor
    And enter the following details in the doctor page6
      | Age | 45 |
    Then selecting the country code from dropdown for doctormasters
    Then enter the following details in the new doctor popup page2
      | Mobile number | 7766554422 |
    #| Email id      | Cucumberdoctor@gmail.com                                 |
    #| Profile image | C:\\Users\\Lenovo\\Desktop\\Uploads\\doctor.png          |
    #| Signature     | C:\\Users\\Lenovo\\Desktop\\Uploads\\doctorsignature.png |
    And click on the continue button to add doctor role in the next popup
    Then select the role and existing hospital from the dropdown
    And upload the doctor signature
    Then clicking on the more icon to enable access checkboxes
    Then click on the save button from add doctor page
    Then click on the copy to clipboard button for doctormasters
    And click on the add or edit consultations plus button
    Then addoredit consultations page opens
    And click on the add icon to addconsultations for doctormaster
    Then select the appointment type enter fee,slot duration1
    And click on the add icon again to addconsultations for doctormaster
    Then select the appointment type enter fee,slot duration2
    And remove the last added consultation for doctormaster
    Then click on the save button from doctor consultations
    And clicking on the sharecredentials button and click on confirm for doctormaster
    Then search the recent added doctor using search field
    And navigate to the masterdata dashboard from doctormasters

  @dieticianmaster
  Scenario: dietician master from dashboard
    When the masterdata dashboard is opened
    Then click on the userdetails button
    When userdetails page open
    Then click on the add button to add a new dietician master
    And enter the details of the dietitian
    Then select the role and hospital from the creation page
    And click on the save button from add dietician page
    Then click on the edit button for newly created dietician
    And edit the phonenumber click on save button for dietician
    Then click on the dietitian role name and add availability
    And click on the add available time to addconsultations for dietician
    #Then select the appointment type enter fee,slot duration1 for dietician
    #And click on the add icon again to addconsultations for dietician
    Then select the appointment type_days_slot_timings for dietician
    #And remove the last added consultation for dietician
    Then click on the save button from dietician consultations
    And clicking on the sharecredentials button and click on confirm for dietician
    Then search the recent added dietician using search field

  @pharmacy
  Scenario: pharmacy from dashboard
    When the masterdata dashboard opened
    Then click on the digital twin from masterdata dashboard
    And drag and drop to create a new pharmacy
    When add pharmacy popup opens enter the following details
    And enter the details in the create new pharmacy popup
    Then click on the submit button from the create new pharmacy popup
    And add the address for pharmacy and save the pharmacy
    And search and click on the pharmacy from the search box
    Then double click on the pharmacy to edit
    And edit the pharmacy and add address for the pharmacy
    Then click on the submit button from the pharmacy address popup
    And click on the submit button from the pharmacy popup
    Then connect this created pharmacy with the cucum hospital
    And add pharmacist user using created pharmacy from hospital digital twin
    And disconnect the pharmacy with the hospital

  @labmaster
  Scenario: lab masters from the masterdata
    Then click on facility digital_twin from the masterdata
    And drag and drop the lab to create a new lab
    Then enter the necessary details for the lab creation
    And click on the submit button to create a new lab
    Then double click on the lab to edit
    And add the lab address and save it
    Then map the lab with the hospital to create tests in the lab
    And search the created lab that is connected with the hospital
    Then mouse over on to the lab that created
    And click on the lab test to create radiology pathology packages
    #pathology
    Then click on the plus button to add new test1
    And select the individual radio button for adding pathology test to lab
    Then select the pathology radio button to add pathology test
    And select the test name from the dropdown to add pathology test
    When selecting pathology test
    Then label name_department field automatically filled for pathology test
    And enter the technology for the pathology test
    Then enable the active checkbox for the pathology test
    Then click on the plus button to add ideal range
    And enter the details for diagnostic test lab configurations
    Then click on the plus to add new ideal range
    And entering the details and remove last added
    Then click on the continue button for pathology test
    And entering the cost and price of that pathology test
    Then click on the save button for saving pathology test
    #radiology
    And click on the plus button to add new test2
    Then select the individual radio button for adding radiology test to lab
    And select the radiology radio button to add radiology test
    Then select the test name from the dropdown to add radiology test
    When selecting radiology test
    Then click on the continue button for radiology test
    And entering the cost and price of that radiology test
    Then click on the save button for saving radiology test
    #profile-pathology
    And click on the plus button to add new test3
    Then select the profile radio button for adding profile pathology test to lab
    And select the pathology radio button to add profile pathology test
    Then select the test name from the dropdown to add profile pathology test
    When selecting profile pathology test
    Then label name_department field automatically filled for profile pathology test
    And enter the technology for the profile pathology test
    Then enable the active checkbox for the profile pathology test
    Then click on the plus button to add ideal range for profile pathology test
    And enter the details for diagnostic test lab configurations for profile pathology test
    And click on the continue button for profile pathology test
    And entering the cost and price of that profile pathology test
    Then click on the save button for saving profile pathology test
    #profile-radiology
    And click on the plus button to add new test4
    Then select the profile radio button for adding profile radiology test to lab
    And select the radiology radio button to add profile radiology test
    Then select the test name from the dropdown to add profile radiology test
    When selecting profile radiology test
    Then click on the continue button for profile radiology test
    And entering the cost and price of that profile radiology test
    Then click on the save button for saving profile radiology test
    #popular package
    And click on the plus button to add new test5
    And select the popular package radio button to add popular package
    Then enter the popular package test name
    And disable and enable the checkboxes of the popular package
    Then selecting the test name from the dropdown to add into the popular package
    And clicking on the plus button to select one more test1
    And entering the order number1
    Then selecting the test name1 from the dropdown to add into the popular package
    And clicking on the plus button to select one more test2
    And entering the order number2
    Then selecting the test name2 from the dropdown to add into the popular package
    And clicking on the plus button to select one more test3
    And entering the order number3
    Then selecting the test name3 from the dropdown to add into the popular package
    And removing the last added test name for the popular package
    Then clicking on the continue button from the popular package popup
    And entering the cost and price for the popular package
    Then click on the save button to save the popular package
    When popular package is saved
    And deleting the one test OPG
    Then mouse-hovering to the tests in the cucumber testlab
    #edit
    And click on the edit for popular package
    Then update the price and click on save button from edit package
    And click on the edit2
    Then update the price and click on save button2
    And click on the edit3
    Then update the price and click on save button3
    And click on the edit4
    Then update the price and click on save button4
    And searching test name and type using search
    Then click on the linked hospital button
    And add the hospital name and save it
    Then clicking on the linked hospital button again
    And removing the mapped hospital from linked hospitals
    When linked hospital removed and clicking on the back button
    #Then click on the tests button from lab_masters page
    #And searching the test using search filters
    Then open facility digital twin and search for the hospital
    When mouse hover on the lab and click on the add technician_pathologist
    Then user details page will be opened
    And click on the add button to create a new user with technician_pathologist
    Then enter the details of the user and click on continue
    And select the roles technician_pathologist and save

  @teamdetails
  Scenario: teamdetails from masterdata
    When existing teamdetails is deleted
    And click on the teamdetails button from the masterdata dashboard
    Then click on the plus button to add new user
    And enter the necessary details of the user
    When details has been entered then continue button will enable and turn to green colour
    Then click on the continue button to add the roles to user
    And select the role from the roles popup and select the required options from the role fields
    Then click on the plus button to add new role to the user
    And select the another role and role required options from the dropdowns
    Then click on the remove icon to remove one of the added role
    And click on the save button from the roles page
    When save button is clicked it will redirect to the users role page
    Then click on the edit button and make changes
    And click on the save button from the edit user role
    Then navigate to the masterdata dashboard from teamdetails page

  @healthcoach
  Scenario: healthcoach from masterdata
    Then click on the team details button from the masterdata
    And click on the plus button to add new healthcoach from teamdetails
    Then enter the details like first and last name age email no profile picture
    And click on the continue button from the team details
    Then select the role as healthcoach from the dropdown
    When healthcoach role is selected location will be automatically update
    Then select the city and area from the dropdown
    And click on the more button to add more details
    Then enable the required checkboxes
    And upload the Aadhar PAN files
    Then click on the save button from the popup to create a new healhcoach
    And edit the age and save the user of healthcoach
    Then click on the healthcoach role
    And download the profile and assign device and assign tablet

  @chargemasters
  Scenario: creating a new ip procedures using chargemasters from masterdata
  	And changing role from clinicmanager to ipbillingmanager to create new ipprocedure
    Then click on the charge masters from the dashboard to create ipprocedure
    And create a new ip procedure using surgery masters from the charge master
    Then click on add new charge master from the charge masters
    And select the hospital service type service name code master
    Then select the ipprocedure using dropdown created before using surgery master
    And enter the base price and select the variable price
    Then select the price type as self defined
    And add provider and demand programs and save the ipprocedure
    Then select the facility and service and search for the ipprocedure
    And edit and save the ipprocedure
    And navigate to the masterdata dashboard from ip procedures page

  @minorprocedures
  Scenario: minor procedures from masterdata
    Then click on the minor procedures from the dashboard
    And edit the minor procedure and save it
    And searching through using service dropdown for minorprocedures1
    Then clicking on the search button and reseting after for minorprocedures1
    And searching using through active dropdown for minorprocedures2
    Then clicking on the search button and reseting after for minorprocedures2
    And navigate to the masterdata dashboard from minor procedures page

  #@chargemasters
  #Scenario: creating a new chargemaster
    #Then click on the chargemaster button from the dashboard
    #When plus button is clicked to add new charge master
    #And select the service type from the dropdown
    #When professional fees is selected from service type service name will automatically selected
    #Then select the service detail from the dropdown
    #And enter hospital service name
    #Then enter the base price
    #When valuable price radio button yes is selected it will show other options
    #And click on the save button from the charge masters popup
    #Then click on the edit button from the charge masters
    #And edit and save the charge masters
    #Then search newly created charge masters from the search dropdown
    #And navigate to the masterdata dashboard from the charge masters

  #room masters
  @patientrooms
  Scenario: room masters from the masterdata
    Then click on the room masters from the dashboard
    And click on the room type details from the clinic room masters page
    Then deleting the room type and room details from UI
    Then click on the plus to add room type
    And enter the following details
      | Room type   | Cucumber room typee       |
      | Description | Cucumber room description |
    Then clicking on the dropdown charge code master
    And selecting the general ward  charges
    Then click on the save button from the room type details
    And click on the edit button and update the room type name
    Then click on save button from the edit room type details page
    And click on the Room details in the header section
    Then click on the plus button to room
    And selecting the room type from the dropdown
    Then entering the following details into room details
      | Room no     |                101 |
      | Description | Cucum room masters |
      | Price       |               1000 |
      | Bed no      | 101A               |
      | Description | Cucum room         |
      | Price       |               1000 |
    And click on the plus button to add another bed in the same room
      | Bed no      | 101B           |
      | Description | Cucum room two |
      | Price       |           1200 |
    And removing the last added room
    Then click on the save button from the room details popup
    And click on the edit button and update the price
    Then click on the save button from the edit room details popup
    And navigate to the masterdata dashboard from room masters page

  @hcs
  Scenario: home care services from masterdata
    #Home care services
    Then click on the home care services from the masterdata dashboard
    And edit and save the homecareservices
    And searching through the service name for hcs
    Then click on the search and reset buttons after getting the results1
    And searching through the active for hcs
    Then clicking on the search and reset buttons after getting the results2
    And navigate to the masterdata dashboard from home care services page

  @brandmaster
  Scenario: brandmasters from the masterdata
    Then click on the brandmaster from the masterdata dashboard
    And click on plus button to add new brand
    Then select the category of the brand using dropdown
    And select the manufacturer of the brand using dropdown
    Then select the form of the brand using dropdown
    And enter the brand and salt names
    Then select the route of the brand using dropdown
    When entering the HSN code for add new brand
    Then selecting the GST rate from the dropdown
    And select the vaccine for from dropdown
    Then enter the price for the vaccine brand
    And select the checkboxes active and verified
    Then click on the save button from new brand popup
    And click on the edit button update the salt name
    Then click on the save button from the edit new brand popup
    And search the added brand by using brand name field
    Then navigate to the masterdata dashboard from brandmasters page

  @dieaseprogram
  Scenario: dieaseprogram from the masterdata
    Then click on the diease program from the masterdata dashboard
    And click on the plus button to add new program
    Then enter the program name from add new program popup
    And select the effective start date
    Then enter the package duration and select the days from dropdown
    And enter the description from add new program popup
    Then uploading the image of the program
    And enabling the checkboxes for the new program
    Then selecting the charge code and for ip from dropdown
    And selecting services from add new program popup
    Then clicking on the add plus button to add new service
    And selecting services again
    Then remove last added services
    And selecting the checkbox active
    Then click on the save button from the add new program popup
    And click on the edit button and updating the description
    Then click on the save button from the edit program
    And selecting the program name from dropdown and searching
    Then navigae to the masterdata dashboard from diease program page

  @promocode
  Scenario: promo code from masterdata
    Then click on the promocode from the masterdata
    And click on the plus button to add new promo code
    Then enter promo code in the new promo code popup
    And select the start date from the calendar for new promo code
    Then select the end date from the calendar for new promo code
    And selecting the active checkbox for new promo code
    And select the program status_master service_master from the dropdown for new promo code
    Then entering the discount and enabling the checkbox for new promo code
    And click on the save button for new promo code
    Then click on edit and update the promo code
    And click on the save button from the edit promo code page
    Then selecting the promo code from the dropdown and searching
    And navigate to the masterdata dashboard from the promocode page

  #@district
  #Scenario: district from masterdata
  #Then click on the district from masterdata
  #And click on the plus button to add new distict
  #Then select the state from the dropdown to add new district
  #And enter the district name and code
  #Then enable the active checkbox for the new district
  #And click on the save button for new distrcit
  #Then edit and update the district code
  #And click on the save button from the edit distict page
  #Then search the added district using dropdown
  #And navigate to the masterdata dashboard from the district page
  #@useraddetail
  #Scenario: user ad details from masterdata
  #Then click on the userdadetails from masterdata
  #And click on the plus button to add new user addetails
  #Then select the cdp for the new useraddetials
  #And select the service using dropdown
  #Then select the appointmenttype using dropdown
  #And enter the following details into the new useraddetails
  #| Description     | test description                                             |
  #| BackGroundColor | white                                                        |
  #| add url         | C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (1).png |
  #| link url        | C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (1).png |
  #Then enabling the isactive checkbox for the new useraddetails
  #And click on the save button from the new useraddetails page
  #Then click on the edit button and update the description
  #And click on the save button from the edit new useraddetails page
  #Then searching for lab using dropdown
  #And navigate to the masterdata from the useraddetails page
  #tax service
  #@taxservice
  #Scenario: tax service from the masterdata
  #Then click on the tax service from the masterdata
  #And selecting the hsncode from the dropdown
  #Then clicking on the search button and delete
  #And confirm the delete by clicking yes button
  #And click on the plus button to add new tax service
  #Then enter the following details into the new tax service popup
  #| HSN Code | 8791 |
  #| CGST     |    6 |
  #| SGST     |    6 |
  #| IGST     |   12 |
  #And click on the save button
  #Then click on the edit button and update the HSN Code
  #And click on save button in the edit tax service
  #Then select the hsn code from dropdown and search
  #And navigate to the masterdata dashboard from the taxservice page
  #forms
  #@forms
  #Scenario: forms from masterdata
  #Then click on the forms from the masterdata
  #And click on the plus button to add new template
  #Then enter the template name from add new template page
  #And select the service from the dropdown for new template
  #Then enter the following details into the new template
  #| Template header url | C:\\Users\\Lenovo\\Desktop\\Uploads\\header.png |
  #| Template footer url | C:\\Users\\Lenovo\\Desktop\\Uploads\\footer.png |
  #| Header height       |                                              80 |
  #| Footer height       |                                              30 |
  #And click on the save button from the template page
  #Then edit the form and update the form name
  #And click on the save button from the edit template
  #Then search with the template name
  #And navigate to the masterdata dashboard from the forms page
  @screeningcamps
  Scenario: screening camps from masterdata
    Then click on the screening camps from the masterdata dashboard
    And click on the add new camp from the screening camps
    Then entering the camp name to create new camp
    And select the location from the dropdown
    Then select the program from the dropdown
    #And select the promo code from the dropdown
    Then entering the capacity for new camp
    And select the start date and time for new camp
    Then select the end date and time for new camp
    And entering the age from and to for new camp
    Then enabling the checkbox for ispublic
    And click on the save button for new camp
    #Then clicking on the edit and updating the capacity
    #And click on the save button from the edit screening camp page
    Then adding slots for the screeningcamp
    And adding address for the screeningcamp
    Then adding recommendations for the screeningcamp
    Then clicking on the camp name
    And clicking on the filter icon
    Then searching the patient name using filters
    And clicking on the reset button in the camp page
    And deleting already exisiting patient in the camp
    Then click on the plus button to assign patients
    And add patient in that new camp
    Then navigate to the masterdata dashboard from the screening camps

  #@vaccine
  #Scenario: vaccines from the masterdata
  #And click on the vaccine button from the masterdata
  #Then click on the plus button for add new vaccine
  #And Enter vaccine name to add new vaccine
  #Then select the formasters from the dropdown
  #And enter the description for add new vaccine
  #Then select the effective start and end dates
  #And enabling the active checkbox for add new vaccine
  #Then click on the save button from new vaccine popup
  #And click on the edit and update the vaccine name
  #Then click on save button from the edit vaccine popup
  #And search the added vaccine using dropdown
  #Then navigate to the masterdata dashboard from the vaccine page
  #@medicinetype
  #Scenario: medicinetype from the masterdata
  #And click on the medicine type from the masterdata
  #Then click on the plus button to add new medicine type
  #And enter the medicine type name for new medicine type
  #Then select the start and end date to add new medicine type
  #And upload the icon for the medicine type
  #Then enable the checkbox isactive for new medicine type
  #And click on the save button to add new medicine type
  #Then edit and update the vaccine name
  #And click on save button in the edit vaccine page
  #Then select the vaccine name and search
  #And navigate to the masterdata dashboard from the medicinetype page
  @devicemanagement
  Scenario: device management from the masterdata
    Then click on the device management from the masterdata
    And click on the device details to select device type
    Then selecting the device type from the dropdown and searching
    And clicking on the delete button beside edit button
    Then clicking on the confirm button to delete
    And click on the device type details to select device type
    Then selecting the device type from the dropdown to delete
    And clicking on the search button to get the device type details data
    Then clicking on the delete button and confirm deleting
    And click on the device type details from the device masters page
    Then click on the plus button to add new device1
    And enter the device type and description
    Then enable the active checkbox for new device
    And click on the save button to add new device master
    And Edit and update the device name
    Then click on the save button from the edit device popup
    And searching added device using dropdown
    Then click on the device details from the device masters page
    And click on the plus button to add new device2
    Then select the device type from the dropdown to add new device
    And enter the following details in the add new device popup
      | Device id    | cucumberid1234   |
      | Device name  | cucumber device1 |
      | UUID         |             8700 |
      | Major        | test major       |
      | Minor        | test minor       |
      | Rent per day |             1000 |
      | Sale price   |            60000 |
    Then enable the avaible checkbox to add new device popup
    And click on the save button to add new device
    Then edit and update the rent per day
    And click on the save button from the edit new device popup
    Then searching with the device type using dropdown
    And searching with the device id using dropdown
    Then searching with the avaible dropdown
    And navigate to the masterdata dashboard from the device masters page

  @feeds
  Scenario: personalized feeds from the masterdata
    Then click on the personalized feeds from the masterdata
    And click on the plus button to add new personalized feeds
    Then entering the title name for feeds
    And selecting the disease from the dropdown
    Then enter the feed description
    Then enter the following details into the new personalized feed popup
      | Feed url  | C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\bpfeed.jpg |
      | Image url | C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\bpfeed.jpg |
    And click on the save button from new personalized feed popup
    Then click on edit and update the feed name
    And click on the save from edit personalized feed popup
    Then searching the added feed using search field
    And navigate to the masterdata dashboard from the feeds page

  @formbuilder
  Scenario: creating a form and edit the form from the formbuilder
    And click on the formmasters button from the masterdata
    And delete the form created previously
    Then click on the questnr masters from the form master
    And click on the plus button to add new question
    Then add and save the new question master
    And search for the newly added question master and edit it
  
    Then click on the formbuilder to create a new form
    And mouse hover and click on the plus button to create a new form
    Then select the form type from form type and form name popup
    When form type is selected then form name and label configuration question will display
    Then enter the form name and select the label configuration for that form
    And click on the add button from form type and form name popup
    Then add responsible role and add header footer for the form
    And click on the string question type from left side question types
    When string question is clicked then Add String Type Question 
    Then select the question and give label configuration for that question
    And click on add button to add first question in the form
    Then click on the integer question type from left side question types
    Then select the question for integer and give label configuration for that question
    And click on add button to add second question in the form
    Then search the question type as radio and click on it
    And select the question for radio and give label configuration for that question
    Then click on add button to add third question in the form
    Then search the question type as checkbox and click on it
    And select the question for checkbox and give options and label configuration for that question
    Then click on add button to add fourth question in the form
    And remove the last question from the creating form 
    And drag and down the questions
    #Then make first as parent and next question as derived question
    And click on save button to create the new form
    Then edit the form add the newly created question and save changes 
    
    
    
    
    #Then click on the form masters button to create a new form
    #Then click on the plus button to add a new form
    #When plus button is clicked new form ui will be opened
    #Then enter the form name and select the form type masters from the dropdown
    #And click on the plus button to add questions in the new form
    #Then select the question from the dropdown
    #When question is selected from dropdown then question name type options is automatically filledup based upon the question selected
    #Then select the question as is_parent checkbox
    #When is_parent checkbox is enabled then derived questions will be shown in the dropdown
    #Then enter the orderid for the first selected question
    #And click on the plus button again to add new question
    #Then select the question from the dropdown and remainaing fields will be filled
    #And select this question as is_dependent checkbox
    #When is_dependent checkbox is enabled then this question will be show in the derived questions dropdown
    #And select the question in the derived questions field in the parent question
    #Then click on the plus button again to add new question in the form
    #And select the question and enter order id for the question
    #Then add new question and remove the question
    #And click on the save button to save the form
    #When save is clicked it will redirect to the form_masters
    #Then search the created form using filters
    #And edit the form and add new question and save again
    #Then click on the preview button after searching the form
    #And click on the download pdf button for form
	
	
	#@specializationmaster
  #Scenario: specialization masters
  #When masterdata dashboard is opened
  #Then mouse hover to reports and masterdata
  #And from masterdata mouse hover to specialization masters
  #Then click on the specialization masters from the masterdata
  #When specialization masters is opened
  #And selecting specialist from dropdown and searching to delete the data
  #Then click on the delete and confirm
  #Then click on the plus button to add new specialization masters
  #And enter the following details in the new specialization popup
  #| Specialisation code        |                                                          87900 |
  #| Specialisation description | cucumber spec descriptionn                                     |
  #| Specialist                 | cucum specialist                                               |
  #| Symptoms                   | test symptom                                                   |
  #| Meta title                 | cucumbertest                                                   |
  #| Meta description           | cucum desc.                                                    |
  #| Icon image                 | C:\\Users\\Lenovo\\Desktop\\Uploads\\specializationmasters.png |
  #| OG image                   | C:\\Users\\Lenovo\\Desktop\\Uploads\\specializationmasters.png |
  #Then enable the checkbox in the top of the specialization master
  #And click on the save button from the new specialization
  #Then click on the edit button and update the specialization description
  #And click on the save button from the edit specialization master
  #Then searching the added specialization master using dropdown
  #And navigate to the masterdata dashboard from the specialization masters
  @storemaster
  Scenario: storemaster from the masterdata
    Then click on the storemaster from the masterdata
    And search and delete the already existing storemaster
    When existing storemaster is deleted
    Then click on the plus button to add new storemaster
    When plus button is clicked it will open a popup to add new storemaster
    Then select the hospital name from dropdown
    And enter the required store type and store name
    Then click on the save button to save the new store master
    And search the store and click on the edit button
    Then edit the changes and save again of store master
    And search the recently added store using search functionality
    Then navigate to the masterdata dashboard from storemaster

  @urlshortener
  Scenario: urlshortener from the masterdata
    And click on the url shortener button from the masterdata
    Then enter the url and click on the generate url button
    When shortener link is generated then it will show the shortener url in the below
    Then copy the url using copy button
    And paste it in the new tab and click enter
    When it will open the link of the url shortener and closing this tab
    Then navigated back to the previous page and just click on the close button
    And clicking on the reset button from the url shortener page
    Then navigate to the masterdata dashboard from url shortener
		
		@procedurerooms
		Scenario: creating new procedurerooms from the masterdata
		And click on the procedurerooms from the masterdata
		Then click on the plus button to add a new procedurerooms
		And save the procedurerooms after entering the details
		Then edit and save again the procedurerooms
	