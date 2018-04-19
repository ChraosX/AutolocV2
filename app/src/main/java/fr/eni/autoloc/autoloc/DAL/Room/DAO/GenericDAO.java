package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;


@Dao
public interface GenericDAO<T> {



    @Insert(onConflict = OnConflictStrategy.FAIL)
    int insert( T entity );
    @Delete
    void delete( T entity );
    @Update
    void update(T entity);
}
