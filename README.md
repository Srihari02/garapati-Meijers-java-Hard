# garapati-Meijers-java-Hard

When this main method executes it calls an External sample API and store the response in string builder.
After storing the date parsing the string to JSON and getting the variables using Bean/pojo classes.
Writing the retrieved data to excel sheet in csv format. Which is stored under this projects structure
The retrieved pojo data is being sent to an implementation method where interface is instantiated and doing few operations.
operation 1: concatenating the name, category and label with price of recipe and printing them.
operation 2: Using Java Streams filtering the name of recipes which contains letter r by collecting all the names in a single list and sending to java stream.
The new operation is sending the retrieved names to single ton pattern and converting them to UPPER CASE. get Instance in singleton will convert other variables and printing them
