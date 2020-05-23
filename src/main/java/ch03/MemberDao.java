package ch03;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
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
            },
            email
        );

        return result.isEmpty() ? null : result.get(0);
    }

    public void insert(Member member) {
    }

    public void update(Member member) {
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

}
