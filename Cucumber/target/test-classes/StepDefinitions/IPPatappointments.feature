Feature: Admitting an ip patient after registration and booking appointments

  @admit
  Scenario: Admitting a patient in IP Billing Manager after registration in NH_Web_Portal
    Given the user navigates to the NH_Web_Portal application
    When the NanoHealth login page opens
    Then the user enters credentials with email "sunilcm@gmail.com" and password "Demo@1234"
    And clicks on the Sign In button
    When the user selects the profile when the popup opens
    Then the user selects the role as CDPAdmin
    When the CDPAdmin dashboard is displayed
    And deletes an already existing patient in the CDPAdmin role
    Then the user switches the role to IP_Billing_Manager
    And clicks on the Add Patient icon from the IP_Billing_Manager dashboard
    When the user selects the title of the IP patient
    When enters the following details into the registration form:
      | firstname    | Cucum         |
      | lastname     | Ippatapts     |
      | age          |            55 |
      | phone        |    6788110011 |
      | addressline1 | ameerpet      |
      | addressline2 | ameerpet      |
      | landmark     | metro station |
      | city         | test          |
      | district     | test          |
      | pincode      |        878787 |
      | aadharcard   |  123456789012 |
    Then the user selects the necessary radio buttons in the registration form
    And clicks on the Submit button to register the patient
    When the user clicks on the Admission Detail button
    And select the payment_mode as insurance and select the paymentdetailmethod
    And select department from the dropdown
    Then select single from the roomtype dropdown
    And select lead doctor from the dropdown
    And enter the comments in admissiondetail form
    And select admission type radio button
    Then select NH_IP_Ward from the dropdown on clicking admission site
    And clicks on the Submit button

    @apts
    Scenario: Booking services to the ip patient from the ip billing manager
    When the patient is IP then ip icon will be shown