Feature: Login page 
Scenario: UI Test : Check All Default Relevent Fields are on Registration page for User living in India(non NRI) that they exists and are empty/unchecked and enabled and visible
	Given Create Location Type as "CountryLocationType"
	| name      |
    | Country   | 
	When Open Login page 
	Then Check Field exists "name" 
	Then Check Field exists "email" 
	Then Check Field exists "password" 
	Then Check Field exists "confirm_password" 
	Then Check Field do not exists "country_code" 
	Then Check Field exists "mobile_number" 
	Then Check Field exists "captcha" 
	Then Check Field do not exists "error_label" 
	Then Check Field exists "register_button" 
	Then Check Field exists "nri" 
	Then Check Field exists "login_button" 
	Then Check Field "name" is empty 
	Then Check Field "email" is empty 
	Then Check Field "password" is empty 
	Then Check Field "confirm_password" is empty 
	Then Check Field "mobile_number" is empty 
	Then Check Field "nri" is not checked 
	Then Check Field "name" is enabled and visible
	Then Check Field "email" is enabled and visible
	Then Check Field "password" is enabled and visible
	Then Check Field "confirm_password" is enabled and visible 
	Then Check Field "mobile_number" is enabled and visible
	Then Check Field "nri" is enabled and visible
	Then Check Field "register_button" is enabled and visible
	Then Check Field "login_button" is enabled and visible
	
Scenario: UI Test : Check All Default Relevent Fields are on Registration page for User living abroad(NRI) that they exists and are empty/unchecked and enabled and visible
	Given Create Location Type as "CountryLocationType"
	| name      |
    | Country   | 
	When Open Login page 
	And Select Registeration NRI checkbox
	Then Check Field exists "name" 
	Then Check Field exists "email" 
	Then Check Field exists "password" 
	Then Check Field exists "confirm_password" 
	Then Check Field exists "country_code" 
	Then Check Field exists "mobile_number" 
	Then Check Field exists "captcha" 
	Then Check Field do not exists "error_label" 
	Then Check Field exists "register_button" 
	Then Check Field exists "nri" 
	Then Check Field exists "login_button" 
	Then Check Field "name" is empty 
	Then Check Field "email" is empty 
	Then Check Field "password" is empty 
	Then Check Field "confirm_password" is empty 
	Then Check Field "mobile_number" is empty 
	Then Check Field "nri" is checked 
	Then Check Field "name" is enabled and visible
	Then Check Field "email" is enabled and visible
	Then Check Field "password" is enabled and visible
	Then Check Field "confirm_password" is enabled and visible 
	Then Check Field "mobile_number" is enabled and visible
	Then Check Field "nri" is enabled and visible
	Then Check Field "country_code" is enabled and visible
	Then Check Field "register_button" is enabled and visible
	Then Check Field "login_button" is enabled and visible
		

Scenario: Functional Test : Register an Indian User(non NRI)
	Given Create Location Type as "CountryLocationType"
	| name      |
    | Country   | 
	When Open Login page 
	And Enter Registeration Name "Ravi Sharma"
	And Enter Registeration Email "ping2ravi@gmail.com"
	And Enter Registeration Password "password"
	And Enter Registeration Confirm Password "password"
	And Enter Registeration Mobile Number "9876543210"
	And Click on Registration Button
	#Then Registration Button should be disabled //Its very fast so unable to assert
	Then Wait for field "success_label" to appear
	Then Registration Button should be enabled
	Then Check one user exists
	| name          | creationType    |  nri  | superAdmin | donor | member |
    | Ravi Sharma   | SelfServiceUser | false | false      | false | false  |
    Then Check one email exists
	| email                 | emailUp             | newsLetter | confirmationType | confirmed |
    | ping2ravi@gmail.com   | PING2RAVI@GMAIL.COM | true       | UN_CONFIRNED     | false     |
    Then Check one phone exists
	| countryCode | phoneNumber | phoneType | confirmed |
    | 91          | 9876543210  | MOBILE    | false     |
    Then Check email and user are connected
    Then Check email and phone are connected
    Then Check phone and user are connected
 
 Scenario: Functional Test : Register NRI user
	Given Create Location Type as "CountryLocationType"
	| name      |
    | Country   | 
    Given Create Location as "CountryLocationUk" with locationType "CountryLocationType"
	| name | isdCode |
    | UK   | 44      |
    Given Create Location as "CountryLocationUsa" with locationType "CountryLocationType"
	| name | isdCode |
    | USA  | 1       |
	When Open Login page 
	And Enter Registeration Name "Ravi Sharma"
	And Enter Registeration Email "ping2ravi@gmail.com"
	And Enter Registeration Password "password"
	And Enter Registeration Confirm Password "password"
	And Select Registeration NRI checkbox
	And Select Registration Country "UK(44)"
	And Enter Registeration Mobile Number "9876543210"
	And Click on Registration Button
	#Then Registration Button should be disabled //Its very fast so unable to assert
	Then Wait for field "success_label" to appear
	Then Registration Button should be enabled
	Then Check one user exists
	| name          | creationType    |  nri  | superAdmin | donor | member |
    | Ravi Sharma   | SelfServiceUser | true  | false      | false | false  |
    Then Check one email exists
	| email                 | emailUp             | newsLetter | confirmationType | confirmed |
    | ping2ravi@gmail.com   | PING2RAVI@GMAIL.COM | true       | UN_CONFIRNED     | false     |
    Then Check one phone exists
	| countryCode | phoneNumber | phoneType     | confirmed |
    | 44          | 9876543210  | NRI_MOBILE    | false     |
    Then Check email and user are connected
    Then Check email and phone are connected
    Then Check phone and user are connected   
	
	
    