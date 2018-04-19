package fr.eni.autoloc.autoloc.DAL.Room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;


import fr.eni.autoloc.autoloc.BO.Agent;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgentEntity;


@Dao

public interface AgentDAO extends GenericDAO<AgentEntity> {

    @Query("SELECT * FROM agent")
    List<AgentEntity> selectAll();
    @Query("SELECT * FROM agent WHERE agence_id=:idAgence")
    List<AgentEntity> findByAgence(int idAgence);
    @Query("SELECT * FROM agent JOIN personne p ON personne_id = p.id  WHERE passwd=:mdp AND p.email =:email ")
    Agent connection(String email, String mdp);
    @Query("SELECT * FROM agent WHERE personne_id =:id")
    AgentEntity findById(int id);

}
