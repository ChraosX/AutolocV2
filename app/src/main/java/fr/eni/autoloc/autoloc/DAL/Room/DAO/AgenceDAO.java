package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgenceEntity;

@Dao
public interface AgenceDAO extends  GenericDAO<AgenceEntity> {

    @Query("SELECT * FROM agence")
    List<AgenceEntity> selectAll();
    @Query("SELECT * FROM agence WHERE id =:id")
    AgenceEntity findById(int id);

}
