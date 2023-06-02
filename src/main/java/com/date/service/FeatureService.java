package com.date.service;

import com.date.entity.Member;
import com.date.infrastructure.FeatureHybridRepository;
import com.date.infrastructure.FeatureRepository;

import java.io.IOException;

public class FeatureService {

    private final FeatureRepository featureRepository;
    public void createTable() {
        featureRepository.create();
        featureRepository.createIndex();
    }

    public void insertRandomTuples(int count) {
        for(int i = 0; i < count; i++) {
            featureRepository.save(Member.rand());
        }
    }

    public void createBitmapIndex() throws IOException {
        String[] columns = {"gender", "hobby", "job", "nationality"};

        for(String column : columns){
            featureRepository.createBitmapIndex(column);
        }
    }

    public FeatureService() {
        featureRepository = new FeatureHybridRepository();
    }
}
