package Bus_Application;
import java.util.Scanner;
import java.util.ArrayList;

public class Login {
    Scanner sc;
    

    public Login(ArrayList<Userdetails> details,ArrayList<Bus> busDetails) {
        sc = new Scanner(System.in);
        System.out.println("Login!");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals("admin") && password.equals("password")) {
            new Admin(details, busDetails);
        } else {
            boolean found = false;
            for (Userdetails detail : details) {
                if (detail.getUsername().equals(username) && detail.getPassword().equals(password)) {
                    found = true;
                    System.out.println("Login successful!");
                    new User(username,busDetails);
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid username or password.");
            }
        }
    }

}
