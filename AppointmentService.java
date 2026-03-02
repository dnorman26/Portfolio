package tasks;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	///Adds an appointment with a unique ID
	public void addAppointment(Appointment appointment) {
		if (appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null");
		}
		
		String id = appointment.getAppointmentId();
		if (appointments.containsKey(id)) {
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		
		appointments.put(id, appointment);
	}
	
	///Deletes an appointment by ID
	public void deleteAppointment(String appointmentId) {
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID not found");
		}
		appointments.remove(appointmentId);
	}
	
	///Retrieves an appointment by ID
	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
}