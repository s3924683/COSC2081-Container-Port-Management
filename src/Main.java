import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    public static void loginGui(){
        Scanner input = new Scanner(System.in);

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println("-------------------------------------------");
            System.out.println("|   Input a number to choose an option!   |");
            System.out.println("-------------------------------------------");

            System.out.println("----------------LOGIN GUI------------------");
            System.out.println("| 1. System admin         2. Port manager |");
            System.out.println("-------------------------------------------");
            System.out.print("Input: ");

            String result = input.next();

            if(isNumeric(result)){
                int value =  Integer.parseInt(result);
                if(value == 1){
                    break;
                }else if(value == 2){
                    break;
                }else{
                    System.out.println("There is no option for " + value);
                }
            }else{
                System.out.println("Please input a number!");
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(" \n" +
                "COSC2081 GROUP ASSIGNMENT  \n" +
                "CONTAINER PORT MANAGEMENT SYSTEM \n" +
                "Instructor: Mr. Minh Vu & Dr. Phong Ngo \n" +
                "Group: Group Name  \n" +
                "s3924683, Nguyen Minh Tri  \n" +
                "sXXXXXXX, Student Name  \n" +
                "sXXXXXXX, Student Name  \n");

        loginGui();
    }
}
