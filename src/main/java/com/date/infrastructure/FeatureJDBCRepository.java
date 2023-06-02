package com.date.infrastructure;

import com.date.entity.Member;
import com.date.util.view.ViewHolder;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeatureJDBCRepository implements FeatureRepository<Member> {

    String url = "jdbc:mysql://localhost:3306/date";
    String username = "root";
    String password = "";
    int stringSize = 45;

    @Override
    public void create() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            StringBuilder query = new StringBuilder("create table " + Member.class.getSimpleName().toLowerCase() + "(");

            for(Field field : Member.class.getFields()) {
                query.append(field.getName());

                if(field.getName().equals("id"))
                    query.append(" INT PRIMARY KEY AUTO_INCREMENT");
                else if(field.getType().toString().equals("int"))
                    query.append(" INT NOT NULL");
                else if(field.getType() == String.class)
                    query.append(" VARCHAR(" + stringSize + ") NOT NULL");

                query.append(",\n");
            }

            query.deleteCharAt(query.length() - 1);
            query.deleteCharAt(query.length() - 1);
            query.append(");");

            ViewHolder.printQuery(query.toString());
            PreparedStatement statement = conn.prepareStatement(query.toString());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createIndex() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String tableName = Member.class.getSimpleName().toLowerCase();

            StringBuilder query = new StringBuilder("create index " + tableName
                    + "_index" + " on " + tableName + " (id);");

            ViewHolder.printQuery(query.toString());
            PreparedStatement statement = conn.prepareStatement(query.toString());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Member member) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String tableName = Member.class.getSimpleName().toLowerCase();

            StringBuilder query = new StringBuilder("insert into " + tableName
                    + "(");

            for(Field field : Member.class.getFields()) {
                if(field.getName().equals("id"))
                    continue;

                query.append(field.getName());
                query.append(",");
            }
            query.deleteCharAt(query.length() - 1);

            query.append(") values(");
            for(int i = 0; i < Member.class.getFields().length - 1; i++) {
                query.append("?,");
            }
            query.deleteCharAt(query.length() - 1);
            query.append(");");

            ViewHolder.printQuery(query.toString());
            PreparedStatement statement = conn.prepareStatement(query.toString());
            statement.setString(1, member.name);
            statement.setString(2, member.gender);
            statement.setString(3, member.age);
            statement.setInt(4, member.height);
            statement.setInt(5, member.weight);
            statement.setString(6, member.hobby);
            statement.setString(7, member.job);
            statement.setString(8, member.location);
            statement.setString(9, member.nationality);

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBitmapIndex(String column) {

    }

    @Override
    public List<String> findGender() {
        List<String> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT gender FROM member";
            PreparedStatement statement = conn.prepareStatement(query);

            ViewHolder.printQuery(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gender = resultSet.getString("gender");

                result.add(gender);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(result.isEmpty())
            return Collections.emptyList();

        return result;
    }

    @Override
    public List<String> findHobby() {
        List<String> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT hobby FROM member";
            PreparedStatement statement = conn.prepareStatement(query);

            ViewHolder.printQuery(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String hobby = resultSet.getString("hobby");

                result.add(hobby);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(result.isEmpty())
            return Collections.emptyList();

        return result;
    }

    @Override
    public List<String> findJob() {
        List<String> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT job FROM member";
            PreparedStatement statement = conn.prepareStatement(query);

            ViewHolder.printQuery(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String job = resultSet.getString("job");

                result.add(job);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(result.isEmpty())
            return Collections.emptyList();

        return result;
    }

    @Override
    public List<String> findNationality() {
        List<String> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT nationality FROM member";
            PreparedStatement statement = conn.prepareStatement(query);

            ViewHolder.printQuery(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nationality = resultSet.getString("nationality");

                result.add(nationality);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(result.isEmpty())
            return Collections.emptyList();

        return result;
    }
}
