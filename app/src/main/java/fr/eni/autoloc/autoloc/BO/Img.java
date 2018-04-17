package fr.eni.autoloc.autoloc.BO;

public class Img {
    private  int id;
    private  String path;
    private  String description;

    public Img() {
    }

    public Img(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public Img(int id, String path, String description) {
        this.id = id;
        this.path = path;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
