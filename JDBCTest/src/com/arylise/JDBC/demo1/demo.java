package com.arylise.JDBC.demo1;

import java.sql.*;

/**
 * @ClassName demo
 * @Description TODO
 * @Date 2021/2/9 3:15
 * @Author arylise
 * @Version 1.0
 */
public class demo {
    public static void main(String[] args) throws Exception {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                        "root",
                        "root"
                );
        System.out.println("aaaaaaaa");
        Statement statement = connection.createStatement();
        String sql = "insert into dept values(50,'教学部','北京');";
        System.out.println(statement.executeUpdate(sql));
        statement.close();
        connection.close();
    }
}
