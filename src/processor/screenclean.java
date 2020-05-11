package processor;
import java.io.*;
public class screenclean
{
    public void clearScreen() throws IOException,InterruptedException{
// to clearscreen and this is supported in 2 os linus and windows
        try {
            if (System.getProperty("os.name").contains("Linux"))//if the operating system is linux 
                new ProcessBuilder("clear").inheritIO().start().waitFor();//this command is used
            else if(System.getProperty("os.name").contains("Windows"))//if the operating system is windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//this command is used
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ex) {ex.printStackTrace();}
    }
}
