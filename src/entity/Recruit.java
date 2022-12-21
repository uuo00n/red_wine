package entity;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/21 0:06
 */
public class Recruit {
    private int id; // id
    private String title; // 职位名称
    private String job_describe; // 职位描述
    private String requirement; // 招聘要求

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJob_describe(String job_describe) {
        this.job_describe = job_describe;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getJob_describe() {
        return job_describe;
    }

    public String getRequirement() {
        return requirement;
    }
}
