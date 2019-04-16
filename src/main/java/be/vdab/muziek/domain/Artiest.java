package be.vdab.muziek.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "artiesten")
public class Artiest {
    private String naam;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @OneToMany(mappedBy = "artiest")
    private Set<Album> albums = new HashSet<>();

    public Artiest(String naam) {
        this.naam = naam;
    }
    protected Artiest() {}

    void addAlbum(final Album album) {
        albums.add(album);
    }

    public long getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
    public Set<Album> getAlbums() {
        return Collections.unmodifiableSet(albums);
    }

    @Override
    public String toString() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artiest artiest = (Artiest) o;
        return naam.equals(artiest.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }
}
