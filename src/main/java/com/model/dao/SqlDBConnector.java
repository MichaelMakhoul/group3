package com.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlDBConnector extends SqlDB{
    private Connection connection;
    public SqlDBConnector() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{

        this.connection = super.openConnection();
    }
    
    public Connection connection(){
        return this.connection;
    }
    
    public void closeConnection() throws SQLException{
        this.connection.close();
    }
}
