package fr.eni.autoloc.autoloc.DAL;

import java.util.List;

import fr.eni.autoloc.autoloc.Exception.DALException;

public interface DAO<T>{
    public List<T> selectAll();
    public T selectById(int id)throws DALException;
    public void insert (T o) throws  DALException;
    public void delete (int id) throws  DALException;
    public void update(T o) throws  DALException;


}
