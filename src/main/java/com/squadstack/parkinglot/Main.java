package com.squadstack.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//$ java -jar target/gojek-1.0.jar (Interactive command-line mode)
//$ java -jar target/gojek-1.0.jar <inputfile> (File input)


public class Main {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        switch (args.length) {
            case 0:
                System.out.println("-------------Command List------------");
                System.out.println();
                System.out.println("'exit' : quit.");
                System.out.println("'create lotSize' : create a parking lot.");
                System.out.println("'park regNum Age' : park a car");
                System.out.println("'leave slotNum' : leave/ empty a particular slot");
                System.out.println("'reg_num_acc_to_age age'");
                System.out.println("'slot_num_acc_to_age age'");
                System.out.println("'slot_num_acc_to_reg_num regNum'");
                // Interactive command-line input/output
                // Run an infinite loop
                for (;;) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                            inputParser.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Oops! Error in reading the input from console.");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                // File input/output
                inputParser.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
        }
    }
}
