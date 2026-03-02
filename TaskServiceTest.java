package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import task.java.TaskService;
import task.java.Task;

public class TaskServiceTest {
	
	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Daniel Norman", "Description");
		
		service.addTask(task);
		assertNotNull(service.getTask("1"));
	}
	
	@Test 
	void testAddDuplicateTaskId() {
		TaskService service = new TaskService();
		Task task1 = new Task("1", "Task One", "Description");
		Task task2 = new Task("1", "Task two", "description");
		
		service.addTask(task1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	@Test 
	void testDeleteTask() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Daniel Norman", "Description");
		
		
		service.addTask(task);
		service.deleteTask("1");
		
		assertNull(service.getTask("1"));
	}
	
	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Daniel Norman", "Description");
		
		service.addTask(task);
		service.updateTaskName("1", "Susan Norman");
		
		assertEquals("Susan Norman", service.getTask("1").getName());
	}
	
	@Test 
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Daniel Norman", "123");
		
		service.addTask(task);
		service.updateTaskDescription("1", "Description");
		
		assertEquals("Description", service.getTask("1").getDescription());
	}
	
	@Test
	void testDeleteNonExistentTaskThrows() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("999");
		});
	}
	
	@Test
	void testUpdateNonExistentTaskNameThrows() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("999", "New Name");
		});
	}
	
	@Test 
	void testUpdateNonExistentTaskDescriptionThrows() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("999", "Description");
		});
	}
	
	@Test
	void testUpdateTaskNameNullThrows() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Name", "Description");
		
		service.addTask(task);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("1", null);
		});
	}
	
	@Test
	void testUpdateTaskNameTooLongThrows() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Name", "Description");
		
		service.addTask(task);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("1", "ABCDEFGHIJKLMNOPQRSTU");
		});
	}
	
	@Test
	void testUpdateTaskDescriptionNullThrows() {
		TaskService service = new TaskService();
		Task task = new Task ("1", "Name", "Description");
		
		service.addTask(task);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("1", null);
		});
	}
	
	@Test
	void testUpdateTaskDescriptionTooLongThrows() {
		TaskService service = new TaskService();
		Task task = new Task ("1", "Name", "Description");
		
		service.addTask(task);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("1", "123456789012345678901234567890123456789012345678901");
		});
	}
}