package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.EtatVehiculeEntity;

@Dao
public interface EtatVehiculeDAO extends GenericDAO<EtatVehiculeEntity> {

    @Query("SELECT * FROM etat_vehicule")
    List<EtatVehiculeEntity> selectAll();
    @Query("SELECT * FROM etat_vehicule WHERE id =:id")
    EtatVehiculeEntity findById(int id);
}

