package main;
// Giogioanni Morales 6/15/2024 
import java.util.Date; // for the appointmentDate field 

public class Appointment {
	// storage of appointment details
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;
    //constructor for appointment object
    public Appointment(String appointmentId, Date appointmentDate, String description) {
    	// must not be null and must not exceed 10 characters
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("invalid appointment ID");
        }
        // must not be null and must not be in the past
        if (appointmentDate == null || appointmentDate.before(new Date())) { // (new Date()) to check if the date is in the past.
            throw new IllegalArgumentException("invalid appointment date");
        }
        // must not be null and must not exceed 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("invalid description");
        }
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }
    // getter for appointmentID
    public String getAppointmentId() {
        return appointmentId;
    }
    // getter for appointmendDate
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    // getter for description 
    public String getDescription() {
        return description;
    }
}
