package fr.eni.autoloc.autoloc.BO;

import android.arch.persistence.room.Ignore;

public class Model {
    private int id;
    @Ignore
    private Marque marque;
    @Ignore
    private TypeVehicule type;
    private String nom;
    @Ignore
    private Img img;

    public Model() {
    }

    public Model(Marque marque, TypeVehicule type, String nom) {
        this.marque = marque;
        this.type = type;
        this.nom = nom;
    }

    public Model(int id, Marque marque, TypeVehicule type, String nom) {
        this.id = id;
        this.marque = marque;
        this.type = type;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public TypeVehicule getType() {
        return type;
    }

    public void setType(TypeVehicule type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", marque=" + marque +
                ", type=" + type +
                ", nom='" + nom + '\'' +
                '}';
    }
}
