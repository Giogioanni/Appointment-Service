package tests;
//Giogioanni Morales 6/15/2024
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import main.Appointment;

public class AppointmentTest {
	@Test
	public void testValidAppointment() {
	    Date futureDate = new Date(System.currentTimeMillis() + 10000); // creates a date 10 seconds in the future
	    Appointment appointment = new Appointment("987654321", futureDate, "Valid description"); // creates a new valid appointment
	    // assertions that the new appointment was created correctly 
	    assertNotNull(appointment);
	    assertEquals("987654321", appointment.getAppointmentId()); // Corrected expected ID (my first submission had a error because i hard coded expected the appointment ID in the assertEquals assertion)
	    assertEquals(futureDate, appointment.getAppointmentDate());
	    assertEquals("Valid description", appointment.getDescription());
	}

    @Test
    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> { // tests for null appointment ID
            new Appointment(null, futureDate, "Valid description");
        });
        assertThrows(IllegalArgumentException.class, () -> { //  tests appointment ID longer than 10 characters
            new Appointment("12345678910", futureDate, "Valid description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> { // test for past appointment date
            new Appointment("1234567890", new Date(System.currentTimeMillis() - 10000), "Valid description");
        });
        assertThrows(IllegalArgumentException.class, () -> { // test for null appointment date
            new Appointment("1234567890", null, "Valid description");
        });
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> { // test for null description
            new Appointment("1234567890", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> { // test for description longer than 50 characters
            new Appointment("1234567890", futureDate, "This description is way more than fifty characters long and is thus invalid ");
        });
    }
}
