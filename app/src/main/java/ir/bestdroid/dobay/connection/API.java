package ir.bestdroid.dobay.connection;


import ir.bestdroid.dobay.model.BannerCallBack;
import ir.bestdroid.dobay.model.CallBackFindErrorModels;
import ir.bestdroid.dobay.model.ErrorCallBack;
import ir.bestdroid.dobay.model.NumberRequest;
import ir.bestdroid.dobay.model.ShoppingCallBack;
import ir.bestdroid.dobay.model.SupportCallBack;
import ir.bestdroid.dobay.model.SupportDetailCallBack;
import ir.bestdroid.dobay.model.SupportSubCallBack;
import ir.bestdroid.dobay.model.UserCallback;
import ir.bestdroid.dobay.newModels.books.CallBooks;
import ir.bestdroid.dobay.newModels.paragraphs.CallParagraphs;
import ir.bestdroid.dobay.newModels.season.CallSeasons;
import ir.bestdroid.dobay.newModels.user.CallUser;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Aaron on 5/21/2017.
 */
public interface API {







    @FormUrlEncoded
    @POST("api/v1/register")
    Call<CallUser> login(
            @Field("password") String password,
            @Field("imei") String imei,
            @Field("api_key") String api_key

    );


     @FormUrlEncoded
    @POST("api/v1/books")
    Call<CallBooks> getBooks(
            @Field("api_key") String api_key

    );

  @FormUrlEncoded
    @POST("api/v1/seasons")
    Call<CallSeasons> getSeasons(
            @Field("api_key") String api_key

    );

  @FormUrlEncoded
    @POST("api/v1/paragraphs")
    Call<CallParagraphs> getParagraphs(
            @Field("seasonId") int seasonId,
            @Field("api_key") String api_key

    );




//
// @FormUrlEncoded
//    @POST("v1/login")
//    Call<UserCallback> login(
//            @Field("mobile") String mobile,
//            @Field("password") String password,
//            @Field("imei") String imei,
//            @Field("api_key") String api_key
//
//    );




    @FormUrlEncoded
    @POST("v1/register")
    Call<UserCallback> register(
            @Field("name") String name,
            @Field("mobile") String mobile,
            @Field("password") String password,
            @Field("type") String type,
            @Field("imei") String imei,
            @Field("api_key") String api_key

    );



    @FormUrlEncoded
    @POST("v1/getShopping")
    Call<NumberRequest> getShopping(
            @Field("phone") String phone

    );


    @GET("v1/categories/8")
    Call<ErrorCallBack> getAllError();

    @GET("v1/categories/7")
    Call<SupportCallBack> getAllSupportList();


     @GET("v1/topics/7/cat/{cat}/page/{page}/count/{count}")
    Call<SupportSubCallBack> getAllSubSupportList(
             @Path("cat") int cat,
             @Path("page") int page,
             @Path("count") int count
     );

  @GET("v1/search/{search}/cat/{cat}/user/{user}")
    Call<CallBackFindErrorModels> FindMyError(
          @Path("search") String search,
          @Path("cat") int cat,
          @Path("user") int user
  );




    @GET("v1/topic/{topic}")
    Call<SupportDetailCallBack> getAllSupportDetails(
            @Path("topic") int topic

    );


//    @FormUrlEncoded
//    @POST("v1/register")
//    Call<SupportDetailCallBack> register(
//            @Path("name") int name,
//            @Path("mobile") int mobile,
//            @Path("password") int password,
//            @Path("type") int type
//
//    );


    @GET("v1/topics/10/page/0/count/100")
    Call<ShoppingCallBack> getAllShoppingList(


    );


     @GET("v1/banners/1")
    Call<BannerCallBack> getBanner();


    @FormUrlEncoded
    @POST("v1/forgetPass")
    Call<UserCallback> forgetPassword(@Field("mobile") String phone);
}
