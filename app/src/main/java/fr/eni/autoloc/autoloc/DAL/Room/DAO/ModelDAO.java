package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.BO.Model;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ModelEntity;
@Dao
public interface ModelDAO extends GenericDAO<ModelEntity>{
    @Query("SELECT * FROM moddel")
    List<Model> selectAll();

    @Query("SELECT * FROM moddel WHERE id = :id")
    Model findById(int id );

}
