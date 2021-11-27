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
    public static boolean search(String given_contact) {
        for (int i = 0; i < all_Bills.size(); i++) {
            if (given_contact.equals(all_Bills.get(i).contact)) {
                return true;
            } 
        }
        return false;
    }
}
