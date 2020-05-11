package data;

import java.io.*;
import java.util.Scanner;

import processor.reader;

public class show {
    public void showme(String name) {//this function is called when the user wants to see their data
        try {
            String filepath= "csv/users/" + name + "/daily.csv";//this is the users data file that gets updated
            File file = new File("csv/users/daily_expenses.txt");//this is a common file for every user
            // we copy every thing to this file the csv file but un the format of a table so that it is presentable
            FileWriter archivo = new FileWriter(file);
            double x = 0.0;
            int i=0;
            String am;
            String it;
            Scanner r = new Scanner(new File(filepath));
            System.out.println("\n\n-----------------------------------");
            System.out.println("    DAILY EXPENSES MANAGEMENT      ");
            System.out.println("-----------------------------------\n\n\n");
            archivo.write("-------------------------------------------------------------------\n");

            r.useDelimiter("[,\n]");//this breaks one line of the from the csv file in diffrent parts on the basis of what comes in between
            am=r.next();
            it=r.next();
            archivo.write(String.format("|  %8s|  %20s| %30s|\n","item num",am, it));
            archivo.write("-------------------------------------------------------------------\n");
            //this is the part that helps us print in a tabular form
            while(r.hasNext()){
                i++;
                am=r.next();
                it=r.next();
                x = x + Double.parseDouble(am);//here we are converting a strring to double to find out the total expenditure
                archivo.write(String.format("|  %8s|  %20s| %30s|\n",i ,am, it));
            }
            archivo.write("-------------------------------------------------------------------\n");
            r.close();
            archivo.flush();
            archivo.close();
            reader re = new reader();
            System.out.println("\n\n\t\t\t\t\t\t total expenses = "+x+"\n\n");//this shows the total expenditure
            re.read(name);
            System.out.println("\n\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}