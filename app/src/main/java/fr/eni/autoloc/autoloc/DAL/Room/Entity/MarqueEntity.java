package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Marque;

@Entity(tableName = "marque")
public class MarqueEntity implements ParsableToBo<Marque>{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;

    @Override
    public Marque toBo() {
        Marque m = new Marque();
        m.setId(this.id);
        m.setNom(this.nom);
        return m;
    }
}
