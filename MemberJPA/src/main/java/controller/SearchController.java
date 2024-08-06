package controller;

import model.entity.Member;
import model.service.MemberService;

import java.util.List;
import java.util.Scanner;

public class SearchController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        System.out.println("회원 정보 검색 처리를 시작합니다.");
        System.out.print("이름: ");
        String name = sc.nextLine();

        //회원 검색 처리
        //회원 검색 성공 시 회원 정보 출력
        List<Member> list = MemberService.getInstance().searhMember(name);
        if(list.size() > 0)
        {
            for (Member m : list) {
                System.out.println(m);
            }
        }
        else
        {
            //회원 검색 실패 시 실패 메시지 출력
            System.out.println("해당 이름의 회원이 존재하지 않습니다.");
        }
    }
}
