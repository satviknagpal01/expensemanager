package login;

import data.*;
import processor.*;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
// this is the screen user comes to when they chose the login option or they just signed up
public class login {
    exit ex = new exit();
    choice cs = new choice();
    screenclean cls = new screenclean();
    reader readcall = new reader();
    String name;
    static Scanner sc = new Scanner(System.in);
    public void login1() throws IOException {// this is the funcion that is called
            String an = "admin";
            String ap = "admin";//this is the admin login
            try {
                cls.clearScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("\n\n-----------------------------------");
            System.out.println("    DAILY EXPENSES MANAGEMENT      ");
            System.out.println("-----------------------------------\n\n");
            System.out.println("-----------------------------------");
            System.out.println("               LOGIN               ");
            System.out.println("-----------------------------------\n\n");
            Console console = System.console();
            if (console == null) {
                System.out.println("No console: non-interactive mode!");
                System.exit(0);
            }
            System.out.print("Enter your Username: ");
            String uname = sc.next();
            System.out.print("Enter your password: ");
            char[] password = console.readPassword();// the user enters a password but that is not visible 
            String pass = String.valueOf(password);
            verifylog log = new verifylog();// verify login is called to check if it is the correct username and password
            if (log.verifylogin(uname, pass)) {
                try {
                    cls.clearScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("logged in");
                if (uname.equals(an) && pass.equals(ap)) {//if the user enters the correct username and 
                    //password then the user gets signed into as the admin
                    Admin ad = new Admin();
                    ad.Admin1();
                    ex.bye();
                } else {
                    cs.choose(uname);
                    try {
                        cls.clearScreen();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    ex.bye();
                }
            } else {
            System.out.println("Invalid username or password\n");
    		ex.bye();
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
