package fr.eni.autoloc.autoloc.BO;

import java.util.List;

public class Client extends Personne {

    private Adresse adress;
    private List<Location> locations;

    public Client() {
    }

    public Client(String nom, String prenom, String sexe, String email, String tel, Adresse adress) {
        super(nom, prenom, sexe, email, tel);
        this.adress = adress;
    }

    public Client(String nom, String prenom, String sexe, String email, String tel) {
        super(nom, prenom, sexe, email, tel);
    }

    public Client(int id, String nom, String prenom, String sexe, String email, String tel, Adresse adress) {
        super(id, nom, prenom, sexe, email, tel);
        this.adress = adress;
    }


    public Adresse getAdress() {
        return adress;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Client{" +
                "adress=" + adress +
                '}';
    }
}
