package ua.danit.model;

public class Users {
    private String name;
    private String url;

    public Users(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
}