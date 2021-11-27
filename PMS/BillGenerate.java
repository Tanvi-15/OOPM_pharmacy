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
    
}
// public void borrowedBooks(){
//     Scanner b = new Scanner(System.in);
//     System.out.println("Enter book title: ");
//     String btitle=b.next();
//     String availableBookTitle = BookDatabase.search(btitle);
//     if (availableBookTitle != "") {
//         readerAcct.borrowedBooksV.add(availableBookTitle);
//         for (int i = 0; i < BookDatabase.all_books.size(); i++) {
//             if(readerAcct.borrowedBooksV.get(i).equalsIgnoreCase(BookDatabase.all_books.get(i).title)){
//                 BookDatabase.all_books.get(i).quantity--;
//                 System.out.println("Book was successfully issued!");
//             }
//         }
//     }
//     else {
//         System.out.println("Book is not available in database!");
//     }
// }