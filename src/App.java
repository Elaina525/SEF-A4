import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <String> occupation = new ArrayList<>();
        ArrayList <String> award = new ArrayList<>();
        ArrayList <String> genre = new ArrayList<>();
        occupation.add("Singer");
        award.add("2013, Melbourne Music Festival Season Two");
        genre.add("pop");
        genre.add("jazz");
        Artist a = new Artist(null, null, null, null, null, null, null, null);
        Artist artist1 = new Artist("569MMMRR!!", "John Doe", "Melbourne|Victoria|Australia", "05-11-1980", "1 2 3 4 5 6 7 8 9 10 11 12 13", occupation, genre, award);
        
        a.addArtist(artist1);
    }
}
