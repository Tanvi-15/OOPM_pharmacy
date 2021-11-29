package PMS;
import java.util.*;
class contactException extends Exception {
    contactException() {
    }
    public String toString() {
        return "Contact number is invalid.";
    }
}

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
            System.out.println("\n1. Add medicine to database.\n2. Delete Medicine from database.\n3. Display Database\n4. Generate Bill\n5. Display All bills \n6. Search for Bill\n7. Logout\n8. Exit");
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
                    generateBill();
                    break; //generate bill;
                case 5:
                    BillRecords.displayBills();
                    break; //display all bills
                case 6:
                    try {
                        System.out.println("Enter user contact number to search for their bill: ");
                        String user_contact = sc.next();
                        if (user_contact.length() != 10 || !isNumeric(user_contact)) {
                            throw new contactException();   
                        }
                        System.out.println("Enter the date(DD/MM/YYYY) of billing: ");
                        String date = sc.next();
                        BillRecords.search(user_contact, date);
                    }
                    catch(contactException e) {
                        System.out.println(e.toString());
                    }
                    break; 
                case 7: 
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); //clear space/screen
                    main(null);// logout opt to again login
                    break;
                case 8:
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

    public static void generateBill() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter customer name: ");
            String name = sc.next();
            System.out.println("Enter date of purchase: ");
            String date = sc.next();
            System.out.println("Enter phone number: ");
            String phone_no = sc.next();
            if (phone_no.length() != 10 || !isNumeric(phone_no)) {
                throw new contactException();   
            }
            System.out.println("Enter doctor referral: ");
            String doctor = sc.next();
            System.out.println("Add medicines to cart: ");
            Vector<Medicine> cust_meds = new Vector<Medicine>();
            Vector<Integer> quantity = new Vector<Integer>();
            boolean flag = true;
            while (flag) {
                purchaseMedicine(cust_meds, quantity);
                System.out.println("Do you want more medicines? (Y/N)");
                String med_choice = sc.next();
                if (!med_choice.equalsIgnoreCase("Y")) {
                    flag = false;
                }
            }
            BillGenerate b = new BillGenerate(name, date, phone_no, doctor, cust_meds, quantity); 
            if (!b.purchased_medicines.isEmpty()) {
                b.getBillDetails();
                BillRecords.addBill(b);
            }
            //sc.close();
        }
        catch(contactException e) {
            System.out.println(e.toString());
        }
        
    }

    public static void purchaseMedicine(Vector<Medicine> purchased_medicines, Vector<Integer> quantitites){
        Scanner b = new Scanner(System.in);
        System.out.println("Enter Medicine name: ");
        String Med_name = b.next();   
        System.out.println("Enter Medicine quantity: ");
        int Med_quantity = b.nextInt();   
        boolean availablility = false;
        if (MedicineDatabase.all_medicines.isEmpty()) {
            System.out.println("Medicine is not available in database!");
            return;
        }
        for (int i = 0; i < MedicineDatabase.all_medicines.size(); i++) {
            if (MedicineDatabase.all_medicines.get(i).name.equalsIgnoreCase(Med_name)) {
                purchased_medicines.add(MedicineDatabase.all_medicines.get(i));
                if (Med_quantity <= MedicineDatabase.all_medicines.get(i).quantity) {
                    MedicineDatabase.all_medicines.get(i).quantity -= Med_quantity;
                    quantitites.add(Med_quantity);
                    System.out.println("Medicine was successfully added to cart!");
                    availablility = true;
                    return;
                }
                else {
                    System.out.println("Sufficient quantity not available!");
                    availablility = true;
                    return;
                }
            }
        }
        if (availablility == false) {
            System.out.println("Medicine is not available in database!");
        }
        //b.close();
    }

    public static boolean isNumeric(String s) {
        try {
            Long.parseLong(s);
        } 
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}

