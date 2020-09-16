package ir.bestdroid.dobay.connection;




import ir.bestdroid.dobay.model.NumberRequest;
import ir.bestdroid.dobay.model.advertisement.CallAdvertisementDetail;
import ir.bestdroid.dobay.model.advertisement.CallAdvertisementList;
import ir.bestdroid.dobay.model.appSetting.CallAppSetting;
import ir.bestdroid.dobay.model.copoun.ActiveUserByCoupon;
import ir.bestdroid.dobay.model.discountModel.CallDiscount;
import ir.bestdroid.dobay.model.getLinkModels.CallGetLink;
import ir.bestdroid.dobay.model.newServerModels.UserCallBack;
import ir.bestdroid.dobay.model.price.CallBackPrices;
import ir.bestdroid.dobay.model.questionModels.CallQuestion;
import ir.bestdroid.dobay.model.serverModels.Message;
import ir.bestdroid.dobay.model.updateModels.CallBackHellp504;
import ir.bestdroid.dobay.model.updateModels.UpdateModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Aaron on 5/21/2017.
 */

public interface APIWebService {


    @FormUrlEncoded
    @POST("api/v1/login")
    Call<UserCallBack> login(
            @Field("mobile") String mobile,
            @Field("imei") String imei,
            @Field("verNumber") int verNumber,
            @Field("api_key") String api_key
    );

    @FormUrlEncoded
    @POST("api/users/sendVerifyAgain")
    Call<Message> resencode(
            @Field("mobile") String user_id
    );

    @FormUrlEncoded
    @POST("api/friends/getShopping")
    Call<NumberRequest> getShopping(
            @Field("user_id") String user_id

    );

    @FormUrlEncoded
    @POST("api/v1/profile")
    Call<UserCallBack> updateProfile(
            @Field("id") int user_id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("api_key") String api_key

    );

    @FormUrlEncoded
    @POST("api/v1/getCopounPercent")
    Call<CallDiscount> getCoupon(
            @Field("user_id") int user_id,
            @Field("api_key") String api_key,
            @Field("coupon_code") String coupon

    );

    @GET("version.php")
    Call<String> getVersion(

    );


    @FormUrlEncoded
    @POST("api/v1/verify")
    Call<UserCallBack> verify(
            @Field("mobile") String mobile,
            @Field("verify") String verify,
            @Field("imei") String imei,
            @Field("api_key") String api_key


    );

    @GET("api/v1/topics/13/page/0/count/20")
    Call<UpdateModel> updateAlarm();


    @GET("api/v1/topics/14/page/0/count/21")
    Call<UpdateModel> getLink();

    @GET("api/v1/topics/15/page/0/count/20")
    Call<CallBackHellp504> getHelp1100();


    @GET("api/v1/topics/16/page/0/count/20")
    Call<CallBackHellp504> getHelpReading();

    @GET("api/v1/topics/17/page/0/count/20")
    Call<CallBackHellp504> getHelpSmart();


    @GET("api/v1/topics/18/page/0/count/20")
    Call<CallBackHellp504> getHelpDictation();

    @GET("api/v1/topics/19/page/0/count/20")
    Call<CallBackHellp504> getHelpExam();

    @GET("api/v1/topics/20/page/0/count/20")
    Call<CallBackHellp504> getHelpIdioms();

    @FormUrlEncoded
    @POST("api/v1/user")
    Call<UserCallBack> updateShopping(
            @Field("id") int user_id,
            @Field("verNumber") int verNumber
            , @Field("api_key") String api_key

    );

    @FormUrlEncoded
    @POST("api/v1/user")
    Call<UserCallBack> getUser(
            @Field("id") int user_id,
            @Field("verNumber") int verNumber
            , @Field("api_key") String api_key

    );


    @GET("api/v1/topics/10/page/0/count/20")
    Call<CallBackPrices> getPrice();




    @FormUrlEncoded
    @POST("api/v1/getUsualQuestions")
    Call<CallQuestion> GetQuestionList(
            @Field("api_key") String api_key

    );

    @FormUrlEncoded
    @POST("api/v1/activeByCopon")
    Call<ActiveUserByCoupon> activeByCoupon(
            @Field("api_key") String api_key,
            @Field("coupon_code") String coupon_code,
            @Field("user_id") int user_id


    );






    @FormUrlEncoded
    @POST("api/v1/getroot_link")
    Call<CallGetLink> getLinkDownload(
            @Field("api_key") String api_key


    );

    @FormUrlEncoded
    @POST("api/v1/advertisement")
    Call<CallAdvertisementList> getAdvertisement(
            @Field("api_key") String api_key,
            @Field("user_id") int user_id


    );

    @FormUrlEncoded
    @POST("api/v1/advertisement_details")
    Call<CallAdvertisementDetail> getAdvertisement_details(
            @Field("api_key") String api_key,
            @Field("user_id") int user_id,
            @Field("adv_id") int adv_id


    );

    @FormUrlEncoded
    @POST("api/v1/app_setting")
    Call<CallAppSetting> getAppSetting(
            @Field("api_key") String api_key
    );


}
