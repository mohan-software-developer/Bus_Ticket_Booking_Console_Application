package Bus_Application;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    Scanner sc;
    ArrayList<Bus> busList;

    public Admin(ArrayList<Userdetails> userDetails, ArrayList<Bus> busDetails) {
        sc = new Scanner(System.in);
        busList = busDetails;
        int option;
        char check;
        do {
            System.out.println("Welcome Admin!");
            System.out.println("1 : Add new Bus details \n2 : View all bus information \n3 : View a specific bus \n4 : Exit");
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            sc.nextLine();  
            switch (option) {
                case 1:
                    addBusDetails();
                    break;
                case 2:
                    viewAllBuses();
                    break;
                case 3:
                    viewBus();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Check whether you entered valid details or not?");
            }
            System.out.print("Do you want to continue:(y or n): ");
            check = sc.next().charAt(0);
            sc.nextLine(); 
        } while (check == 'y');
    }

    private void addBusDetails() {
        System.out.println("Enter Bus Details:");
        System.out.print("Bus No: ");
        String busNo = sc.nextLine();
        System.out.print("From Date (yyyy-mm-dd): ");
        String fromDate = sc.nextLine();
        System.out.print("To Date (yyyy-mm-dd): ");
        String toDate = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();
        System.out.print("Arrival Time (hh:mm): ");
        String arrivalTime = sc.nextLine();
        System.out.print("Depart Time (hh:mm): ");
        String departTime = sc.nextLine();
        System.out.print("Bus Type: ");
        String busType = sc.nextLine();
        System.out.print("Bus Driver: ");
        String busDriver = sc.nextLine();

        Bus newBus = new Bus(busNo, fromDate, toDate, from, to, arrivalTime, departTime, busType, busDriver);
        busList.add(newBus);
        System.out.println("Bus details added successfully!");
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
                System.out.println("Capacity: " + bus.getCapacity());
                bus.displaySeatLayout();
                System.out.println();
            }
        }
    }
    
    private void viewBus() {
        System.out.println("Enter Bus No:");
        String no = sc.nextLine();
        if (busList.isEmpty()) {
            System.out.println("No bus details available.");
        } else {
            System.out.println("Bus Information for Bus No " + no + ":");
            for (Bus bus : busList) {
                if (no.equals(bus.getBusNo())) {
                    System.out.println("Bus No: " + bus.getBusNo());
                    System.out.println("From Date: " + bus.getFromDate());
                    System.out.println("To Date: " + bus.getToDate());
                    System.out.println("From: " + bus.getFrom());
                    System.out.println("To: " + bus.getTo());
                    System.out.println("Arrival Time: " + bus.getArrivalTime());
                    System.out.println("Depart Time: " + bus.getDepartTime());
                    System.out.println("Bus Type: " + bus.getBusType());
                    System.out.println("Bus Driver: " + bus.getBusDriver());
                    System.out.println("Capacity: " + bus.getCapacity());
                    bus.displaySeatLayout();
                    System.out.println();
                    return;
                }
            }
            System.out.println("Bus with Bus No " + no + " not found.");
        }
    }
}
