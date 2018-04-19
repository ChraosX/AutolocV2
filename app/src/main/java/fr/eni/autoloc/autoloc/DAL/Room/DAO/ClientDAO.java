package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import fr.eni.autoloc.autoloc.DAL.Room.Entity.ClientEntity;
@Dao
public interface ClientDAO {


    @Query("SELECT  * from client")
    List<ClientEntity> selectqAll();

    @Query("SELECT * FROM   client WHERE id = :id")
    ClientEntity findById(int id);

    @Insert
    void insert(ClientEntity client);

    @Delete
    void delete(ClientEntity client);

    @Update
    void update(ClientEntity client);

}
