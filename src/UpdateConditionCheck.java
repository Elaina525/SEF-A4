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
        }
        } catch (NumberFormatException e) {
            return false; // Birthdate is not in the expected format
        }
        
        return true;
    }

    public boolean awardsCheck(Artist artist, ArrayList <String> awards) {
        for (int i = 0; i < awards.size(); i++) {
            String award = awards.get(i);
            int awardYear = Integer.parseInt(award.substring(0, 4));
            if (awardYear < 2000) {
                // This award was given before 2000, check if it is changed
                if (!award.equals(artist.getAwards().get(i))) {
                    return false; // Awards given before 2000 cannot be changed
                }
            }
        }
        return true;
    }

}
