package main;

import java.io.IOException;
import java.util.Scanner;

import login.*;
import processor.*;
//this is our main functions as the programs starts it starts from here
public class hellothismain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char sw;
        screenclean cl = new screenclean();
        login log = new login();
        SignupPage sup = new SignupPage();
        try {
            cl.clearScreen();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n-----------------------------------");
        System.out.println("    DAILY EXPENSES MANAGEMENT      ");
        System.out.println("-----------------------------------\n\n");
        System.out.println(" -----------------------------------------------------------------");
        System.out.println("|                SELECT THE FOLLOWING OPTION                      |");
        System.out.println(" -----------------------------------------------------------------");
        System.out.println("|                       PRESS 1 TO LOGIN                          |");
        System.out.println("|                       PRESS 2 TO SIGNUP                         |");
        System.out.println("|                       PRESS 3 TO EXIT                           |");
        System.out.println(" -----------------------------------------------------------------");
        sw = sc.next().charAt(0);
        //you can enter enything there of how many characters you want
        //but still it will go for the the first character only
        //and if it's anything other than 1 or 2 it will exit
        switch (sw) {
            case '1'://the function login is called for already existing users
                log.login1();
                break;
            case '2':
                sup.signup();//the function signup is called for new users
                break;
            default:
                System.out.println("Thank you for using our app");
                System.out.println("We hope you enjoyed ");
                System.out.println("\n......................... BYE  BYE...................................");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
