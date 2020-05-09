package ch03;

public class MemberInfoPrinter {

    private MemberDao memberDao;
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
