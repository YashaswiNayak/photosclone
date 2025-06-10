package com.example.photosclone.service;

import com.example.photosclone.model.Photo;
import com.example.photosclone.repositoty.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

@Service
public class PhotosService {

    private final PhotosRepository photosRepository;


    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Iterable<Photo> values() {
        return photosRepository.findAll();
    }

    public void remove(Integer id) {
         photosRepository.deleteById(id);
    }

    public Photo save(String filename, byte[] data, String contentType) {
        Photo photo=new Photo();
        photo.setFileName(filename);
        photo.setData(data);
        photo.setContentType(contentType);
        photosRepository.save(photo);
        return photo;
    }

    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }
}
