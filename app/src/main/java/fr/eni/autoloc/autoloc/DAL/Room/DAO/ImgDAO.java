package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.BO.Img;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgEntity;

@Dao
public interface ImgDAO extends GenericDAO<ImgEntity> {

    @Query("SELECT * FROM img")
    List<Img> selectAll();

    @Query("SELECT * FROM img WHERE id =:id")
    ImgEntity findById(int id);


}
