package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import tasks.Appointment;
import tasks.AppointmentService;

public class AppointmentServiceTest {
	
	///Testing adding an appointment
	@Test
	public void testAddAppointmentSuccessfully() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		Appointment appointment = new Appointment("A123", futureDate, "Meeting");
		
		service.addAppointment(appointment);
		assertNotNull(service.getAppointment("A123"));
	}
	
	///Testing duplicate IDs
	@Test
	public void testAddDuplicateAppointmentIdRejected() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		
		Appointment a1 = new Appointment("A123", futureDate, "Meeting");
		Appointment a2 = new Appointment("A123", futureDate, "Another Meeting");
		
		service.addAppointment(a1);
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(a2));
	}
	
	///Testing adding a null appointment
	@Test
	public void testAddNullAppointmentRejected() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () ->
		service.addAppointment(null));
	}
	
	///Testing deleting existing appointment
	@Test
	public void testDeleteExistingAppointment() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		Appointment appointment = new Appointment("A123", futureDate, "Meeting");
		
		service.addAppointment(appointment);
		service.deleteAppointment("A123");
		
		assertNull(service.getAppointment("A123"));
	}
	
	///Testing Deleting a non existent appointment
	@Test
	public void testDeleteNonExistentAppointmentRejected() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () ->
		service.deleteAppointment("Does_Not_Exist"));
	}
}