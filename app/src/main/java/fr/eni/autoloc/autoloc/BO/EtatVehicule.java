package fr.eni.autoloc.autoloc.BO;

public class EtatVehicule {
    private int id;
    private String nom;

    public EtatVehicule() {
    }

    public EtatVehicule(String nom) {
        this.nom = nom;
    }

    public EtatVehicule(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "EtatVehicule{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object etatVehicule) {

        if (etatVehicule == null)
            return false;

        if (!(etatVehicule instanceof EtatVehicule))
            return false;

        if (this.id != ((EtatVehicule) etatVehicule).getId()
                || !this.nom.equals(((EtatVehicule) etatVehicule).getNom()))
            return false;

        return true;
    }
}
