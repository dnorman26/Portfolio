package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import task.java.Task;

public class TaskTest {
	
	@Test
	void testValidTaskCreation() {
		Task task = new Task("12345", "Daniel Norman", "Description");
		assertEquals("12345", task.getTaskId());
		assertEquals("Daniel Norman", task.getName());
		assertEquals("Description", task.getDescription());
	}
	
	@Test
	void testTaskIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Daniel Norman", "Description");
		});
	}
	
	@Test
	void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Daniel Norman Daniel Norman Daniel Norman", "description");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Task("12345", "Daniel Norman", "123456789012345678901234567890123456789012345678901234567890123456789012345678901");
			});
	}
	
	@Test
	void testNullFields() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Daniel Norman", "Description");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Description");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Daniel Norman", null);
		});
	}
	
	@Test
	void testTaskIdMaxLengthAccepted() {
		Task task = new Task("ABCDEFGHIJ", "Name", "Description");
		assertEquals("ABCDEFGHIJ", task.getTaskId());
	}
	
	@Test 
	void testNameMaxLengthAccepted() {
		Task task = new Task("1", "ABCDEFGHIJKLMNOPQRST", "Description");
		assertEquals("ABCDEFGHIJKLMNOPQRST", task.getName());
	}
	
	@Test
	void testDescriptionMaxLengthAccepted() {
		Task task = new Task("1", "Name", "12345678901234567890123456789012345678901234567890");
		assertEquals("12345678901234567890123456789012345678901234567890", task.getDescription());
	}
	
	@Test
	void testTaskIdIsImmutable() {
		Task task = new Task("12345", "Name", "Description");
		
		task.setName("UpdatedName");
		task.setDescription("UpdatedDescription");
		
		assertEquals("12345", task.getTaskId());
	}
}
	