package be.vdab.muziek.controllers;

import be.vdab.muziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("album")
public class AlbumController {
    private final AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    ModelAndView getAlbum(@PathVariable long id) {
        var album = service.findById(id);
        if (album.isEmpty()) {
            return new ModelAndView("404");
        } else {
            return new ModelAndView("album")
                    .addObject("album", album.get());
        }
    }
}
