package entity;

public class Users
{
    private Long userId;
    private String name;
    private String password;
    private String email;
    private String phnNo;
    private String city;
    private String role;

    public Users(Long userId, String name, String password, String email, String phnNo, String city, String role)
    {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phnNo = phnNo;
        this.city = city;
        this.role = role;

    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public String getCity() {
        return city;
    }

    public String getRole()
    {
        return role;
    }


    @Override
    public String toString() {
        return userId + " | " + name + " | " + role;
    }
}
