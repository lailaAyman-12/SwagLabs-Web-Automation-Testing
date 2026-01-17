SwagLabs Web Automation Testing
Overview
This project is a complete web automation testing framework for the SwagLabs demo application.
It is built using Java, Maven, TestNG, and Selenium WebDriver, following best practices in test automation.
The framework is designed for academic submission, portfolio presentation, and CI/CD integration.

Tech Stack
• 	Java 17 – Core programming language
• 	Maven – Build and dependency management
• 	TestNG – Test execution and reporting
• 	Selenium WebDriver – Browser automation (EdgeDriver configured)
• 	Allure Reports – Rich test reporting with screenshots and logs
• 	Jenkins – CI/CD pipeline integration

Project Structure
SwagLabs-Web-Automation/
│
├── src/test/java/         # Test cases
├── src/main/java/         # Page Object Models
├── target/                # Build output (ignored in Git)
├── allure-results/        # Test execution results
├── pom.xml                # Maven configuration
└── README.md              # Project documentation

Features
• 	Page Object Model (POM) for clean, maintainable code
• 	Automated test cases for login, product checkout, and UI validations
• 	Allure reporting with screenshots and logs
• 	CI/CD ready with Jenkins integration
• 	Scalable design for future test cases

Getting Started
1. Clone the repository
2. git clone https://github.com/USERNAME/swaglabs-web-automation.git
cd swaglabs-web-automation

Example Test Scenarios
• 	Login Tests – Valid and invalid credentials
• 	Product Checkout – Add to cart, remove, purchase flow
• 	UI Validations – Element visibility, error messages
• 	Cross-browser tests – Edge, Chrome, Firefox

CI/CD Integration
• 	Configured for Jenkins pipelines
• 	Supports GitHub Actions for automated builds and test runs

License
This project is created for academic and portfolio purposes.
Feel free to fork and adapt for your own learning.
