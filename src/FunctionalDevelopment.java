import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 기능 개발 - Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */

public class FunctionalDevelopment {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> progressesList = (ArrayList<Integer>) Arrays.stream(progresses).boxed().collect(Collectors.toList());
        ArrayList<Integer> speedsList = (ArrayList<Integer>) Arrays.stream(speeds).boxed().collect(Collectors.toList());
        Queue queue = new LinkedList();
        for (int i = 0; progressesList.size() > i; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; progressesList.size() > i; i++) {
                if (progressesList.get(i) < 100) {
                    progressesList.add(i, progressesList.get(i) + speedsList.get(i));
                    progressesList.remove(i + 1);
                }
            }
            //System.out.println(progressesList);
            if (progressesList.get(0) >= 100) {
                int count = 0;
                for (int i = 0; progressesList.size() > i; i++) {
                    if (progressesList.get(i) >= 100) {
                        queue.remove();
                        progressesList.remove(i);
                        speedsList.remove(i);
                        count++;
                        i--;
                    } else {
                        break;
                    }
                }
                answer.add(count);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        FunctionalDevelopment fd = new FunctionalDevelopment();
        int[] arr1 = new int[]{95, 90, 99, 99, 80, 99};    // 1, 3, 2
        int[] arr2 = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(fd.solution(arr1, arr2));
    }
}
