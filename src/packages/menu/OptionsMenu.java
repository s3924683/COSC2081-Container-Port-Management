package packages.menu;

import packages.menu.builders.OptionsInterface;

import java.util.HashMap;

public class OptionsMenu {
    private String id;
    private String name;
    private HashMap<String, OptionsInterface> interfaces = new HashMap<>();
    private String oldPointer = "1";
    private String pointer = "1";

    public OptionsMenu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public HashMap<String, OptionsInterface> getInterfaces() {
        return interfaces;
    }

    public void addOptionInterface(String order, OptionsInterface optionsInterface) {
        interfaces.put(order, optionsInterface);
    }

    public void removeOptionInterface(String interfaceOrder) {
        interfaces.remove(interfaceOrder);
    }

    public HashMap<String, String> run() {
        boolean keepRunning = true;

        while (keepRunning) {
            OptionsInterface optionInterface = interfaces.get(pointer);
            String option = optionInterface.run();
            String optionPointer = optionInterface.getPointer();

            System.out.println(option + " " + optionPointer);

            switch (option) {
                case "Go back": {
                    pointer = oldPointer;
                    break;
                }
                case "Exit": {
                    keepRunning = false;
                    break;
                }
                default: {
                    oldPointer = pointer;
                    pointer = pointer + " " + optionPointer;
                    break;
                }
            }

            boolean noMoreInterfaces;

            if (interfaces.containsKey(pointer)) {
                noMoreInterfaces = false;
            } else {
                noMoreInterfaces = true;
            }

            if (noMoreInterfaces) {
                HashMap<String, String> interfaceData = new HashMap<>();
                interfaceData.put("id", optionInterface.getId());
                interfaceData.put("option", option);
                return interfaceData;
            }
        }

        return null;
    }
}

/*
public class OptionsMenu{
    private String id;
    private String name;
    private HashMap<String, OptionsInterface> interfaces;
    private boolean keepRunning = true;
    private String oldPointer = "1";
    private String pointer = "1";

    public OptionsMenu(String id, String name, HashMap<String, OptionsInterface> interfaces) {
        this.id = id;
        this.name = name;
        this.interfaces = interfaces;
    }
    public HashMap<Object, Object> run(){
        if(!keepRunning){
            keepRunning = true;
        }

        Scanner input = new Scanner(System.in);
        int count = 0;

        while (keepRunning){
            OptionsInterface anOptionsInterface = interfaces.get(pointer);

            String text = anOptionsInterface.toString();

            boolean noMoreGuis = false;

            if(count < 2){
                System.out.println(text);
            }else{
                count = 0;
            }

            System.out.print("Input: ");

            String inputResult = input.next();

            for (String key : interfaces.keySet()) {
                if(!key.equals(pointer)){
                    if (key.contains(pointer) && key.length() > pointer.length()) {
                    } else{
                        noMoreGuis = true;
                    }
                }
            }

            if(noMoreGuis){
                String guiOption = anOptionsInterface.getOptions().get(inputResult);

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
                        guiData.put("gui", anOptionsInterface);
                        guiData.put("option", inputResult);

                        return guiData;
                    }
                };
            }else{
                String index = pointer;

                if(interfaces.size() == 1){
                    String guiOption = anOptionsInterface.getOptions().get(inputResult);

                    if(guiOption.equals("Go back")){
                        pointer = oldPointer;
                    }else if(guiOption.equals("Exit")){
                        keepRunning = false;
                    }else{
                        HashMap<Object, Object> guiData = new HashMap<>();
                        guiData.put("gui", anOptionsInterface);
                        guiData.put("option", inputResult);

                        return guiData;
                    }
                }else{
                    index = pointer + " " + inputResult;
                }


                if(interfaces.containsKey(index)){
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
*/