package ir.bestdroid.dobay.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.File;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.connection.ApiClient;
import ir.bestdroid.dobay.database.DbHandler;
import ir.bestdroid.dobay.newModels.paragraphs.CallParagraphs;
import ir.bestdroid.dobay.newModels.season.CallSeasons;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.newModels.books.CallBooks;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.PermissionActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashActivity extends PermissionActivity {
    // TODO: 98/03/23

    Activity activity;
    DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: 98/05/05

        setContentView(R.layout.activity_splash);
        A.A();
        initView();


        getListBook();


    }

    private void getListBook() {

        if (A.isNetworkAvailable(activity)) {


        } else {

            if (dbHandler.getBooks().getId() > 0) {

                afterSetAppInfo();

            } else {

                showFirstNetwork();

            }

        }


    }


    private void afterSetAppInfo() {

        if (dbHandler.getListSeasons().size() > 0) {

            for (int i = 0; i < dbHandler.getListSeasons().size(); i++) {


            }


        } else {

            setToast("در حال بارگزاری اولیه...\nلطفا منتظر بمانید...");


        }


        A.setDelay(5000, new A.OnDelay() {
            @Override
            public void AfterOnDelay() {

                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }

    private void setToast(String s) {


    }

    private void afterDownload() {


    }

    private void createFile() {

        setPermission(20, WRITE_EXTERNAL_STORAGE);

        File file = new File(C.BASEPATH);

        if (!file.exists()) {
            file.mkdirs();
        }


        String[] imageList = getResources().getStringArray(R.array.imageNames);


        for (int i = 0; i < imageList.length; i++) {

            File file1 = new File(C.BackgroundPATH + "/" + imageList[i]);
            if (!file1.exists()) {
                A.CopyMyPick(activity, C.BackgroundPATH, imageList[i]);
            }

        }


    }

    public void initView() {
        activity = this;
        dbHandler = new DbHandler(activity);
    }

    public static boolean hasPermissions(Activity activity, String... permissions) {

        if (activity != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }


    private void showFirstNetwork() {


        getFirstInformation();

    }

    private void getFirstInformation() {


        Call<CallBooks> getListBook = ApiClient.createAPI()
                .getBooks(C.api_key);

        getListBook.enqueue(new Callback<CallBooks>() {
            @Override
            public void onResponse(Call<CallBooks> call, Response<CallBooks> response) {


                if (response != null && response.body().getStatus().equals("1")) {

                    dbHandler.insertAppInfo(response.body().getData().get(0));
                }

                getFirstSeasons();


            }

            @Override
            public void onFailure(Call<CallBooks> call, Throwable t) {

                A.C();

            }
        });


    }

    int seasonCounter = 0;
    int seasonSize = 0;

    private void getFirstSeasons() {


        Call<CallSeasons> getSeasons = ApiClient.createAPI()
                .getSeasons(C.api_key);

        getSeasons.enqueue(new Callback<CallSeasons>() {
            @Override
            public void onResponse(Call<CallSeasons> call, Response<CallSeasons> response) {

                if (response.body() != null) {

                    if (response.body().getStatus().equals("1")) {

                        seasonSize = response.body().getData().size();

                        for (int i = 0; i < response.body().getData().size(); i++) {
                            seasonCounter++;
                            dbHandler.insertSeasons(response.body().getData().get(i));
                            getFirstParagraphs(response.body().getData().get(i).getId());

                        }


                    } else {
                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            }

            @Override
            public void onFailure(Call<CallSeasons> call, Throwable t) {


            }
        });


    }

    private void getFirstParagraphs(int seasonId) {


        Call<CallParagraphs> getParagraphs = ApiClient.createAPI()
                .getParagraphs(seasonId, C.api_key);

        getParagraphs.enqueue(new Callback<CallParagraphs>() {
            @Override
            public void onResponse(Call<CallParagraphs> call, Response<CallParagraphs> response) {

                if (response.body() != null) {

                    if (response.body().getStatus().equals("1")) {

                        for (int i = 0; i < response.body().getData().size(); i++) {
                            dbHandler.insertParagraphs(response.body().getData().get(i));
                        }

                        if (seasonSize == seasonCounter) {

                            sfterSetDatabase();

                        }


                    } else {

                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            }

            @Override
            public void onFailure(Call<CallParagraphs> call, Throwable t) {

            }
        });


    }

    private void sfterSetDatabase() {

        startActivity(new Intent(activity, MainActivity.class));


    }


}
