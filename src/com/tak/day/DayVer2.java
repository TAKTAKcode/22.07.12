package com.tak.day;

import java.util.Random;
import java.util.Scanner;

public class DayVer2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        String[] dayKorean = {"일", "월", "화", "수", "목", "금", "토"};
        String[] dayEnglish = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};

        System.out.print("요일명을 영어[소문자]로 입력해주세요 : ");

        int retry;      //다시 한번
        int last = -1;  //이전 요일

        do {
            int day;    //표시할 요일 : 0~6의 난수
            do {
                day = random.nextInt(7);
            } while (day == last);
            last = day;

            /* 정답보기 추가용!! */
            int action;
            do {
                System.out.print(dayKorean[day] + "요일 >> ");
                String record = sc.next();

                if (record.equals(dayEnglish[day])) {
                    System.out.println("정답입니다.");
                    break;
                }
                System.out.println("오답입니다.");
                do {
                    System.out.print("어떻게 할까요? 1..재입력 / 2..정답보가 : ");
                    action = sc.nextInt();
                } while (action != 0 && action != 1);
                if (action == 0) {
                    System.out.println(dayKorean[day] + "요일은\"" + //정답표시
                            dayEnglish[day] + "\"입니다.");
                }
            } while (action == 1);

            System.out.print("정답입니다. 다시 한번? 1...YES / 0...NO : ");
            retry = sc.nextInt();
        } while (retry == 1);
    }
}
