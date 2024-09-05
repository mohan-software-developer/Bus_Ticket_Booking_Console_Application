package Bus_Application;
import java.util.Scanner;
import java.util.ArrayList;

public class Signup {
    Scanner sc;

    public Signup(ArrayList<Userdetails> details,ArrayList<Bus> busList) {
        sc = new Scanner(System.in);
        System.out.println("Signup!");
        System.out.print("Choose a Username: ");
        String username = sc.nextLine();
        System.out.print("Choose a Password: ");
        String password = sc.nextLine();
        

        boolean exists = false;
        for (Userdetails detail : details) {
            if (detail.getUsername().equals(username)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Username already exists. Please choose a different username.");
            new Signup(details,busList);
        } else {
            details.add(new Userdetails(username, password));
            System.out.println("Signup successful! You can now login.");
            new Login(details,busList);
        }
    }
}
