package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.domain.Artiest;
import be.vdab.muziek.repositories.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AlbumService {
    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public List<Album> findAlleAlbums() {
        return repository.findAll();
    }

    public Optional<Album> findById(long id) {
        return repository.findById(id);    }
}
