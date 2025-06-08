package com.example.photosclone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotosController {

    private List<Photo> db=List.of(new Photo("1","timepass.jpg"));
    @GetMapping("/")
    public  String defaultPage(){
        return "Default Page";
    }
    @GetMapping("/hello")
    public String printAMessage(){
        return "Hello World - I am Alive";
    }
    @GetMapping("/photos")
    public List<Photo> getPhotos(){
        return db;
    }
}
