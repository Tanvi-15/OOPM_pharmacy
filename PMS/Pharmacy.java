package PMS;
import java.util.*;
public class Pharmacy {
    public static Vector<String> usernames = new Vector<String>();
    public static Vector<String> passwords = new Vector<String>();    
    public static void register(String user_name, String user_password) {
        usernames.addElement(user_name);
        passwords.addElement(user_password);
        System.out.println("User credentials saved!");
    }
    public static boolean login(String name, String password) {
        if (usernames.contains(name)) {
            int index = usernames.indexOf(name);
            if (password.equals(passwords.get(index))) {
                System.out.println("Login Successful!");
                return true;
            }
            else {
                System.out.println("Incorrect Password!");
            }
        }
        else {
            System.out.println("User not registered!");
        }
        return false;
    }
    public static void main(String args[]) {
        usernames.add("ishika");
        passwords.add("ishika");
        Scanner sc = new Scanner(System.in);
        System.out.println("***PHARMACY***");
        boolean flag = true;
        while (flag) {
            System.out.println("1. Existing User? Login.\n2. New User? Register\n3. Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: 
                    System.out.println("Enter Username: ");
                    String name = sc.next();
                    System.out.println("Enter Password: ");
                    String password = sc.next();                  
                    boolean check_login = login(name, password);
                    if (check_login == true) {
                        Admin.choice();
                    }
                    break;
                case 2:
                    System.out.println("Enter Username: ");
                    String name2 = sc.next();
                    System.out.println("Enter Password: ");
                    String password2 = sc.next();
                    register(name2, password2);
                    break;     
                case 3:
                    flag = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected.");
            }
        }   
        sc.close();   
    }
}