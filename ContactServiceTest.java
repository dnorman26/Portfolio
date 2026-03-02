import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		assertDoesNotThrow(() -> service.addContact(contact));
	}
	
	@Test
	void testAddDuplicateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, ()
				-> service.addContact(contact));
	}
	
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		service.addContact(contact);
		service.deleteContact("1");
		
		assertThrows(IllegalArgumentException.class, ()->
			service.updateFirstName("1", "Dan"));
	}
	
	@Test
	void testUpdateContactFields() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		service.addContact(contact);
		
		service.updateFirstName("1", "Dan");
		service.updateLastName("1", "Norm");
		service.updatePhone("1",  "2345678901");
		service.updateAddress("1", "New Address");
		
		assertEquals("Dan", contact.getFirstName());
		assertEquals("Norm", contact.getLastName());
		assertEquals("2345678901", contact.getPhone());
		assertEquals("New Address", contact.getAddress());
		
	}
	
	@Test
	void testDeleteNonExistentContact() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class,() -> {
			service.deleteContact("999");
		});
	}
}