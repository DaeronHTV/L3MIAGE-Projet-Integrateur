package l3m;

import org.w3c.dom.Document;

public abstract class DomDAO<T> implements DAO<T> {

    
    protected String nomFichier ;
    protected Document doc;
    
    public abstract boolean create(T obj);
    
    public abstract T read(int id) ;

    public abstract boolean update(T obj) ;

    public abstract boolean delete(T obj) ;
    



}