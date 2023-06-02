package com.date.entity;

import java.util.Random;

public class Member {
    public int id;
    public String name;
    public String gender;
    public String age;
    public int height;
    public int weight;
    public String hobby;
    public String job;
    public String location;
    public String nationality;

    private static String[] names = {"강수경", "강원용", "정준서", "장유진", "최가희", "임승하", "김동휘", "이승헌", "이영주", "최윤한"};

    private static String[] genders = {"F", "M"};
    private static String[] hobbys = {"책읽기", "등산하기", "카페가기", "음주", "공부", "코딩", "헬스", "노래", "줄넘기", "영화"};
    private static String[] jobs = {"간호사", "대표", "개발자", "기획자", "세무사", "물류", "금융", "기자", "PD", "아이돌"};
    private static String[] nationalities = {"한국", "일본", "중국", "몽골", "싱가포르", "미국", "우크라이나", "태국", "베트남", "브라질"};

    private static String[] locations = {"서울", "경기", "부산"};

    public Member() {

    }

    public Member(String name, String gender, String age, int height, int weight, String hobby, String job, String location, String nationality) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hobby = hobby;
        this.job = job;
        this.location = location;
        this.nationality = nationality;
    }

    public static Member rand(){
        Random random = new Random();

        String name = names[random.nextInt(10)];
        String gender = genders[random.nextInt(2)];
        String age = String.valueOf(random.nextInt(40));
        int height = random.nextInt(200);
        int weight = random.nextInt(100);
        String hobby = hobbys[random.nextInt(10)];
        String job = jobs[random.nextInt(10)];
        String location = locations[random.nextInt(3)];
        String nationality = nationalities[random.nextInt(10)];

        return new Member(name, gender, age, height, weight, hobby, job, location, nationality);
    }
}
