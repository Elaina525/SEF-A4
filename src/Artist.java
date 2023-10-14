import java.util.ArrayList;
public class Artist {
    
    private String ID;
    private String Name;
    private String Address;
    private String Birthdate;
    private String Bio;
    private ArrayList <String> Occupations;
    private ArrayList <String> Genres;
    private ArrayList <String> Awards;

    public Artist(String id, String name, String address, String birthdate, String bio, ArrayList<String> occupations,
            ArrayList<String> genres, ArrayList<String> awards) {
        ID = id;
        Name = name;
        Address = address;
        Birthdate = birthdate;
        Bio = bio;
        Occupations = occupations;
        Genres = genres;
        Awards = awards;
    }

    

    public String getID() {
        return ID;
    }



    public String getName() {
        return Name;
    }



    public String getAddress() {
        return Address;
    }



    public String getBirthdate() {
        return Birthdate;
    }



    public String getBio() {
        return Bio;
    }



    public ArrayList<String> getOccupations() {
        return Occupations;
    }



    public ArrayList<String> getGenres() {
        return Genres;
    }



    public ArrayList<String> getAwards() {
        return Awards;
    }



    public void setID(String iD) {
        ID = iD;
    }



    public void setName(String name) {
        Name = name;
    }



    public void setAddress(String address) {
        Address = address;
    }



    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }



    public void setBio(String bio) {
        Bio = bio;
    }



    public void setOccupations(ArrayList<String> occupations) {
        Occupations = occupations;
    }



    public void setGenres(ArrayList<String> genres) {
        Genres = genres;
    }



    public void setAwards(ArrayList<String> awards) {
        Awards = awards;
    }



    

}

