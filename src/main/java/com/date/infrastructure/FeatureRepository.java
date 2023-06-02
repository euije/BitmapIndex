package com.date.infrastructure;

import java.io.IOException;
import java.util.List;

public interface FeatureRepository<T> {
    // CREATE
    void create();
    void createIndex(/* columns */);
    void save(T t);
    void createBitmapIndex(String column) throws IOException;

    // READ
    List<String> findGender();
    List<String> findHobby();
    List<String> findJob();
    List<String> findNationality();

    // UPDATE

    // DELETE
}
