package processor;

import java.io.*;

//this is the function that is used to to read the daily_expenses.txt file
public class reader {
    public void read(String select) {
        try {
            FileReader usr = new FileReader("csv/users/daily_expenses.txt");
            BufferedReader bin = new BufferedReader(usr);
            System.out.println("------------------------------------------------");
            System.out.println("    The Daily Transactions of " + select + " are:   ");
            System.out.println("------------------------------------------------\n\n");
            String sr;
            sr = bin.readLine();
            System.out.println(sr);
            while ((sr = bin.readLine()) != null) {// this loop reads the complete file and prints it on the screen
                System.out.println(sr);
            }
            bin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
