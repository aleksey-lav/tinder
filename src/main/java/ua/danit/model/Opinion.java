package ua.danit.model;

public class Opinion {
    private String who;
    private String whom;
    private String opinion;

    public Opinion(String who, String whom, String opinion) {
        this.who = who;
        this.whom = whom;
        this.opinion = opinion;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}

