package com.model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * SqlDB Class establishes the connection with the database
 *     - 'connection' a Connection class instance
 *     -  
 * @author 
 */
public class SqlDB {

    protected Connection connection;

    /**
     * Opens the connection with the database
     * 
     * @return a Connection type object
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     * @throws IOException 
     */
    protected Connection openConnection() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        Map<String, String> variables = System.getenv();
        String password = variables.get("dbpassword");
        if (password == null) {
            password = variables.get("DBPASSWORD");
        }

        InputStream propsInputStream = getClass().getResourceAsStream("/db.properties");
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
