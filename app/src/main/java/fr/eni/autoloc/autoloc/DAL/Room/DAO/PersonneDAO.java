package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import fr.eni.autoloc.autoloc.DAL.DAO;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.PersonneEntity;

@Dao

public interface PersonneDAO extends GenericDAO<PersonneEntity> {
    @Query("SELECT  * from personne")
    List<PersonneEntity> selectqAll();

    @Query("SELECT * FROM   personne WHERE id = :id")
    PersonneEntity findById(int id);




}
