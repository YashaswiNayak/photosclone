package com.example.photosclone.repositoty;

import com.example.photosclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo,Integer> {
}
