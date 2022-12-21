package entity;

/**
 * @author uuo00_n(Hwang Jumbo)
 * @Date 2022/12/20 23:58
 */
public class Commodity {
    private int id;        //ID
    private int class_id;        //分类ID
    private String title;        //名称
    private float price;        //价格
    private String specifications;        //规格
    private String place;        //产地
    private String alcohol;        //酒精度
    private String photo;        //图片
    private String content;        //简介

    public void setId(int id) {
        this.id = id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getClass_id() {
        return class_id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public String getPlace() {
        return place;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public String getPhoto() {
        return photo;
    }

    public String getContent() {
        return content;
    }
}
