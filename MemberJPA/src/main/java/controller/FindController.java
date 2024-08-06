package controller;

import model.service.MemberService;

import java.util.Scanner;

public class FindController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        System.out.println("회원 정보 검색 처리를 시작합니다.");
        System.out.print("아이디: ");
        String id = sc.nextLine();

        //회원 검색 처리
        //회원 검색 성공 시 회원 정보 출력
        //회원 검색 실패 시 실패 메시지 출력
        MemberService.getInstance().deleteMember(id);
    }
}
