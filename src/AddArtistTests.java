import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

public class AddArtistTests {

    // Create artist and other needed objects
    Artist artist;
 
    ArtistUtil artistUtil = new ArtistUtil();
    ArrayList<String> Occupations = new ArrayList<>();
    ArrayList<String> Genres = new ArrayList<>();
    ArrayList<String> Awards = new ArrayList<>();
    
    @BeforeEach
    public void SetUp() {
        // Intialize the artist to a valid one
        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2013, Melbourne Music Festival Season Two");
        artist = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", 
        "1 2 3 4 5 6 7 8 9 10 11 12 13", Occupations, Genres, Awards);
    }

    @Test
    public void testValidArtist() {
        // Test if valid returns true
        assertTrue(artistUtil.addArtist(artist));
        artist.setID("987ABCDE_%");
        assertTrue(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidID() {
        // Test if invalid ID returns false
        artist.setID("");
        assertFalse(artistUtil.addArtist(artist));
        artist.setID("569MMMRR!");
        assertFalse(artistUtil.addArtist(artist));
        artist.setID("123MMMRR!!");
        assertFalse(artistUtil.addArtist(artist));
        artist.setID("569mmmrr!!");
        assertFalse(artistUtil.addArtist(artist));
        artist.setID("569MMMRRRR");
        assertFalse(artistUtil.addArtist(artist));
        artist.setID("569MMMRR!!!");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidAddress() {
        // Test if invalid address returns false
        artist.setAddress("Invalid");
        assertFalse(artistUtil.addArtist(artist));
        artist.setAddress("Invalid");
        assertFalse(artistUtil.addArtist(artist));
        artist.setAddress("Invalid|");
        assertFalse(artistUtil.addArtist(artist));
        artist.setAddress("Invalid|Invalid");
        assertFalse(artistUtil.addArtist(artist));
        artist.setAddress("Invalid|Invalid|");
        assertFalse(artistUtil.addArtist(artist));
        artist.setAddress("Invalid|Invalid|Invalid|");
        assertFalse(artistUtil.addArtist(artist));
    }
    
    @Test
    public void testInvalidBirthdate() {
        // Test if invalid birthdate returns false
        artist.setBirthdate("");
        assertFalse(artistUtil.addArtist(artist));
        artist.setBirthdate("Invalid");
        assertFalse(artistUtil.addArtist(artist));
        artist.setBirthdate("01/01/2023");
        assertFalse(artistUtil.addArtist(artist));
        artist.setBirthdate("01012023");
        assertFalse(artistUtil.addArtist(artist));
        artist.setBirthdate("1Jan2023");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidBio() {
        // Test if invalid bio returns false
        artist.setBio("Too short");
        assertFalse(artistUtil.addArtist(artist));
        artist.setBio("Too long 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 41 43 44 45 46 47 48 49 50 51");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidOccupation() {
        // Test if invalid occupation returns false
        Occupations.clear();
        artist.setOccupations(Occupations);
        assertFalse(artistUtil.addArtist(artist));
        Occupations.add("1");
        Occupations.add("2");
        Occupations.add("3");
        Occupations.add("4");
        Occupations.add("5");
        Occupations.add("6");
        artist.setOccupations(Occupations);
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidGenre() {
        // Test if invalid genre returns false
        Genres.clear();
        artist.setGenres(Genres);
        assertFalse(artistUtil.addArtist(artist));

        Genres.add("1");
        artist.setGenres(Genres);
        assertFalse(artistUtil.addArtist(artist));

        Genres.add("2");
        Genres.add("3");
        Genres.add("4");
        Genres.add("5");
        Genres.add("6");
        artist.setGenres(Genres);
        assertFalse(artistUtil.addArtist(artist));

        Genres.clear();
        Genres.add("pop");
        Genres.add("rock");
        artist.setGenres(Genres);
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidAward() {
        // Test if invalid award returns false
        Awards.clear();
        Awards.add("Invalid");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
        Awards.clear();
        Awards.add("Year, and the description of awards");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
        Awards.clear();
        Awards.add("2000, too short");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
        Awards.clear();
        Awards.add("2000, too long 3 4 5 6 7 8 9 10 11");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
        Awards.clear();
        Awards.add("2001, and the description of awards");
        Awards.add("2002, and the description of awards");
        Awards.add("2003, and the description of awards");
        Awards.add("2004, and the description of awards");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
    }
}
