package ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {

    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일!!!");
    }

    public void print(Member member) {
        if(dateTimeFormatter == null) {
            System.out.printf("member info(dateTimeFormatter==null): id=%d, email=%s, name=%s, register=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("member info: id=%d, email=%s, name=%s, register=%s\n",
                    member.getId(), member.getEmail(), member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

//    @Autowired(required = false)
//    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//        this.dateTimeFormatter = dateTimeFormatter;
//    }
}
