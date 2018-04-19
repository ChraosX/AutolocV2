package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.RestrictTo;

import fr.eni.autoloc.autoloc.BO.EtatVehicule;
import fr.eni.autoloc.autoloc.BO.Marque;
import fr.eni.autoloc.autoloc.BO.Model;
import fr.eni.autoloc.autoloc.BO.TypeVehicule;
import fr.eni.autoloc.autoloc.BO.Vehicule;

@Entity(tableName = "vehicule",
        foreignKeys = {
        @ForeignKey(entity = ModelEntity.class,parentColumns =  {"marque_id","type_id","id"},childColumns ={"marque_id","type_id","model_id"},onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = AgenceEntity.class,parentColumns = "id",childColumns ="agence_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = EtatVehicule.class,parentColumns = "id",childColumns ="etat_vehicule_id",onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.NO_ACTION)
},indices = @Index(value = "immatriculation",name="idx_imma",unique = true),
primaryKeys = {"marque_id","type_id","model_id","id"})

public class VehiculeEntity implements ParsableToBo<Vehicule>{
    @PrimaryKey(autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "model_id")
    public  int modelId;
    @ColumnInfo(name = "marque_id")
    public   int marqueId;
    @ColumnInfo(name = "type_id")
    public  int type_id;
    public  int puissance;
    @ColumnInfo (name = "agence_id")
    public  int agenceId;
    @ColumnInfo(name = "etat_vehicule_id")
    public int etatVehicule;
    public double prix;
    public  Boolean disponibilite;

    public String immatriculation;

    @Override
    public Vehicule toBo() {
        Vehicule v = new Vehicule();
        v.setId(this.id);
        v.setDisponibilite(this.disponibilite);
        v.setPrix(this.prix);
        v.setImmatriculation(this.immatriculation);
        EtatVehicule etatVehicule = new EtatVehicule();
        etatVehicule.setId(this.etatVehicule);
        v.setEtatVehicule(etatVehicule);
        Model m = new Model();

        m.setId(this.modelId);
        Marque mark = new Marque();
        mark.setId(this.marqueId);
        m.setMarque(mark);

        v.setModel(m);


        return v;
    }
}
