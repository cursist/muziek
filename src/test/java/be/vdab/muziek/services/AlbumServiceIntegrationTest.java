package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.domain.Artiest;
import be.vdab.muziek.domain.Track;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/insertAlbum.sql")
public class AlbumServiceIntegrationTest
        extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired private AlbumService service;
    private Artiest artiest = new Artiest("AC/DC");
    private Album album = new Album("Black Ice", artiest);
    private Track track1 = new Track("Spoilin' for a Fight", 181, album);
    private Track track2 = new Track("Wheels", 210, album);

    @Test
    public void findAllVindtAlbum() {
        assertTrue(
                service.findAlleAlbums()
                       .contains(album)
        );
    }

    @Test
    public void findByIdVindtAlbum() {
        var mogelijkAlbum = service.findById(idVanBlackIce());
        assertTrue(mogelijkAlbum.isPresent());
        assertEquals(album, mogelijkAlbum.get());
    }

    @Test
    public void tracksZijnToegankelijkViaAlbum() {
        var mogelijkAlbum = service.findById(idVanBlackIce());
        assertTrue(mogelijkAlbum.isPresent());
        assertTrue(
                mogelijkAlbum.get()
                             .getTracks()
                             .containsAll(List.of(track1, track2))
        );
    }

    @Test
    public void somethingSomethingNPlus1LazyLoading() {
        var album = service.findById( idVanBlackIce() )
                           .orElseThrow();
//        manager.clear();
        assertTrue(
                album.getTracks()
                     .stream()
                     .map(Track::getNaam)
                     .anyMatch(naam -> naam.equals("Wheels"))
        );
    }

    private long idVanBlackIce() {
        var query = "select id from albums where naam = 'Black Ice'";
        return super.jdbcTemplate.queryForObject(query, Long.class);
    }
}
