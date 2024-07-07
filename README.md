# Serenity BDD Project

Welcome to the Serenity BDD project! This project is designed to help you automate acceptance tests and produce high-quality living documentation for your software applications.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Serenity BDD is a powerful tool for writing automated acceptance tests that are easy to read and understand. It integrates with various testing frameworks like JUnit and Cucumber, and it produces detailed test reports that can serve as living documentation for your project.

## Prerequisites

Before you can start using Serenity BDD, you need to have the following installed:

- Java JDK 8 or higher
- Maven 3.3.9 or higher
- An IDE like IntelliJ IDEA or Eclipse

## Installation

To set up the project, follow these steps:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/automation-andy101/serenity-bdd-template-project.git
    cd serenity-bdd-project
    ```

2. **Install dependencies:**

    ```bash
    mvn clean install
    ```

## Running Tests

To run the tests against the 'test' environment using the Chrome browser, use the following command:

   ```bash
   mvn clean verify -Denvironment=test -Ddriver=chrome
   ```

To run a specific feature file against the 'test' environment using the Firefox browser, use the following command:

   ```bash
   mvn clean verify -Denvironment=test -Ddriver=firefox -Dtest=Admin.feature
   ```

To run in debug mode using the following command:

   ```bash
   $env:MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
mvn clean verify -Denvironment=test -Ddriver=chrome
   ```

To run API tests against a specific environment:-

   ```bash
  mvn clean verify -Dapi.base.url=http://localhost:3001
   ```

