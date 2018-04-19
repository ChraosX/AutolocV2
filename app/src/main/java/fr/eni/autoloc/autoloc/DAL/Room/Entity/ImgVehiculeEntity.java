package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;


@Entity(tableName = "img_vehicule",
        foreignKeys = {
        @ForeignKey(entity = ImgEntity.class,parentColumns = "id",childColumns ="img_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = VehiculeEntity.class,parentColumns =  {"marque_id","type_id","model_id","id"},childColumns ={"marque_id","type_id","model_id","vehicule_id"},onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)
        },
        primaryKeys = {"marque_id","type_id","model_id","vehicule_id","img_id"}
        )
public class ImgVehiculeEntity {
    @ColumnInfo(name = "img_id")
    public  int imgId;
    @ColumnInfo(name = "marque_id")
    public int marqueId;
    @ColumnInfo(name = "type_id")
    public int typeId;
    @ColumnInfo(name = "model_id")
    public int modelId;
    @ColumnInfo(name = "vehicule_id")
    public int vehiculeId;

}
