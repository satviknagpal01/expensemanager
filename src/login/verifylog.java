package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;
//this verifies whether the user is currently a user or not
public class verifylog {
    public boolean verifylogin(String usname, String password) {//is called in login
        boolean found = false;//it is returned at the end if this is true then the user is logged in else the system exits
        try {
            FileReader fr = new FileReader("csv/data.csv");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataline = line.split(",");
                if (dataline[4].equals(usname) && dataline[5].equals(password)) {
                    found = true;//if the username and password match then the value of found changes to true
                    break;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            return found;
    }
}