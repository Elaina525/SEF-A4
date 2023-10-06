import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public boolean addArtist(Artist artist) {
        ConditionCheck cc = new ConditionCheck();
        if (cc.IDCheck(artist.ID) == true &&
            cc.addressCheck(artist.Address) == true &&
            cc.awardsCheck(artist.Awards) == true &&
            cc.bioCheck(artist.Bio) == true &&
            cc.birthdateCheck(artist.Birthdate) == true &&
            cc.genresCheck(artist.Genres) == true &&
            cc.occupationsCheck(artist.Occupations) == true) {
            try {
                File file = new File("ArtistData.txt");
                FileWriter fr = new FileWriter(file, true);
                String data = String.format(
                    "ID: %s\nName: %s\nAddress: %s\nBirthdate: %s\nBio: %s\nOccupations: %s\nGenres: %s\nAwards: %s\n",
                    artist.ID, artist.Name, artist.Address, artist.Birthdate, artist.Bio,
                    artist.Occupations, artist.Genres, artist.Awards);
                fr.write(data+"-----------------------------------------------------------------------\n");
                fr.close();
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean updateArtist() {


        return true;
    }
}

