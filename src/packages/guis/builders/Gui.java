package packages.guis.builders;

import java.util.HashMap;
import java.util.Map;

public class Gui{
    private String id;
    private String name;
    private HashMap<String, String> options;
    private String text;

    public Gui(String id, String name, HashMap<String, String> options) {
        this.id = id;
        this.name = name;
        this.options = options;

        generateTextGui();
    }

    private void generateTextGui(){
        StringBuilder gui = new StringBuilder();

        gui.append("-------------------------------------------\n");
        gui.append("|   ").append(name).append("\n");
        gui.append("-------------------------------------------\n");

        for (Map.Entry<String, String> entry : options.entrySet()) {
            String optionNumber = entry.getKey();
            String optionText = entry.getValue();
            gui.append("| ").append(optionNumber).append(". ").append(optionText).append("\n");
        }

        gui.append("-------------------------------------------\n");

        text = gui.toString();
    }
    public String getId() {
        return id;
    }

    public HashMap<String, String> getOptions() {
        return options;
    }

    public void setOptions(HashMap<String, String> options) {
        this.options = options;
        generateTextGui();
    }

    public void addOption(String optionName, String optionDescription) {
        this.options.put(optionName, optionDescription);
        generateTextGui();
    }

    public void removeOption(String optionName) {
        this.options.remove(optionName);
        generateTextGui();
    }

    public String getText() {
        return text;
    }
}