package chapter04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Homework0331 {
    public static final int SIZE = 3;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //1.학생성적프로그램 작성 (10명정도)
        //학생정보: 이름, 나이, 성별, 국어, 영어, 총점, 평균, 등급 배열로 저장
        String[] name = new String[SIZE];
        int[] age = new int[SIZE];
        char[] gender = new char[SIZE];
        int[] kor = new int[SIZE];
        int[] eng = new int[SIZE];
        int[] total = new int[SIZE];
        double[] avg = new double[SIZE];
        String[] grade = new String[SIZE];
        int choice=0;
        boolean stopFlag = false;

        while(!stopFlag) {
            //메뉴생성(학생입력, 학생출력, 학생계산, 학생검색(이름))
            System.out.println("=================");
            System.out.println("1.학생정보 입력");
            System.out.println("2.학생정보 출력");
            System.out.println("3.학생점수 계산");
            System.out.println("4.학생검색");
            System.out.println("5.종료");
            System.out.println("=================");
            while (true) {
                System.out.print("메뉴 번호 입력: ");
                String input = s.nextLine();
                boolean isInputCheck = Pattern.matches("^[1-5]$", input);
                if(isInputCheck){
                    choice = Integer.parseInt(input);
                    break;
                }
                System.out.println("유효한 번호를 입력해주세요");
            }
            switch (choice) {
                case 1:
                    for(int i=0; i<SIZE; i++){
                        while(true) {
                            System.out.print("이름: ");
                            name[i] = s.nextLine();
                            boolean isInputCheck = Pattern.matches("^[가-힣]{2,4}$", name[i]);
                            if(isInputCheck){
                                break;
                            }
                            System.out.println("유효한 값을 입력해주세요");
                        }
                        while(true) {
                            System.out.print("나이: ");
                            String input = s.nextLine();
                            boolean isInputCheck = Pattern.matches("^[0-9]{1,3}$",input);
                            if(isInputCheck) {
                                age[i] = Integer.parseInt(input);
                                break;
                            }
                            System.out.println("유효한 값을 입력해주세요");
                        }
                        while(true){
                            System.out.print("성별(m/f): ");
                            String input = s.nextLine().toLowerCase();
                            boolean isInputCheck = Pattern.matches("^[m,f]$",input);
                            if(isInputCheck) {
                                gender[i] = input.charAt(0);
                                break;
                            }
                            System.out.println("유효한 값을 입력해주세요");
                        }
                        while(true){
                            System.out.print("국어: ");
                            String input = s.nextLine();
                            boolean isInputCheck = Pattern.matches("^[0-9]{1,3}$",input);
                            if(isInputCheck) {
                                kor[i] = Integer.parseInt(input);
                                break;
                            }
                            System.out.println("유효한 값을 입력해주세요");
                        }
                        while (true) { 
                            System.out.print("영어: ");
                            String input = s.nextLine();
                            boolean isInputCheck = Pattern.matches("^[0-9]{1,3}$",input);
                            if(isInputCheck) {
                                eng[i] = Integer.parseInt(input);
                                break;
                            }
                            System.out.println("유효한 값을 입력해주세요");
                        }
                    }
                    break;
                case 2:
                    for(int i=0; i<SIZE; i++){
                        System.out.println("학생이름:"+name[i]);
                        System.out.println("나이:"+age[i]);
                        System.out.println("성별:"+gender[i]);
                        System.out.println("국어점수:"+kor[i]);
                        System.out.println("영어점수 :"+eng[i]);
                        System.out.println("총점:"+total[i]);
                        System.out.println("평균:"+avg[i]);
                        System.out.println("등급:"+grade[i]);
                        System.out.println();
                    }
                    break;
                case 3:
                    for(int i=0; i<SIZE; i++){
                        total[i] = kor[i] + eng[i];
                        avg[i] = total[i]/2.0;
                        if(100>avg[i] && avg[i]>=95){
                            grade[i] = "A+";
                        }else if(95>avg[i] && avg[i]>=90){
                            grade[i] = "A";
                        }else if(90>avg[i] && avg[i]>=85){
                            grade[i] = "B+";
                        }else if(85>avg[i] && avg[i]>=80){
                            grade[i] = "B";
                        }else if(80>avg[i] && avg[i]>=75){
                            grade[i] = "C+";
                        }else if(75>avg[i] && avg[i]>=70){
                            grade[i] = "C";
                        }else if(70>avg[i] && avg[i]>=65){
                            grade[i] = "D+";
                        }else if(65>avg[i] && avg[i]>=60){
                            grade[i] = "D";
                        }else {
                            grade[i] = "F";
                        }
                    }
                    System.out.println("점수 계산 완료");
                    break;
                case 4:
                    System.out.print("검색할 학생 이름입력: ");
                    String search = s.nextLine();
                    boolean isSearched = false;
                    for(int i=0; i<SIZE; i++){
                        if(search.equals(name[i])){
                            isSearched = true;
                            System.out.println(search+"이름을 가진 학생을 찾았습니다");
                            System.out.println("학생이름:"+name[i]);
                            System.out.println("나이:"+age[i]);
                            System.out.println("성별:"+gender[i]);
                            System.out.println("국어점수:"+kor[i]);
                            System.out.println("영어점수 :"+eng[i]);
                            System.out.println("총점:"+total[i]);
                            System.out.println("평균:"+avg[i]);
                            System.out.println("등급:"+grade[i]);
                            System.out.println();
                            break;
                        }
                    }
                    if(!isSearched){
                        System.out.println(search+"이름을 가진 학생을 찾을 수 없습니다.");
                    }
                    break;
                default:
                    stopFlag = true;
                    break;
            }
        }
        s.close();
        System.out.println("The End");
    }
}