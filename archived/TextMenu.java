/*
package packages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TextMenu {
    private Map<String, Map<String, String>> guis = new HashMap<>();
    public TextMenu() {
        generateTextGuis();
    }

    private void generateTextGuis(){
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put("0",
                """
                ----------------Login GUI------------------
                | 1. System admin         2. Port manager |
                -------------------------------------------
                """);
        loginMap.put("1",
                """
                ----------------System Admin---------------
                | 1. Login                     2. Go back |
                -------------------------------------------
                """);
        loginMap.put("2",
                """
                ----------------Port Manager---------------
                | 1. Login                     2. Go back |
                -------------------------------------------
                """);

        guis.put("login", loginMap);
    }
    public Map<String, String> login(){
        Scanner input = new Scanner(System.in);

        Map<String, String> Login = guis.get("login");

        String pastGui = "0";
        String activeGui = "0";

        Map<String, String> userData = new HashMap<>();

        boolean keepRunningGui = true;

        int count = 0;

        while (keepRunningGui){
            if(count > 2){
                count = 0;
            }

            if(count == 0){
                System.out.print( "|   Input a number to choose an option!   |\n");
                String menu = Login.get(activeGui);
                System.out.println(menu);
            }

            System.out.print("Input: ");

            String inputResult = input.next();

            switch (activeGui) {
                case "1" -> {
                    switch (inputResult) {
                        case "1" -> {
                            while (true){
                                System.out.print("Username: ");
                                String username = input.next();
                                System.out.print("Password: ");
                                String password = input.next();
                                String type = "systemAdmin";

                                 if(true){
                                     break;
                                 }
                            }

                            keepRunningGui = false;
                        }
                        case "2" -> {
                            activeGui = pastGui;
                        }
                        default -> {
                            ErrorHandlers.noOptionsFromInput(inputResult);
                            count++;
                        }
                    }
                }
                case "2" -> {
                    switch (inputResult) {
                        case "1" -> {
                            while (true){
                                System.out.print("Username: ");
                                String username = input.next();
                                System.out.print("Password: ");
                                String password = input.next();
                                String type = "portManager";

                                if(true){
                                    break;
                                }
                            }
                            keepRunningGui = false;
                        }
                        case "2" -> {
                            activeGui = pastGui;
                        }
                        default -> {
                            ErrorHandlers.noOptionsFromInput(inputResult);
                            count++;
                        }
                    }
                }
                default -> {
                    if (Login.containsKey(inputResult)) {
                        pastGui = activeGui;
                        activeGui = inputResult;

                        System.out.println(pastGui + " " + activeGui);
                    } else {
                        ErrorHandlers.noOptionsFromInput(inputResult);
                        count++;
                    }
                }
            }
        }

        return userData;
    }
}
*/