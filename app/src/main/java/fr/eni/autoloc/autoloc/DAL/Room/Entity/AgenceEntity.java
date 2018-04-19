package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Adresse;
import fr.eni.autoloc.autoloc.BO.Agence;

@Entity(tableName = "agence")
public class AgenceEntity implements ParsableToBo<Agence> {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String nom;
    @Embedded
    public Adresse adresse;

    @Override
    public Agence toBo() {
        Agence a  = new Agence();

        a.setId(this.id);
        a.setAdresse(this.adresse);
        a.setNom(this.nom);
        return a;
    }


}
