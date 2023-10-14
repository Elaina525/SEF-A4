import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArtistUtil artistUtil = new ArtistUtil();
        ArrayList<Artist> artists = artistUtil.getArtists();
        artistUtil.updateArtist(artists.get(0), null, null, null, null, null, null, null, null);
    }

}