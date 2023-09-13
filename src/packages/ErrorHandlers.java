package packages;

public class ErrorHandlers {
    public static void incorrectInputType(String input, String actualType){
        System.out.println("Please input a correct type, you inputted" + "\n" + input + "\n" + "The expected type is: " + actualType);
    }
    public static void noOptionsFromInput(String input){
        System.out.println("There is no option for " + input);
    }
}
