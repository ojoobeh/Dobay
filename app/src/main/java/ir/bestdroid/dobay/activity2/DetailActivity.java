package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.adapter.DetailAdapter;
import ir.bestdroid.dobay.database.DbHandler;
import ir.bestdroid.dobay.model.DetailModel;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;

public class DetailActivity extends AppCompatActivity {
    protected RecyclerView detailList;
    protected ImageView backIcon;
    protected TextView tooltxt;
    protected ImageView cheshmeOghabLogo;
    protected Toolbar maintoolbar;
    Activity activity;
    DbHandler db;
    int catId;
    String catTitle;
    int fav;
    DetailAdapter adapter;
    TextView txtEmpty;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        A.A();
        initView();
        getData();
        inittoolbar(catTitle);
        setData();

    }

    public void initView() {
        activity = this;
        db = new DbHandler(activity);
        detailList = findViewById(R.id.detail_List);
        progress = findViewById(R.id.progress);
        txtEmpty = findViewById(R.id.txtEmpty);
        detailList.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new DetailAdapter(activity);
        backIcon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        cheshmeOghabLogo = (ImageView) findViewById(R.id.cheshme_oghab_logo);
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        catId = bundle.getInt(C.PUT_CATID);
        catTitle = bundle.getString(C.PUT_CATTITLE);
//        fav = db.getNameFavorite(catId);

    }
    int page=0;
    int corent=260;

    private void inittoolbar(String title) {
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        tooltxt.setText(title);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setData() {
     //   List<DetailModel> list = db.getDetailByCatId(catId);


//        for (int i = 0; i < list.size(); i++) {
//
//            new CopyPic(activity, list.get(i).getPic());
//        }

//        if (db.getDetailByCatId(catId).size() > 0) {
//
//            txtEmpty.setVisibility(View.GONE);
//        } else {
//            txtEmpty.setVisibility(View.VISIBLE);
//        }
//        List<DetailModel> list1=db.getDetailByCatId(catId);

//        adapter.AddToList(list1);
        detailList.setAdapter(adapter);






//        InfiniteScrollProvider infiniteScrollProvider = new InfiniteScrollProvider();
//        infiniteScrollProvider.attach(detailList, new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                progress.setVisibility(View.VISIBLE);
//                page=page+corent;
//
//                List<DetailModel> list1=getDetail(page,corent);
//
//                adapter.AddToList(list1);
//                detailList.setAdapter(adapter);
//                progress.setVisibility(View.GONE);
//            }
//        });
    }


    public List<DetailModel> getDetail( int pageNumber, int corent){

        List<DetailModel> list2=new ArrayList<>();

//        for (int i = pageNumber; i < pageNumber+corent; i++) {
//
//            if (i < db.getDetailByCatId(catId).size()) {
//
//                list2.add(db.getDetailByCatId(catId).get(i));
//            }
//
//        }

        return list2;

    }
}
