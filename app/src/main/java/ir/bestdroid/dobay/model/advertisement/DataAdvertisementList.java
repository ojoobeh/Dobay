
package ir.bestdroid.dobay.model.advertisement;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
@SuppressWarnings("unused")
public class DataAdvertisementList {


    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("introtext")
    @Expose
    private String introtext;

    @SerializedName("name")
    @Expose
    private String name;

     @SerializedName("visit")
    @Expose
    private int visit;

     @SerializedName("link")
    @Expose
    private String link;

     @SerializedName("link_Description")
    @Expose
    private String link_Description;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {
        this.introtext = introtext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkDescription() {
        return link_Description;
    }

    public void setLinkDescription(String link_Description) {
        this.link_Description = link_Description;
    }
}
