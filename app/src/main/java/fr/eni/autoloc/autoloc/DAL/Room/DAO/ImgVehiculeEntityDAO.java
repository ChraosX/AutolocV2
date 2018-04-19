package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgVehiculeEntity;

@Dao
public interface ImgVehiculeEntityDAO extends GenericDAO<ImgVehiculeEntity> {

    @Query("SELECT * FROM IMG_VEHICULE")
    List<ImgVehiculeEntity> selectAll();
    @Query("SELECT * FROM img_vehicule WHERE img_id =:imgId AND marque_id=:marqueId  AND model_id=:modelId AND type_id =:typeId AND vehicule_id =:vehiculeId ")
    ImgVehiculeEntity findById(int imgId,int marqueId, int modelId, int typeId, int vehiculeId);

}
