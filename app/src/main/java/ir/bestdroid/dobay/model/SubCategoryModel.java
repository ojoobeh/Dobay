package ir.bestdroid.dobay.model;

public class SubCategoryModel {

    private int id;
    private int mainCatId;
    private int catId;
    private String title;
    private String icon;
    private int fav;
    private String fileName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainCatId() {
        return mainCatId;
    }

    public void setMainCatId(int mainCatId) {
        this.mainCatId = mainCatId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
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
}
