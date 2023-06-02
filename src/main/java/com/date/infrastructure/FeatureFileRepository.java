package com.date.infrastructure;

import com.date.entity.Member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class FeatureFileRepository implements FeatureRepository<Member>{



    @Override
    public void create() {

    }

    @Override
    public void createIndex() {

    }

    @Override
    public void save(Member member) {

    }

    @Override
    public void createBitmapIndex(String column) {
        FeatureJDBCRepository featureJDBCRepository = new FeatureJDBCRepository();
        List<String> data;

        String[] genders = {"F", "M"};
        String[] hobbys = {"책읽기", "등산하기", "카페가기", "음주", "공부", "코딩", "헬스", "노래", "줄넘기", "영화"};
        String[] jobs = {"간호사", "대표", "개발자", "기획자", "세무사", "물류", "금융", "기자", "PD", "아이돌"};
        String[] nationalities = {"한국", "일본", "중국", "몽골", "싱가포르", "미국", "우크라이나", "태국", "베트남", "브라질"};

        String path = Paths.get("").toAbsolutePath().toString() + "/src/main/resources/files/" + column + ".txt";
        File file = new File(path);

        try {
            file.createNewFile();
            System.out.println("해당 파일이 생성되었습니다: " + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(column.equals("gender")){
            data = featureJDBCRepository.findGender();
        }
        else if(column.equals("hobby")){
            data = featureJDBCRepository.findHobby();
        }
        else if(column.equals("job")){
            data = featureJDBCRepository.findJob();
        }
        else if(column.equals("nationality")){
            data = featureJDBCRepository.findNationality();
        }

        if(column.equals("gender")){

        }
        else if(column.equals("hobby")){

        }
        else if(column.equals("job")){

        }
        else if(column.equals("nationality")){

        }
    }

    @Override
    public List<String> findGender() {
        return null;
    }

    @Override
    public List<String> findHobby() {
        return null;
    }

    @Override
    public List<String> findJob() {
        return null;
    }

    @Override
    public List<String> findNationality() {
        return null;
    }


}
