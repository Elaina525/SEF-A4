import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtistUtil {
    public boolean addArtist(Artist artist) {
        AddConditionCheck acc = new AddConditionCheck();
        if (acc.IDCheck(artist.getID()) &&
            acc.addressCheck(artist.getAddress()) &&
            acc.awardsCheck(artist.getAwards()) &&
            acc.bioCheck(artist.getBio()) &&
            acc.birthdateCheck(artist.getBirthdate()) &&
            acc.genresCheck(artist.getGenres()) &&
            acc.occupationsCheck(artist.getOccupations())) {
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
                System.out.println("Add Failed!");
                return false;
            }
        }
        return false;
    }

    public boolean updateArtist(Artist artist, String id, String name, String address, String birthdate, String bio, ArrayList<String> occupations,
    ArrayList<String> genres, ArrayList<String> awards) {
        UpdateConditionCheck ucc = new UpdateConditionCheck();
        AddConditionCheck acc = new AddConditionCheck();
        if (ucc.birthYearCheck(artist, birthdate, occupations) && ucc.awardsCheck(artist, awards)) {
            if (acc.IDCheck(artist.getID()) &&
                acc.addressCheck(artist.getAddress()) &&
                acc.awardsCheck(artist.getAwards()) &&
                acc.bioCheck(artist.getBio()) &&
                acc.birthdateCheck(artist.getBirthdate()) &&
                acc.genresCheck(artist.getGenres()) &&
                acc.occupationsCheck(artist.getOccupations())) {
                    artist.setID(id);
                    artist.setAddress(address);
                    artist.setAwards(awards);
                    artist.setBio(bio);
                    artist.setBirthdate(birthdate);
                    artist.setGenres(genres);
                    artist.setOccupations(occupations);
                    artist.setName(name);
                    return true;
                }
        }
        System.out.println("Update Failed!");
        return false;
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
        } catch (Exception e) {
            System.out.println("Read data failed!");
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
