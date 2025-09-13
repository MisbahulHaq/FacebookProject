# Facebook Automation Project

This is a Selenium + TestNG automation framework for **Facebook Login and Forgot Password** pages, built using **Page Object Model (POM)** with OOP concepts.

## ✅ Features
- **Page Object Model (POM)**
- **Encapsulation, Inheritance, Abstraction, Polymorphism**
- **Selenium Waits (Explicit)**
- **ExtentReports with Screenshots**
- **Retry logic for flaky tests (IRetryAnalyzer)**
- **Screenshot on failure (ITestListener)**
- **Maven + TestNG integration**

## 📂 Project Structure
FacebookAutomation/
│── pom.xml
│── testng.xml
│── src
├── main/java
│ ├── base # BaseTest, AbstractPage, PageActions
│ ├── pages # Page classes (LoginPage, ForgotPasswordPage)
│ └── utils # WaitUtils, ReportManager, RetryAnalyzer, TestListener
└── test/java
└── tests # Test classes (LoginTest, ForgotPasswordTest)


## ⚙️ Setup Instructions

### 1. Prerequisites
- Install **Java 8+**
- Install **Maven**
- Install **Eclipse IDE**
- Download **ChromeDriver** matching your Chrome version and add it to PATH.

### 2. Import into Eclipse
1. Open Eclipse  
2. `File > Import > Maven > Existing Maven Project`  
3. Select the extracted project folder `FacebookAutomation`  
4. Finish  

### 3. Run Tests
You can run tests in two ways:

**From Eclipse:**  
- Right click `testng.xml` → `Run As` → `TestNG Suite`

**From Maven CLI:**
```bash
mvn clean test

4. Reports & Screenshots

After test execution, open:

test-output/ExtentReport.html → Detailed ExtentReport

test-output/screenshots/ → Screenshots of failed tests