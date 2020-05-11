package validations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exceptions.numchkcharec;
import exceptions.numchkdigi;
//this is the number validator it check if the number is 10 digits or not and if there are any characters or not 
public class numcheck {
    public boolean numgo(String num) throws numchkcharec, numchkdigi, IOException {
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("configs/constants/exceptions.properties");
            prop.load(input);
            //this is the pattern matcher if there is anything present in the phone number
            //that is in this box it will throw an exception
            Pattern patternGet = Pattern.compile("[abcdefghigjklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,./<>?;':{}]|'/*-+!@#$%^&*()'");
            Matcher check = patternGet.matcher(num);
            boolean finalValue = check.find();
            if (finalValue == true) {
                throw new numchkcharec();
            } else{
                //if the number is not 10 digits this shows an exception
                if(num.length()==10) {
                    return true;
                }
                else
                throw new numchkdigi();
            }
        }catch(numchkcharec e){
            String s = prop.getProperty("numchkchr");
            System.out.println(s);
            return false;
        } catch (numchkdigi e) {
            String s = prop.getProperty("numchkdig");
            System.out.println(s);
            return false;
        }
    }
}