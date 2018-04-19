package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Img;
import fr.eni.autoloc.autoloc.BO.Marque;
import fr.eni.autoloc.autoloc.BO.Model;
import fr.eni.autoloc.autoloc.BO.TypeVehicule;

@Entity(tableName = "moddel",primaryKeys = {"marque_id","type_id","id"},
        foreignKeys = { @ForeignKey(entity = ImgEntity.class , parentColumns = "id",childColumns = "img_id",onDelete = ForeignKey.SET_NULL,onUpdate = ForeignKey.CASCADE),
                        @ForeignKey(entity = MarqueEntity.class , parentColumns = "id",childColumns = "marque_id",onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE),
                        @ForeignKey(entity = TypeVehiculeEntity.class , parentColumns = "id",childColumns = "type_id",onDelete = ForeignKey.NO_ACTION,onUpdate = ForeignKey.CASCADE)})

public class ModelEntity implements ParsableToBo<Model> {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "marque_id")
    public int marqueId;

    @ColumnInfo(name = "type_id")
    public int typeId;
    public  String nom;
    @ColumnInfo(name = "img_id")
    public int imgId;

    @Override
    public Model toBo() {
        Model m = new Model();
        Marque marque = new Marque();
        marque.setId(this.marqueId);

        m.setMarque(marque);
        m.setId(this.id);
        m.setNom(this.nom);
        TypeVehicule tV = new TypeVehicule();
        tV.setId(this.typeId);
        Img i = new Img();
        i.setId(this.imgId);
        m.setImg(i);

        return m;
    }
}
