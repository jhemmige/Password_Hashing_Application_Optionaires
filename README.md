# JumpCloud_password_hashing_Application

## Handy References:
1. https://www.restapitutorial.com/httpstatuscodes.html
2. https://www.w3schools.com/tags/ref_httpmethods.asp
3. https://www.webfx.com/web-development/glossary/http-status-codes/



## Requirements about the Application :						
https://drive.google.com/file/d/1Ikh18AVdkXtrJ_YakgvcpWH3d8WqS98p/view?usp=sharing


## How to Run the Test
I have created Automation scripts using RestAssured api framework. I am still learning advanced framework from Udemy.com.
I am still figuring out how to create a stable testscript for **"The software should be able to process multiple connections simultaneously"** requirement.
Scripts have been created only for a few TestCases based on the manual Testcase document and they have been marked as an YES corresponding to the testcase.
To run the code, the following is required.
1. Download an IDE for running Java code. Set the Java JRE path
2. Create a Maven Project.
3. In the POM.xml , we need the following Libraries. These latest versions of these libraries can be obtained from MavenRepository. 
4. https://mvnrepository.com/
   **A.**   io.rest-assured
   **B.**   Com.fasterxml.jackson.core- jackson-databind
   **C.**   Com.fasterxml.jackson.core- jackson-core
   **D.**   Com.fasterxml.jackson.core - jackson-annotations
   **E.**   Com.google.code.gson- gson
   **F.**   testng ( for Assertions and Validations)
   **G.**   json-simple
   **H.**   Extentreports ( For Creating Reports)
   **I.**   Log4j-api ( For Creating Logs)
   **J.**   Log4j-core 
   **K.**   junit (for Assertions and Validations)

## TestCases and Defects Sheet
All Manual testing has been carried out using POSTMAN tool. Here's a link to download the tool https://www.postman.com/product/rest-client/
I have used Mac os for testing.
I have Created a .xlsx sheet that contains **Manual TestCases** used for testing the application on the **TestCase Tab**.
Those cases that are Automated. I have marked them with an YES.
The .xlsx sheet has a **Defects Tab** that lists the defects/bugs identified while testing the api.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/blob/master/JumpCloud_TestCases%20and%20Defects.xlsx

## Logs and Reports
**Logs folder** contains the Logs that were created while running the test.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/blob/master/Logs/log4j.log

**Reports folder** contains the reports on PASSED OR FAILED Testcases in .html format.
https://github.com/jhemmige/JumpCloud_password_hashing_Application/tree/master/Reports

