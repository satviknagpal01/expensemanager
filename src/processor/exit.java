package processor;

import java.io.IOException;

public class exit {// exit screen
    public void bye() { // this function is called when the user wants to exit
        System.out.println("\n\n\n\n-------PRESS ENTER TO EXIT-------------\n");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        screenclean cls = new screenclean();
        try {
            cls.clearScreen();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("\n\n-----------------------------------");
        System.out.println("    DAILY EXPENSES MANAGEMENT      ");
        System.out.println("-----------------------------------\n\n");
        System.out.println("Thank you for using our app \nYou have been successfully logged out");
        System.out.println("We hope you enjoyed ");
        System.out.println("\n......................... BYE  BYE...................................");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
