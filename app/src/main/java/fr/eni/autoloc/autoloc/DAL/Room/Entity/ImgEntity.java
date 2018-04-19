package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Img;

@Entity(tableName = "img")
public class ImgEntity implements ParsableToBo<Img> {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String path;
    public  String description;

    @Override
    public Img toBo() {
        Img img = new Img();
        img.setId(this.id);
        img.setDescription(this.description);
        img.setPath(this.path);

        return img;
    }
}
