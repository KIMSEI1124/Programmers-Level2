import java.util.Arrays;

/**
 * 순위 검색 - Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 */
public class RankFinder {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] volunteer = new String[info.length][];
        String[][] query2Arr = new String[query.length][];

        // TODO 지원자 정보 2차원배열에 저장
        get2Arr(info, volunteer);

        // TODO 쿼리 정보 2차원 배열에 저장
        get2Arr(query, query2Arr);

        // TODO 지원자와 쿼리를 비교
        countResult(answer, volunteer, query2Arr);

        return answer;
    }

    /**
     * 지원자의 언어, 직군, 경력, 소울 푸드, 점수를 2차원 배열에 저장
     * O(n)
     *
     * @param infoOrQuery 지원자 정보, 쿼리 1차원 배열
     * @param str2Arr     지원자 정보, 쿼리 2차원 배열 ( null )
     * @return 지원자 정보,쿼리 2차원 배열
     */
    public String[][] get2Arr(String[] infoOrQuery, String[][] str2Arr) {
        for (int i = 0; infoOrQuery.length > i; i++) {
            infoOrQuery[i] = infoOrQuery[i].replaceAll(" and ", " ");
            str2Arr[i] = infoOrQuery[i].split(" ");
//            System.out.println(Arrays.toString(str2Arr[i])); // 2차원 배열 출력 확인
        }
        return str2Arr;
    }


    /**
     * 2차원 배열을 비교하여 result 를 구한다.
     * O(n^3)
     *
     * @param answer        쿼리에 적합한 지원자의 수 배열 ( null )
     * @param volunteer2Arr 지원자 정보 2차원 배열
     * @param query2Arr     쿼리 2차원 배열
     * @return 쿼리에 적합한 지원자의 수 배열
     */
    public int[] countResult(int[] answer, String[][] volunteer2Arr, String[][] query2Arr) {
        for (int i = 0; query2Arr.length > i; i++) {
            int volunteerCount = 0;
            for (int j = 0; volunteer2Arr.length > j; j++) {
                for (int k = 0; volunteer2Arr[j].length > k; k++) {
                    if ( k < 4) {
                        if (query2Arr[i][k].equals("-"));
                        else if (!query2Arr[i][k].equals(volunteer2Arr[j][k])) break;
                    }
                    if (k == 4) {
                        int queryNum = Integer.parseInt(query2Arr[i][k]);
                        int volunteerNum = Integer.parseInt(volunteer2Arr[j][k]);
                        if ( queryNum > volunteerNum) break;
                    }
                    if ( k == 4) {
                        volunteerCount++;
                    }
                }
            }
            answer[i] = volunteerCount;
            volunteerCount = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        String[] info = new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        RankFinder rf = new RankFinder();
        System.out.println(Arrays.toString(rf.solution(info, query)));

        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        double secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : " + secDiffTime);
    }
}
