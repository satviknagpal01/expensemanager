package login;

import java.io.*;
import java.util.*;
import data.*;
import processor.*;
// admin user logs in and the admin can see anything from any user but cant edit the details
public class Admin {
    public void Admin1() {
        show sh = new show();
        screenclean cls = new screenclean();
        char cont;//just to ask whether to continue or not
        Scanner sc = new Scanner(System.in);
        try {
            cls.clearScreen();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        do {
            boolean exist = false;
            try{
                FileReader fr = new FileReader("csv/data.csv"); // open all the list of users
                BufferedReader br = new BufferedReader(fr);
                cls.clearScreen();
                System.out.println("\n\n------------ADMIN LOGIN------------\n");
                System.out.println("\n\n-----------------------------------");
                System.out.println("    DAILY EXPENSES MANAGEMENT      \n");
                System.out.println("-----------------------------------\n\n");
                System.out.println("\nList of useres: "); // print the list of all users
                br.readLine();
                br.readLine();
                String line;
                int i = 1;
                while ((line = br.readLine()) != null){//prints usernames of all the users
                    String[] dataLine = line.split(",");
                    System.out.println(i +". "+ dataLine[4]);
                    i++;
                }
                fr.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            String select;
            System.out.print("\nEnter a username to view their transaction history: ");
            select = sc.next();//asks for the username from admin that they want to see details of
            try {
                FileReader fr = new FileReader("csv/data.csv");
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] dataline = line.split(",");
                    if (dataline[4].equals(select)) {
                        exist = true;
                        break;
                    }
                    else
                    exist = false;
                }
                if(exist){
                    cls.clearScreen();
                    sh.showme(select);
                }
                else
                System.out.println("Wrong Username");
                br.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("do you wish to continue press y");
            cont = sc.next().charAt(0);
        }while(cont=='y'||cont=='Y');
    }
}