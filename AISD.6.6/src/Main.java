import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 1, 1, 4, 4, 4};
        List<Integer> positions = JavaHash.findPositions(nums);
        List<Integer> positionsUsingMyHash = JavaHash.findPositionsUsingMyHash(nums);

        System.out.println("Позиции: " + positions);
        System.out.println("Позиции (Собственная реализация): " + positionsUsingMyHash);
    }
}

