Feature: Login with OTP
 
 Background: 
    Given Naviagate to the NH Web portal
    When Login_page opens
    Then Click on the Login with otp button
    
  @passcase
  Scenario: Login with OTP positive case
    And Provide the valid mobile number or email id for otp verify
    When Get otp button clicks otp will generate 
    Then Enter the otp
    And Click on the verify button to verify the valid gmail or mobile for login
    When The otp is correct it will verify and login 
    
   @failcaseone
   Scenario: Login with OTP invalid mail or mobile number
    And provide the invalid mobile number or email id for otp verify
    When Get otp button clicked otp will generate 
    Then Mobile number or mail does not exist validation should show
    
   @failcasetwo
   Scenario: Login with OTP invalid otp
    And provide the valid mobile number or emailid for otp verify
    When Get otp button clicked otp will_generate 
    Then enter the wrong otp
    And click on the verify button
    Then Sorry! The entered OTP is invalid. Please try again validation should show
    
    @failcasethree
   Scenario: Login with OTP invalid otp
    And provide the valid number or email id for otp verify
    When Get otp button is clicked otp will generate 
    Then enter the otp in five digits only
    And click the verify button
    Then verify button should not work
    
    

  

     