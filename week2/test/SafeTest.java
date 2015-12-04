package ss.week2.test;

import ss.week2.hotel.*;
import ss.week3.hotel.Password;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SafeTest {

	private Safe safe;
	
	@Before
	public void setUp() throws Exception {
		safe = new Safe(Password.INITIAL);
	}

	@Test
	public void testSetUp() {
		assertEquals("Password: ", "abcdefgh", safe.getPassword());
		assertEquals("Is Safe open: ", true, safe.isOpen());
		assertEquals("Is Safe active: ", true, safe.isActive());
	}
	
	@Test
	public void testActivateCorrectPassword() {
		safe.activate("abcdefgh");
		assertEquals("Activate open and activated safe with correct password: ",
						true, safe.isActive());
		safe.close();
		safe.activate("abcdefgh");
		assertEquals("Activate closed and activated safe with correct password: ",
						true, safe.isActive());
		safe.deactivate();
		safe.activate("abcdefgh");
		assertEquals("Activate deactivated safe with correct password: ",
						true, safe.isActive());
	}
	
	@Test
	public void testActivateWrongPassword() {
		safe.activate("wrong");
		assertEquals("Activate open and actived safe with incorrect password: ",
						true, safe.isActive());
		safe.close();
		safe.activate("wrong");
		assertEquals("Activate closed and actived safe with incorrect password: ", 
						true, safe.isActive());
		safe.deactivate();
		safe.activate("wrong");
		assertFalse("Activate deactivated safe with incorrect password: ", safe.isActive());
	}
	
	@Test
	public void testOpenCorrectPassword() {
		safe.open("abcdefgh");
		assertTrue("Open activated and open safe with correct password: ", safe.isOpen());
		safe.close();
		safe.open("abcdefgh");
		assertTrue("Open closed and activated safe with correct password: ", safe.isOpen());
		safe.deactivate();
		safe.open("abcdefgh");
		assertFalse("Open deactivated safe with correct password: ", safe.isOpen());
	}
	
	@Test
	public void testOpenWrongPassword() {
		safe.open("wrong");
		assertTrue("Open activated and open safe with incorrect password: ", safe.isOpen());
		safe.close();
		safe.open("wrong");
		assertFalse("Open closed and activated safe with incorrect password: ", safe.isOpen());
		safe.deactivate();
		safe.open("wrong");
		assertFalse("Open deactivated safe with correct password: ", safe.isOpen());
	}
	
	@Test
	public void testClose() {
		safe.close();
		assertFalse("Close activated and open safe: ", safe.isOpen());
		safe.close();
		assertFalse("Close closed and activated safe: ", safe.isOpen());
		safe.deactivate();
		safe.close();
		assertFalse("Close deactivated safe: ", safe.isOpen());
	}
	
	@Test
	public void testDeactivate() {
		safe.deactivate();
		assertFalse("Deactivate activated and open safe: check if active ", safe.isActive());
		assertFalse("Deactivate activated and open safe: check if open ", safe.isOpen());
		safe.activate("abcdefgh");
		safe.deactivate();
		assertFalse("Deactivate closed and activated safe: check if active ", safe.isActive());
		assertFalse("Deactivate closed and activated safe: check if open", safe.isOpen());
		safe.deactivate();
		assertFalse("Deactivate deactivated safe: check if active ", safe.isActive());
		assertFalse("Deactivate deactivated safe: check if open ", safe.isOpen());
	}
}
