package fr.eni.autoloc.autoloc.BO;

public class TypeVehicule {
    private int id;
    private String nom;

    public TypeVehicule() {
    }

    public TypeVehicule(String nom) {
        this.nom = nom;
    }

    public TypeVehicule(int id, String nom) {
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
        return "TypeVehicule{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
