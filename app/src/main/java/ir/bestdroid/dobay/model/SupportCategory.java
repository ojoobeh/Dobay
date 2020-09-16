package ir.bestdroid.dobay.model;

public class SupportCategory {

    int id;
    String title;
    String icon;
    String photo;
    String href;
    int sub_categories_count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getSub_categories_count() {
        return sub_categories_count;
    }

    public void setSub_categories_count(int sub_categories_count) {
        this.sub_categories_count = sub_categories_count;
    }
}
