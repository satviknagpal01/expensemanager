package data;

import java.io.IOException;
import java.util.*;

import processor.*;
//this gives the user a choice what he wants to do with his file does he want add or update or delete
public class choice
{
    public void choose(String username) throws IOException {//ths function is called directly after the user has logged in
        Scanner sc = new Scanner(System.in);
        screenclean cls = new screenclean();
        add ad = new add();
        delete de = new delete();
        update up = new update();
        show sh = new show();
        exit ex = new exit();
        char a;
        do{
	        System.out.println("\n\n-----------------------------------");
            System.out.println("     DAILY EXPENSES MANAGEMENT     ");
            System.out.println("-----------------------------------\n\n");
            System.out.println(" ----------------------------------------------------");
            System.out.println("|             SELECT THE FOLLOWING OPTION            |");
            System.out.println(" ----------------------------------------------------");
            System.out.println("|                   PRESS 1 TO ADD                   |");
            System.out.println("|                   PRESS 2 TO UPDATE                |");
            System.out.println("|                   PRESS 3 TO DELETE DATA           |");
            System.out.println("|                   PRESS 4 TO SHOW YOUR DATA        |");
            System.out.println("|                   PRESS 5 TO EXIT                  |");
            System.out.println(" ----------------------------------------------------");
            a = sc.next().charAt(0);//here we take the input asking the using what he wants to do from the given options
            switch (a){
            case '1':{
                try {//here first the screen is cleaned then the adddata function is called 
                    cls.clearScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ad.adddata(username);
                break;
            }
            case '2':{
                try {// here first the screen is cleaned then the updatedata function is called
                    cls.clearScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                up.updatedata(username);
                break;
            }
            case '3':{
                try {// here first the screen is cleaned then the deletedata function is called
                    cls.clearScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                de.deletedata(username);
                break;
            }
            case '4':{
                try {
                    cls.clearScreen();// here first the screen is cleaned then the show function is called
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sh.showme(username);
                System.out.println("------------PRESS ENTER TO CONTINUE--------------\n");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:{
                ex.bye();
            }
            }
            try{
                cls.clearScreen();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        while(a=='1'||a=='2'||a=='3'||a=='4');
    }
}