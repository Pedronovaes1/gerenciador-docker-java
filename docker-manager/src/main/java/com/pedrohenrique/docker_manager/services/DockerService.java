package com.pedrohenrique.docker_manager.services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {
    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    // Método que lista/mostra todos os container
    public List<Container> listContainers(boolean all){
        return dockerClient.listContainersCmd().withShowAll(all).exec();
    }

    // Método que lista/mostra todas as imagens do docker
    public List<Image> listImage(){
        return dockerClient.listImagesCmd().exec();
    }

    // Método que filtra as imagens do docker pelo nome
    public List<Image> filtertImage(String imageName){
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }

    // Método para começar/start em um novo container
    public void startContainer(String containerId){
        dockerClient.startContainerCmd(containerId).exec();
    }

    // Método para parar/stop em um container
    public void stopContainer(String containerId){
        dockerClient.stopContainerCmd(containerId).exec();
    }

    // Método para deletar um container
    public void deleteContainer(String containerId){
        dockerClient.removeContainerCmd(containerId).exec();
    }

    // Método para criar um novo container
    public void createContainer(String imageName){
        dockerClient.createContainerCmd(imageName).exec();
    }

    // Método para criar volumes
    public void createVolume(){
        dockerClient.createVolumeCmd().exec();
    }

    // Limpar volume
    public void clearVol(String containerId){
        dockerClient.removeVolumeCmd(containerId).exec();
    }

}
