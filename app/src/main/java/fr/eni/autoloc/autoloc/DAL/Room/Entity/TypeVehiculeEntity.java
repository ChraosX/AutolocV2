package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.TypeVehicule;

@Entity(tableName = "type_vehicule")
public class TypeVehiculeEntity implements ParsableToBo<TypeVehicule> {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public  String nom;


    @Override
    public TypeVehicule toBo() {
        TypeVehicule tV = new TypeVehicule();
        tV.setId(this.id);
        tV.setNom(this.nom);
        return tV;
    }
}
