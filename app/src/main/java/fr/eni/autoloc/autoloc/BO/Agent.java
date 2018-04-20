package fr.eni.autoloc.autoloc.BO;

import android.arch.persistence.room.Ignore;

public class Agent extends Personne{
    @Ignore
    private Agence agence;
    private String passwd;

    public Agent() {
    }

    public Agent(Agence a) {
        this.agence = a;
    }

    public Agent(String nom, String prenom, String sexe, String email, String tel, Agence agence, String passwd) {
        super(nom, prenom, sexe, email, tel);
        this.agence = agence;
        this.passwd = passwd;
    }

    public Agent(int id, String nom, String prenom, String sexe, String email, String tel, Agence agence, String passwd) {
        super(id, nom, prenom, sexe, email, tel);
        this.agence = agence;
        this.passwd = passwd;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agence=" + agence +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object agent) {

        if (agent == null)
            return false;

        if (!(agent instanceof Agent))
            return false;

        if (this.agence.getId() != ((Agent) agent).getAgence().getId()
                || !this.passwd.equals(((Agent) agent).getPasswd()))
            return false;

        return true;
    }
}
