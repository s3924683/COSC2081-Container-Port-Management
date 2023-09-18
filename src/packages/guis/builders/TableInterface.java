package packages.guis.builders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TableInterface{
    private String[] cols;
    private String delimiter;
    private String id;
    private String name;
    private HashMap<String, String[]> rows = new HashMap<>();
    public TableInterface(String id, String name, String[] cols, String delimiter) {
        this.id = id;
        this.name = name;
        this.cols = cols;
        this.delimiter = delimiter;
    }
    private String[] getPartsFromLine(String line){
        return line.split(delimiter);
    }
    private boolean hasSameColsLength(String[] parts){
        return parts.length <= cols.length;
    }
    public boolean addRow(String line){
        String[] parts = getPartsFromLine(line);

        if(!hasSameColsLength(parts)) return false;

        int count = rows.size() + 1;
        rows.put(String.valueOf(count), parts);

        return  true;
    }
    public boolean setRow(int index, String line){
        String[] parts = getPartsFromLine(line);

        if(!hasSameColsLength(parts)) return  false;

        rows.put(String.valueOf(index), parts);

        return  true;
    }
    public boolean removeRow(int index){
        String value = String.valueOf(index);

        if (rows.containsKey(value)) {
            rows.remove(value);
            return true;
        } else {
           return  false;
        }
    }
    public String toString(){
        String horizontalLine = "-";
        String intersection = "+";
        String verticalLine= "|";

        int[] longestTextLength = new int[cols.length];

        int count = 0;

        for (String col : cols) {
            longestTextLength[count] = col.length();
            count++;
        }

        count = 0;

        for(Map.Entry<String, String[]> entry : rows.entrySet()){
            String index = entry.getKey();
            String[] row = entry.getValue();

            for(int i = 0; i < row.length; i++){
                String value = row[i];

                if(longestTextLength[count] < value.length()){
                    longestTextLength[count] = value.length();
                }
                count++;
            }

            count = 0;
        }

        StringBuilder table = new StringBuilder();

        table.append(name);
        table.append("\n");

        String line = horizontalLine.repeat(Arrays.stream(longestTextLength).sum() + cols.length -1);

        table.append(intersection)
                .append(line)
                .append(intersection).append("\n");
        table.append(verticalLine);

        for(int i = 0; i < cols.length; i++){
            String col = cols[i];

            if(col.length() < longestTextLength[i]){
                col = col + " ".repeat(longestTextLength[i] - col.length());
            }

            table.append(col);
            /*
            String spacing = " ".repeat((longestTextLength[i] - col.length())/2);

            table.append(spacing)
                   .append(col)
                   .append(spacing);

            */
            table.append(verticalLine);
        }

        table.append("\n").append(intersection).append(line).append(intersection);



        /*
        for(Map.Entry<String, String[]> entry : rows.entrySet()){
            String index = entry.getKey();
            String[] row = entry.getValue();

            for(int i = 0; i < row.length; i++){
               // value = row[i];
            }
        }

        table.append(verticalLine)
                .append(" ".repeat((line.length() - name.length())/2))
                .append(name)
                .append(" ".repeat((line.length() - name.length())/2))
                .append("|");
        */
        return table.toString();
    }

    public static void main(String[] args) {
        String[] stringArray = {"id", "name", "age"};

        TableInterface test = new TableInterface("test","Test",stringArray,",");

        test.addRow("p03,Cookie,100 ");
        test.addRow("p01,Jam,5");

        System.out.println(test.toString());
    }
}
