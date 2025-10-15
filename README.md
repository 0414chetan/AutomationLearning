# Playwright Java Automation Template

This repository contains a complete Playwright + Java automation starter kit built with Maven and TestNG. It provides a ready-to-run project structure that you can extend for your UI automation needs.

## Project layout

```
learning/
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               ├── config
│   │               │   └── EnvironmentConfig.java
│   │               ├── core
│   │               │   ├── BasePage.java
│   │               │   └── PlaywrightFactory.java
│   │               └── pages
│   │                   ├── DocumentationPage.java
│   │                   └── LandingPage.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── tests
│       │               ├── BaseTest.java
│       │               └── LandingPageTest.java
│       └── resources
│           ├── config
│           │   └── config.properties
│           └── testng.xml
└── target/
```

## Getting started

1. **Install Java 17+ and Maven 3.9+.**
2. Navigate to the `learning` directory.
3. Install Playwright browsers (run once):
   ```bash
   mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```
4. Execute the sample TestNG suite:
   ```bash
   mvn clean test
   ```

Test output and Allure results are written under `learning/target`.

## Configuration

Runtime configuration is stored in `src/test/resources/config/config.properties`.

| Property     | Description                                  | Default                           |
|--------------|----------------------------------------------|-----------------------------------|
| `base.url`   | Base URL opened before each test              | `https://playwright.dev/java/`    |
| `browser`    | Browser to launch (`chromium`, `firefox`, `webkit`) | `chromium`                        |
| `headless`   | Whether to run browser in headless mode       | `true`                            |
| `timeout.ms` | Default timeout applied to Playwright actions | `30000`                           |

Adjust these properties or externalise them as environment variables to suit different environments.

## Extending the framework

- Add new page objects under `src/main/java/com/example/pages`.
- Create new TestNG tests in `src/test/java/com/example/tests`.
- Update `testng.xml` to control suites, groups, and parallel execution.
- Integrate additional reporting or CI tools by augmenting the `pom.xml`.

This starter project gives you a clean, opinionated baseline that you can evolve into a complete automation framework.
