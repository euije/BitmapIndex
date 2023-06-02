package com.date.controller;

import com.date.service.FeatureService;

import java.io.IOException;

public class FeatureController implements Controller {

    private final FeatureService featureService;

    public void feature(int option) throws IOException {
        if(option == 1) {
            featureService.createTable();
        }
        else if(option == 2) {
            featureService.insertRandomTuples(30);
        }
        else if(option == 3) {
            featureService.createBitmapIndex(/* columns */);
        }
    }

    public FeatureController() {
        featureService = new FeatureService();
    }
}
