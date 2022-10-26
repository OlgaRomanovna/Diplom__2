package models;
import com.github.javafaker.Faker;

public class User {
    public String name;
    public String password;
    public String email;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    static Faker faker = new Faker();
    public static User getRandomUser() {
        return new User(
                faker.internet().safeEmailAddress(),
                faker.internet().password(),
                faker.name().username()
            );
        }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static User getRandomUser2() {
        return new User(
                faker.internet().safeEmailAddress(),
                faker.internet().password()
        );
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
