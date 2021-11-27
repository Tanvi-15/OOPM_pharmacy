package PMS;
import java.util.*;

public class Medicine {
    public String name;// title
    public String company;// author //company
    public int quantity;
    public String expiry_date ;//ISBN
    public double price;

    //construct
    Medicine (String name, String company, int quantity, String expiry_date, double price) {
        this.name = name;
        this.company = company;
        this.quantity=quantity;
        this.expiry_date=expiry_date ;
        this.price=price ;
        
    }

    public void getMedicineDetails() { //getBookDetails
        System.out.print(name + "\t" + company + "\t" +quantity+ "\t\t" + expiry_date + "\t" + price + "\t" );
    }

}
