package ir.bestdroid.dobay.model;

import java.util.List;

public class SupportSubCallBack {

    String msg;
    String section_id;
    String section_title;
    int type;
    int topics_count;
    List<SupportDetails> topics;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_title() {
        return section_title;
    }

    public void setSection_title(String section_title) {
        this.section_title = section_title;
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

    public List<SupportDetails> getTopics() {
        return topics;
    }

    public void setTopics(List<SupportDetails> topics) {
        this.topics = topics;
    }
}
