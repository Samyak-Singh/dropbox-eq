package com.example.dropbox.equivalent.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer fileId;

    String filename;

    String binaryData;

    public String getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(String binaryData) {
        this.binaryData = binaryData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", filename='" + filename + '\'' +
                ", binaryData='" + binaryData + '\'' +
                ", filepath='" + filepath + '\'' +
                ", size='" + size + '\'' +
                ", fileType='" + fileType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    String filepath;

    String size;

    String fileType;

    Timestamp createdAt;



}
