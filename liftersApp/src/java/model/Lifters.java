package model;

/**
 *
 * @author itzjs
 */
public class Lifters {
    
    private int lifterID;
    private String lifterName;
    private int lifterAge;
    private int lifterWeight;
    private String lifterHeight;
    private String lifterClass;

    public Lifters() {
        this.lifterID = 0;
        this.lifterName ="";
        this.lifterAge = 0;
        this.lifterWeight = 0;
        this.lifterHeight = "";
        this.lifterClass = "";
    }

    
    
    public Lifters(int lifterID, String lifterName, int lifterAge, int lifterWeight, String lifterHeight, String lifterClass) {
        this.lifterID = lifterID;
        this.lifterName = lifterName;
        this.lifterAge = lifterAge;
        this.lifterWeight = lifterWeight;
        this.lifterHeight = lifterHeight;
        this.lifterClass = lifterClass;
    }
    
    public int getLifterID() {
        return lifterID;
    }

    public void setLifterID(int lifterID) {
        this.lifterID = lifterID;
    }

    public String getLifterName() {
        return lifterName;
    }

    public void setLifterName(String lifterName) {
        this.lifterName = lifterName;
    }

    public int getLifterAge() {
        return lifterAge;
    }

    public void setLifterAge(int lifterAge) {
        this.lifterAge = lifterAge;
    }

    public int getLifterWeight() {
        return lifterWeight;
    }

    public void setLifterWeight(int lifterWeight) {
        this.lifterWeight = lifterWeight;
    }

    public String getLifterHeight() {
        return lifterHeight;
    }

    public void setLifterHeight(String lifterHeight) {
        this.lifterHeight = lifterHeight;
    }

    public String getLifterClass() {
        return lifterClass;
    }

    public void setLifterClass(String lifterClass) {
        this.lifterClass = lifterClass;
    }

    @Override
    public String toString() {
        return "Lifters{" + "lifterID=" + lifterID + ", lifterName=" + lifterName + ", lifterAge=" + lifterAge + ", lifterWeight=" + lifterWeight + ", lifterHeight=" + lifterHeight + ", lifterClass=" + lifterClass + '}';
    }
    
    
    
    
}
