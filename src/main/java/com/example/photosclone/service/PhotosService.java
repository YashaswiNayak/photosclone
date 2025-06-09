package com.example.photosclone.service;

import com.example.photosclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PhotosService {

    HashMap<String, Photo> db=new HashMap<>(){{
        put("1",new Photo("1","timepass.jpg",null));
        put("2",new Photo("2","hello.jpg",null));
    }};

    public Collection<Photo> values() {
        return db.values();
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String filename, byte[] data, String contentType) {
        Photo photo=new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(filename);
        photo.setData(data);
        photo.setContentType(contentType);
        db.put(photo.getId(),photo);
        return photo;
    }

    public Photo get(String id) {
        return db.get(id);
    }
}
