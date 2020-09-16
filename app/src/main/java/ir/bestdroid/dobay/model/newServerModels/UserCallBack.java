
package ir.bestdroid.dobay.model.newServerModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
public class UserCallBack {

    @SerializedName("agent_list")
    @Expose
    private List<AgentList> agentList;

    @SerializedName("data")
    @Expose
    private List<DatumUser> data;


    @SerializedName("msg")
    @Expose
    private String msg;


    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("is_show_payment")
    @Expose
    private int is_show_payment;

    @SerializedName("is_paypal")
    @Expose
    private int is_paypal;


    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("is_discount")
    @Expose
    private int is_discount;

    @SerializedName("is_agent")
    @Expose
    private int is_agent;


    public List<AgentList> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<AgentList> agentList) {
        this.agentList = agentList;
    }

    public List<DatumUser> getData() {
        return data;
    }

    public void setData(List<DatumUser> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public int getIsShowPayment() {
        return is_show_payment;
    }

    public void setIsShowPayment(int isShowPayment) {
        this.is_show_payment = isShowPayment;
    }

    public int getIs_show_payment() {
        return is_show_payment;
    }

    public void setIs_show_payment(int is_show_payment) {
        this.is_show_payment = is_show_payment;
    }

    public int getIs_paypal() {
        return is_paypal;
    }

    public void setIs_paypal(int is_paypal) {
        this.is_paypal = is_paypal;
    }

    public int getIs_discount() {
        return is_discount;
    }

    public void setIs_discount(int is_discount) {
        this.is_discount = is_discount;
    }

    public int getIs_agent() {
        return is_agent;
    }

    public void setIs_agent(int is_agent) {
        this.is_agent = is_agent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
