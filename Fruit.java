import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Fruit {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line = br.readLine();
            String[] array = line.split("\\s+");
            System.out.println("В списке фруктов " + array.length);
            int max_lenght = 0;
            String str = null;
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() > max_lenght) {
                    max_lenght = array[i].length();
                    str = array[i];
                }
            }
            System.out.println("Самое длинное слово " + str + " " + max_lenght + " символов");

            HashMap<String, Integer> fruit_count = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                int count = 0;
                fruit_count.put(array[i], count);
            }
            for (int i = 0; i < array.length; i++) {
                int value = fruit_count.get(array[i]);
                fruit_count.put(array[i], value += 1);
            }
            List<Map.Entry<String, Integer>> fruit_list = new ArrayList<>(fruit_count.entrySet());
            Collections.sort(fruit_list, (key, value) -> Integer.compare(key.getValue(), value.getValue()));
            Map<String, Integer> sorted_fruit = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : fruit_list) {
                sorted_fruit.put(entry.getKey(), entry.getValue());
            }

            sorted_fruit.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
