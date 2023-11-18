package com.example.dropbox.equivalent.controllers;

import com.example.dropbox.equivalent.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("fileName") String fileName,
                                             @RequestParam(value = "metadata", required = false) String metadata) {
        try {
            // Save the file
            String fileId = fileStorageService.storeFile(file, fileName, metadata);

            // Return the unique file identifier
            return ResponseEntity.ok("File uploaded successfully. File ID: " + fileId);
        } catch (IOException ex) {
            return ResponseEntity.status(500).body("Error uploading file");
        }
    }
}
