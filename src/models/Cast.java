package models;

public class Cast {
    private String fullName;
    private String role;

    public Cast() {}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return String.format("actor: %-20s | role: %s", getFullName(), getRole());
    }
}
