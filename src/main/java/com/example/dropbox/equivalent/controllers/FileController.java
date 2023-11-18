package com.example.dropbox.equivalent.controllers;

import com.example.dropbox.equivalent.model.File;
import com.example.dropbox.equivalent.repository.FileRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.logging.Level;


@Controller
@RequestMapping(path="/files")
@Log
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping(path="/upload") // Map ONLY POST Requests
    public @ResponseBody Integer uploadFile (
              @RequestParam String binaryData,
              @RequestParam String fileName,
              @RequestParam String size,
              @RequestParam String fileType) {

        File file = new File();
        file.setFilename(fileName);
        file.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        file.setSize(size);
        file.setFileType(fileType);
        file.setBinaryData(binaryData);

        fileRepository.save(file);

        log.log(Level.INFO, "The File Created is : {} ", file.toString());
        return file.getFileId();
    }

}
