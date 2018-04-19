package fr.eni.autoloc.autoloc.DAL.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import fr.eni.autoloc.autoloc.BO.Agence;
import fr.eni.autoloc.autoloc.BO.Agent;

@Entity(tableName = "agent",
        foreignKeys = {
                @ForeignKey(entity = PersonneEntity.class,parentColumns = "id",childColumns = "personne_id",onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = AgenceEntity.class,parentColumns = "id",childColumns = "agence_id",onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE)
        })
public class AgentEntity implements ParsableToBo<Agent>{
    @PrimaryKey
    @ColumnInfo(name = "personne_id")
    public  int personneId;
    @ColumnInfo(name="agence_id")
    public int agenceId;

    public String passwd;

    @Override
    public Agent toBo() {
        Agence agence = new Agence();
        agence.setId(this.agenceId);
        Agent a = new Agent(agence);
        a.setId(this.personneId);
        a.setPasswd(this.passwd);
        
        return null;
    }
}
