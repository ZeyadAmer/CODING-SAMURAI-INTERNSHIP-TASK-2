package src.engine;

import java.io.IOException;
import java.util.Scanner;


public class Functions{
    private static double operant_1 , operant_2;
    private static Operations mode = Operations.idle;
    private static String operant;

    public static double Calculations() throws IOException 
    {
        // Switch keyword
        switch (mode) {
        // Case statements
        case addition:
            return operant_1 + operant_2;
        case subtraction:
            return operant_1 - operant_2;
            
        case multiplication:
            return operant_1 * operant_2;
        
        case division:
            return operant_1 / operant_2;
        // Default case statement
        default: 
        case idle:
           return operant_1;
        }
    }

    public static void OperationDeclaration(String operation){
        switch (operation) {
        // Case statements
        case "addition":
            mode = Operations.addition;
            break; 
        case "subtraction":
            mode = Operations.subtraction;
            break;    
        case "multiplication":
           mode = Operations.multiplication;
           break;  
        case "division":
           mode = Operations.division;
           break;  
        case "exit":
           System.exit(0);
        default: 
           System.out.println("please enter a valid operation");
        }  

    }
      public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
         System.out.println("Hello!!! \n \n");

       while(true){
    
        while(mode.name() == "idle"){ // to ensure that the user chose an operation
        System.out.println("Please choose one of the these operants (addition, subtraction, multiplication, and division) or exit...");
        String operation = input.nextLine();
        OperationDeclaration(operation);
        }

        System.out.println("Please enter the first Operant");

       while(operant_1 == 0.0){ //to ensure the user enters a valid number
        try {
            operant = input.nextLine();
            operant_1 = Double.valueOf(operant);
            break;
        } catch (Exception e) {
            System.out.println("please enter a valid number");
        }
    }

    System.out.println("Please enter the second Operant");

     while(operant_2 == 0.0){ //to ensure the user enters a valid number
        try {
            operant = input.nextLine();
           
            if(Double.valueOf(operant) == 0.0 && mode.name() == "division"){
                operant = "aa";
            }
             operant_2 = Double.valueOf(operant);
        } catch (Exception e) {
             System.out.println("you can't divide by zero this is math error");
            System.out.println("please enter a valid number");
        }
    }
    try {
       double answer = Calculations();
       System.out.println(answer);
    } catch (Exception e) {
        System.out.println("cannot divide by 0");
    }
     mode = Operations.idle;
        }
   }
}