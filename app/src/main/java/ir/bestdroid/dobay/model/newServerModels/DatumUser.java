
package ir.bestdroid.dobay.model.newServerModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
public class DatumUser {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("package1")
    @Expose
    private String package1;

    @SerializedName("package2")
    @Expose
    private String package2;

    @SerializedName("package3")
    @Expose
    private String package3;

    @SerializedName("package4")
    @Expose
    private String package4;

    @SerializedName("package5")
    @Expose
    private String package5;

    @SerializedName("package6")
    @Expose
    private String package6;

    @SerializedName("verify")
    @Expose
    private String verify;

    @SerializedName("is_show_payment")
    @Expose
    private int is_show_payment;

     @SerializedName("is_show_disCount")
    @Expose
    private int is_show_disCount;


     @SerializedName("is_show_agent")
    @Expose
    private int is_show_agent;



    @SerializedName("agent_list")
    @Expose
    List<AgentList> agentLists;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    public String getPackage2() {
        return package2;
    }

    public void setPackage2(String package2) {
        this.package2 = package2;
    }

    public String getPackage3() {
        return package3;
    }

    public void setPackage3(String package3) {
        this.package3 = package3;
    }

    public String getPackage4() {
        return package4;
    }

    public void setPackage4(String package4) {
        this.package4 = package4;
    }

    public String getPackage5() {
        return package5;
    }

    public void setPackage5(String package5) {
        this.package5 = package5;
    }

    public String getPackage6() {
        return package6;
    }

    public void setPackage6(String package6) {
        this.package6 = package6;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public List<AgentList> getAgentLists() {
        return agentLists;
    }

    public void setAgentLists(List<AgentList> agentLists) {
        this.agentLists = agentLists;
    }

    public int getIs_show_payment() {
        return is_show_payment;
    }

    public void setIs_show_payment(int is_show_payment) {
        this.is_show_payment = is_show_payment;
    }

    public int getIs_show_disCount() {
        return is_show_disCount;
    }

    public void setIs_show_disCount(int is_show_disCount) {
        this.is_show_disCount = is_show_disCount;
    }

    public int getIs_show_agent() {
        return is_show_agent;
    }

    public void setIs_show_agent(int is_show_agent) {
        this.is_show_agent = is_show_agent;
    }
}
