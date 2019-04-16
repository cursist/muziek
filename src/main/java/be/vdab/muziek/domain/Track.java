package be.vdab.muziek.domain;

import be.vdab.muziek.utility.Convertor;

import javax.persistence.*;

import java.util.Objects;

import static be.vdab.muziek.utility.Convertor.printDoubleAlsMinutenEnSeconden;

@Embeddable
public class Track {
    private String naam;
    private double tijd;

//    private long albumId;

    public Track(String naam, double tijd, Album album) {
        this.naam = naam;
        this.tijd = tijd;
        setAlbum(album);
    }
    protected Track() {}

    private void setAlbum(Album album) {
        album.addTrack(this);
//        this.albumId = album.getId();
    }

    public String getNaam() {
        return naam;
    }
    public double getTijd() {
        return tijd;
    }

    @Override
    public String toString() {
        return naam + " (" + printDoubleAlsMinutenEnSeconden(tijd) + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return naam.equals(track.naam) &&
                tijd == track.tijd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, tijd);
    }
}
