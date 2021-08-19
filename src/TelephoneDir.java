import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class TelephoneDir {
    public boolean solution(String[] phone_book) {  // 효율성 테스트 3,4 오류
        boolean answer = true;
        char[][] phoneArr = new char[phone_book.length][];

        for (int i = 0; phone_book.length > i; i++) {
            phoneArr[i] = phone_book[i].toCharArray();
        }
        for (int i = 0; phoneArr.length > i; i++) {
            for (int j = 0; phoneArr.length > j; j++) {
                int min = Math.min(phoneArr[i].length, phoneArr[j].length);
                for (int k = 0; min > k; k++) {
                    if (phoneArr[i].length >= phoneArr[j].length) break;
                    else if (phoneArr[i][k] != phoneArr[j][k]) break;
                    if (k == phoneArr[i].length - 1 && phoneArr[i][k] == phoneArr[j][k]) answer = false;
                }
                if (!answer) break;
            }
            if (!answer) break;
        }
        return answer;
    }

    public boolean solution2(String[] phone_book) { // 1, 5, 13, 14 / 3, 4실패
        boolean answer = true;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(phone_book));
        for (String str : list) {
            for (int i = 0; list.size() > i; i++) {
                if (list.get(i).contains(str) && list.get(i).length() > str.length()) {
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
        }
        return answer;
    }

    public boolean solution3(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; phone_book.length > i; i++) {
            for (int j = 0; phone_book.length > j; j++) {
                if (phone_book[i].length() < phone_book[j].length()) {
                    // System.out.println( "phone_book[i] : " + phone_book[i] + ", phone_book[j].substring : " + phone_book[j].substring(0, phone_book[i].length()));
                    if (phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) return answer = false;
                }
            }
        }
        return answer = true;
    }

    public boolean solution4(String[] phone_book) {
        boolean answer;
        HashSet<String> hash = new HashSet<>();
        for (String phone_num : phone_book) hash.add(phone_num);
        for (String phone_num : hash) {
            for (int i = 1; phone_num.length() - 1 >= i; i++) {
                if (hash.contains(phone_num.substring(0, i))) return answer = false;
            }
        }
        return answer = true;
    }

    public static void main(String[] args) {
        TelephoneDir td = new TelephoneDir();
        String[] arr1 = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(td.solution4(arr1));
    }
}
