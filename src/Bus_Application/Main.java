package Bus_Application;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Bus-Booking_website!");

        ArrayList<Userdetails> userDetails = new ArrayList<>();
        ArrayList<Bus> busDetails = getDefaultBusDetails();

        int option;
        char check;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("1 : Login \n2 : Signup \n3 : Exit");
                System.out.print("Enter your option: ");
                option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        new Login(userDetails, busDetails);
                        break;
                    case 2:
                        new Signup(userDetails, busDetails);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Check whether you entered valid details or not?");
                }
                System.out.print("Do you want to continue:(y or n): ");
                check = sc.next().charAt(0);
            } while (check == 'y');
        }
    }

    private static ArrayList<Bus> getDefaultBusDetails() {
        ArrayList<Bus> defaultBusDetails = new ArrayList<>();
        defaultBusDetails.add(new Bus("1", "2024-05-30", "2024-05-31", "Rasipuram", "Sathy", "09:00", "01:00", "AC", "Muthu"));
        defaultBusDetails.add(new Bus("2", "2024-05-30", "2024-05-31", "Rasipuram", "Sathy", "07:00", "15:00", "Non-AC", "Rajini"));
        defaultBusDetails.add(new Bus("3", "2024-05-30", "2024-05-31", "Rasipuram", "Sathy", "10:00", "02:00", "AC", "Kumar"));
        defaultBusDetails.add(new Bus("4", "2024-05-30", "2024-05-31", "Rasipuram", "Sathy", "08:00", "16:00", "Non-AC", "Vijay"));
        defaultBusDetails.add(new Bus("5", "2024-05-30", "2024-05-31", "Rasipuram", "Sathy", "11:00", "03:00", "AC", "Suresh"));
        return defaultBusDetails;
    }
}
