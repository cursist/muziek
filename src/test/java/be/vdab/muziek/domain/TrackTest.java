package be.vdab.muziek.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {
    private Artiest artiest;
    private Album album;
    private Track track1, track2;

    @Before
    public void setUp() {
        artiest = new Artiest("AC/DC");
        album = new Album("Black Ice", artiest);
        track1 = new Track("Spoilin' for a Fight", 181, album);
        track2 = new Track("Wheels", 210, album);
    }


    @Test
    public void toStringTest() {
        assertEquals("Spoilin' for a Fight (3:01)", track1.toString());
        assertEquals("Wheels (3:30)", track2.toString());
    }
}