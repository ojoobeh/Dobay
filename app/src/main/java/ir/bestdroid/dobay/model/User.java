package ir.bestdroid.dobay.model;

/**
 * Created by Aron on 6/4/2016.
 */

public class User {


    int id;
    String name;
    String email;
    String mobile;
    String photo;
    int permissions_id;
    String type;
    int status;
    String connect_email;
    String connect_password;
    String provider;
    String provider_id;
    String access_token;
    String created_by;
    String updated_by;
    String created_at;
    String updated_at;
    String expire_date;
    int can_use;


    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public int getCan_use() {
        return can_use;
    }

    public void setCan_use(int can_use) {
        this.can_use = can_use;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPermissions_id() {
        return permissions_id;
    }

    public void setPermissions_id(int permissions_id) {
        this.permissions_id = permissions_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getConnect_email() {
        return connect_email;
    }

    public void setConnect_email(String connect_email) {
        this.connect_email = connect_email;
    }

    public String getConnect_password() {
        return connect_password;
    }

    public void setConnect_password(String connect_password) {
        this.connect_password = connect_password;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
