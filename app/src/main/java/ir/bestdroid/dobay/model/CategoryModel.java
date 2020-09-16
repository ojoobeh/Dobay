package ir.bestdroid.dobay.model;

public class CategoryModel {

    private int id;
    private int parentId;
    private String title;
    private String icon;
    private int fav;
    private String fileName;
    private int isEndUp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIsEndUp() {
        return isEndUp;
    }

    public void setIsEndUp(int isEndUp) {
        this.isEndUp = isEndUp;
    }
}
