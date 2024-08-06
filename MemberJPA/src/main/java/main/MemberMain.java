package main;

import controller.Controller;
import controller.HandlerMapping;

import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("회원 관리 프로그램");
            System.out.println("1. 등록");
            System.out.println("2. 찾기");
            System.out.println("3. 변경");
            System.out.println("4. 삭제");
            System.out.println("5. 전체 출력");
            System.out.println("6. 이름 검색");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int menu = sc.nextInt(); sc.nextLine();
            Controller controller = HandlerMapping.getInstance().createController(menu);
            if (controller != null){
                try {
                    controller.execute(sc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (menu == 0) {
                break;
            }
        }

    }
}
