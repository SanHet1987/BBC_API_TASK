### Overview
This Repo holds the BDD Rest api tests for the BBC Music tracks API.
### Run Tests locally

* Pre-Requisite/Setup
   * Java 1.8
   * Maven
   
* IDE Support
   * Gherkin(Intellij Plugin)
   * Cucumber for Java (Intellij Plugin)
   
Run the Tests locally in different environment (qa,INTe,UAT)

   mvn clean verify -Dtest.environment=qa -Dcucumber.options="--tags @BBCRmsMedia_Acceptance_Test"
   mvn clean verify -Dtest.environment=qa -Dcucumber.filter.tags="@BBCRmsMedia_Acceptance_Test"
   
Note : --tags is to run the tests for different services

Tags values example are
@BBCRmsMedia_Acceptance_Test
  
* [feature files](./src/test/resources/features)
* [Stepdefinitions](./src/test/java/steps)

### Test Reporting

* Serenity Test Report --> ./target/site/serenity/index.html 
      
   