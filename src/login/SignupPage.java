package login;

import java.io.*;
import java.util.*;

import processor.screenclean;
import validations.*;
import java.lang.String;
// this is the signup page whenever there is a new user they can make the new user
public class SignupPage {
    public void signup() throws IOException {
        try {
            passcheck pp = new passcheck();
            unamechk up = new unamechk();
            foldercreate fol = new foldercreate();
            numcheck np = new numcheck();
            screenclean cls = new screenclean();
            Scanner sc = new Scanner(System.in);
            String firstname, lastname, email, phoneno, username,pass;
            boolean exist = false;
            cls.clearScreen();
            System.out.println("\n\n-----------------------------------");
            System.out.println("    DAILY EXPENSES MANAGEMENT      ");
            System.out.println("-----------------------------------\n\n");
            System.out.print("\nEnter First Name: ");
            firstname = sc.next();
            System.out.print("\nEnter Last Name: ");
            lastname = sc.next();
            System.out.print("\nEnter E-Mail: ");
            email = sc.next();
            do{System.out.print("\nEnter Phone Number: ");
            phoneno = sc.next();
            }while(!np.numgo(phoneno));
            Console console = System.console();
            if (console == null) {
                System.out.println("No console: non-interactive mode!");
                System.exit(0);
            }
            do {
                System.out.print("Enter username: ");
                username = console.readLine();
                System.out.print("\nEnter Password: ");
                char[] password = console.readPassword();//here the password is taken from the user but it is not visible to the user
                //instead it seems like the user isn't entering anything
                pass = String.valueOf(password);//the char array is converted into a string
                if (up.go(username) && pp.go(pass)) {//here that username and password are sent to check
                    //if they are valid 
                    FileReader fr = new FileReader("csv/data.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] dataline = line.split(",");
                        if (dataline[4].equals(username)) {//here it checks whether the username has been used before or not
                            exist = false;
                            break;
                        } else {
                            exist = true;
                        }
                    }
                    fr.close();
                    if (!exist) {
                        System.out.println("\nUser already exists!!! Try again!! ");
                    }
                }
            } while (!exist);
            if (exist) {
                fol.fcreate(username);
                File fl = new File("csv/data.csv");
                FileWriter fw = new FileWriter(fl, true);
                fw.write("\n" + firstname + "," + lastname + "," + email + "," + phoneno + "," + username + ","+ pass);
                fw.close();
                //here we are creating a new user we add the data into the file data.csv and a new folder is created
                //for the new user
            }
        } catch (Exception e) {
        }
        System.out.println("\n\n\n\n-------PRESS ENTER TO CONTINUE TO LOGIN SCREEN-------------\n");
        System.in.read();
        login log = new login();//now the user is sent to the login page to login and add data to their file
        log.login1();
    }
}
