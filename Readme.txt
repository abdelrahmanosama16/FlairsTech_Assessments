# Automated Testing with Cucumber and Selenium WebDriver

This repository contains automated tests for a web application using Cucumber and Selenium WebDriver.

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
- [Folder Structure](#folder-structure)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project implements automated tests for a web application using Cucumber and Selenium WebDriver. It includes step definitions for various scenarios related to user authentication, user management, and more.

## Setup

1. **Clone the repository:**


2. **Install Dependencies:**
- Make sure you have Java and Maven installed on your system.
- Update the `pom.xml` file with any additional dependencies if necessary.


3. **Run the Tests:**


## Folder Structure

- `src/test/java/stepDefinitions`: Contains Cucumber step definitions.
- `src/test/java/pages`: Contains page object classes for different pages of the web application.
- `src/test/java/utils`: Contains utility classes, such as WebDriverFactory.
- `src/test/resources/features`: Contains feature files written in Gherkin syntax.

## Features

- **Login**: Includes scenarios for logging in and verifying successful login.
- **User Management**: Includes scenarios for adding, searching, and deleting users.
- **Assertions**: Includes assertions to verify the state of the application after certain actions.

## Contributing

- Contributions are welcome! Feel free to submit issues or pull requests.
- Make sure to follow the existing coding style and naming conventions.
- Write clear commit messages and provide detailed descriptions for your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
