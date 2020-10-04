package DZ6;


import lombok.Getter;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerText {

    @Getter
    private String text;

    @Getter
    private Map<String, Integer> sortedMap;

    public HandlerText(String path) {
        writeText(path);
        sortedWordAndCount();
    }

    private void writeText(String path) {
        try (FileReader reader = new FileReader(path)) {
            this.text = "";
            int c;
            while ((c = reader.read()) != -1) {
                text += (char) c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            this.text = "";
        }
    }

    private void sortedWordAndCount() {

        sortedMap = new TreeMap<>();

        Pattern pat = Pattern.compile("[A-Za-zА-Яа-я]{1,}");
        Matcher mat = pat.matcher(text);

        while (mat.find()) {
            String word = mat.group();
            if (sortedMap.containsKey(word)) {
                sortedMap.put(word, sortedMap.get((String) word) + 1);
            } else sortedMap.put(word, 1);
        }
    }

    public void showAllWordAndCount() {
        for (Map.Entry item : sortedMap.entrySet()) {
            System.out.println(item);
        }
    }

    public void showMaxCountWord() {

        int count = 0;
        for (Map.Entry item : sortedMap.entrySet()) {
            if ((int) item.getValue() > count)
                count =(int) item.getValue();
        }

        Map<String, Integer> mapMaxCount = new HashMap<>();

        for (Map.Entry item : sortedMap.entrySet()) {
            if ((int) item.getValue() == count)
                mapMaxCount.put((String) item.getKey(),(int) item.getValue());
        }

        for (Map.Entry item : mapMaxCount.entrySet()) {
            System.out.println(item);
        }
    }

}

