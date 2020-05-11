package login;

import java.io.File;
import java.io.FileWriter;
import java.lang.String;
public class foldercreate{
// this creates a new folder for the new users and then a new file daily.csv 
    public boolean fcreate(String usname){
    String path="csv/users/";
        try{
            File dir = new File(path + usname);
            dir.mkdirs();
            File file = new File(dir, "daily.csv");
            FileWriter fw = new FileWriter(file, true);
            fw.write("amount" + "," + "item"+"\n");
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}