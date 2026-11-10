package murach.business;

import java.io.Serializable;

public class Survey implements Serializable {
    private User user;
    private String heardFrom;
    private String wantRef;
    private String wantUpdates;
    private String contactVia;

    public Survey() {
        user = new User();
        heardFrom = "";
        wantRef = "";
        wantUpdates = "";
        contactVia = "";
    }

    public Survey(User user, String heardFrom, String wantRef, String wantUpdates, String contactVia) {
        this.user = user;
        this.heardFrom = heardFrom;
        this.wantRef = wantRef;
        this.wantUpdates = wantUpdates;
        this.contactVia = contactVia;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getHeardFrom() { return heardFrom; }
    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    public String getWantRef() { return wantRef; }
    public void setWantRef(String wantRef) { this.wantRef = wantRef; }

    public String getWantUpdates() { return wantUpdates; }
    public void setWantUpdates(String wantUpdates) { this.wantUpdates = wantUpdates; }

    public String getContactVia() { return contactVia; }
    public void setContactVia(String contactVia) { this.contactVia = contactVia; }
}