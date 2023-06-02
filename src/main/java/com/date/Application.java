package com.date;

import com.date.core.DateApplication;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DateApplication application = new DateApplication(false);
        application.run();
    }
}

