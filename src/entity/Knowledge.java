package entity;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 0:01
 */
public class Knowledge {
    private int id;         // ID
    private String title;   // 标题
    private String author;  // 作者
    private String content; // 内容
    private String date;       // 发布时间

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
