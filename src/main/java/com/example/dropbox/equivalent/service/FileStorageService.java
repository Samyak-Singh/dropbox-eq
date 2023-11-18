package com.example.dropbox.equivalent.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface FileStorageService {
    String storeFile(MultipartFile file, String fileName, String metadata) throws IOException;
}
