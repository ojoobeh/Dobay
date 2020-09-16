package ir.bestdroid.dobay.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.activity2.DetailActivity;
import ir.bestdroid.dobay.adapter.CategoryAdapter;
import ir.bestdroid.dobay.connection.ApiClient;
import ir.bestdroid.dobay.database.DbHandler;
import ir.bestdroid.dobay.model.CategoryModel;
import ir.bestdroid.dobay.newModels.books.CallBooks;
import ir.bestdroid.dobay.newModels.season.CallSeasons;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.PermissionActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends PermissionActivity {
    Activity activity;

    protected RecyclerView categoryList;
    protected TextView tooltxt;
    protected ImageView LOGO;
    protected ImageView BackIcon;
    protected Toolbar maintoolbar;

    int parentId;
    String Subtitle, Title;
    DbHandler db;
    CategoryAdapter adapter;
    List<Integer> listId = new ArrayList<>();
    List<String> listName = new ArrayList<>();


    DrawerLayout drawer;


    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A.A();

        initView();
        setToolbar();

        Clicked();

        getData();
        clicked();


    }

    private void Clicked() {






    }

    private void goToLink(String link) {


        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);

    }


    private void setData() {


    }


    private boolean isLogin() {

        if (A.getBoolean(activity, C.SH_ISLOGIN)) {

            return true;
        } else {
            return false;
        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            A.doFinish(activity);
        }
    }


    public void initView() {
        activity = this;

        db = new DbHandler(activity);
        adapter = new CategoryAdapter(activity);
        categoryList = findViewById(R.id.category_List);
        categoryList.setLayoutManager(new LinearLayoutManager(activity));
        BackIcon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        LOGO = (ImageView) findViewById(R.id.cheshme_oghab_logo);
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        //  MainBackground = findViewById(R.id.mainbackground);

        ImageView imageView = findViewById(R.id.imgLogo);
        int d = A.getInt(activity, C.IMGNUMBER);
//        imageView.setImageDrawable(getResources().);


    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(getResources().getString(R.string.app_name));

//        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.DST);

        setSupportActionBar(toolbar);


    }


    public void setImageBackground(String name) {


    }




    private void clicked() {

    }



    private void getData() {

        Call<CallSeasons> getSeasons = ApiClient.createAPI()
                .getSeasons(C.api_key);

        getSeasons.enqueue(new Callback<CallSeasons>() {
            @Override
            public void onResponse(Call<CallSeasons> call, Response<CallSeasons> response) {

                if (response.body()!=null){

                    if (response.body().getStatus().equals("1")){



                    }else {
                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }



            }

            @Override
            public void onFailure(Call<CallSeasons> call, Throwable t) {



            }
        });






    }


}
