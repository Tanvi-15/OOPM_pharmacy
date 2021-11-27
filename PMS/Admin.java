package PMS;
import java.util.*;
public class Admin extends Pharmacy {
    public static String admin_name;
    public static MedicineDatabase db = new MedicineDatabase(); 
    Admin(String name) { 
        admin_name = name;
    }
    public static void choice() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        //System.out.flush();
        System.out.println("Welcome Admin!");
        Scanner sc =  new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n1. Add medicine to database.\n2. Delete Medicine from database.\n3. Display Database\n4. Logout\n5. Exit");
            int ch = sc.nextInt();
            switch(ch) {
                case 1: 
                    addMedicine();
                    break;
                case 2:
                    deleteMedicine();
                    break;
                case 3:
                    MedicineDatabase.displayDatabase();
                    break;
                case 4: 
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); //clear space/screen
                    main(null);// logout opt to again login
                    break;
                case 5:
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        //sc.close();
    }
    public static void addMedicine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter medicine name: ");
        String name = sc.next();
        System.out.println("Enter production company name: ");
        String company = sc.next();
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Enter expiry date: ");
        String expiry_date = sc.next();
        System.out.println("Enter price: ");
        Double price = sc.nextDouble();
        Medicine med = new Medicine(name, company, quantity, expiry_date, price); 
        MedicineDatabase.addMedicine(med);
        //sc.close();
    }

    public static void deleteMedicine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the medicine you want to delete: ");
        String name = sc.next();
        MedicineDatabase.deleteMedicine(name);
        //sc.close();
    }
    
}
