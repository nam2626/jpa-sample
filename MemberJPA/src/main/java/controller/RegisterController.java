package controller;

import model.entity.Grade;
import model.entity.Member;
import model.service.MemberService;

import java.util.Scanner;

public class RegisterController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        //회원 정보 입력 받은 뒤 회원 등록
        System.out.println( "회원 등록 처리를 시작합니다." );
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

        //회원 등록 처리
        //회원 등록 성공 시 성공 메시지 출력
        Member member = new Member();
        member.setMemberId(id);
        member.setMemberPasswd(password);
        member.setMemberName(name);
        member.setMemberEmail(email);
        member.setMemberAddr(addr);
        member.setGradeNo(1);

        MemberService.getInstance().insertMember(member);

        System.out.println( "회원 등록 처리가 완료되었습니다." );


    }
}
