package packages.guis.builders;

import java.util.HashMap;
import java.util.Map;

public class OptionsInterface {
    private String id;
    private String name;
    private int width = 2;
    private HashMap<String, String> options;
    public String getId() {
        return id;
    }

    public HashMap<String, String> getOptions() {
        return options;
    }

    public String toString() {
        int gap = 5;
        int textLongestLength = 0;
        int index = 0;
        String[] texts = new String[options.size()];

        for (Map.Entry<String, String> entry : options.entrySet()) {
            String optionNumber = entry.getKey();
            String optionText = entry.getValue();

            String text = optionNumber + ". " + optionText;

            if (textLongestLength < text.length()) {
                textLongestLength = text.length();
            }

            texts[index] = text;
            index++;
        }

        for (int i = 0; i < texts.length; i++) {
            int textLength = texts[i].length();
            if (textLength < textLongestLength) {
                texts[i] = texts[i] + " ".repeat(textLongestLength - textLength);
            }
        }

        String line = "=".repeat(textLongestLength * width + (gap * width));

        StringBuilder gui = new StringBuilder();
        gui.append(line).append("\n");
        gui.append("|").append(" ".repeat((line.length() - name.length()) / 2)).append(name).append("\n");
        gui.append(line).append("\n");

        int count = 1;
        for (String text : texts) {
            if (count == width) {
                gui.append(" ".repeat(gap - 1)).append(text);
                gui.append("\n");
                count = 1;
            } else {
                if (count == 1) {
                    gui.append("|").append(" ".repeat(gap - 2)).append(text);
                } else {
                    gui.append(" ".repeat(gap - 1)).append(text);
                }
                count++;
            }
        }
        return gui.toString();
    }
}
