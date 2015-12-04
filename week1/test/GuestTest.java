package ss.week1.test;

import org.junit.Before;
import org.junit.Test;
import ss.week1.hotel.Guest;
import ss.week1.hotel.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test program for Room and Guest.
 * Lab Exercise SoftwareSystems
 * @author Arend Rensink, Jip Spel
 * @version $Revision: 1.2 $
 */
public class GuestTest {
    /** Test variable for a <tt>Guest</tt>-object. */
    private Guest ot;
    /** Test variable for a <tt>Guest</tt>-object. */
    private Guest sien;
    /** Test variable for a <tt>Room</tt>-object. */
    private Room k101;
    /** Test variable for a <tt>Room</tt>-object. */
    private Room k102;

    /**
     * Sets initial variables to a well-defined initial value.
     * <p>
     * Assigns a <tt>Guest</tt> object to the <tt>ot</tt> instance variable
     * with the name <tt>&quot;Ot&quot;</tt> and assigns a <tt>Guest</tt> object
     * to the <tt>sien</tt> instance variable with the name <tt>&quot;Sien&quot;</tt>.
     * Also assigns <tt>Room</tt> objects to instance variables <tt>k101</tt> and
     * <tt>k102</tt> with numbers <tt>101</tt> and <tt>102</tt> respectively.
     * Lastly, checks in <tt>sien</tt> in room <tt>k102</tt>.
     */
    @Before
    public void setUp() {
        // initialisation of Guest-variables
        ot = new Guest("Ot");
        sien = new Guest("Sien");
        // initialisation of Room-variables
        k101 = new Room(101);
        k102 = new Room(102);
        // check in sien on room 102
        sien.checkIn(k102);
    }

    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testInitialcondition() {
        assertEquals("Ot", ot.getName());
        assertEquals("Sien", sien.getName());
        assertEquals(null, ot.getRoom());
        assertEquals(k102, sien.getRoom());
    }

    /**
     * Tests checking in a new guest in an empty room.
     * Calls <tt>ot.checkin(k101)</tt>.
     */
    @Test
    public void testCheckinEmpty() {
        assertTrue(ot.checkIn(k101));
        assertEquals(k101, ot.getRoom());
        assertEquals(ot, k101.getGuest());
    }

    /**
     * Checks checking in a new guest in a room that is already taken.
     * Calls <tt>ot.checkin(k102)</tt>.
     */
    @Test
    public void testCheckinTaken() {
        assertFalse(ot.checkIn(k102));
        assertEquals(null, ot.getRoom());
        assertEquals(sien, k102.getGuest());
    }

    /**
     * Tests checking out a guest that rented a room.
     * Calls <tt>sien.checkout()</tt>.
     */
    @Test
    public void testCheckoutKnown() {
        assertTrue(sien.checkOut());
        assertEquals(null, sien.getRoom());
        assertEquals(null, k102.getGuest());
        
    }

    /**
     * Tests checking out a guest that didn't rent a room.
     * Calls <tt>ot.checkout()</tt>.
     */
    @Test
    public void testCheckoutUnknown() {
        assertEquals(null, ot.getRoom());
        assertFalse(ot.checkOut());
        assertEquals(null, ot.getRoom());
        
    }
}
