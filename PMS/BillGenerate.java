package PMS;
import java.util.*;

public class BillGenerate {
    public String cust_name;// title
    public String date;// author //company
    public String Phone_number ;//ISBN
    public String DoctorName;
    public Vector<Medicine> purchased_medicines;
    public double total_price;

    //construct
    BillGenerate (String cust_name, String date, String Phone_number, String DoctorName) {
        this.cust_name = cust_name;
        this.date = date;
        this.Phone_number=Phone_number;
        this.DoctorName=DoctorName;
        total_price = 0;
        
    }

    public double total() {
        for (int i = 0; i < purchased_medicines.size(); i++) {
            total_price += purchased_medicines.get(i).price;
        }
        return total_price;
    }

    public void getBillDetails() { //getBookDetails
        System.out.print(cust_name + "\t" + date + "\t" +Phone_number+ "\t\t" + DoctorName+ "\t" );
        System.out.println();
        for (int i = 0; i < purchased_medicines.size(); i++) {
            purchased_medicines.get(i).getMedicineDetails();
        }
        System.out.println("Total Price = " + total_price);
    }
  
}


