package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.EtatLieux;
import fr.eni.autoloc.autoloc.BO.EtatVehicule;
import fr.eni.autoloc.autoloc.BO.Location;


@Entity(tableName = "etat_lieux",
        foreignKeys = {
        @ForeignKey(entity = EtatVehiculeEntity.class,parentColumns = "id",childColumns = "etat_debut_id"),
        @ForeignKey(entity = EtatVehiculeEntity.class,parentColumns = "id",childColumns = "etat_fin_id"),
        @ForeignKey(entity = LocationEntity.class,parentColumns = "id",childColumns = "location_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)

},indices = @Index(value = {"location_id","id"},name = "idx_pk_el",unique = true))

public class EtatLieuxEntity implements ParsableToBo<EtatLieux>{
    @PrimaryKey(autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "location_id")
    public int locationId;
    @ColumnInfo(name = "etat_debut_id")
    public int etatDebut;
    @ColumnInfo(name = "etat_fin_id")
    public  int etatFin;
    public String descriptionEDebut;
    public String descriptionEFin;


    @Override
    public EtatLieux toBo() {
        EtatLieux eL = new EtatLieux();

        eL.setId(this.id);
        eL.setDescriptionEDebut(this.descriptionEDebut);
        eL.setDescriptionEFin(this.descriptionEFin);
        EtatVehicule evD = new EtatVehicule();
        EtatVehicule evF = new EtatVehicule();
        evD.setId(this.etatDebut);
        evF.setId(this.etatFin);
        eL.setEtatDebut(evD);
        eL.setEtatFin(evF);
        Location l = new Location();
        l.setId(this.locationId);
        eL.setLocation(l);

        return eL;
    }
}
