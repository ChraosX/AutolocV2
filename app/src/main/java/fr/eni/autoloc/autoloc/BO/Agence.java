package fr.eni.autoloc.autoloc.BO;

import java.util.List;

public class Agence {
    private  int id;
    private  String nom;
    private  Adresse adresse;
    private List<Vehicule> vehicules;
    private List<Agent> agents;


    public Agence() {
    }

    public Agence(String nom, Adresse adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public Agence(String nom, Adresse adresse, List<Vehicule> vehicules, List<Agent> agents) {
        this.nom = nom;
        this.adresse = adresse;
        this.vehicules = vehicules;
        this.agents = agents;
    }

    public Agence(int id, String nom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Agence(int id, String nom, Adresse adresse, List<Vehicule> vehicules, List<Agent> agents) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.vehicules = vehicules;
        this.agents = agents;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse=" + adresse +
                ", vehicules=" + vehicules +
                ", agents=" + agents +
                '}';
    }
}
