package ir.bestdroid.dobay.connection;


import java.util.concurrent.TimeUnit;

import ir.bestdroid.dobay.utils.C;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Aaron on 5/31/2016.
 */

public class RetrofitWebServiceAdapter {

    public static final String BASE_URL= C.BASE_URL;


    public static APIWebService createAPI() {



        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(APIWebService.class);
    }


}
