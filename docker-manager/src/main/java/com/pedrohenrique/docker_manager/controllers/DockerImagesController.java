package com.pedrohenrique.docker_manager.controllers;

import com.github.dockerjava.api.model.Image;
import com.pedrohenrique.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class DockerImagesController {
    private final DockerService dockerService;

    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("")
    // Controller para retornar lista de imagens
    public List<Image> listImages(){
        return dockerService.listImage();
    }
    @GetMapping("/filter")
    // Controller para retornar lista de imagens
    public List<Image> filterImages(@RequestParam(required = false, defaultValue = "image-") String filterName){
        return dockerService.filtertImage(filterName);
    }


}
