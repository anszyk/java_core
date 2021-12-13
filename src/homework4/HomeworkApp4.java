package homework4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class HomeworkApp4 {

    public static void main(String[] args) {

        String[] arr = new String[]
                {"вот ", "дом ", "который ", "построил ","Джек ", "а ", "это ", "пшеница ","которая ", "в ", "темном ",
                        "чулане ", "хранится ", "в ", "доме ", "который ", "построил ", "Джек ", "а ", "это "};

        Set<String> setUniqueStrings = new LinkedHashSet<>();
        for(String s : arr) {
            setUniqueStrings.add(s);
        }
        for(String s : setUniqueStrings) {
            System.out.print(s);
        }

        System.out.println();

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : arr){
            if(!wordsCount.containsKey(s)){
                wordsCount.put(s, 1);
            }else{
                wordsCount.put(s, wordsCount.get(s) + 1);
            }
        }

        System.out.println(wordsCount);
        System.out.println();

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Иванова", 9000000000L);
        telephoneDirectory.add("Кочан", 9010000000L);
        telephoneDirectory.add("Савровская", 9020000000L);
        telephoneDirectory.add("Петров", 9030000000L);
        telephoneDirectory.add("Петров", 9040000000L);
        telephoneDirectory.add("Иванов", 9050000000L);
        telephoneDirectory.add("Климов", 9060000000L);

        System.out.println(telephoneDirectory.get("Петров"));
    }
}
