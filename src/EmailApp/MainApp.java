package EmailApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Email> list=new ArrayList<>();
        list.add(new Email(getFirstName(),getLastName()));


        //list.get(0).changePassword();

    }

    private static String getFirstName(){
        System.out.print("Enter First Name: ");
        return new Scanner(System.in).nextLine();
    }
    private static String getLastName(){
        System.out.print("Enter Last Name: ");
        return new Scanner(System.in).nextLine();
    }
}
