# About

This command line application reads a CSV file ("customers.csv") from the location

```
/resources/customerDir
```

The CSV (which uses ";" as the separator between fields) has the following format

CustomerRef;Customer Name;Address Line1;Address Line2;Town;County;Country;Postcode

For each line in the CSV, the application will make an HTTP POST request to the following REST endpoint, which must already be available via another application.

http://localhost:8080/customer

# How to run the application

execute on the commandline

```
./gradlew bootRun
```

which will start the SpringBoot application on port 8090 (the port to bind to is defined in `/resources/application.properties`).

# How to test the application

execute on the commandline

```
./gradlew test
```