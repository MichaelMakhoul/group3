/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author 236351
 */
public class SqlDB {
    protected Connection connection;
    
    protected Connection openConnection() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException{
        Map<String,String> variables = System.getenv();
        String password = variables.get("dbpassword");
        
        URL dburl = getClass().getResource("db.properties");
//        C:\\Users\\236351\\Documents\\github\\group3\\src\\main\\resources\\db.properties
        InputStream propsInputStream = new FileInputStream("C:\\\\Users\\\\236351\\\\Documents\\\\github\\\\group3\\\\src\\\\main\\\\resources\\\\db.properties");
        Properties properties = new Properties();
        properties.load(propsInputStream);
        
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String dbuser = properties.getProperty("dbuser");
        
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url, dbuser, password);
        propsInputStream.close();
        return connection;
    }
}
