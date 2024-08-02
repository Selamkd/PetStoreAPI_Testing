# PetStore API Test Framework
### Project Goal

The goal of this project was to create a functional test framework for the PetStore API, testing numerous functional features and aimed to identify any possible defects in the API through our testing and report them accordingly.

The Pet store API covers the following endpoints:

	•	Get pet by ID
	•	Delete pet
	•	Post pet
	•	Get purchase order by ID
	•	Get pet inventories
	•	Delete purchase order
	•	Create user and login
 	•	Logout user 
  

 ### Running the Tests 
 #### Dependecies 

 	•	Rest Assured
	•	Jackson
	•	Junit
 
 1.	Navigate to the src/test directory.
 2.	Run the tests using your preferred IDE or via command line
    ` mvn test `
 #### Test Paths 
 
 Happy Path and Sad Path tests are implemented for most endpoints.

 Examples:
 #### Happy Path Tests
 	•	Get Pet by ID: Retrieve a pet that exists and verify the details match the expected results.
	•	Delete Pet: Successfully delete a pet that exists in the system and verify the deletion.
	•	Post Pet: Add a new pet with valid data and ensure it is correctly added to the system.
#### Sad Path Tests 
 	•	Get Pet by ID: Attempt to retrieve a pet with an invalid ID and verify that the system returns a 404 status.
	•	Delete Pet: Try to delete a pet that does not exist and ensure the system handles it gracefully.

 #### Configuration files 
 	•	config.properties: Contains base URL and endpoint paths.
	•	AppConfig.java: Extracts and returns the URL and endpoints.

 #### Utility Functions 

 	•	Utils.java: Provides utility functions for creating request specifications.
