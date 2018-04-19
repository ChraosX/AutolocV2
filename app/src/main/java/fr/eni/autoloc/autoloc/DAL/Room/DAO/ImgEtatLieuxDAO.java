package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgEtatLieuxEntity;

@Dao
public interface ImgEtatLieuxDAO extends GenericDAO<ImgEtatLieuxEntity> {
    @Query("SELECT * FROM img_etat_lieux")
    List<ImgEtatLieuxEntity> selectAll();

    @Query("SELECT * FROM img_etat_lieux WHERE etat_lieux_id =:etatLieuxId AND img_id =:imgId")
    ImgEtatLieuxEntity findById(int etatLieuxId, int imgId);
}
