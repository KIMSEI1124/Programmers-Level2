/**
 * 예상 대진표 - Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 */

public class ExpectedSchedule {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int round = 0;

        // TODO 2^n > n의 지수 구하기
        do {
            n /= 2;
            round++;
        } while (n > 1);

        // TODO 몇번만에 만나는지 구하기
        for (int i = 0; round > i; i++) {
            answer++;

            int max = Math.max(a, b);
            // a와 b가 대진표에서 만났을 경우
            if (max % 2 == 0 && max == (a + b + 1) / 2) break;
            if (a % 2 == 1) {   // a가 홀수일 경우
                a++;
            }
            if (b % 2 == 1) {   // b가 홀수일 경우
                b++;
            }
            a /= 2;
            b /= 2; // 라운드 종료시 번호 수정
        }
        return answer;
    }

    public static void main(String[] args) {
        ExpectedSchedule es = new ExpectedSchedule();
        System.out.println(es.solution(8, 4, 5));   // 7, 9, 27, 33
    }
}
