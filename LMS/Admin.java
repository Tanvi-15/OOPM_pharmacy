package LMS;
import java.util.*;

public class Admin extends Library{
    public static String admin_name;
    public static String admin_ID;
    public static BookDatabase db = new BookDatabase(); //obj
        
    Admin(String admin_name1, String admin_ID1) {
        admin_name = admin_name1;
        admin_ID = admin_ID1;
    }

    public static void choice() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        //System.out.flush();
        System.out.println("Welcome Admin!");
        Scanner sc =  new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n1. Add book to database.\n2. Delete book from database.\n3. Display Database\n4. Logout\n5. Exit");
            int ch = sc.nextInt();
            switch(ch) {
                case 1: 
                    addMedicine();
                    break;
                case 2:
                    deleteMedicine();
                    break;
                case 3:
                    BookDatabase.displayDatabase();
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
    }
    public static void addMedicine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter medicine name: ");
        String name = sc.next();
        System.out.println("Enter production company name: ");
        String production = sc.next();
        System.out.println("Enter quantity of strips: ");
        int quantity = sc.nextInt();
        System.out.println("Enter quantity of pills per strips: ");
        int quantity_per_strip = sc.nextInt();
        System.out.println("Enter expiry date: ");
        String expiry_date = sc.next();
        System.out.println("Is it to be given only on prescription? ");
        String doctor_prescribed = sc.next();
        Medicine med = new Medicine(name, production, quantity, quantity_per_strip, expiry_date,doctor_prescribed); 
        BookDatabase.addMedicine(med);
    }

    public static void deleteMedicine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the medicine you want to delete: ");
        String name = sc.next();
        BookDatabase.deleteBook(name);
    }
}
