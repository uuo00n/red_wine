package entity;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/20 23:57
 */
public class Administrators {
    private int id; // 管理员ID
    private String name; // 用户名
    private String password; // 密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
