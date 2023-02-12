
package com.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * - The Class inherits the SqlDB class which establishes a connection to
 *   the Hotel App's Database
 * - This Connector class is used by DAO classes to establish Database
 *   connection
 * 
 * @author Micheal
 */
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
