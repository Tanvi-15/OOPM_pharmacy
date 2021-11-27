package PMS;
import java.util.*;

public class MedicineDatabase {
    public static Vector<Medicine> all_medicines = new Vector<Medicine>();

    public static void addMedicine(Medicine b) {
        all_medicines.add(b);
        System.out.println("Medicine successfully added to system.");
    }

    public static void deleteMedicine(String title) {
        for (int i = 0; i < all_medicines.size(); i++) {
            if (title.equalsIgnoreCase(all_medicines.get(i).name)) {
                all_medicines.remove(i);
                System.out.println("Medicine successfully deleted from system.");
            }
        }
    }

    public static void displayDatabase() {
        System.out.println("Name\tCompany\tQuantity\tExpiry\t\tPrice");
        for (int i = 0; i < all_medicines.size(); i++) {
            all_medicines.get(i).getMedicineDetails();
            System.out.println();
        }
    }
    public static String search(String given_name) {
        for (int i = 0; i < all_medicines.size(); i++) {
            if (given_name.equalsIgnoreCase(all_medicines.get(i).name)) {
                return given_name;
            } 
        }
        return "";
    }
    
}
