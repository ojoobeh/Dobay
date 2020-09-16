package ir.bestdroid.dobay.model;

import java.util.List;

public class CallBackFindErrorModels {

    String msg;
    String section_id;
    String section_title;
    int type;
    List<FindErrorModels> topic;

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

    public List<FindErrorModels> getTopic() {
        return topic;
    }

    public void setTopic(List<FindErrorModels> topic) {
        this.topic = topic;
    }
}
