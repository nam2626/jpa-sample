package controller;

import model.entity.Member;
import model.service.MemberService;

import java.util.Scanner;

public class ChangeController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        System.out.println("회원 정보 변경 처리를 시작합니다.");
        System.out.print("아이디: ");
        String id = sc.nextLine();
        System.out.print("비밀번호: ");
        String password = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("이메일: ");
        String email = sc.nextLine();
        System.out.print("전화번호: ");
        String addr = sc.nextLine();

        Member member = MemberService.getInstance().selectMember(id);
        if(member != null)
        {
            member.setMemberPasswd(password);
            member.setMemberName(name);
            member.setMemberEmail(email);
            member.setMemberAddr(addr);
            MemberService.getInstance().updateMember(member);
        }
        else
        {
            System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
        }

        System.out.println("회원 정보 변경 처리가 완료되었습니다.");
    }
}
