package ua.danit.model;

public class Users {
    private String name;
    private String url;
    private int id;

    public Users(String name, String url, int id) {
        this.name = name;
        this.url = url;
        this.id = Math.abs(Integer.parseInt((name.hashCode() + "").substring(0, 4)));


    }
    public Users(){
    }
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return name + " " + id + " " + url;
    }
}