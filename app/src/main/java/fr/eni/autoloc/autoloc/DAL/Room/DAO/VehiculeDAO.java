package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.VehiculeEntity;

@Dao
public interface VehiculeDAO extends GenericDAO<VehiculeEntity>  {

    @Query("SELECT * FROM vehicule")
    List<VehiculeEntity> selectAll();

    @Query("SELECT * FROM vehicule WHERE agence_id =:idAgence")
    List<VehiculeEntity> selectByAgence(int idAgence);

    @Query("SELECT * FROM vehicule WHERE id =:id AND marque_id =:marqueId AND model_id =:modelId AND type_id =:typeId  ")
    VehiculeEntity findById(int id, int marqueId, int modelId,int typeId);
}


