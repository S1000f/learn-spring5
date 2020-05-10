package ch03;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            System.out.println("no data.\n");
            return;
        }

        printer.print(member);
        System.out.println();
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setPrinter(MemberPrinter memberPrinter) {
        this.printer = memberPrinter;
    }
}
