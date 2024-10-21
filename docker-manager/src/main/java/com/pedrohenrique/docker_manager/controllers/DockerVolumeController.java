package com.pedrohenrique.docker_manager.controllers;

import com.pedrohenrique.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/volumes/")
public class DockerVolumeController {

    private final DockerService dockerService;

    public DockerVolumeController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @PostMapping("")
    public void createVolume(){
        dockerService.createVolume();
    }

    @DeleteMapping
    public void deleteVolume(String id){
        dockerService.clearVol(id);
    }
}
