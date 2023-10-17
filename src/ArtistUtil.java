import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtistUtil {
    public boolean addArtist(Artist artist) {
        AddConditionCheck acc = new AddConditionCheck();
        // Check if all elements in the artist if valid
        if (acc.IDCheck(artist.getID()) &&
            acc.addressCheck(artist.getAddress()) &&
            acc.awardsCheck(artist.getAwards()) &&
            acc.bioCheck(artist.getBio()) &&
            acc.birthdateCheck(artist.getBirthdate()) &&
            acc.genresCheck(artist.getGenres()) &&
            acc.occupationsCheck(artist.getOccupations())) {
            // If valid, try to write the data of this artist to txt file
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
            // Catch and print exceptions
            catch (Exception e) {
                System.out.println(e);
                System.out.println("Add Failed!");
                return false;
            }
        }
        // If the artist contains invalid data, return false
        return false;
    }

    public boolean updateArtist(Artist artist, String id, String name, String address, String birthdate, String bio, ArrayList<String> occupations,
    ArrayList<String> genres, ArrayList<String> awards) {
        UpdateConditionCheck ucc = new UpdateConditionCheck();
        AddConditionCheck acc = new AddConditionCheck();
        // Check for birthyear and awards, which has limitations in updating
        if (ucc.birthYearCheck(artist, birthdate, occupations) && ucc.awardsCheck(artist, awards)) {
            // Check for new elements of the artist
            if (acc.IDCheck(id) &&
                acc.addressCheck(address) &&
                acc.awardsCheck(awards) &&
                acc.bioCheck(bio) &&
                acc.birthdateCheck(birthdate) &&
                acc.genresCheck(genres) &&
                acc.occupationsCheck(occupations)) {
                    artist.setID(id);
                    artist.setAddress(address);
                    artist.setAwards(awards);
                    artist.setBio(bio);
                    artist.setBirthdate(birthdate);
                    artist.setGenres(genres);
                    artist.setOccupations(occupations);
                    artist.setName(name);
                    try {
                        File file = new File("ArtistData.txt");
                        FileWriter fr = new FileWriter(file);
                        String data = String.format(
                            "ID: %s\nName: %s\nAddress: %s\nBirthdate: %s\nBio: %s\nOccupations: %s\nGenres: %s\nAwards: %s\n",
                            artist.getID(), artist.getName(), artist.getAddress(), artist.getBirthdate(), artist.getBio(),
                            artist.getOccupations(), artist.getGenres(), artist.getAwards());
                        fr.write(data+"-----------------------------------------------------------------------\n");
                        fr.close();
                        return true;
                    }
                    // Catch and print exceptions
                    catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Add Failed!");
                        return false;
                    }
                } else {
                    // Contains invalid element
                    System.out.println("ACC failed");
                    return false;
                }
            } else {
                // Updating check failed
                System.out.println("UCC failed");
                return false;
            }
        
    }

    public ArrayList<Artist> getArtists() {
    ArrayList<Artist> artists = new ArrayList<>();
        try {
            // Read the data line by line
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
                    // Store the data into a new artist
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
                // Add the artist to an array
                artists.add(artist);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Read data failed!");
        }
        // Return the array of artists
        return artists;
    }

    // Parse the list in txt file as a true arraylist
    private static ArrayList<String> parseList(String input) {
        ArrayList<String> list = new ArrayList<>();
        String[] elements = input.substring(1, input.length() - 1).split(", ");
        for (String element : elements) {
            list.add(element);
        }
        return list;
    }
}
