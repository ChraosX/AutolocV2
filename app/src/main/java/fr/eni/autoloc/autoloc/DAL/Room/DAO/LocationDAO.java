package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Query;

import java.util.List;


import fr.eni.autoloc.autoloc.DAL.Room.Entity.LocationEntity;

public interface LocationDAO extends GenericDAO<LocationEntity> {
    @Query("SELECT * FROM location")
    List<LocationEntity> selectAll();
    @Query("SELECT * FROM location WHERE id =:id")
    LocationEntity findById(int id);
}
