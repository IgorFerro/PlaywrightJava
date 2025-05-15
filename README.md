# Playwright Screenplay TestNG Example

This project demonstrates a test automation setup using Java, Playwright, TestNG, and the Screenplay pattern, all managed with Maven.

Estrutura:
Actor – quem executa.
Task – o que é feito (ex: "Logar").
Interaction – ações menores (ex: "Clicar", "Preencher campo").
Question – validações (ex: "Texto está visível?").
Ability – capacidades do ator (ex: "Usar navegador").



The initial test case navigates to `https://automationteststore.com/` and verifies the URL.

## Project Structure

- `pom.xml`: Defines project dependencies (Playwright, TestNG, SLF4J) and Maven build plugins.
- `src/main/java`: Intended for main application code (currently minimal, focused on test code).
  - `com/example/screenplay`: Placeholder for any main Screenplay components if needed.
- `src/test/java`: Contains all test-related code.
  - `com/example/screenplay/abilities`: Screenplay abilities (e.g., `BrowseTheWeb` using Playwright).
  - `com/example/screenplay/actor`: The `Actor` class.
  - `com/example/screenplay/interactions`: Low-level interactions (e.g., `OpenUrl`).
  - `com/example/screenplay/questions`: For querying application state (e.g., `PageTitle`).
  - `com/example/screenplay/tasks`: High-level tasks (e.g., `NavigateTo`).
  - `com/example/screenplay/tests`: TestNG test classes (e.g., `NavigateToSiteTest`).

## Prerequisites

- Java Development Kit (JDK) version 11 or higher.
- Apache Maven installed and configured on your system.

## How to Build and Run Tests

1.  **Clone the repository** (if applicable) or ensure you have the project files.
2.  **Open a terminal or command prompt** in the root directory of the project (where `pom.xml` is located).
3.  **Clean and compile the project, and run the tests** using Maven:

    ```bash
    mvn clean test
    ```

This command will:
- Clean previous build artifacts.
- Compile the source code and test code.
- Execute the TestNG tests defined in the `src/test/java` directory.
- Playwright will download the necessary browser binaries automatically on the first run if they are not already present.

You should see a browser window open, navigate to the specified website, and then close. Test results will be displayed in the console, and standard Maven test reports will be generated in the `target/surefire-reports` directory.

## Screenplay Pattern Components

-   **Actor**: Represents the user interacting with the application (e.g., `Actor.named("James")`).
-   **Abilities**: What an actor *can do* (e.g., `BrowseTheWeb` which allows interaction with a web browser via Playwright).
-   **Tasks**: High-level business-relevant actions an actor performs (e.g., `NavigateTo.url(...)`). Tasks are composed of interactions or other tasks.
-   **Interactions**: Low-level actions an actor performs directly with the system (e.g., `OpenUrl.to(...)`). Interactions implement `Task`.
-   **Questions**: Used to query the state of the application. An actor asks a question, and the answer can be used in assertions (e.g., `WhatIsThePageTitle.displayed()`).

## Example Test Flow (`NavigateToSiteTest.java`)

1.  **`@BeforeMethod`**: 
    -   A `Playwright` instance is created.
    -   An `Actor` named "James" is instantiated.
    -   The `Actor` is given the `BrowseTheWeb` ability, initialized with the `Playwright` instance (this launches a browser).
2.  **`@Test`**: 
    -   The `Actor` attempts to perform the `NavigateTo.url("https://automationteststore.com/")` task.
    -   An assertion verifies that the browser's current URL matches the target URL.
3.  **`@AfterMethod`**: 
    -   The `BrowseTheWeb` ability is used to close the browser and the Playwright instance associated with the actor. 