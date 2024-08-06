package controller;

import model.service.MemberService;

import java.util.Scanner;

public class RemoveController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        System.out.println("회원 정보 삭제 처리를 시작합니다.");
        System.out.print("아이디: ");
        String id = sc.nextLine();

        //회원 삭제 처리
        //회원 삭제 성공 시 성공 메시지 출력
        MemberService.getInstance().deleteMember(id);
    }
}
