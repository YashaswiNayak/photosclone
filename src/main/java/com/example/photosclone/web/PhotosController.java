package com.example.photosclone.web;

import com.example.photosclone.model.Photo;
import com.example.photosclone.service.PhotosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotosController {

    private final PhotosService photoService;

    public PhotosController(PhotosService photoService){
        this.photoService=photoService;
    }

    @GetMapping("/")
    public  String defaultPage(){
        return "Default Page";
    }
    @GetMapping("/hello")
    public String printAMessage(){
        return "Hello World - I am Alive";
    }
    @GetMapping("/photos")
    public Collection<Photo> getAll(){
        return photoService.values();
    }
    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id){
        Photo photo= photoService.get(id);
        if(photo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }
    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id){
        Photo photo=photoService.remove(id);
        if(photo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/photos")
    public  Photo createPhoto(@RequestPart("data") @Valid MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(),file.getBytes(),file.getContentType());
    }
}
