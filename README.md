# Appointment-Service

## Features

* **Appointment Creation:** Allows the creation of appointments with a unique ID, a future date, and a description.
* **Appointment Management:** Provides functionality to add, delete, and retrieve appointments.
* **Data Validation:** Enforces rules for appointment data:
    * Appointment ID:  Maximum 10 characters, not null.
    * Appointment Date: Must be a future date, not null.
    * Description: Maximum 50 characters, not null.
* **In-Memory Storage:** Uses a `HashMap` for storing appointments.  _(**Note:** This implementation uses in-memory storage. Data is not persisted between application runs.)_
* **Unit Testing:** Includes comprehensive JUnit tests to ensure the reliability of the application.

## Technologies Used

* Java
* JUnit

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or later
* A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor and command-line tools

### Installation

1.  Clone the repository:
    ```bash
    git clone \[repository URL]
    ```
2.  Navigate to the project directory:
    ```bash
    cd \[project directory]
    ```
3.  Compile the Java code:
    ```bash
    javac src/main/\*.java src/tests/\*.java -d bin
    ```
4.  Run the tests:
    ```bash
    java -cp bin;path/to/junit.jar;path/to/hamcrest.jar org.junit.runner.JUnitCore tests.AppointmentTest tests.AppointmentServiceTest
    ```
    _(**Note:** You'll need to adjust `path/to/junit.jar` and `path/to/hamcrest.jar` to the actual location of your JUnit and Hamcrest JAR files.)_
5.  Run the application (if you add a main method to run the service):
    ```bash
    java -cp bin main.AppointmentService  
    ```

## Code Explanation

### `Appointment` Class (`src/main/Appointment.java`)

* Defines the structure of an `Appointment` object.
* Attributes:
    * `appointmentId` (String):  Unique identifier for the appointment.
    * `appointmentDate` (Date):  Date of the appointment.
    * `description` (String):  Description of the appointment.
* The constructor validates the input data to ensure that it meets the specified requirements.  If the data is invalid, it throws an `IllegalArgumentException`.
* Provides getter methods to access the appointment's attributes.

### `AppointmentService` Class (`src/main/AppointmentService.java`)

* Manages `Appointment` objects.
* Uses a `HashMap` (`appointments`) to store appointments, with the `appointmentId` as the key.
* Methods:
    * `addAppointment(Appointment appointment)`:  Adds a new appointment.  Throws an exception if an appointment with the same ID already exists.
    * `deleteAppointment(String appointmentId)`:  Deletes an appointment by its ID.  Throws an exception if the ID does not exist.
    * `getAppointment(String appointmentId)`:  Retrieves an appointment by its ID.  Throws an exception if the ID does not exist.

### Tests (`src/tests/AppointmentTest.java`, `src/tests/AppointmentServiceTest.java`)

* JUnit tests to verify the functionality of the `Appointment` and `AppointmentService` classes.
* Tests cover:
    * Valid appointment creation.
    * Invalid input handling (e.g., null or invalid IDs, dates, descriptions).
    * Adding, deleting, and retrieving appointments.
    * Handling duplicate appointment IDs.

## Potential Enhancements

* **Persistence:** Implement data persistence using a database (e.g., SQLite, MySQL) or file storage.
* **User Interface:** Develop a command-line interface (CLI) or a graphical user interface (GUI) for interacting with the service.
* **Search and Filter:** Add functionality to search for appointments by date or description.
* **Reminders:** Implement appointment reminders.
* **Error Handling:** Enhance error handling and logging.

## Author

Giogioanni Morales
