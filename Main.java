package encryptdecrypt;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a message and an integer");
        String mode = "enc";
        String message = "";
        String alg = "shift";
        String fileIn = null;
        String fileOut = null;
        int number = 0;
        boolean in = false;
        boolean out = false;
        boolean data = false;

        try {
            for (int i = 0; i < args.length; i++) {


                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                }

                if (args[i].equals("-data")) {
                    data = true;
                    message = args[i + 1];
                }

                if (args[i].equals("-key")) {
                    number = Integer.parseInt(args[i + 1]);
                }

                if (args[i].equals("-in")) {
                    in = true;
                    fileIn = args[i + 1];
                }

                if (args[i].equals("-out")) {
                    out = true;
                    fileOut = args[i + 1];
                }

                if (args[i].equals("-alg")) {
                    alg = args[i+1];
                }
            }

            if (!data && in) {
                //BufferedReader reader = new BufferedReader(new FileReader(fileIn));
                message = Files.readString(Path.of(fileIn));

            }

            String result = "";

            if (mode.equals("enc") && alg.equals("shift")) {
                ShiftObj cypher = new ShiftObj(message, number);
                result = cypher.encrypt(message, number);
            } else if (mode.equals("dec") && alg.equals("shift")) {
                ShiftObj cypher = new ShiftObj(message, number);
                result = cypher.decrypt(message, number);
            }

            else if (mode.equals("enc") && alg.equals("unicode")) {
                UnicodeObj cypher = new UnicodeObj(message, number);
                result = cypher.encrypt(message, number);
            } else if (mode.equals("dec") && alg.equals("unicode")) {
                UnicodeObj cypher = new UnicodeObj(message, number);
                result = cypher.decrypt(message, number);
            }

            if (!out) {
                System.out.println(result);
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
                writer.write(result);
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("An Error has occurred. Program shutting down...");
            System.exit(0);
        }

    }

}


