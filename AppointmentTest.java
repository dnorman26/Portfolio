package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import tasks.Appointment;


public class AppointmentTest {
	
	///Testing valid appointment creation
	@Test
	public void testValidAppointmentCreation() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		Appointment appointment = new Appointment("A123", futureDate, "Doctor vist");
		
		assertEquals("A123", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Doctor vist", appointment.getDescription());
	}
	
	///Testing appointment ID max length
	@Test
	public void testAppointmentIdAtMaxLengthAccepted() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		String maxId = "1234567890";
		
		Appointment appointment = new Appointment(maxId, futureDate, "valid description");
		assertEquals(maxId, appointment.getAppointmentId());
	}
	
	///Testing Description at max length
	@Test
	public void testDescriptionAtMaxLengthAccepted() {
		Date futureDate = new Date(System.currentTimeMillis()+ 100000);
		String maxDescription = "A".repeat(50);
		
		Appointment appointment = new Appointment("123", futureDate, maxDescription);
		assertEquals(maxDescription, appointment.getDescription());
	}
	
	///Testing appointment ID too long
	@Test
	public void testAppointmentIdTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment("12345678901", futureDate, "Test"));
	}
	
	///Testing Date in the past
	@Test
	public void testAppointmentDateInPastRejected() {
		Date pastDate = new Date(System.currentTimeMillis() - 100000);
		
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment("A123", pastDate, "Test"));
	}
	
	///Testing Description too long
	@Test
	public void testDescriptionTooLongRejected() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		String longDescription = "A".repeat(51);
		
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment("A123", futureDate, longDescription));
	}
	
	///Testing Id Immutable
	@Test
	public void testAppointMentIdisImmutable() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		Appointment appointment = new Appointment("IMMUTABLE", futureDate, "Initial");
		
		Date newFutureDate = new Date(System.currentTimeMillis() + 200000);
		appointment.setAppointmentDate(newFutureDate);
		appointment.setDescription("Updated description");
		
		assertEquals("IMMUTABLE", appointment.getAppointmentId());
	}
	
	///Testing null appointment ID
	@Test
	public void testNullAppointmentIdRejected() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment(null, futureDate, "Valid description"));
	}
	
	///Testing null Date
	@Test 
	public void testNullAppointmentDateRejected() {
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment("A123", null, "Valid description"));
	}
	
	///Testing null description
	@Test
	public void testNullDescriptionRejected() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		
		assertThrows(IllegalArgumentException.class, () ->
		new Appointment("A123", futureDate, null));
	}
}