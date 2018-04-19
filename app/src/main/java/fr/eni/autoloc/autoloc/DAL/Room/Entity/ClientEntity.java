package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Adresse;
import fr.eni.autoloc.autoloc.BO.Client;

@Entity(tableName = "client",
        foreignKeys = @ForeignKey(entity = PersonneEntity.class,parentColumns = "id",childColumns = "personne_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE))
public class ClientEntity implements ParsableToBo<Client> {
    @PrimaryKey
    @ColumnInfo(name = "personne_id")
    public int personneId;

    @Embedded
    public Adresse adresse;

    @Override
    public Client toBo() {
        Client c = new Client();
        c.setId(this.personneId);
        c.setAdress(this.adresse);
        return c;
    }
}
