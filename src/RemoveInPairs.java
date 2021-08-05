import java.util.Stack;

/**
 * 짝지어 삭제하기 - Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class RemoveInPairs {
    public int solution(String s) {
        int answer = -1;
        Stack stack = new Stack();
        char[] cArr = s.toCharArray();
        for ( int i = 0; s.length() > i; i++) {
            //System.out.println(stack);
            if ( stack.empty()) { // 스택이 비어있을 경우
                stack.push(cArr[i]);
            }
            else if ( (char) stack.peek() == cArr[i]) { // 값이 동일한 경우
                stack.pop();
            }
            else {  // 값이 동일하지 않은 경우
                stack.push(cArr[i]);
            }
        }
        return answer = (stack.empty()) ? 1 : 0;
    }

    public static void main(String[] args) {
        RemoveInPairs rip = new RemoveInPairs();
        rip.solution("baabaa");
    }
}
