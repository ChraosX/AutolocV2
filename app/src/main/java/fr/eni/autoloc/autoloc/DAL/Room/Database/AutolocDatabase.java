package fr.eni.autoloc.autoloc.DAL.Room.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import fr.eni.autoloc.autoloc.DAL.Room.DAO.AgenceDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.AgentDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.ClientDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.EtatLieuxDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.EtatVehiculeDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.ImgDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.ImgEtatLieuxDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.ImgVehiculeEntityDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.LocationDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.MarqueDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.ModelDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.PersonneDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.TypeVehiculeDAO;
import fr.eni.autoloc.autoloc.DAL.Room.DAO.VehiculeDAO;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgenceEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgentEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ClientEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.EtatLieuxEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.EtatVehiculeEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgEtatLieuxEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgVehiculeEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.LocationEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.MarqueEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ModelEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.PersonneEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.TypeVehiculeEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.VehiculeEntity;

@Database(version =1, entities = {  AgenceEntity.class,
                                    AgentEntity.class,
                                    ClientEntity.class,
                                    EtatLieuxEntity.class,
        EtatVehiculeEntity.class,
        ImgEntity.class,
        ImgEtatLieuxEntity.class,
        ImgVehiculeEntity.class,
        LocationEntity.class,
        MarqueEntity.class,
        ModelEntity.class,
        PersonneEntity.class,
        TypeVehiculeEntity.class,
        VehiculeEntity.class


                                })
public abstract class AutolocDatabase extends RoomDatabase {

    public static final String DB_NAME="autoloc_db";

    abstract public AgenceDAO   agenceDAO();
    abstract public AgentDAO agentDAO();
    abstract public ClientDAO clientDAO();
    abstract public EtatLieuxDAO etatLieuxDAO();
    abstract public EtatVehiculeDAO etatVehiculeDAO();
    abstract public ImgDAO imgDAO();
    abstract public ImgEtatLieuxDAO imgEtatLieuxDAO();
    abstract public ImgVehiculeEntityDAO imgVehiculeEntityDAO();
    abstract public LocationDAO locationDAO();
    abstract public MarqueDAO marqueDAO();
    abstract public ModelDAO modelDAO();
    abstract public PersonneDAO PersonneDAO();
    abstract public TypeVehiculeDAO typeVehiculeDAO();
    abstract public VehiculeDAO vehiculeDAO();
}
