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

    public Artist(String iD, String name, String address, String birthdate, String bio, ArrayList<String> occupations,
            ArrayList<String> genres, ArrayList<String> awards) {
        ID = iD;
        Name = name;
        Address = address;
        Birthdate = birthdate;
        Bio = bio;
        Occupations = occupations;
        Genres = genres;
        Awards = awards;
    }

    public boolean addArtist() {


        return true;
    }

    public boolean updateArtist() {


        return true;
    }

}
