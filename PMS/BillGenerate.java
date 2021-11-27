package PMS;
import java.util.*;

public class BillGenerate {
    public String cust_name;// title
    public String date;// author //company
    public String Phone_number ;//ISBN
    public String DoctorName;

    public Vector<Medicine> purchased_medicines;

    //construct
    BillGenerate (String cust_name, String date, String Phone_number, String DoctorName) {
        this.cust_name = cust_name;
        this.date = date;
        this.Phone_number=Phone_number;
        this.DoctorName=DoctorName;
        
    }

    public void getBillDetails() { //getBookDetails
        System.out.print(cust_name + "\t" + date + "\t" +Phone_number+ "\t\t" + DoctorName+ "\t" );
    }
  
}

public void purchaseMedicine(){
    Scanner b=new Scanner(System.in);
    System.out.println("Enter Medicine name: ");
    String bname=b.next();

    String availableMedicineName=MedicineDatabase.search(bname);
    if (availableMedicineName!=""){
        purchased_medicines.add(availableMedicineName); 

        for (int i = 0; i < MedicineDatabase.all_medicines.size(); i++) {
                        if(purchased_medicines.get(i).equalsIgnoreCase(MedicineDatabase.all_medicines.get(i).name)){
                            MedicineDatabase.all_medicines.get(i).quantity--;
                            System.out.println("Medicine was successfully issued!");
                        }
                    }
    }
    else{
        System.out.println("Medicine is not available in database!");
    }
}

/*
Input: customer name, date, phone number, doctor
Additional Input: Medicine, Quantity, (price, auto generate)
Calculate: Total Price
*/
