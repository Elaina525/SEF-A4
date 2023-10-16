import java.util.ArrayList;

public class UpdateConditionCheck {
    public boolean birthYearCheck(Artist artist, String birthYear, ArrayList <String> occupations) {
        try {
            int birthYearInt = Integer.parseInt(birthYear.substring(6)); // Extract the birth year
            if (birthYearInt < 2000) {
                // Artist was born before 2000, check if occupations are changed
                
                if (!occupations.equals(artist.getOccupations())) {
                    return false; // Occupations cannot be changed
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid Birthdate!");
            return false; // Birthdate is not in the expected format
        }
        
        return true;
    }

    public boolean awardsCheck(Artist artist, ArrayList<String> awards) {
        for (int i = 0; i < awards.size(); i++) {
            try {
                String newAward = awards.get(i);
                String currentAward = artist.getAwards().get(i);
    
                String newYear = newAward.substring(0, 4);
                String currentYear = currentAward.substring(0, 4);
    
                if (Integer.parseInt(currentYear) < 2000) {
                    return false; // Year before 2000 is unchangeable
                }
    
                if (!newYear.equals(currentYear)) {
                    return false; // Year and title must remain the same if the year is after 2000
                }
            } catch (Exception e) {
                System.out.println("Invalid Awards!");
                return false;
            }
        }
        return true;
    }
    

}
