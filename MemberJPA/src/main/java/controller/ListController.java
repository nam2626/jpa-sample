package controller;

import model.entity.Member;
import model.service.MemberService;

import java.util.List;
import java.util.Scanner;

public class ListController implements Controller {
    @Override
    public void execute(Scanner sc) throws Exception {
        System.out.println("회원 전체 목록을 출력합니다.");
        List<Member> list = MemberService.getInstance().getMemberList();
        for (Member m : list) {
            System.out.println(m);
        }
    }
}
