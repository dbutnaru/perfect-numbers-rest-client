# perfect-numbers-rest-client
## To build
 - First intall in local maven repository https://github.com/dbutnaru/perfect-numbers
 - Run `mvn clean install` to install it in local repository and build executable jar
 - The executable jar we can find in the `target` folder
 
 ## To run
 - Run `java -jar perfect-numbers-rest-client-1.0.0-SNAPSHOT-jar-with-dependencies.jar` from command line
 - Open web browser and do a get request `http://localhost:8080/isPerfect/6`, resutlt should be true. Check for other numbers
 - Open web browser and do a get request `http://localhost:8080/perfectNumbersFromRange/1/10000`, a list of numbers should returned in JSON format. For very big ranges could be performance issues.
 
