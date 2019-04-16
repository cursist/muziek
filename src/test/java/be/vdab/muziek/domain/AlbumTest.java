package be.vdab.muziek.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlbumTest {
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
    public void toonAlbumInfo() {
        assertEquals("Black Ice (AC/DC)", album.toString() );
    }

    @Test
    public void getArtiest() {
        assertEquals(artiest, album.getArtiest());
    }

    @Test
    public void getTracks() {
        assertTrue( album.getTracks().containsAll(List.of(track1, track2)) );
    }

    @Test
    public void totaleTijd() {
        assertEquals("6:31", album.getTotaleTijd());
    }
}