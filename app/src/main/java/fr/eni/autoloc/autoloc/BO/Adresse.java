package fr.eni.autoloc.autoloc.BO;

public class Adresse {

    private int id;
    private String codePostal;
    private String ville;
    private String rue;
    private int    numRue;

    public Adresse() {
    }

    public Adresse( String codePostal, String ville, String rue, int numRue) {
        this.id = id;
        this.codePostal = codePostal;
        this.ville = ville;
        this.rue = rue;
        this.numRue = numRue;
    }

    public Adresse(int id, String codePostal, String ville, String rue, int numRue) {
        this.id = id;
        this.codePostal = codePostal;
        this.ville = ville;
        this.rue = rue;
        this.numRue = numRue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }


    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                ", numRue=" + numRue +
                '}';
    }

    @Override
    public boolean equals(Object adresse) {
        if (adresse == null)
            return false;

        if (!(adresse instanceof Adresse))
            return false;

        if (this.id != ((Adresse) adresse).getId()
                || !this.codePostal.equals(((Adresse) adresse).getCodePostal())
                || !this.ville.equals(((Adresse) adresse).getVille())
                || !this.rue.equals(((Adresse) adresse).getRue())
                || this.numRue != ((Adresse) adresse).getNumRue())
            return false;

        return true;
    }
}
