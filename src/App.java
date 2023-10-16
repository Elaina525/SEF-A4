import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        AddConditionCheck acc = new AddConditionCheck();
        String validID = "789AAAAA!!";
        String invalidID_length = "1";
        String invalidID_numbers = "123AAAAA!!";
        String invalidID_letters = "789aaaaa!!";
        String invalidID_symbols = "789AAAAAAA";
        System.out.println(acc.IDCheck(validID));
        System.out.println(acc.IDCheck(invalidID_length));
        System.out.println(acc.IDCheck(invalidID_numbers));
        System.out.println(acc.IDCheck(invalidID_letters));
        System.out.println(acc.IDCheck(invalidID_symbols));
    }

}