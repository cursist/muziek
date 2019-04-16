package be.vdab.muziek.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static be.vdab.muziek.utility.Convertor.printDoubleAlsMinutenEnSeconden;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "albums")
public class Album {
    private String naam;

    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "artiestId")
    private Artiest artiest;

    @ElementCollection
    @CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumId"))
//    @OneToMany(mappedBy = "tracks")
    private Set<Track> tracks = new HashSet<>();

    public Album(String naam, final Artiest artiest) {
        this.naam = naam;
        this.setArtiest(artiest);
    }
    protected Album() {}

    private void setArtiest(final Artiest artiest) {
        this.artiest = artiest;
        artiest.addAlbum(this);
    }

    void addTrack(Track track) {
        tracks.add(track);
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }

    public String getTotaleTijd() {
        double totaalAantalSeconden =
                tracks.stream()
                        .mapToDouble(Track::getTijd)
                        .sum();
        return printDoubleAlsMinutenEnSeconden(totaalAantalSeconden);
    }

    @Override
    public String toString() {
        return naam + " (" + artiest.getNaam() + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return naam.equals(album.naam) &&
                artiest.equals(album.artiest);
    }

    @Override
    public int hashCode() {
        return naam.hashCode() + artiest.hashCode();
    }
}
