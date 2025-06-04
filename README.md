# Page Object Model (POM) Framework

This repository contains a structured and maintainable test automation framework implementing the Page Object Model (POM) design pattern. The framework is designed to improve readability, scalability, and reusability of test scripts for web application testing.

## What is Page Object Model (POM)?

The Page Object Model is a design pattern that promotes the creation of object-oriented classes that serve as an interface to a web page. This pattern helps in reducing code duplication and enhances test maintenance by encapsulating the page-specific logic within separate classes.

## Framework Structure

The repository follows a modular structure to organize the test automation framework:

- `src/main/java/com/yourcompany/pages/`: Contains the page classes representing different web pages.
- `src/test/java/com/yourcompany/tests/`: Contains the test classes implementing the test cases.
- `test-output/`: Directory for storing test execution reports.
- `.gitignore`: Specifies files and directories to be ignored by Git.
- `pom.xml`: Maven configuration file for managing dependencies and build lifecycle.
- `testng.xml`: TestNG configuration file for test suite execution.

## 🚀 Getting Started

1. **Clone the Repository**

   ```bash
   git clone https://github.com/shailid12/page-object-model.git
   cd page-object-model
