import java.util.ArrayList;

public class Test {
    
    public static void main(String[] args) {
        String ID = "569MMMRR_!";
        int counter = 0;

        if (ID.length() != 10) {
            System.out.println("Length Wrong!");
            return;
        }

        ArrayList<String> IDList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            IDList.add(String.valueOf(ID.charAt(i)));
        }
        
        try {
            for (String a: IDList) {
                if (counter < 3) {
                    if (Integer.parseInt(a) >=5 && Integer.parseInt(a) <=9) {
                        System.out.println(a+counter);
                        counter++;
                    } else {
                        System.out.println("First 3 numbers to in range of 5-9");
                        return;
                    }
                } else if (counter >= 3 && counter <7) {
                    if (Character.isLetter(a.charAt(0)) && a.equals(a.toUpperCase())) {
                        System.out.println(a+counter);
                        counter++;
                    } else {
                        System.out.println("4-7 not letters or not uppercase");
                        return;
                    }
                } else if (counter <= 9) {
                    if (Character.isLetter(a.charAt(0)) && Character.isDigit(a.charAt(0))) {
                        System.out.println("Last 2 not symbols");
                        return;
                        
                    } else {
                        System.out.println(a+counter);
                        counter++;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        
    }
}
