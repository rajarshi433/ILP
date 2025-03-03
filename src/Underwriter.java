import java.time.LocalDate;

public class Underwriter {
    private final long id = (long) (Math.random() * 100000);
    private String name;
    private LocalDate dob;
    private final LocalDate joiningDate = LocalDate.now();
    private String password;

    Underwriter(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.password = "user123" + this.name + id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public String getPassword() {
        return password;
    }
}
