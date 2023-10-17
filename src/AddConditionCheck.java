import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddConditionCheck {

    public boolean IDCheck(String ID) {

        int counter = 0;
        // Check the length of ID
        if (ID.length() != 10) {
            System.out.println("Length must be 10");
            return false;
        }

        ArrayList<String> IDList = new ArrayList<>();

        // Convert the ID to a list of chars
        for (int i = 0; i < 10; i++) {
            IDList.add(String.valueOf(ID.charAt(i)));
        }
        
        try {
            for (String a: IDList) {
                // The first 3 chars must be integer between 5 and 9
                if (counter < 3) {
                    if (Integer.parseInt(a) >=5 && Integer.parseInt(a) <=9) {
                        counter++;
                    } else {
                        System.out.println("First 3 numbers to in range of 5-9");
                        return false;
                    }
                // The middle 5 chars must be uppercase letters
                } else if (counter >= 3 && counter <8) {
                    if (Character.isLetter(a.charAt(0)) && a.equals(a.toUpperCase())) {
                        counter++;
                    } else {
                        System.out.println("4-7 not letters or not uppercase");
                        return false;
                    }
                // The last 2 chars must be symbols
                } else if (counter >= 8 && counter <= 9) {
                    if (!Character.isLetterOrDigit(a.charAt(0))) {
                        counter++;
                    } else {
                        System.out.println("Last 2 not symbols");
                        return false;
                    }
                }
                
                
                }
            
            return true;
        } catch(Exception e) {
            System.out.println("Invalid ID!");
            return false;
        }
    }

    public boolean birthdateCheck(String Birthdate) {
        // Set date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(Birthdate);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid Birthdate!");
            return false;
        }
    }

    public boolean addressCheck(String Address) {
        // Set the syntax of address
        String regexPattern = "^[^|]+\\|[^|]+\\|[^|]+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(Address);
        if (!matcher.matches()) {
            System.out.println("Invalid Address!");
        }
        return matcher.matches();
    }

    public boolean bioCheck(String Bio) {
        int counter = 0;
        // Convert bio to a list of chars
        for (char a: Bio.toCharArray()) {
            // Count the whitespaces in the arraylist
            if (String.valueOf(a).isBlank()) {
                counter++;
            }
        }
        if (counter >= 10 && counter <= 30) {
            return true;
        } else {
            System.out.println("Invalid Bio!");
            return false;
        }
    }

    public boolean occupationsCheck(ArrayList <String> Occupations) {
        // Count the number of occupations in the arraylist
        if (Occupations.size() >= 1 && Occupations.size() <= 5) {
            return true;
        } else {
            System.out.println("Invalid Occupations!");
            return false;
        }
    }

    public boolean awardsCheck(ArrayList <String> Awards) {
        int counter = 0;
        // Count the number of awards in the arraylist
        if (Awards.size() <= 3) {
            for (String award: Awards) {
                try {
                    System.out.println(award);
                    String year = award.substring(0, 4);
                    String title = award.substring(5);
                    // First 4 chars must be integer
                    Integer.parseInt(year);
                    // Count the whitespaces, the rest of the chars should be between 4 and 10
                    for (char a: title.toCharArray()) {
                        if (String.valueOf(a).isBlank()) {
                            counter++;
                        }
                    }
                    if (counter >= 4 && counter <= 10) {
                        counter = 0;
                        return true;
                    } else {
                        System.out.println("Invalid Awards!");
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Awards!");
                    return false;
                }
            }
        }
        return false;
    }

    public boolean genresCheck(ArrayList <String> Genres) {
        // Check the number of the genres
        if (Genres.size() >= 2 && Genres.size() <= 5) {
            for (String genre: Genres) {
                // pop and rock can't show at once
                if (genre.equalsIgnoreCase("pop") && Genres.contains("rock")) {
                    System.out.println("Invalid Genres!");
                    return false;
                }
            }
        } else {
            System.out.println("Invalid Genres!");
            return false;
        }
        return true;
    }

}
