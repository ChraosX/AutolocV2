package fr.eni.autoloc.autoloc.DAL.Room.DAO;


import android.arch.persistence.room.Dao;

import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.TypeVehiculeEntity;

@Dao
public interface TypeVehiculeDAO extends  GenericDAO<TypeVehiculeEntity> {

    @Query("SELECT * from type_vehicule")
    List<TypeVehiculeEntity> selectAll();

    @Query("SELECT * from  type_vehicule WHERE id = :id")
    TypeVehiculeEntity findById(int id);



}
