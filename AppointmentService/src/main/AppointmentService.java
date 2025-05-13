package main;
//Giogioanni Morales 6/15/2024
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	// in memory storage for appointments
    private final Map<String, Appointment> appointments = new HashMap<>();
    // method to add appointment 
    public void addAppointment(Appointment appointment) {
    	// this makes sure duplicates aren't created
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }
    // method to delete an appointment just by ID.
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) { // This ensures the appointment ID exists 
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }
    // method to retrieve an appointment, just by ID again. 
    public Appointment getAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) { // This again ensures the appointment ID exists 
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        return appointments.get(appointmentId);
    }
}
