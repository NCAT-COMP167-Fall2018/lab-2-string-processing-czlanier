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
               String age = eachLine[2].trim();
               String gender = eachLine[3].trim();
               String phoneNumber = eachLine[4].trim();
               String email  = eachLine[5].trim();
               
               data[track] = String.format("%-15s%-15s%-10s%10s   %-15s%-15s", firstName, lastName, age, gender, phoneNumber, email);
               System.out.println(data[track]);
               track++;
            }
        } catch (FileNotFoundException ex) {
            System.err.print("Cannot find DataFile");
            System.exit(-1);
        }
       
    }
    public static void validation(){  
        
    }
    
}
