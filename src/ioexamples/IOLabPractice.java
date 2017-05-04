/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexamples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class IOLabPractice {

    public static void main(String[] args) {
        String textPath = "src" + File.separatorChar + "contactList.txt";
        File file = new File(textPath);

        BufferedReader in = null;

//         Exceptions should be handled by the class whose responsibility is output.
//         For the sake of practice we are handling exceptions here.
//         Read file and output to console.
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }

        } catch (IOException ioe) {
            System.out.println("The file cannot be read!");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println("problem closing file");
            }
        }

        //Append a record
        boolean append = true;
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
            out.println("Thurman Merman");
            out.println("227 Chester Ave.");
            out.println("Rocester, Minnesota, 45678");

        } catch (IOException ioe) {
            System.out.println("File cannot be written to.");

        } finally {
            try {
                out.close();
            } catch (Exception e) {
                System.out.println("problem closing file");

            }
        }

        System.out.println("");
        List<String> contactList = new ArrayList<String>();

        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                contactList.add(line);
                line = in.readLine();
            }

        } catch (IOException ioe) {
            System.out.println("The file cannot be read!");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println("problem closing file");
            }
        }
        String name = contactList.get(3);
        String state = contactList.get(5);
        String[] tempSplit = state.split(",");
        state = tempSplit[1];
        
        System.out.println(name + " state: " + state);
        
        
        
        

    }
}
