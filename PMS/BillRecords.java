package PMS;
import java.util.*;
public class BillRecords {
    public static Vector<BillGenerate> all_Bills = new Vector<BillGenerate>();
    public static void addBill(BillGenerate b) {
        all_Bills.add(b);
        System.out.println("Bill successfully added to system.");
    }
    public static void displayBills() {
        System.out.println("Name\tCompany\tQuantity\tExpiry\t\tPrice");
        for (int i = 0; i < all_Bills.size(); i++) {
            all_Bills.get(i).getBillDetails();
            System.out.println();
        }
    }
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

