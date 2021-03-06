package PMS;
import java.util.*;
//Store all the bills
public class BillRecords {
    public static Vector<BillGenerate> all_Bills = new Vector<BillGenerate>();
    
    //add Bill record
    public static void addBill(BillGenerate b) {
        all_Bills.add(b);
        System.out.println("\nBill successfully added to system.");
    }

    //display all bill records
    public static void displayBills() {
        for (int i = 0; i < all_Bills.size(); i++) {
            all_Bills.get(i).getBillDetails2();
            System.out.println();
        }
    }
    
    //search for a particular bill
    public static void search(String given_contact, String given_date) {
        try {
            boolean flag = false;
            
            for (int i = 0; i < all_Bills.size(); i++) {
                if (given_contact.equals(all_Bills.get(i).Phone_number) && given_date.equals(all_Bills.get(i).date)) {
                    all_Bills.get(i).getBillDetails();
                    flag=true;
                }
            }
            if (flag != true) {
                throw new Exception();
            }
        }
        catch(Exception e) {
            System.out.println("Bill doesn't exist in system.");
        }
 
    }  

}

