package PMS;
import java.util.*;

public class BillGenerate {
    public String cust_name;// title
    public String date;// author //company
    public String Phone_number ;//ISBN
    public String DoctorName;
    public Vector<Medicine> purchased_medicines;
    public Vector<Integer> med_quantities;
    public double total_price;

    //construct
    BillGenerate (String cust_name, String date, String Phone_number, String DoctorName, Vector<Medicine> purcMedicines, Vector<Integer> quantities) {
        this.cust_name = cust_name;
        this.date = date;
        this.Phone_number=Phone_number;
        this.DoctorName=DoctorName;
        this.purchased_medicines = purcMedicines;
        this.med_quantities = quantities;
        total_price = 0;
        
    }

    public double total() {
        for (int i = 0; i < purchased_medicines.size(); i++) {
            total_price += (purchased_medicines.get(i).price * Integer.valueOf(med_quantities.get(i)));
        }
        return total_price;
    }

    public void getBillDetails() { //getBookDetails
        System.out.print(cust_name + "\t" + date + "\t" +Phone_number+ "\t\t" + DoctorName+ "\t" );
        System.out.println();
        for (int i = 0; i < purchased_medicines.size(); i++) {
            purchased_medicines.get(i).getMedicineDetails();
        }
        total_price = total();
        System.out.println("Total Price = " + total_price);
    }
  
}



/*
Input: customer name, date, phone number, doctor
Additional Input: Medicine, Quantity, (price, auto generate)
Calculate: Total Price
*/

