# JumpCloud_password_hashing_Application

## Handy References:
1. https://www.restapitutorial.com/httpstatuscodes.html
2. https://www.w3schools.com/tags/ref_httpmethods.asp
3. https://www.webfx.com/web-development/glossary/http-status-codes/



## Requirements about the Application :						
https://drive.google.com/file/d/1Ikh18AVdkXtrJ_YakgvcpWH3d8WqS98p/view?usp=sharing


## How to Run the Test
I have created Automation scripts for api testing using RestAssured framework. 
Scripts have been created for a few TestCases based on the manual Testcase document. 
To run the code, the following is required.
1. Download an IDE for running Java code. Set the Java JRE path
2. Create a Maven Project.
3. In the POM.xml , we need the following Libraries. These latest versions of these libraries can be obtained from MavenRepository. 
4. https://mvnrepository.com/
    -io.rest-assured
    -Com.fasterxml.jackson.core- jackson-databind
  c. Com.fasterxml.jackson.core- jackson-core
  d. Com.fasterxml.jackson.core - jackson-annotations
  e. Com.google.code.gson- gson
  f. testng ( for Assertions and Validations)
  g. json-simple
  h. Extentreports ( For Creating Reports)
  i. Log4j-api ( For Creating Logs)
  j. Log4j-core 
  k. junit (for Assertions and Validations)

## TestCases and Defects Sheet
I have Created a .xlsx sheet that contains **Manual TestCases** used for testing the application on the **TestCase Tab**.
Those cases that are Automated. I have marked them with an YES.
The .xlsx sheet has a **Defects Tab** that lists the defects/bugs identified while testing the api.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/blob/master/JumpCloud_TestCases%20and%20Defects.xlsx

## Logs and Reports
**Logs folder** contains the Logs that were created while running the test.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/blob/master/Logs/log4j.log

**Reports folder** contains the reports on PASSED OR FAILED Testcases in .html format.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/tree/master/Reports

