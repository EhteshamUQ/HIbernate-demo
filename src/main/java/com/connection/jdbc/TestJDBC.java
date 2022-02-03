package com.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hb_student";
        String password  = "hb_student";

        try {
            System.out.println("Connecting to DB:" + jdbcUrl );
            Connection myCon = DriverManager.getConnection(jdbcUrl , user , password);
            System.out.println("Connection Successful");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to Connect");
        }
    }
}
