package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "img_etat_lieux",foreignKeys = {
        @ForeignKey(entity = ImgEntity.class , parentColumns = "id",childColumns = "img_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = EtatLieuxEntity.class, parentColumns ={ "location_id","id"},childColumns = {"location_id","etat_lieux_id"},onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)
        },primaryKeys = {"etat_lieux_id","img_id"}
)
public class ImgEtatLieuxEntity {
    @ColumnInfo(name = "etat_lieux_id")
    public int etatLieuxId;
    @ColumnInfo(name = "img_id")
    public int imgId;

}
