package ir.bestdroid.dobay.model;

public class Sub2CategoryModel {

    private int id;
    private int mainCatId;
    private int catId;
    private int subCatId;
    private String title;
    private String icon;
    private int fav;
    private String fileName;
    private int is2Level;


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

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
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

    public int getIs2Level() {
        return is2Level;
    }

    public void setIs2Level(int is2Level) {
        this.is2Level = is2Level;
    }
}
