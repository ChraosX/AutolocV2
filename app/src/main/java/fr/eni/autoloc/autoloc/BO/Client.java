package fr.eni.autoloc.autoloc.BO;

import java.util.List;

public class Client extends Personne {

    private Adresse adresse;
    private List<Location> locations;

    public Client() {
    }

    public Client(String nom, String prenom, String sexe, String email, String tel, Adresse adresse) {
        super(nom, prenom, sexe, email, tel);
        this.adresse = adresse;
    }

    public Client(String nom, String prenom, String sexe, String email, String tel) {
        super(nom, prenom, sexe, email, tel);
    }

    public Client(int id, String nom, String prenom, String sexe, String email, String tel, Adresse adresse) {
        super(id, nom, prenom, sexe, email, tel);
        this.adresse = adresse;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
                "adresse=" + adresse +
                '}';
    }

    @Override
    public boolean equals(Object client) {

        if (client == null)
            return false;

        if (!(client instanceof Client))
            return false;

        if (!this.adresse.equals(((Client) client).getAdresse()))
            return false;

        return true;
    }
}
