package com.date.infrastructure;

import com.date.entity.Member;

import java.util.List;

public class FeatureHybridRepository implements FeatureRepository<Member> {

    private final FeatureJDBCRepository featureJDBCRepository;
    private final FeatureFileRepository featureFileRepository;


    @Override
    public void create() {
        featureJDBCRepository.create();
    }

    @Override
    public void createIndex() {
        featureJDBCRepository.createIndex();
    }

    @Override
    public void save(Member member) {
        featureJDBCRepository.save(member);
    }

    @Override
    public void createBitmapIndex(String column) {
        featureFileRepository.createBitmapIndex(column);
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


    public FeatureHybridRepository() {
        this.featureJDBCRepository = new FeatureJDBCRepository();
        this.featureFileRepository = new FeatureFileRepository();
    }
}
