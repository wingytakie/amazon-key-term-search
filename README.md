# Amazon Key Term Search

There are two part of codes
First part will allow you do to a specific key term search and determine:
 - Does this key term return you any result.
 - How many result does this key return.
Second part will be enter a partial key, and it will bring a dropdown on the search bar:
 - Each item on the dropdown will be print at console.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- JAVA IDE

```
Eclipse (This project was written using Eclipse)
```
- Maven

## Running the tests
Download a copy of this repository. Open the project using your Java IDE. As you can see, there are two folder within this repository: 'feature' and 'quickstart'. 'feature' folder is using Maven with Cucumber plugin along with a feature file; 'quickstart' is using Maven with TestNG plugin to run.

Both folder are designed to use pom.xml, which you can upload to jenkins enviornment for repeat testing.

Inside the pom.xml, all the test is currently group in the "Regression", you may update as needed.

### Step By Step Running the codes

feature folder
```
Run as JUnit Test
1. Open the project on your IDE.
2. Go to src/test/java/runTest.java
3. Right click to "Run as JUnit Test"
  - You can modify runTest.java to specify which feature to run.

Run with Maven
1. Open the project on your IDE.
2. Right click on pom.xml and "Run as Maven Clean".
3. After clean successful.
4. Right click on pom.xml and "Run as Maven Install".

Run with Jenkins
1. Copy the folder into your .jenkins directory (Usually under user/.jenkins)
2. Start your jenkins.
3. Login your jenkins.
4. Add a new item > Use Custom Workspace > Copy your path from step1.
5. Add a build step > Invoke top-level Maven targets > test -PRegression
   - You may set your own Goals, it does not has to be the same!
```

quickstart folder
```
Run as TestNG Suite
1. Open the project on your IDE.
2. Right click on testng.xml > Run as TestNG suite
 - You can modify testng.xml to only run specific test case.

Run with Maven
1. Open the project on your IDE.
2. Right click on pom.xml and "Run as Maven Clean".
3. After clean successful.
4. Right click on pom.xml and "Run as Maven Install".

Run with Jenkins
1. Copy the folder into your .jenkins directory (Usually under user/.jenkins)
2. Start your jenkins.
3. Login your jenkins.
4. Add a new item > Use Custom Workspace > Copy your path from step1.
5. Add a build step > Invoke top-level Maven targets > test -PRegression
   - You may set your own Goals, it does not has to be the same!
```

## Acknowledgments

* All the library/JARs used are listed inside pom.xml
