# backend-app

## Overview
The `backend-app` is a Spring Boot application designed for the Job Portal project. It serves as the backend service, providing RESTful APIs for the frontend application.

## Project Structure
```
backend-app
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── htc
│       │           └── jobportal
│       │               └── BackendAppApplication.java
│       └── resources
│           ├── application.properties
│           └── static
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Installation
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd backend-app
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```

### Running the Application
To run the application, use the following command:
```
mvn spring-boot:run
```

### Configuration
The application properties can be configured in the `src/main/resources/application.properties` file. You can set properties such as server port, database configurations, and other application-specific settings.

### Static Resources
Static resources such as HTML, CSS, and JavaScript files should be placed in the `src/main/resources/static` directory.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.