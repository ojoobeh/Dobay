package ir.bestdroid.dobay.model;

import java.util.List;

public class BannerCallBack {

    String msg;
    int type;
    int topics_count;
    int banners_count;
    List<Banner> banners;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTopics_count() {
        return topics_count;
    }

    public void setTopics_count(int topics_count) {
        this.topics_count = topics_count;
    }

    public int getBanners_count() {
        return banners_count;
    }

    public void setBanners_count(int banners_count) {
        this.banners_count = banners_count;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
