package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Personne;

@Entity(tableName = "personne")
public class PersonneEntity  {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String nom;
    public  String prenom;
    public String sexe;
    public String email;
    public String tel;


}
