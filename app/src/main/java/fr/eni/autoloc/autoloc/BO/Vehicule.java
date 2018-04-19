package fr.eni.autoloc.autoloc.BO;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.List;

public class Vehicule implements Parcelable{
    private int id;
    private Model model;
    private int puissance;
    private Agence agence;
    private List<Img> listPhotos;
    private EtatVehicule etatVehicule;
    private double prix;
    private Boolean disponibilite;
    private String immatriculation;

    public Vehicule() {
    }

    public Vehicule(Model model, int puissance, Agence agence, List<Img> listPhotos, EtatVehicule etatVehicule, double prix, Boolean disponibilite, String immatriculation) {
        this.model = model;
        this.puissance = puissance;
        this.agence = agence;
        this.listPhotos = listPhotos;
        this.etatVehicule = etatVehicule;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.immatriculation = immatriculation;
    }

    public Vehicule(int id, Model model, int puissance, Agence agence, List<Img> listPhotos, EtatVehicule etatVehicule, double prix, Boolean disponibilite, String immatriculation) {
        this.id = id;
        this.model = model;
        this.puissance = puissance;
        this.agence = agence;
        this.listPhotos = listPhotos;
        this.etatVehicule = etatVehicule;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.immatriculation = immatriculation;
    }

    protected Vehicule(Parcel in) {
        id = in.readInt();
        puissance = in.readInt();
        prix = in.readDouble();
        byte tmpDisponibilite = in.readByte();
        disponibilite = tmpDisponibilite == 0 ? null : tmpDisponibilite == 1;
        immatriculation = in.readString();
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Img> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<Img> listPhotos) {
        this.listPhotos = listPhotos;
    }

    public EtatVehicule getEtatVehicule() {
        return etatVehicule;
    }

    public void setEtatVehicule(EtatVehicule etatVehicule) {
        this.etatVehicule = etatVehicule;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", model=" + model +
                ", puissance=" + puissance +
                ", agence=" + agence +
                ", listPhotos=" + listPhotos +
                ", etatVehicule=" + etatVehicule +
                ", prix=" + prix +
                ", disponibilite=" + disponibilite +
                ", immatriculation='" + immatriculation + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.id);
        dest.writeInt(this.id);
        dest.writeInt(this.id);

    }


    @Override
    public boolean equals(Object vehicule) {

        if (vehicule == null)
            return false;

        if (!(vehicule instanceof Vehicule))
            return false;

        if (this.id != ((Vehicule) vehicule).getId()
                || this.model.getId() != ((Vehicule) vehicule).getModel().getId()
                || this.puissance != ((Vehicule) vehicule).getPuissance()
                || this.agence.getId() != ((Vehicule) vehicule).getAgence().getId()
                || this.etatVehicule.getId() != ((Vehicule) vehicule).getEtatVehicule().getId()
                || this.prix != ((Vehicule) vehicule).getPrix()
                || this.disponibilite != ((Vehicule) vehicule).getDisponibilite()
                || !this.immatriculation.equals(((Vehicule) vehicule).getImmatriculation()))
            return false;

        return true;
    }
}
