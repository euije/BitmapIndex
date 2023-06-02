package com.date.util.view;

import com.date.controller.Controller;
import com.date.controller.FeatureController;
import com.date.controller.TestController;

public class ViewHolder {
    public static void printMenu(Controller controller) {
        if(controller instanceof FeatureController)
            printFeatureMenu();
        else if(controller instanceof TestController)
            printTestMenu();
    }

    private static void printFeatureMenu() {
        System.out.println("1. \"member\" 테이블 생성하기 (B+ tree Index 포함)");
        System.out.println("2. \"member\" 테이블에 레코드 삽입하기 (30,000개)");
        System.out.println("3. \"member\" 테이블에 Bitmap Index 생성하기 (gender, hobby, job, nationality 컬럼)");
        System.out.println("4. \"member\" 테이블에 multiple-key 질의 하기 (질의 메뉴)");
        System.out.println("5. \"member\" 테이블에 count(*) 질의하기 (질의 메뉴)");
        System.out.println("8. 테스트 모드로 바꾸기");
        System.out.println("9. 프로그램 종료하기");
    }

    private static void printTestMenu() {
        System.out.println("8. 테스트 모드로 바꾸기");
        System.out.println("9. 프로그램 종료하기");
    }

    public static void printQuery(String query) {
        System.out.println("\n실행된 쿼리 : " + query + "\n");
    }
}
