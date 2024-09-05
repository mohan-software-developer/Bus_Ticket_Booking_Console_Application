package Bus_Application;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner sc;
    ArrayList<Bus> busList;

    public User(String username, ArrayList<Bus> busDetails) {
        System.out.println("Welcome " + username + "!");
        sc = new Scanner(System.in);
        busList = busDetails;
        int option;
        char check;
        do {
            System.out.println("1 : View all bus information \n2 : BookSeat \n3 : Exit");
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    viewAllBuses();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Check whether you entered valid details or not?");
            }
            System.out.print("Do you want to continue:(y or n): ");
            check = sc.next().charAt(0);
            sc.nextLine();
        } while (check == 'y');
    }

    private void viewAllBuses() {
        if (busList.isEmpty()) {
            System.out.println("No bus details available.");
        } else {
            System.out.println("All Bus Information:");
            for (Bus bus : busList) {
                System.out.println("Bus No: " + bus.getBusNo());
                System.out.println("From Date: " + bus.getFromDate());
                System.out.println("To Date: " + bus.getToDate());
                System.out.println("From: " + bus.getFrom());
                System.out.println("To: " + bus.getTo());
                System.out.println("Arrival Time: " + bus.getArrivalTime());
                System.out.println("Depart Time: " + bus.getDepartTime());
                System.out.println("Bus Type: " + bus.getBusType());
                System.out.println("Bus Driver: " + bus.getBusDriver());
                System.out.println("UnBooked Seats: " + bus.getCapacity());
                bus.displaySeatLayout();
                System.out.println();
            }
        }
    }

    private void bookSeat() {
        System.out.println("Enter Bus Details:");
        System.out.print("Bus No: ");
        String busno = sc.nextLine();

        boolean flag;
        do {
            flag = false;

            System.out.println("Enter no of seats");
            int no_seats = sc.nextInt();

            int[] seatsbook = new int[no_seats];
            System.out.println("Enter seat numbers: ");
            for (int i = 1; i <= no_seats; i++) {
                System.out.print("seat" + i + ": ");
                seatsbook[i - 1] = sc.nextInt();
            }

            for (Bus bus : busList) {
                if ((bus.getBusNo()).equals(busno)) {
                    for (int i = 1; i <= no_seats; i++) {
                        if (bus.bookSeat(seatsbook[i - 1])) {
                            System.out.println("seat" + seatsbook[i - 1] + " Booked");
                        } else {
                            System.out.println("seat" + seatsbook[i - 1] + " already booked \n Try again! ");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                    
                        System.out.println("All seats are booked successfully!");
                        bus.displaySeatLayout();
                        
                    }
                    break;
                }
                bus.setCapacity(bus.getCapacity() - no_seats);
                System.out.println("Remaining seats: " + bus.getCapacity());
            }
            
            if (flag) {
                break;
            }
            
        } while (flag);
           
    }
}
