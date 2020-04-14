package human_resource.entity;

public class Employees {
    private String name;
    private String address;
    private String email;
    private String username;
    private String password;
    private String dateCreated;
    private String dateUpdated;
    private int status;

    public Employees() {
    }

    public Employees(String name, String address, String email, String username, String password, String dateCreated, String dateUpdated, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateUpdated='" + dateUpdated + '\'' +
                ", status=" + (status == 1 ? "dang hoat dong" : (status == 0 ? "khong ton tai" : "khong xac dinh")) +
                '}';
    }
}
