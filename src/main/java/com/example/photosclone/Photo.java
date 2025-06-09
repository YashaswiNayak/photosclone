package com.example.photosclone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;
    @NotEmpty
    private String filename;
    @JsonIgnore
    private byte[] data;
    public Photo(){}
    public Photo(String id , String filename,byte[] data){
        this.id=id;
        this.filename=filename;
        this.data=data;
    }
    //Getter and setter for id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //Getter and setter for filename
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        System.out.println("The file name is "+filename);
    }
    //Getter ans setter for jpg data
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
