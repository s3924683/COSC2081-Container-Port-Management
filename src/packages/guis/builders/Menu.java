package packages.guis.builders;

import packages.ErrorHandlers;
import java.util.HashMap;
import java.util.Scanner;

public class Menu{
    private String id;
    private String name;
    private HashMap<String,Gui> guis;

    private boolean keepRunning = true;
    private String oldPointer = "1";
    private String pointer = "1";

    public Menu(String id, String name, HashMap<String,Gui> guis) {
        this.id = id;
        this.name = name;
        this.guis = guis;
    }
    public HashMap<Object, Object> run(){
        if(!keepRunning){
            keepRunning = true;
        }

        Scanner input = new Scanner(System.in);
        int count = 0;

        while (keepRunning){
            Gui gui = guis.get(pointer);

            String text = gui.toString();

            boolean noMoreGuis = false;

            if(count < 2){
                System.out.println(text);
            }else{
                count = 0;
            }

            System.out.print("Input: ");

            String inputResult = input.next();

            for (String key : guis.keySet()) {
                if(!key.equals(pointer)){
                    if (key.contains(pointer) && key.length() > pointer.length()) {
                    } else{
                        noMoreGuis = true;
                    }
                }
            }

            if(noMoreGuis){
                String guiOption = gui.getOptions().get(inputResult);

                if(guiOption == null){
                    ErrorHandlers.noOptionsFromInput(inputResult);
                    count++;
                }else{
                    if(guiOption.equals("Go back")){
                        pointer = oldPointer;
                    }else if(guiOption.equals("Exit")){
                        keepRunning = false;
                    }else{
                        HashMap<Object, Object> guiData = new HashMap<>();
                        guiData.put("gui",gui);
                        guiData.put("option", inputResult);

                        return guiData;
                    }
                };
            }else{
                String index = pointer;

                if(guis.size() == 1){
                    String guiOption = gui.getOptions().get(inputResult);

                    if(guiOption.equals("Go back")){
                        pointer = oldPointer;
                    }else if(guiOption.equals("Exit")){
                        keepRunning = false;
                    }else{
                        HashMap<Object, Object> guiData = new HashMap<>();
                        guiData.put("gui",gui);
                        guiData.put("option", inputResult);

                        return guiData;
                    }
                }else{
                    index = pointer + " " + inputResult;
                }


                if(guis.containsKey(index)){
                    oldPointer = pointer;
                    pointer = index;}
                else{
                    count++;
                    ErrorHandlers.noOptionsFromInput(inputResult);
                }
            }
        }

        return null;
    }

    public void stop(){
        this.keepRunning = false;
    }
}