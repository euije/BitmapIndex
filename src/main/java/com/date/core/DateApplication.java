package com.date.core;

import com.date.controller.FeatureController;
import com.date.controller.TestController;
import com.date.util.view.ViewHolder;

import java.io.IOException;
import java.util.Scanner;

public class DateApplication {

    private final FeatureController featureController;
    private final TestController testController;

    private final Scanner scanner;
    private boolean mode;
    private int input;

    public void run() throws IOException {
        do {
            if(mode == false) {
                // 기능 모드
                ViewHolder.printMenu(featureController);
                input = scanner.nextInt();

                if(input == 8) {
                    mode = !mode;
                    continue;
                }

                featureController.feature(input);
            }
            else if(mode == true) {
                // 테스트 모드
                ViewHolder.printMenu(testController);
                input = scanner.nextInt();

                if(input == 8) {
                    mode = !mode;
                    continue;
                }

                testController.test(input);
            }
        } while(input != 9);

        System.out.println("프로그램이 종료되었습니다.");
    }

    public DateApplication(boolean mode) {
        featureController = new FeatureController();
        testController = new TestController();

        scanner = new Scanner(System.in);
        this.mode = mode;
        this.input = 0;
    }
}
