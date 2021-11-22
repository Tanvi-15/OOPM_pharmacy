package LMS;
import java.util.*;

public class Book {
    public String name;// title
    public String production;// author
    public int quantity;
    public int quantity_per_strip; // publication
    public String expiry_date ;//ISBN
    public String doctor_prescribed;//  yes/no int quantity

    //construct
    Book (String title, String author, String publication, String ISBN, int quantity) {
        this.name = name;
        this.production = production;
        this.quantity_per_strip=quantity_per_strip ;
        this.expiry_date=expiry_date ;
        this.doctor_prescribed =doctor_prescribed ;
        this.quantity=quantity;
    }

    public void getMedicineDetails() { //getBookDetails
        System.out.print(name + "\t" + production + "\t" + quantity_per_strip + "\t\t" + expiry_date + "\t" + doctor_prescribed + "\t" );
    }

}
