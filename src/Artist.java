import java.util.ArrayList;
public class Artist {
    
    private String ID;
    private String Name;
    private String Address;
    private String Birthdata;
    private String Bio;
    private ArrayList <String> Occupations;
    private ArrayList <String> Genres;
    private ArrayList <String> Awards;

    public Artist(String iD, String name, String address, String birthdata, String bio, ArrayList<String> occupations,
            ArrayList<String> genres, ArrayList<String> awards) {
        ID = iD;
        Name = name;
        Address = address;
        Birthdata = birthdata;
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
