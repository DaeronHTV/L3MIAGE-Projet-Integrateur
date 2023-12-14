/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3m;


/**
 *
 * @author Asus
 * @param <T>
 */
public interface DAO<T> {
 
    boolean create(T obj);
     
    T read(int id);
     
    boolean update(T obj);
     
    boolean delete(T obj);
}
