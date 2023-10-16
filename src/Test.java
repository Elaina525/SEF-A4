import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Artist artist;
 
        ArtistUtil artistUtil = new ArtistUtil();
        ArrayList<String> Occupations = new ArrayList<>();
        ArrayList<String> Genres = new ArrayList<>();
        ArrayList<String> Awards = new ArrayList<>();

        String newID;
        String newName;
        String newAddress;
        String newBirthdate;
        String newBio;
        ArrayList <String> newOccupations = new ArrayList<>();
        ArrayList <String> newGenres = new ArrayList<>();
        ArrayList <String> newAwards = new ArrayList<>();

        newID = "789NEWID!!";
        newName = "Jane Doe";
        newAddress = "Sydney|NewSouthWales|Australia";
        newBirthdate = "12-12-1999";
        newBio = "New bio 3 4 5 6 7 8 9 10 11";
        newOccupations.add("Pianist");
        newGenres.add("classic");
        newGenres.add("jazz");
        newAwards.add("2023, New created awards for unit test");

        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2013, Melbourne Music Festival Season Two");
        artist = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", 
        "1 2 3 4 5 6 7 8 9 10 11 12 13", Occupations, Genres, Awards);

        artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards);

    }
}
