package com.example.photosclone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class PhotosController {
    HashMap<String,Photo>db=new HashMap<>(){{
        put("1",new Photo("1","timepass.jpg"));
        put("2",new Photo("2","hello.jpg"));
    }};
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
        return db.values();
    }
    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id){
        Photo photo= db.get(id);
        if(photo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }
}
