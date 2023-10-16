import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

public class AddArtistTest {

    Artist artist;    
    ArtistUtil artistUtil = new ArtistUtil();
    ArrayList<String> Occupations = new ArrayList<>();
    ArrayList<String> Genres = new ArrayList<>();
    ArrayList<String> Awards = new ArrayList<>();
    @BeforeEach

    public void SetUp() {
        
        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2013, Melbourne Music Festival Season Two");
        artist = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", 
        "1 2 3 4 5 6 7 8 9 10 11 12 13", Occupations, Genres, Awards);

    }

    @Test
    public void testValidArtist() {
        assertTrue(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidID() {
        artist.setID("Invalid");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidAddress() {
        artist.setAddress("Invalid");
        assertFalse(artistUtil.addArtist(artist));
    }
    
    @Test
    public void testInvalidBirthdate() {
        artist.setBirthdate("Invalid");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidBio() {
        artist.setBio("Invalid");
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidOccupation() {
        Occupations.clear();
        artist.setOccupations(Occupations);
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidGenre() {
        Genres.clear();
        artist.setGenres(Genres);
        assertFalse(artistUtil.addArtist(artist));
    }

    @Test
    public void testInvalidAward() {
        Awards.clear();
        Awards.add("Invalid");
        artist.setAwards(Awards);
        assertFalse(artistUtil.addArtist(artist));
    }
}
