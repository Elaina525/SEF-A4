import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionCheck {

    public boolean IDCheck(String ID) {

        int counter = 0;

        if (ID.length() != 10) {
            return false;
        }

        ArrayList<String> IDList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            IDList.add(String.valueOf(ID.charAt(i)));
        }
        
        try {
            for (String a: IDList) {
                if (counter < 3) {
                    if (Integer.parseInt(a) >=5 && Integer.parseInt(a) <=9) {
                        counter++;
                    } else {
                        System.out.println("First 3 numbers to in range of 5-9");
                        return false;
                    }
                } else if (counter >= 3 && counter <7) {
                    if (Character.isLetter(a.charAt(0)) && a.equals(a.toUpperCase())) {
                        counter++;
                    } else {
                        System.out.println("4-7 not letters or not uppercase");
                        return false;
                    }
                } else if (counter <= 9) {
                    if (Character.isLetter(a.charAt(0)) && Character.isDigit(a.charAt(0))) {
                        System.out.println("Last 2 not symbols");
                        return false;
                    } else {
                        counter++;
                    }
                }
            }
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean birthdateCheck(String Birthdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(Birthdate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean addressCheck(String Address) {
        String regexPattern = "^[^|]+\\|[^|]+\\|[^|]+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(Address);
        return matcher.matches();
    }

    public boolean bioCheck(String Bio) {
        int counter = 0;
        for (char a: Bio.toCharArray()) {
            if (String.valueOf(a).isBlank()) {
                counter++;
            }
        }
        if (counter >= 10 && counter <= 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean occupationsCheck(ArrayList <String> Occupations) {
        if (Occupations.size() >= 1 && Occupations.size() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean awardsCheck(ArrayList <String> Awards) {
        int counter = 0;
        if (Awards.size() <= 2) {
            for (String award:  Awards) {
                String[] parts = award.split(", ");
                String year = parts[0];
                String title = parts[1];
                try {
                    Integer.parseInt(year);
                    for (char a: title.toCharArray()) {
                        if (String.valueOf(a).isBlank()) {
                            counter++;
                        }
                    }
                    if (counter >= 4 && counter <= 10) {
                        counter = 0;
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean genresCheck(ArrayList <String> Genres) {
        if (Genres.size() >= 1 && Genres.size() <= 4) {
            for (String genre: Genres) {
                if (genre.equalsIgnoreCase("pop") && Genres.contains("rock")) {
                    return false;
                }
            }
        }
        return true;
    }

}
