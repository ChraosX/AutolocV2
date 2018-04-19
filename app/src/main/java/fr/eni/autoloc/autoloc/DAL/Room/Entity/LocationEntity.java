package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import fr.eni.autoloc.autoloc.BO.Client;
import fr.eni.autoloc.autoloc.BO.EtatLieux;
import fr.eni.autoloc.autoloc.BO.Location;
import fr.eni.autoloc.autoloc.BO.Marque;
import fr.eni.autoloc.autoloc.BO.Model;
import fr.eni.autoloc.autoloc.BO.Vehicule;


@Entity(tableName = "location",
        foreignKeys = {
                @ForeignKey(entity = VehiculeEntity.class,parentColumns =  {"marque_id","type_id","model_id","id"},childColumns ={"marque_id","type_id","model_id","vehicule_id"},onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.NO_ACTION),
                @ForeignKey(entity = ClientEntity.class,parentColumns = "personne_id",childColumns = "client_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = EtatLieuxEntity.class,parentColumns = "id",childColumns = "etat_lieux_id",onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.NO_ACTION)

        })
public class LocationEntity implements ParsableToBo<Location> {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "marque_id")
    public int marqueId;
    @ColumnInfo(name = "type_id")
    public int typeId;
    @ColumnInfo(name = "model_id")
    public int modelId;
    @ColumnInfo(name = "vehicule_id")
    public int vehiculeId;
    @ColumnInfo(name = "client_id")
    public int clientId;
    @ColumnInfo(name = "etat_lieux_id")
    public int etatLieuxId;
    @ColumnInfo(name="date_debut")
    public Date dateDebut;
    @ColumnInfo(name = "date_fin")
    public Date dateFin;

    public  double prix;


    @Override
    public Location toBo() {
        Location l = new Location();
        l.setId(this.id);
        Vehicule v = new Vehicule();
        v.setId(this.vehiculeId);
        Model m = new Model();
        m.setId(this.modelId);
        Marque mark = new Marque();
        mark.setId(this.marqueId);
        m.setMarque(mark);
        v.setModel(m);
        v.setId(this.vehiculeId);
        l.setVehicule(v);
        Client c = new Client();
        c.setId(this.clientId);
        l.setClient(c);
        EtatLieux eT = new EtatLieux();
        eT.setId(this.etatLieuxId);
        l.setEtatLieux(eT);
        l.setPrix(this.prix);

        return l;
    }
}
