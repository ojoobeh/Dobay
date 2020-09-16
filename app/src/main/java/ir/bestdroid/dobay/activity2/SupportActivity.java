package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.bestdroid.dobay.adapter.SupportAdapter;
import ir.bestdroid.dobay.connection.ApiClient;
import ir.bestdroid.dobay.model.SupportCallBack;
import ir.bestdroid.dobay.model.SupportCategory;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupportActivity extends AppCompatActivity {

    protected TextView txtTell01;
    protected TextView txtTell02;
    protected RecyclerView recyclerView;
    protected ImageView imgInsta;
    protected ImageView imgWeb;
    Activity activity;
    int parentId;
    String Subtitle;
    int detail_id;

    SupportAdapter adapter;


    protected ImageView back_icon;
    protected Toolbar maintoolbar;
    protected TextView tooltxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        A.A();
        initView();
        clicked();
        getData();
        inittoolbar(Subtitle);

    }

    private void inittoolbar(String title) {
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        back_icon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        tooltxt.setText(title);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void clicked() {


        txtTell01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                call(txtTell01.getText().toString());
            }
        });

        txtTell02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                call(txtTell02.getText().toString());
            }
        });


        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getLink("http://www.maadgostar.ir/");


            }
            });


        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getLink("http://www.instagram.com/maadgostar");

            }
        });





    }

    private void initView() {
        activity = this;
        txtTell01 = (TextView) findViewById(R.id.txtTell01);
        txtTell02 = (TextView) findViewById(R.id.txtTell02);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        imgInsta = (ImageView) findViewById(R.id.imgInsta);
        imgWeb = (ImageView) findViewById(R.id.imgWeb);


    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        parentId = bundle.getInt(C.PUT_MAINCATID);
        Subtitle = bundle.getString(C.PUT_MAINCATTITLE);
        detail_id = bundle.getInt(C.PUT_ID);

        getAllSupport(1,0,100);
    }


    public void call(String phone) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }


    public void  getAllSupport(int cat,int page,int count){
        Call<SupportCallBack> errorCallBackCall= ApiClient.createAPI().getAllSupportList();
        errorCallBackCall.enqueue(new Callback<SupportCallBack>() {
            @Override
            public void onResponse(Call<SupportCallBack> call, Response<SupportCallBack> response) {

                List<SupportCategory> callBack=response.body().getTopics();

                if (callBack!=null){

                setList(callBack);
                }

                A.C();

            }

            @Override
            public void onFailure(Call<SupportCallBack> call, Throwable t) {

                A.T(t.toString());

            }
        });
    }

    private void setList(List<SupportCategory> callBack) {

        adapter=new SupportAdapter(activity,callBack);

        adapter.AddToList(callBack);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);


        adapter.SetOnItemClicked(new SupportAdapter.OnnItemSelect() {
            @Override
            public void OnItemClicked(SupportCategory categoryModel, int position) {


                Intent intent=new Intent(activity,SupportSubActivity.class);
                intent.putExtra("parentId",categoryModel.getId());
                intent.putExtra("parentTitle",categoryModel.getTitle());
                startActivity(intent);
            }
        });




    }

    public void getLink(String link) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);

    }


}
