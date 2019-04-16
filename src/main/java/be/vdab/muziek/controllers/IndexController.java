package be.vdab.muziek.controllers;

import be.vdab.muziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    private final AlbumService service;

    public IndexController(AlbumService service) {
        this.service = service;
    }

    @GetMapping
    ModelAndView index() {
        var albums = service.findAlleAlbums();
        return new ModelAndView("index").addObject("albums", albums);
    }
}
