package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.EtatVehicule;

@Entity(tableName = "etat_vehicule")
public class EtatVehiculeEntity implements ParsableToBo<EtatVehicule> {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String nom;

    @Override
    public EtatVehicule toBo() {

        EtatVehicule ev = new EtatVehicule();
        ev.setId(this.id);
        ev.setNom(this.nom);
        return ev;
    }
}
