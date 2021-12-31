package App.Data;

public class Student {

    private int matrikelnumber;
    private String firstName;
    private String LastName;
    private int studies;

    //constructor

    public Student(int matrikelnr, String firstName, String lastName, int studies) {
        this.matrikelnumber = matrikelnr;
        this.firstName = firstName;
        this.LastName = lastName;
        this.studies = studies;
    }

    //toString method
    @Override
    public String toString() {
        return "Student [matrikel number=" + matrikelnumber + ", first name = " + firstName + ", last name =" + LastName
                + ", studies = " + studies + "]";
    }

    //getters and setters

    public int getMatrikelnr() {
        return matrikelnumber;
    }

    public void setMatrikelnr(int matrikelnr) {
        this.matrikelnumber = matrikelnr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public int getStudies() {
        return studies;
    }

    public void setStudies(int studies) {
        this.studies = studies;
    }

}
