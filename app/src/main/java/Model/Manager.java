package Model;

public class Manager {

    private String MgID;
    private String pass;
    private String name;
    public Manager(){}
    public Manager(String mgID, String pass, String name) {
        MgID = mgID;
        this.pass = pass;
        this.name = name;
    }

    public String getMgID() {
        return MgID;
    }

    public void setMgID(String mgID) {
        MgID = mgID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
