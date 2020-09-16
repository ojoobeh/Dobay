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

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.adapter.DetailSupportAdapter;
import ir.bestdroid.dobay.connection.ApiClient;
import ir.bestdroid.dobay.model.SupportDetails;
import ir.bestdroid.dobay.model.SupportSubCallBack;
import ir.bestdroid.dobay.utils.A;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupportSubActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;
    Activity activity;
    int parentId;
    String Subtitle;
    int detail_id;

    DetailSupportAdapter adapter;


    protected ImageView back_icon;
    protected Toolbar maintoolbar;
    protected TextView tooltxt;

    String parentTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_support);
        A.A();
        initView();
        clicked();
        getData();
        inittoolbar(parentTitle);

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




    }

    private void initView() {
        activity = this;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


    }

    private void getData() {


        parentId = getIntent().getExtras().getInt("parentId", 0);
        parentTitle = getIntent().getExtras().getString("parentTitle", "پشتیبانی چشم عقاب");




        getAllSupport();
    }


    public void call(String phone) {




        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }


    public void  getAllSupport(){
        Call<SupportSubCallBack> errorCallBackCall= ApiClient.createAPI().getAllSubSupportList(parentId,0,100);
        errorCallBackCall.enqueue(new Callback<SupportSubCallBack>() {
            @Override
            public void onResponse(Call<SupportSubCallBack> call, Response<SupportSubCallBack> response) {

                List<SupportDetails> callBack=response.body().getTopics();

                if (callBack!=null){

                setList(callBack);
                }

                A.C();

            }

            @Override
            public void onFailure(Call<SupportSubCallBack> call, Throwable t) {

                A.T(t.toString());

            }
        });
    }

    private void setList(List<SupportDetails> callBack) {

        adapter=new DetailSupportAdapter(activity);

        adapter.AddToList(callBack);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);


//        adapter.SetOnItemClicked(new SupportSubAdapter.OnnItemSelect() {
//            @Override
//            public void OnItemClicked(SupportDetails categoryModel, int position) {
//
//
//
//                Intent intent=new Intent(activity,SupportDetailActivity.class);
//                intent.putExtra("parentId",categoryModel.getId());
//                intent.putExtra("parentTitle",categoryModel.getTitle());
//                startActivity(intent);
//            }
//        });




    }

    public void getLink(String link) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);

    }



}
