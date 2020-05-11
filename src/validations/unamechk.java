package validations;

import exceptions.*;
//all the validations for user name
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class unamechk{
    boolean spachk(String s)throws spaceusername
    {//there shouldn't be any space in the username
        boolean a=false;
        int i,len = s.length();
        for(i = 0; i<len; i++){
            if (s.charAt(i)==' '){
                a=true;
                break;
            }
        }
        if(a==true){
            throw new spaceusername();
        }
        else
            return !a;
    }
    boolean emtuname(String s) throws emptyUnameException
    {//the username shouldn't be empty 
        String st=null;
        String st1 ="";
        if(s.equals(st)||s.equals(st1))
        {
            throw new emptyUnameException();
        }
        else
            return true;
    }
    boolean lenuname(String s)throws LongUsernameException
    {//the username shouldn't be more than 20
        if(s.length()>20)
        {
            throw new LongUsernameException();
        }
        else
            return true;
    }

    boolean specialCharacter(String s) throws specialcharusername
    {//there can't be any special character except the underscore
        Pattern patternGet = Pattern.compile("[!@#$%^&(,)]");
        Matcher check = patternGet.matcher(s);
        boolean finalValue = check.find();
        if (finalValue == true)
        {
            throw new specialcharusername();
        }
        else
            return true;
    }
    
    public boolean go(String a) throws IOException {
        boolean b, sc, lc, sp;//this is to be called in the program
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("configs/constants/exceptions.properties");
            prop.load(input);
            b = emtuname(a);
            sc = specialCharacter(a);
            lc = lenuname(a);
            sp = spachk(a);
            if (b == false) {
                throw new emptyUnameException();
            }
            if (sc == false) {
                throw new specialcharusername();
            }
            if (lc == false) {
                throw new LongUsernameException();
            }
            if (sp == false) {
                throw new spaceusername();
            } else
                return true;
        } catch (emptyUnameException e) {
            String s = prop.getProperty("emptyUnameMessage");
            System.out.println(s);
            return false;
        } catch (specialcharusername e) {
            String s = prop.getProperty("specialMessage");
            System.out.println(s);
            return false;
        } catch (LongUsernameException e) {
            String s = prop.getProperty("longUserNameMessage");
            System.out.println(s);
            return false;
        } catch (spaceusername e) {
            String s = prop.getProperty("SpaceMessage");
            System.out.println(s);
            return false;
        } 
    }
}
