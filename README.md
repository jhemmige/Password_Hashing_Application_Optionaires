# JumpCloud_password_hashing_Application

Handy References:
https://www.restapitutorial.com/httpstatuscodes.html
https://www.w3schools.com/tags/ref_httpmethods.asp
https://www.webfx.com/web-development/glossary/http-status-codes/



Requirements about the Application :						
https://drive.google.com/file/d/1Ikh18AVdkXtrJ_YakgvcpWH3d8WqS98p/view?usp=sharing


How to Run the Test
Automation Scripts have been created for a few TestCases based on the manual Testcase document.I have used RestAssured api for it.
To run the code, the following is required.
Download an IDE for running Java code. Set the Java JRE path
1. Create a Maven Project.
2. In the POM.xml , we need the following Libraries.
---io.rest-assured
---Com.fasterxml.jackson.core- jackson-databind
---Com.fasterxml.jackson.core- jackson-core<
---Com.fasterxml.jackson.core - jackson-annotations
---Com.google.code.gson- gson
---testng
---json-simple
---Extentreports ( For Creating Reports)
---Log4j-api ( For Creating Logs)
---Log4j-core 
---junit

I have Created a .xlsx sheet that contains Manual TestCases used for testing the application on the TestCase Tab.
Those cases that are Automated. I have marked them with an YES
The .xlsx sheet has a Defects Tab that lists the defects/bugs identified while testing the api.

Logs folder contains the Logs that were created while running the test.
Reports folder contains the reports on PASSED OR FAILED Testcases in .html format.

