import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	@Test
	void testContactIdShorterThanTen() {
		assertDoesNotThrow(()->
				new Contact("12345", "Daniel", "Norman", "1234567890", "Address"));
	}
	
	@Test
	void testContactIdExactlyTen() {
		assertDoesNotThrow(()->
				new Contact("1234567890", "Daniel", "Norman", "1234567890", "Address"));
	}
	
	@Test
	void testContactIdLongerThanTen() {
		assertThrows(IllegalArgumentException.class, ()->
				new Contact("12345678901", "Daniel", "Norman", "1234567890", "Address"));
	}
	
	@Test
	void testPhoneExactlyTenDigits() {
		assertDoesNotThrow(()->
				new Contact("1", "Daniel", "Norman", "1234567890", "Address"));
	}
	
	@Test
	void testPhoneMoreThanTenDigits() {
		assertThrows(IllegalArgumentException.class, ()->
				new Contact("1", "Daniel", "Norman", "12345678901", "Address"));
	}
	
	@Test
	void testAddressExactlyThirtyCharacters() {
		String address = "123456789012345678901234567890";
		assertDoesNotThrow(()->
				new Contact("1", "Daniel", "Norman", "1234567890", address));
	}
	
	@Test
	void testAddressMoreThanThirtyCharacters() {
		String address = "1234567890123456789012345678901";
		assertThrows(IllegalArgumentException.class, ()->
				new Contact("1", "Daniel", "Norman", "1234567890", address));
	}
	
	@Test
	void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Daniel", "Norman", "1234567890", "Address");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "DanielDaniel", "Norman", "1234567890", "Address");
		});
	}
	
	@Test
	void testFirstNameMaxLengthAccepted() {
		Contact contact = new Contact("1", "DanielDani", "Norman", "1234567890", "Address");
		assertEquals("DanielDani", contact.getFirstName());
	}
	
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Norman", "1234567890", "Address");
		});
	}
	
	@Test
	void testSetFirstNameNull() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		assertThrows(IllegalArgumentException.class,() -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testSetFirstNameMaxLengthAccepted() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		contact.setFirstName("DanielDani");
		assertEquals("DanielDani", contact.getFirstName());
	}
	
	@Test
	void testSetFirstNameTooLong() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("DanielDaniel");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", "NormanNorman", "1234567890", "Address");
		});
	}
	
	@Test
	void testLastNameMaxLengthAccepted() {
		Contact contact = new Contact("1", "Daniel", "NormanNorm", "1234567890", "Address");
		assertEquals("NormanNorm", contact.getLastName());
	}
	
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", null, "1234567890", "Address");
		});
	}
	
	@Test
	void testSetLastNameNull() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		assertThrows(IllegalArgumentException.class,() -> {
			contact.setLastName(null);
		});
	}
	
	@Test
	void testSetLastNameMaxLengthAccepted() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		contact.setLastName("NormanNorm");
		assertEquals("NormanNorm", contact.getLastName());
	}
	
	@Test
	void testSetLastNameTooLong() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("NormanNorman");
		});
	}
	
	@Test
	void testContactIdisImmutable() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		assertEquals("1", contact.getContactId());
	}
	
	@Test
	void testPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", "Norman", "12345", "Address");
		});
	}
	
	@Test
	void testPhoneNonDigit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", "Norman", "12345ABCDE", "Address");
		});
	}
	
	@Test
	void testPhoneNullInConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", "Norman", null, "Address");
		});
	}
	
	@Test
	void testSetPhoneNull() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	void testAddressNullInConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Daniel", "Norman", "1234567890", null);
		});
	}
	
	@Test
	void testSetAddressNull() {
		Contact contact = new Contact("1", "Daniel", "Norman", "1234567890", "Address");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
}