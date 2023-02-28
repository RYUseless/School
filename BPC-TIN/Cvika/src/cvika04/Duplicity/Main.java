package cvika04.Duplicity;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map m1 = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader("textak.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] words = line.split(" ");//split slov dle mezery
                for (int i = 0; i < words.length; i++) {
                    if (m1.get(words[i]) == null) {
                        m1.put(words[i], 1);
                    } else {
                        int newValue = Integer.valueOf(String.valueOf(m1.get(words[i])));
                        newValue++;
                        m1.put(words[i], newValue);
                    }
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        Map<String, String> sorted = new TreeMap<String, String>(m1);
        for (Object key : sorted.keySet()) {
            System.out.println("\033[0;1m" + "Slovo: " + key + "\t | Opakuje se: " + m1.get(key));
        }


    }
}
