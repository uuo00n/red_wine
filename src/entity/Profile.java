package entity;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 0:02
 */
public class Profile {
    private int id; // id
    private String content; // 简介內容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
