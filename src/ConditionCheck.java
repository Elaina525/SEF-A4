import java.util.ArrayList;

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
        } catch(Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean birthdateCheck(String Birthdate) {


        return true;
    }

    public boolean addressCheck(String Address) {


        return true;
    }

    public boolean bioCheck(String Bio) {


        return true;
    }

    public boolean occupationsCheck(ArrayList <String> Occupations) {


        return true;
    }

    public boolean awardsCheck(ArrayList <String> Awards) {

        return true;
    }

    public boolean genresCheck(ArrayList <String> Genres) {

        return true;
    }

}
