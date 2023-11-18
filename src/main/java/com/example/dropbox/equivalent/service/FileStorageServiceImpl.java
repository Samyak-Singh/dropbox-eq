package com.example.dropbox.equivalent.service;

import com.example.dropbox.equivalent.model.File;
import com.example.dropbox.equivalent.repository.FileRepository;
import com.example.dropbox.equivalent.service.FileStorageService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;

@Service
@Log
public class FileStorageServiceImpl implements FileStorageService {

    private final String uploadDir = "./uploads"; // Change this to your desired directory

    @Autowired
    FileRepository fileRepository;

    @Override
    public String storeFile(MultipartFile file, String fileName, String metadata) throws IOException {
        String normalizedFileName = StringUtils.cleanPath(fileName);

        Date createdAt = new Date();
        long size = file.getSize();
        String fileType = file.getContentType();

        // Save file to the target directory
        Path targetLocation = Path.of(uploadDir).resolve(normalizedFileName);
        File fileModel  = new File();
        fileModel.setFilename(fileName);
        fileModel.setCreatedAt(Timestamp.from(createdAt.toInstant()));
        fileModel.setFileType(fileType);
        fileModel.setSize(String.valueOf(size));
        try {
            fileRepository.save(fileModel);
            log.log(Level.INFO, "File iinfo saved in the database  ID :{}  ",  fileModel.getFileId());
        }
        catch (Exception e) {

        }

        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return normalizedFileName;
    }
}
