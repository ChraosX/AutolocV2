package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import fr.eni.autoloc.autoloc.DAL.Room.Entity.MarqueEntity;

@Dao
public interface MarqueDAO {
    @Query("SELECT * from marque")
    public List<MarqueEntity> selectAll();

    @Query("SELECT * FROM marque WHERE id = :id")
    public MarqueEntity findById(int id);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long insert(MarqueEntity marque);

    @Update
    void update (MarqueEntity marque);

    @Delete
    void delete(MarqueEntity marque);

}