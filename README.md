What is Rest Assured?

Rest Assured enables you to test REST APIs using java libraries and integrates well with Maven. It has very efficient matching techniques, so asserting your expected results is also pretty straight forward. Rest Assured has methods to fetch data from almost every part of the request and response no matter how complex the JSON structures are.

Maven Commands?

How to handle or download dependency Jar using Maven

Before we start writing a Maven code, we need to add the general dependencies like TestNG and Selenium in the pom.xml file.

So for this, we will follow the below process:

Automatically we get the Pom.xml file within the same project.
To download the dependency jar for TestNG and Selenium, we should write a dependency code for all the tools in the Pom.xml file.
To get the dependency code, go to the Google search and type "TestNG Maven dependency", and click on the given link.

After adding the Dependency code for TestNG and Selenium, the Pom.xml file will look like this:

<dependency>  
<groupId>org.testng</groupId>  
<artifactId>testng</artifactId>  
<version>6.8</version>  
<scope>compile</scope>  
</dependency>  
 <dependency>  
<groupId>org.seleniumhq.selenium</groupId>  
<artifactId>selenium-java</artifactId>  
<version>3.141.59</version>  
</dependency>  
 </dependencies>
 
 projects using Java?
 
To build a Selenium project using Java Client libraries, you first need to ready your system by installing Java and any IDE (Integrated Development Environment) of your choice. 

Installing Java in Mac OS

Since we are using Java to build a Selenium project, we need to install Java or JDK. 

Step 1: Download the latest version of Java. (At the time of writing this blog, the latest version is Java SE 17) 

Step 2: Double-click the .dmg file and complete the installation.

Step 3: On the project template page, click Next, and then on the next screen, mention Project name, Project location, and click Finish.

Done !. Our first Java project was created successfully. Next, write Java code in the src folder shown on the navigation bar.

Setting up Selenium Libraries in Java project
To add Selenium to the Java project, you need to set up Selenium libraries in the project’s CLASSPATH. You need to add TestNG libraries to get better reports and test orchestration in our project.

Step 1: Download the required Selenium libraries and Selenium Server from the Selenium home page. 

Along with Selenium WebDriver libraries, adding any Java test automation frameworks like TestNG, JUnit will further enhance test data management and help on parallel execution and report generation. For example, I have used the TestNG framework to manage test cases and reports in this blog.

Step 2: Download the TestNG jar file and save it in a local folder. TestNG has a wide range of Annotations and Listeners, which helps organize test case execution and manage logs. 

Step 3: In IntelliJ IDEA, click File -> Project Structure -> Modules. Click the dependencies tab from the right panel, click + sign, and select JARs or Directories. 

Step 4: Browse and select all files, including TestNG jar and jar files extracted from the selenium-java-4.x.x.zip file and click Apply and Ok. Now you will see all libraries listed under Project’s External Libraries section.

Our project is now ready to write Selenium test cases. Let’s write a simple test case to launch a web application and validate its title using TestNG.

Step 5: In IntelliJ IDEA, right-click on the src folder click New -> Java Class. Create a new Java class, “SeleniumSampleTest.” 

Step 6: Write a simple script to validate

Execution Steps

For that, carry out the following steps:
Create a Selenium WebDriver instance.
Perform browser optimization if necessary.
Write a sequence of commands to execute the test steps.
Validate the actions performed.

What is Cucumber in Selenium?
Cucumber Framework in Selenium is an open-source testing framework that supports Behavior Driven Development for automation testing of web applications. The tests are first written in a simple scenario form that describes the expected behavior of the system from the user’s perspective.

It consists of

1.feature file

2.StepDefinitions

3.TestRunner file

What is Allure Reports?
Allure Report Selenium and TestNG integration will be explained in all detail in this article. In my last article, I explained how to integrate ExtentReports reporting framework with TestNG for shiny and beautiful test automation reports. Now, I will explain to you another popular test reporting framework that the Yandex QA Team develops – Allure Reports. 
 
 
