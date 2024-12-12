![GitHub License](https://img.shields.io/github/license/Nalankumar/HRMS)

# **HRMS**

  The HR Management System is a comprehensive CLI application developed in Java, utilizing MySQL for database management. It enables HR professionals to perform CRUD operations, efficiently managing employee details within the database. The system allows HR to seamlessly add, update, retrieve, and delete employee information.

  Additionally, the application includes functionality for taking attendance and granting leave, streamlining HR processes and ensuring accurate record-keeping. This feature simplifies the management of employee attendance and leave requests, making HR operations more efficient.

  Overall, this application enhances the efficiency of HR operations, promoting organized and effective management of employee data, attendance, and leave. It contributes to a more productive and well-managed workforce, ensuring that HR tasks are handled with ease and precision.

## **Tech Stack**
[![Tech Stack](https://skillicons.dev/icons?i=java,mysql)](https://skillicons.dev)
## Installation
To run a Java program with JDBC connectivity to MySQL, follow these steps:
### Prerequisites
1. **Install Java Development Kit (JDK):**
   - Ensure JDK is installed and configured. Verify by running:
     ```bash
     java -version
     ```

2. **Install MySQL:**
   - Install MySQL Server and ensure the database and tables required for the program are set up.

3. **Download MySQL JDBC Driver:**
   - Download the MySQL Connector/J from the [MySQL website](https://dev.mysql.com/downloads/connector/j/).
   - Save the JAR file (e.g., `mysql-connector-java-8.x.x.jar`) in an accessible directory.

### Steps to Run the Program

#### 1. Setup the Database
- Open your MySQL client and create the database and tables. Example:
  ```sql
  CREATE DATABASE HRMS;
  USE HRMS;
  ```
#### 2. Import Queries from a SQL File

Import the sql file from the directory using the command line:
```
mysql -u username -p testdb < path/to/yourfile.sql
```
Replace username with your MySQL username and path/to/yourfile.sql with the path to the SQL file.
#### 3. Add JDBC Driver to the Project
- Place the `mysql-connector-java-8.x.x.jar` file in your project directory.

#### 4. Compile the Program
- Use the following command to compile the program:
  ```bash
  javac -cp .;path_to_mysql_connector/mysql-connector-java-8.x.x.jar HRMS.java
  ```
  Replace `path_to_mysql_connector` with the path to the JDBC driver.

#### 5. Run the Program
- Use the following command to run the compiled program:
  ```bash
  java -cp .;path_to_mysql_connector/mysql-connector-java-8.x.x.jar HRMS
  ```

### Notes
1. Replace `localhost`, `3306`, `testdb`, `root`, and `your_password` with your MySQL server details.
2. Handle exceptions appropriately to debug issues.
3. Ensure the `mysql-connector-java` JAR file is correctly referenced in your classpath.

### Troubleshooting
- **Database Connectivity Issues:** Verify the database URL, username, and password.
- **Driver Not Found:** Ensure the MySQL Connector/J is included in the classpath.
- **JDBC URL Format:** Ensure the format is correct: `jdbc:mysql://hostname:port/dbname`.

## Contributing
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes.
4. Push your branch: `git push origin feature-name`.
5. Create a pull request.

## License
This project is licensed under the [MIT License](LICENSE).

