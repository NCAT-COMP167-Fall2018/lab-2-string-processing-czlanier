/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shake
 */
public class StringProcessing {
    private static String[] data = new String[100];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        readFileData(args[0]);
        
    }
    
    public static void readFileData(String filename){

        int track = 0;
        try {
            Scanner scan  = new Scanner(new File(filename));
            while(scan.hasNext()){
               String[] eachLine = scan.nextLine().split(",");
               String firstName = eachLine[0].trim();
               String lastName = eachLine[1].trim();
               String age = eachLine[3].trim();
               String gender = eachLine[2].trim();
               String phoneNumber = eachLine[4].trim();
               String email  = eachLine[5].trim();
               
               data[track] = String.format("%-15s   %-20s    %-10s   %10s       %-10s     %-15s", verifyFirstName(firstName)+ ": " + firstName, verifyLastName(lastName) + ": " + lastName, verifyAge(age)+ ": " + age, verifyGender(gender) + ": " + gender, verifyPhoneNumber(phoneNumber) + ": " + phoneNumber, verifyEmail(email) + ": " + email );
               System.out.println(data[track]);
               track++;
            }
        } catch (FileNotFoundException ex) {
            System.err.print("Cannot find DataFile");
            System.exit(-1);
        }
       
    }
    
    private static boolean verifyFirstName(String fname){
        if(fname == null || fname.equals("")){
            return false;
        }
        if(!fname.matches("[a-zA-Z]*")){
            return false;
        }
        return true;
    } 
    
    private static boolean verifyLastName(String lname){
        if(lname == null || lname.equals("")){
            return false;
        }
        if(!lname.matches("[a-zA-Z]*")){
            return false;
        }
        return true;
    }
    
    private static boolean verifyGender(String gend){
        if(gend == null || gend.equals("")){
            return false;
        }
        if(!(gend.equalsIgnoreCase("male") || gend.equalsIgnoreCase("female"))){
            return false;
        }
        return true;
    }
    
    private static boolean verifyAge(String age){
       
        if(age == null || age.equals("")){
            return false;
        }
        if(Integer.valueOf(age)< 1 || Integer.valueOf(age) > 130){
            return false;
        }
        return true;
    }
    
    private static boolean verifyEmail(String email){
        if(email == null || email.equals("")){
            return false;
        }
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            return false;
        }
        return true;
    }
    
    private static boolean verifyPhoneNumber(String phone){
        if(phone == null || phone.equals("")){
           return false; 
        }
        if(!phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")){ 
            return false;
        }	
        return true;
    }
    
    
}
