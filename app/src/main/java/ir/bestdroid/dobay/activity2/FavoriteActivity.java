package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.adapter.CategoryAdapter;
import ir.bestdroid.dobay.database.DbHandler;
import ir.bestdroid.dobay.model.CategoryModel;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;

//import ir.bestdroid.dobay.utils.C;

public class FavoriteActivity extends AppCompatActivity {
    protected RecyclerView categoryList;
    protected ImageView backIcon;
    protected TextView tooltxt;
    protected ImageView cheshmeOghabLogo;
    protected Toolbar maintoolbar;
    Activity activity;
    TextView Empty;
    int parentId;
    int detail_id;
    int newParentId;
    int lastParentId;
    DbHandler db;
    CategoryAdapter adapter;
    List<Integer> listId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_category_list);
        A.A();
        initView();
        db = new DbHandler(this);
        FavRequest();


//        getData();
        setData();
        clicked();


    }

    private void FavRequest() {
//        if (db.getCategoryByParentIdAndFav().size() == 0) {
//            categoryList.setVisibility(View.GONE);
//            Empty.setVisibility(View.VISIBLE);
//            Empty.setText("لیست خالی است.");
//        } else {
//            Empty.setVisibility(View.GONE);
//            categoryList.setVisibility(View.VISIBLE);
//            setData();
//        }
    }

    private void initView() {
        activity = this;

        db = new DbHandler(activity);
        adapter = new CategoryAdapter(activity);
        categoryList = findViewById(R.id.category_List);
        Empty = findViewById(R.id.empty_List);
        categoryList.setLayoutManager(new LinearLayoutManager(activity));
        backIcon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        cheshmeOghabLogo = (ImageView) findViewById(R.id.cheshme_oghab_logo);
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        tooltxt.setText("علاقمندی ها");
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void getData() {
        Bundle bundle = getIntent().getExtras();
        detail_id = bundle.getInt(C.PUT_ID);
        listId.add(parentId);
    }

    private void setData() {
//        List<CategoryModel> list = db.getCategoryByParentIdAndFav();

//        for (int i = 0; i < list.size(); i++) {
//
//            new CopyPic(activity, list.get(i).getIcon());
//        }
        adapter.removeAll();
//        adapter.AddToList(list);
        categoryList.setAdapter(adapter);
    }

    private void clicked() {
        adapter.SetOnItemClicked(new CategoryAdapter.OnnItemSelect() {
            @Override
            public void OnItemClicked(CategoryModel categoryModel, int position) {

                if (categoryModel.getIsEndUp() == 1) {

                    Intent intent = new Intent(activity, DetailActivity.class);
                    int id = categoryModel.getId();
                    intent.putExtra(C.PUT_CATID, id);

                    startActivity(intent);
                } else {

                    listId.add(categoryModel.getId());
                    setData();

                }


            }
        });
    }
}