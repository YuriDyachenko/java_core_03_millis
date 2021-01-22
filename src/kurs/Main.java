package kurs;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String chars = "qwertyuiopasdfghjklzxcvbnm1234567890";
        int charsLen = chars.length();
        int n = 10000000;
        long saveMillis, currMillis;
        int countA;
        System.out.printf("Каждый цикл - %d итераций - присваивание c = chars.charAt(0..%d) \n", n, charsLen - 1);

        for (int j = 0; j < 10; j++) {
            System.out.printf("--- попытка: %d ---\n", j + 1);

            countA = 0;
            saveMillis = new Date().getTime();
            for (int i = 0; i < n; i++) {
                char c = chars.charAt(i % charsLen);
                if (c == 'a') countA++;
            }
            currMillis = new Date().getTime();
            System.out.printf("  char c - внутри цикла, countA = %d, прошло миллисекунд: %d\n",
                    countA, currMillis - saveMillis);

            countA = 0;
            saveMillis = new Date().getTime();
            char c;
            for (int i = 0; i < n; i++) {
                c = chars.charAt(i % charsLen);
                if (c == 'a') countA++;
            }
            currMillis = new Date().getTime();
            System.out.printf("  char c - перед циклом, countA = %d, прошло миллисекунд: %d\n",
                    countA, currMillis - saveMillis);
        }
    }
}
