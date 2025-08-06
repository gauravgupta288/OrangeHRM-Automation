# 🧪 OrangeHRM Automation Framework

        A robust test automation framework for the [OrangeHRM](https://www.orangehrm.com/) application using:

        - ✅ Java
        - ✅ Selenium WebDriver (4.21)
        - ✅ TestNG
        - ✅ Rest Assured
        - ✅ Allure Reports
        - ✅ slf4j logger
        - ✅ Parallel executions
        - ✅ Design patterns - Singleton, Factory pattern, Builder, 
        - ✅ SOLID Principles
        - ✅ Threads
        - ✅ Maven
        - ✅ POM + Page factory
        - ✅ OOPS
        - ✅ GIT
        - ✅ Github Actions
    


        ---

        ## 📁 Project Structure

        OrangeHRM-Automation/
        ├── src/
        │ ├── main/java/com/orangehrm/framework/
        │ │ ├── base/
        │ │ ├── config/
        │ │ ├── pages/
        │ │ ├── utils/
        │ │ └── api/
        │ └── test/java/com/orangehrm/tests/
        │ ├── ui/
        │ └── api/
        ├── resources/
        │ └── config.properties
        ├── testng.xml
        ├── pom.xml
        ├── README.md


        ---

        ## 🔧 Tools & Libraries

        | Tool              | Purpose                    |
        |-------------------|----------------------------|
        | Java              | Language                   |
        | Maven             | Dependency management      |
        | Selenium          | Web automation             |
        | TestNG            | Test runner                |
        | Rest Assured      | API testing                |
        | Allure            | Reporting                  |

        ---

        ## 🚀 Getting Started

        ### ✅ Prerequisites

        - Java 17+ (Java 20 supported)
        - Maven 3.8+
        - Allure commandline installed ([Docs](https://docs.qameta.io/allure/#_installing_a_commandline))
        - Chrome/Firefox browser

        ---

        ## ▶️ Running Tests

        Run all tests:

        ```bash
        mvn clean test

        mvn test -Dtest=LoginTest
        mvn test -DsuiteXmlFile=testng.xml
