package ru.digitalleague.factory.ok;
import java.util.Locale;

public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Locale language;

    public Locale getLanguage() {
        return language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public User(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.language=Locale.getDefault();
    }
}
