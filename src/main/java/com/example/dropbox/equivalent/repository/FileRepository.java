package com.example.dropbox.equivalent.repository;

import com.example.dropbox.equivalent.model.File;
import lombok.extern.java.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.logging.Level;


public interface FileRepository extends CrudRepository<File, Integer> {
    <S extends File> S save(S entity);
}
