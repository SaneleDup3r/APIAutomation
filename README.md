# API Automation
# Tasks complemted :
Test Cases have been implemented via Excel and uploaded on the Repo including the additional test cases that are not covered by the requirements.

Framework used for the assessment is Called RestAssured with Java.

Two non-functional tests I would design is : Perfomance and Load testing
Tool/Framework I would use to automate the fuctional tests is Jmeter.


# How To Execute Tests
# Prerequisites
1. You'll need to download : 
      Java jdk
      IntelliJ IDEA Community Edition
      Maven
      TestNG "can be installed via IDE"
   
2. Environment Virables need to be setup on your machine for both Java and Maven
3. Once step 1 and 2 is completed, download the project as Zip folder. Open it with IntelliJ
4. Reload dependencies on the POM file by going to notifications tab, then click on relaod
5. Go to API Test class, run tests

# Assumptions and Issues discovered working with the API endpoints:
During testing I noticed that all the API requests return a status 200 even if i'm searching for a record that doesn't exist on the DB.
Meaning that validation was not done on the API's.

The following API's should be returning different codes but they are returning 200 :
1. "SearchByNonExistentCocktailName" - https://www.thecocktaildb.com/api/json/v1/1/search.php?s=sanele 
2. "SearchByNonExistentIngredientName" - https://www.thecocktaildb.com/api/json/v1/1/search.php?i=derivco
3. "SearchBySendingAnEmptyInput"  -  https://www.thecocktaildb.com/api/json/v1/1/search.php?i=

If API validation was made, these API should be returning 404, 404 and 400. As a results I made these three API tests fail since they are not doing what the test case says or returning the wron status code.

# N.B
I treated these tests as if I was testing a live application which has validation and everything suppose to be working properly.

Also included a video running the tests.




