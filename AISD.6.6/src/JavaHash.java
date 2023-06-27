import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaHash {
    public static List<Integer> findPositions(int[] nums) {
        Map<Integer, List<Integer>> positionsMap = new HashMap<>();

        // Проходимся по массиву и сохраняем позиции каждого числа
        for (int i = 0; i < nums.length; i++) {
            if (!positionsMap.containsKey(nums[i])) {
                positionsMap.put(nums[i], new ArrayList<>());
            }
            positionsMap.get(nums[i]).add(i);
        }

        int maxCount = 0; // будет хранить наибольшее количество позиций
        List<Integer> maxCountPositions = new ArrayList<>(); // будет хранить список позиций нужного числа

        // Проходимся по словарю для поиска числа с наибольшим количеством позиций
        for (Map.Entry<Integer, List<Integer>> entry : positionsMap.entrySet()) {
            int number = entry.getKey(); // возвращаем число
            List<Integer> positions = entry.getValue(); // возращаем список позиций этого числа
            int count = positions.size(); // считаем сколько позиций

            if (count > maxCount) { // проверка на самое частое число
                maxCount = count;
                maxCountPositions.clear();
                maxCountPositions.addAll(positions);
            } else if (count == maxCount) {
                maxCountPositions.addAll(positions);
            }
        }

        return maxCountPositions;
    }
    // Поиск в словаре собственной реализации
    public static List<Integer> findPositionsUsingMyHash(int[] nums) {
        MyHash<Integer, List<Integer>> positionsMap = new MyHash<>();

        // Проходимся по массиву и сохраняем позиции каждого числа
        for (int i = 0; i < nums.length; i++) {
            if (!positionsMap.containsKey(nums[i])) {
                positionsMap.put(nums[i], new ArrayList<>());
            }
            positionsMap.get(nums[i]).add(i);
        }

        int maxCount = 0; // будет хранить наибольшее количество позиций
        List<Integer> maxCountPositions = new ArrayList<>(); // будет хранить список позиций нужного числа

        // Получаем все значения из словаря
        List<List<Integer>> values = positionsMap.getValues();

        // Проходимся по значениям для поиска числа с наибольшим количеством позиций
        for (List<Integer> positions : values) {
            int count = positions.size(); // считаем сколько позиций

            if (count > maxCount) { // проверка на самое частое число
                maxCount = count;
                maxCountPositions.clear();
                maxCountPositions.addAll(positions);
            } else if (count == maxCount) {
                maxCountPositions.addAll(positions);
            }
        }
        return maxCountPositions;
    }
}
