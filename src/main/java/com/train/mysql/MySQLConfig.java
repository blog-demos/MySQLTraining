package com.train.mysql;

class MySQLConfig {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String HOST = "192.168.37.146";
    private static final int PORT = 3306;
    private static final String DB_NAME = "student";

    static final String URL = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=utf8&useSSL=true&serverTimezone=UTC", HOST, PORT, DB_NAME);

    static final String USER = "root";
    static final String PASSWORD = "123456";

}
