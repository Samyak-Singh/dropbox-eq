package com.example.dropbox.equivalent.service;

import com.example.dropbox.equivalent.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final String uploadDir = "./uploads"; // Change this to your desired directory

    @Override
    public String storeFile(MultipartFile file, String fileName, String metadata) throws IOException {
        String normalizedFileName = StringUtils.cleanPath(fileName);

        Date createdAt = new Date();
        long size = file.getSize();
        String fileType = file.getContentType();

        // Save file to the target directory
        Path targetLocation = Path.of(uploadDir).resolve(normalizedFileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return normalizedFileName;
    }
}
