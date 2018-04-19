package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;


import fr.eni.autoloc.autoloc.DAL.Room.Entity.EtatLieuxEntity;

@Dao
public interface EtatLieuxDAO extends GenericDAO<EtatLieuxEntity> {
    @Query("SELECT * FROM etat_lieux")
    List<EtatLieuxEntity> selectAll();
    @Query("SELECT * FROM etat_lieux WHERE id =:id")
    EtatLieuxEntity findById(int id);
}
