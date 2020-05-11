package data;
import java.io.*;
import java.util.Scanner;
// this is used to add data to users files everything is added to the users own csv file
public class add {
    public float adddata(String name) {//this function is called in choice java file
        Float amount;//new data ammount that is to be added
        String item;//new data name that is to be added
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n-----------------------------------");
        System.out.println("     DAILY EXPENSES MANAGEMENT     ");
        System.out.println("-----------------------------------\n\n");
        System.out.print("\nEnter cost of item/service: ");
        amount = sc.nextFloat();//enter ammount here
        System.out.print("\nEnter the name of the item or service: ");
        item=sc.nextLine();//enter name of the item here
        item = sc.nextLine();
        try {
            File fl = new File("csv/users/" + name + "/daily.csv");
            FileWriter fw = new FileWriter(fl, true);
                fw.append(amount + "," + item+"\n");
            fw.close();
            System.out.println("Data added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
}