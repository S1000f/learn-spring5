package ch11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public AuthInfo authenticate(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            throw new WrongPasswordException();
        }

        if(!member.matchPassword(password)) {
            throw new WrongPasswordException();
        }

        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}
