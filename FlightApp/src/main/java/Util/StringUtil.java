package Util;

import java.util.ArrayList;

public class StringUtil {

    public StringUtil(){
    }

    // [][] -> []
    public static String[] flatten(String[][] data) {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++){
                list.add(data[i][j]);
            }
        }

        return list.toArray(new String[0]);
    }

}
