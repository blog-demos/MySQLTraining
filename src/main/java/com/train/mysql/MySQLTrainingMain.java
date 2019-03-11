package com.train.mysql;

import java.sql.*;

public class MySQLTrainingMain {

    public static void main(String[] args) throws SQLException {
        System.out.println("---------------- 初始化 ------------------");
        Connection conn = initDB();
        System.out.println("--------------- 一般查询 -----------------");
        testSelectName(conn);
        System.out.println("--------------- 一般查询 -----------------");
        testSelectScore(conn,"李雷", "数学");
        System.out.println("--------------- 注入测试 -----------------");
        testSelectScore(conn,"李雷", "数学' OR '1'='1");
        System.out.println("--------------- 参数化查询 ----------------");
        testSelectScoreByParams(conn,"韩梅梅", "数学");
        System.out.println("--------------- 注入测试 ----------------");
        testSelectScoreByParams(conn,"韩梅梅", "数学' OR '1'='1");
        conn.close();
    }

    private static Connection initDB() {
        Connection conn = null;
        try{
            Class.forName(MySQLConfig.DRIVER);
            conn = DriverManager.getConnection(MySQLConfig.URL, MySQLConfig.USER, MySQLConfig.PASSWORD);

            if (!conn.isClosed()) { System.out.println("数据库连接成功"); }
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

        return conn;
    }

    /**
     * 测试普通查询1
     */
    private static void testSelectName(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM student_info;";
        ResultSet resultSet = statement.executeQuery(sql);
        String name;
        while (resultSet.next()) {
            name = resultSet.getString("name");
            System.out.println("姓名：" + name);
        }
        resultSet.close();
    }

    /**
     * 测试普通查询2
     */
    private static void testSelectScore(Connection conn, String student, String course) throws SQLException {
        String sql =
                "SELECT\n" +
                "    sci.score AS score,\n" +
                "    si.name AS name,\n" +
                "    ci.name AS course\n" +
                "FROM\n" +
                "    student_info AS si,\n" +
                "    course_info AS ci,\n" +
                "    score_info AS sci\n" +
                "WHERE\n" +
                "    si.id=sci.student_info_id AND\n" +
                "    ci.id=sci.course_info_id AND\n" +
                "    si.name='" + student + "' AND\n" +
                "    ci.name='" + course + "';";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        select(resultSet);
        //while (resultSet.next()) {
        //    String s1 = resultSet.getString("name");
        //    String s2 = resultSet.getString("course");
        //    String s3 = resultSet.getString("score");
        //    System.out.println(String.format("姓名：%s 课程：%s 分数：%s", s1, s2, s3));
        //}
        //resultSet.close();
    }

    /**
     * 测试参数化查询
     */
    private static void testSelectScoreByParams(Connection conn, String student, String course) throws SQLException {
        String sql =
                "SELECT\n" +
                "    sci.score AS score,\n" +
                "    si.name AS name,\n" +
                "    ci.name AS course\n" +
                "FROM\n" +
                "    student_info AS si,\n" +
                "    course_info AS ci,\n" +
                "    score_info AS sci\n" +
                "WHERE\n" +
                "    si.id=sci.student_info_id AND\n" +
                "    ci.id=sci.course_info_id AND\n" +
                "    si.name=? AND\n" +
                "    ci.name=?;";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, student);
        pStatement.setString(2, course);

        ResultSet resultSet = pStatement.executeQuery();
        select(resultSet);
        //while (resultSet.next()) {
        //    String s1 = resultSet.getString("name");
        //    String s2 = resultSet.getString("course");
        //    String s3 = resultSet.getString("score");
        //    System.out.println(String.format("姓名：%s 课程：%s 分数：%s", s1, s2, s3));
        //}
        //resultSet.close();
    }

    private static void select(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String s1 = resultSet.getString("name");
            String s2 = resultSet.getString("course");
            String s3 = resultSet.getString("score");
            System.out.println(String.format("姓名：%s 课程：%s 分数：%s", s1, s2, s3));
        }
        resultSet.close();
    }
}
