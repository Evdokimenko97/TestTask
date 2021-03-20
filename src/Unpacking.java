import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Unpacking {
    public static void unpackingString(String str) {
        List<String> array = new ArrayList<>(); // Массив для складирования строк по разделителю '[]'
        List<Object> longString = new ArrayList<>(); // Массив с распакованной строкой

        StringTokenizer st = new StringTokenizer(str, "[]", false);
        while (st.hasMoreTokens()) {
            array.add(st.nextToken("[]"));
        }

        try {
            for (int i = array.size() - 1; i >= 0; i--) {

                //Добавляем символ, который не является числом и элемент в цикле перед ним тоже не число
                if (!array.get(i).matches("\\d") && !array.get(i - 1).matches("\\d")) {
                    longString.add(array.get(i));
                }

                //Добавляем символ, у которого впереди цикла есть число. Добавление символа = числу впереди.
                if (array.get(i).matches("\\d") && !array.get(i + 1).matches("\\d")) {
                    for (int q = 0; q < (Integer.parseInt(array.get(i))); q++) {
                        longString.add(array.get(i + 1));
                    }
                }

                //Повторяем добавление списка символов, если предыдущий и нынешний элемент цикла равны числам
                if (array.get(i).matches("\\d") && array.get(i + 1).matches("\\d")) {
                    for (int q = 0; q < (Integer.parseInt(array.get(i))) - 1; q++) {

                        Object[] stringArray = longString.toArray();
                        Collections.addAll(longString, stringArray);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Строка не валидна.");
        }

        //Выводим сформированный список в обратном порядке
        for (int i = longString.size() - 1; i >= 0; i--) {
            System.out.print(longString.get(i));
        }
    }
}