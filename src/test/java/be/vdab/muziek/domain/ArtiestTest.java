package be.vdab.muziek.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtiestTest {
    private final Artiest artiest = new Artiest("AC/DC");;
    private final Album album  = new Album("Black Ice", artiest);


    @Test
    public void getNaam() {
        assertEquals("AC/DC", artiest.getNaam());
    }

    @Test
    public void toString1() {
        assertEquals("AC/DC", artiest.toString());
    }

    @Test
    public void getAlbumsBevat1Album() {
        assertEquals(1, artiest.getAlbums().size());
    }

    @Test
    public void getAlbumBevatHetJuisteAlbumMethode1() {
        assertTrue(artiest.getAlbums().contains(album));
    }

    @Test
    public void getAlbumBevatHetJuisteAlbumMethode2() {
        assertEquals(album, artiest.getAlbums().toArray()[0]);
    }
}