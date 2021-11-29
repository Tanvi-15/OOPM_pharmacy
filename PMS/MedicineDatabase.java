package PMS;
import java.util.*;

public class MedicineDatabase {
    public static Vector<Medicine> all_medicines = new Vector<Medicine>();

    public static void addMedicine(Medicine b) {
        all_medicines.add(b);
        System.out.println("Medicine successfully added to system.");
    }

    public static void deleteMedicine(String title) {
        boolean check_med = false;
        for (int i = 0; i < all_medicines.size(); i++) {
            if (title.equalsIgnoreCase(all_medicines.get(i).name)) {
                all_medicines.remove(i);
                check_med = true;
                System.out.println("Medicine successfully deleted from system.");
            }
        }
        if (check_med == false) {
            System.out.println("Medicine not present in system.");
        }
    }

    public static void displayDatabase() {
        System.out.println("Name\t\tCompany\t\tQuantity\tExpiry\t\tPrice");
        for (int i = 0; i < all_medicines.size(); i++) {
            all_medicines.get(i).getMedicineDetails();
            System.out.println();
        }
    }    
}
