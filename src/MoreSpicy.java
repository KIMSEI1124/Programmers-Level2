import java.util.*;
import java.util.stream.Collectors;

/*
더 맵게 - Level 2
https://programmers.co.kr/learn/courses/30/lessons/42626
*/

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        while ( queue.peek() < K && queue.size() >= 2) {
            int newSpicy = queue.poll() + (queue.poll() * 2);
            queue.offer(newSpicy);
            answer++;
        }
        if ( queue.peek() < K) return answer = -1;
        else return answer;
    }

    public static void main (String[]args){
        int[] arr1 = {1, 2, 3, 9, 10, 12};
        MoreSpicy ms = new MoreSpicy();
        ms.solution(arr1, 7);
    }
}
