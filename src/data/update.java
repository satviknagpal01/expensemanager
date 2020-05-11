package data;
import java.io.*;
import java.util.Scanner;
//this shows data that is present in the file and asks the user which line they want to update
//then asks what that user wants the updated line to be

public class update
{
    public void updatedata(String name)//this is the function that is called in choice.java when the user selects to update
    {
        show sh = new show();
        File temp=new File("csv/users/"+name+"/temp.csv");//we copy every line of the user file into this file
        File old = new File("csv/users/" + name + "/daily.csv");//this is the original file for the user
        int n,count=0;
        Float newamount;
        String newitem;
        Scanner sc= new Scanner(System.in);
        try {
            FileReader fr = new FileReader(old);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(temp, true);
            String s;

            while ((s = br.readLine()) != null) {//here we are copying every single line of our original file to this temporary file
                count++;//count is used in this so that the user doesn't enter any number that is not in the file
                fw.write(s+"\n");
                fw.flush();
            }
            fr.close();
            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh.showme(name); //here we show the original file  and ask the user whiiich item they want to edit or update
        System.out.print("\nEnter the item number you want to update: ");
        do{
            n=sc.nextInt();
        if(n==0||n>count)
        {

            System.out.print(count+"\nERROR!!!!!!!! \nEnter a valid item number you want to update: ");
            // until the user enters a number in range this will show this error
        }
        }while(n==0||n>count);
        System.out.print("\nEnter cost of item/service: ");
        newamount = sc.nextFloat();
        System.out.print("\nEnter item/service name: ");
        newitem = sc.nextLine();
        newitem = sc.nextLine();
        try {
            FileReader fr = new FileReader(temp);
            BufferedReader br = new BufferedReader(fr); //here we are copying all the line back to the original file
            FileWriter fw = new FileWriter(old, false);//and while doing that we will be changing the line the user wants to change
            String s;
            int i=0;
            while ((s = br.readLine()) != null) {
                if (i == n) {
                    i++;
                    s=newamount+","+newitem;
                    fw.write(s+"\n"); 
                    fw.flush();
                } else {
                    i++;
                    fw.write(s+"\n");
                    fw.flush();
                }
            }
            fr.close();
            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp.delete();//temporary file is deleted
    }
}
