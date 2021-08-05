/**
 * 멀쩡한 사각형 - Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */
public class NormalSquare {
    public long solution(int w, int h) {
        long answer = (long) w*h;
        int whAdd = w + h;
        int min = Math.min(w,h);
        int gcd = 1;
        for ( int i = 2; min >= i; i++) {
            if ( w % i == 0 && h % i == 0) {    // 최대 공약수 구하기
                w /= i; h /= i;
                gcd *= i;
                i--;
            }
            if ( i > w || i > h) {  // 시간 단축을 위해서 중간에 break
                break;
            }
        }
        return answer -= whAdd-gcd;
    }

    public static void main(String[] args) {
        NormalSquare ns = new NormalSquare();
        System.out.println(ns.solution(8, 12));
    }
}

/*
8 * 12 = 96 - 16
2    3

6 * 12 = 72 - 12
1    2

4 * 12 = 48 - 12
1    3

4 * 4 = 16 - 4
1   1

>> w + h - 최대공약수
 */