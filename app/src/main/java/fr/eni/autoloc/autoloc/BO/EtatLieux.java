package fr.eni.autoloc.autoloc.BO;

import java.util.List;

public class EtatLieux {
        private  int id;
        private  Location location;
        private  EtatVehicule etatDebut;
        private  EtatVehicule etatFin;
        private String descriptionEDebut;
        private String descriptionEFin;
        private List<Img> listImgDebut;
        private List<Img> listImgFin;

    public EtatLieux() {
    }

    public EtatLieux(Location location) {
        this.location = location;
    }

    public EtatLieux(Location location, EtatVehicule etatDebut, EtatVehicule etatFin, String descriptionEDebut, String descriptionEFin, List<Img> listImgDebut, List<Img> listImgFin) {
        this.location = location;
        this.etatDebut = etatDebut;
        this.etatFin = etatFin;
        this.descriptionEDebut = descriptionEDebut;
        this.descriptionEFin = descriptionEFin;
        this.listImgDebut = listImgDebut;
        this.listImgFin = listImgFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EtatVehicule getEtatDebut() {
        return etatDebut;
    }

    public void setEtatDebut(EtatVehicule etatDebut) {
        this.etatDebut = etatDebut;
    }

    public EtatVehicule getEtatFin() {
        return etatFin;
    }

    public void setEtatFin(EtatVehicule etatFin) {
        this.etatFin = etatFin;
    }

    public String getDescriptionEDebut() {
        return descriptionEDebut;
    }

    public void setDescriptionEDebut(String descriptionEDebut) {
        this.descriptionEDebut = descriptionEDebut;
    }

    public String getDescriptionEFin() {
        return descriptionEFin;
    }

    public void setDescriptionEFin(String descriptionEFin) {
        this.descriptionEFin = descriptionEFin;
    }

    public List<Img> getListImgDebut() {
        return listImgDebut;
    }

    public void setListImgDebut(List<Img> listImgDebut) {
        this.listImgDebut = listImgDebut;
    }

    public List<Img> getListImgFin() {
        return listImgFin;
    }

    public void setListImgFin(List<Img> listImgFin) {
        this.listImgFin = listImgFin;
    }

    @Override
    public String toString() {
        return "EtatLieux{" +
                "id=" + id +
                ", location=" + location +
                ", etatDebut=" + etatDebut +
                ", etatFin=" + etatFin +
                ", descriptionEDebut='" + descriptionEDebut + '\'' +
                ", descriptionEFin='" + descriptionEFin + '\'' +
                ", listImgDebut=" + listImgDebut +
                ", listImgFin=" + listImgFin +
                '}';
    }
}
