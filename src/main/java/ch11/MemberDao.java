package ch11;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

@Component
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> result = jdbcTemplate.query(
            "select * from MEMBER where EMAIL = ?",
            (ResultSet rs, int rowNum)-> {
                Member member = new Member(
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME"),
                        rs.getTimestamp("REGDATE").toLocalDateTime()
                );
                member.setId(rs.getLong("ID"));
                return member;
            }, email
        );

        return result.isEmpty() ? null : result.get(0);
    }

    public void insert(final Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection con)-> {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE) values(?,?,?,?)",
                    new String[] {"ID"}
            );
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

            return pstmt;
            }, keyHolder
        );
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
                member.getName(), member.getPassword(), member.getEmail()
        );
    }

    public List<Member> selectAll() {
        return jdbcTemplate.query(
            "select * from MEMBER",
            (ResultSet rs, int rowNum)-> {
                Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
                );
                member.setId(rs.getLong("ID"));
                return member;
        });
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class
        );
        return count;
    }

}
