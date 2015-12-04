package ss.week2.test;

import org.junit.Before;
import org.junit.Test;

import ss.week1.Password;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

import static org.junit.Assert.*;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101, Password.INITIAL);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testSafe() {
    	assertNotNull(room.getSafe());
    	assertEquals("Password: ", Password.INITIAL, room.getSafe().getPassword());
    	assertEquals("Is open: ", true, room.getSafe().isOpen());
    	assertEquals("Is active: ", true, room.getSafe().isActive());
    	
    }
}
