/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3m;

import java.sql.Connection;

public abstract class SqlDAO<T> implements DAO<T> {
    
    public Connection connect;

    public SqlDAO(){

        this.connect = ConnectionBuilder.getInstance();
         
    }
    
    public abstract boolean create(T obj);
    
    public abstract T read(int id) ;

    public abstract boolean update(T obj) ;

    public abstract boolean delete(T obj) ;
    
}
