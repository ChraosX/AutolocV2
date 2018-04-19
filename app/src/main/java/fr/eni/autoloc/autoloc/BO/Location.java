package fr.eni.autoloc.autoloc.BO;

import java.util.Date;

public class Location {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private Vehicule vehicule;
    private Client client;
    private double prix;
    private EtatLieux etatLieux;

    public Location() {
    }

    public Location(Date dateDebut, Date dateFin, Vehicule vehicule, Client client, double prix, EtatLieux etatLieux) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.vehicule = vehicule;
        this.client = client;
        this.prix = prix;
        this.etatLieux = etatLieux;
    }

    public Location(int id, Date dateDebut, Date dateFin, Vehicule vehicule, Client client, double prix, EtatLieux etatLieux) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.vehicule = vehicule;
        this.client = client;
        this.prix = prix;
        this.etatLieux = etatLieux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public EtatLieux getEtatLieux() {
        return etatLieux;
    }

    public void setEtatLieux(EtatLieux etatLieux) {
        this.etatLieux = etatLieux;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", vehicule=" + vehicule +
                ", client=" + client +
                ", prix=" + prix +
                ", etatLieux=" + etatLieux +
                '}';
    }

    @Override
    public boolean equals(Object location) {

        if (location == null)
            return false;

        if (!(location instanceof Location))
            return false;

        if (this.id != ((Location) location).getId()
                || this.dateDebut.equals(((Location) location).getDateDebut())
                || this.dateFin.equals(((Location) location).getDateFin())
                || !this.vehicule.equals(((Location) location).getVehicule())
                || this.client.getId() != ((Location) location).getClient().getId()
                || this.prix != ((Location) location).getPrix()
                || this.etatLieux.equals(((Location) location).getEtatLieux()))
            return false;

        return true;
    }
}
