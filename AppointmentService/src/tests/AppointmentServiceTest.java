package tests;
//Giogioanni Morales 6/15/2024 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import main.Appointment;
import main.AppointmentService;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach // set up method to initialize the appointment service BeforeEach test
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() { 
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // creation of future date for testing 
        Appointment appointment = new Appointment("9876543210", futureDate, "Valid description"); // creates valid appointment
        appointmentService.addAppointment(appointment); // adds appointment to the service
        assertEquals(appointment, appointmentService.getAppointment("9876543210")); // this verifies it was added correctly
    }

    @Test
    public void testAddDuplicateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment1 = new Appointment("1234567890", futureDate, "Valid description");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Another description");

        appointmentService.addAppointment(appointment1); // adds the first appointment
        assertThrows(IllegalArgumentException.class, () -> { // attempt to add a duplicate appointment and anticipate an exception
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description");
        appointmentService.addAppointment(appointment); // adds appointment 
        appointmentService.deleteAppointment("1234567890"); // deletes the appointment 
        assertThrows(IllegalArgumentException.class, () -> { // this will attempt to catch the deleted appointment and anticipate an exception
            appointmentService.getAppointment("1234567890");
        });
    }

    @Test
    public void testDeleteNonexistentAppointment() { // attempt to delete an appointment that does not exist and expect and exception 
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistent");
        });
    }
}
