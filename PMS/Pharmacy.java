package PMS;
import java.util.*;
class LoginException extends Exception {
    LoginException(int indicator) {
        if (indicator == 2) {
            System.out.println("Password was incorrectly typed.");
        }
        else if (indicator == 3) {
            System.out.println("Username already exists in system.");
        }
        else {
            System.out.println("User does not exist.");
        }
    }
    public String toStringLogin() {
        return "Login Error!!!";
    }
    public String toStringRegister() {
        return "Registration Error!!!";
    }
}
public class Pharmacy {
    public static Vector<String> usernames = new Vector<String>();
    public static Vector<String> passwords = new Vector<String>();    
    public static void register(String user_name, String user_password) {
        usernames.addElement(user_name);
        passwords.addElement(user_password);
        System.out.println("User credentials saved!");   
    }

    public static int login(String name, String password) {
        if (usernames.contains(name)) {
            int index = usernames.indexOf(name);
            if (password.equals(passwords.get(index))) {
                System.out.println("Login Successful!");
                return 1;
            }
            else {
                return 2;
            }
        }
        else {
            return -1;
        }
    }
    
    public static void main(String args[]) {
        usernames.add("ishika");
        passwords.add("ishika");
        Scanner sc = new Scanner(System.in);
        System.out.println("***PHARMACY***");
        boolean flag = true;
        while (flag) {
            System.out.println("\n1. Existing User? Login.\n2. New User? Register\n3. Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: 
                    try {
                        System.out.println("Enter Username: ");
                        String name = sc.next();
                        System.out.println("Enter Password: ");
                        String password = sc.next();                  
                        int check_login = login(name, password);
                        if (check_login == 1) {
                            Admin.choice();
                        }
                        else if (check_login == 2) {
                            throw new LoginException(2);
                        }
                        else {
                            throw new LoginException(-1);
                        }
                    }
                    catch(LoginException e){
                        System.out.println(e.toStringLogin());
                    }
                    break;
                case 2:
                    System.out.println("Enter Username: ");
                    String user_name = sc.next();
                    try {
                        if (usernames.contains(user_name)) {
                            throw new LoginException(3);
                        }  
                        System.out.println("Enter Password: ");
                        String password2 = sc.next();
                        register(user_name, password2);
                        
                    }
                    catch(LoginException e) {
                        System.out.println(e.toStringRegister());
                    }                   
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