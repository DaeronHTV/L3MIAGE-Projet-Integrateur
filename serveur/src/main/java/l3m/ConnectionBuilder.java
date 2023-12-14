/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3m;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class ConnectionBuilder {

    private final String URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    private final String USER = "varinier";
    private final String PASSWD = "2eKSrGx6T5";
    
    private static Connection connect;
    
    
    private ConnectionBuilder() throws ClassNotFoundException, SQLException{
       try{ 
            connect = (Connection) DriverManager.getConnection(URL,USER,PASSWD);
            
       }catch (SQLException e) {
           System.out.println(e);
       }
    }

    public static Connection getInstance(){
        if(connect == null){
			try {
				connect = (Connection) DriverManager.getConnection(
                        "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "varinier", "2eKSrGx6T5");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
    }
}

