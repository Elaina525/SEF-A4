import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArtistUtil artistUtil = new ArtistUtil();
        ArrayList<String> Occupations = new ArrayList<>();
        ArrayList<String> Genres = new ArrayList<>();
        ArrayList<String> Awards = new ArrayList<>();
        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2013, Melbourne Music Festival Season Two");
        Artist artist = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", 
        "1 2 3 4 5 6 7 8 9 10 11 12 13", Occupations, Genres, Awards);
        artistUtil.addArtist(artist);
        // artistUtil.updateArtist(artist, "789AAAAA!!", artist.getName(), artist.getAddress(), artist.getBirthdate(), artist.getBio(), Occupations, Genres, Awards);
    }

}