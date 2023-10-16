import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class UpdateArtistTests {
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

    @BeforeEach
    public void SetUp() {
        newID = "789NEWID!!";
        newName = "Jane Doe";
        newAddress = "Sydney|NewSouthWales|Australia";
        newBirthdate = "12-12-1999";
        newBio = "New bio 3 4 5 6 7 8 9 10 11";
        newOccupations.add("Pianist");
        newGenres.add("classic");
        newGenres.add("jazz");
        newAwards.add("2013, New created awards for unit test");

        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2013, Melbourne Music Festival Season Two");
        artist = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", 
        "1 2 3 4 5 6 7 8 9 10 11 12 13", Occupations, Genres, Awards);
    }

    @Test
    public void testValidArtist() {
        newBirthdate = "12-12-2020";
        assertTrue(artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards));
        newBirthdate = "12-12-1999";
        assertTrue(artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards));
    }

    @Test
    public void testInvalidBirthYear() {
        newBirthdate = "12-12-1999";
        assertFalse(artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards));

    }

    @Test
    public void testInvalidAwards() {
        newAwards.clear();
        newAwards.add("2012, Melbourne Music Festival Season Two");
        assertFalse(artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards));
        Awards.clear();
        newAwards.clear();
        Awards.add("1999, Melbourne Music Festival Season Two");
        newAwards.add("1999, 123 Melbourne Music Festival Season Two");
        assertFalse(artistUtil.updateArtist(artist, newID, newName, newAddress, newBirthdate, newBio, newOccupations, newGenres, newAwards));
    }
}
