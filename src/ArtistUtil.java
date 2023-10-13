import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtistUtil {
    public boolean addArtist(Artist artist) {
        AddConditionCheck acc = new AddConditionCheck();
        if (acc.IDCheck(artist.getID()) == true &&
            acc.addressCheck(artist.getAddress()) == true &&
            acc.awardsCheck(artist.getAwards()) == true &&
            acc.bioCheck(artist.getBio()) == true &&
            acc.birthdateCheck(artist.getBirthdate()) == true &&
            acc.genresCheck(artist.getGenres()) == true &&
            acc.occupationsCheck(artist.getOccupations()) == true) {
            try {
                File file = new File("ArtistData.txt");
                FileWriter fr = new FileWriter(file, true);
                String data = String.format(
                    "ID: %s\nName: %s\nAddress: %s\nBirthdate: %s\nBio: %s\nOccupations: %s\nGenres: %s\nAwards: %s\n",
                    artist.getID(), artist.getName(), artist.getAddress(), artist.getBirthdate(), artist.getBio(),
                    artist.getOccupations(), artist.getGenres(), artist.getAwards());
                fr.write(data+"-----------------------------------------------------------------------\n");
                fr.close();
                return true;
            }
            catch (Exception e) {
                System.out.println("Artist add failed, please try again!");
                return false;
            }
        }
        return true;
    }

    public boolean updateArtist() {


        return true;
    }

    public ArrayList<Artist> getArtists() {
    ArrayList<Artist> artists = new ArrayList<>();
        try {
            File file = new File("ArtistData.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line;
                Artist artist = new Artist(null, null, null, null, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                
                while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
                    if (line.equals("-----------------------------------------------------------------------")) {
                        break;  // Skip separator line
                    }
                    String[] parts = line.split(": ");
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "ID":
                            artist.setID(value);
                            break;
                        case "Name":
                            artist.setName(value);
                            break;
                        case "Address":
                            artist.setAddress(value);
                            break;
                        case "Birthdate":
                            artist.setBirthdate(value);
                            break;
                        case "Bio":
                            artist.setBio(value);
                            break;
                        case "Occupations":
                            artist.setOccupations(parseList(value));
                            break;
                        case "Genres":
                            artist.setGenres(parseList(value));
                            break;
                        case "Awards":
                            artist.setAwards(parseList(value));
                            break;
                    }
                }
                artists.add(artist);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return artists;
    }

    private static ArrayList<String> parseList(String input) {
        ArrayList<String> list = new ArrayList<>();
        String[] elements = input.substring(1, input.length() - 1).split(", ");
        for (String element : elements) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        ArtistUtil au = new ArtistUtil();
        au.getArtists();
    }
}
