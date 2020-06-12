package ch11;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class Member {

    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    //@JsonFormat(shape = JsonFormat.Shape.STRING) // ISO-8601 format
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime registerDateTime;

    public Member(String email, String password, String name, LocalDateTime registerDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = registerDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void changePassword(String oldPassword, String newOne) {
        if(!password.equals(oldPassword)) {
            throw new WrongPasswordException();
        }

        this.password = newOne;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}
