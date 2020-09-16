package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import ir.bestdroid.dobay.utils.PermissionActivity;

public class CategoryActivity extends PermissionActivity {

    protected RecyclerView categoryList;
    protected TextView tooltxt;
    protected ImageView LOGO;
    protected ImageView BackIcon;
    protected Toolbar maintoolbar;
    protected TextView emptyList;
    Activity activity;

    int parentId;
    String Subtitle, Title;
    DbHandler db;
    CategoryAdapter adapter;
    List<Integer> listId = new ArrayList<>();
    List<String> listName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_category_list);
        A.A();
        initView();
        getData();
        inittoolbar(Subtitle);
        setData(parentId);
        clicked();


    }

    private void clicked() {
        adapter.SetOnItemClicked(new CategoryAdapter.OnnItemSelect() {
            @Override
            public void OnItemClicked(CategoryModel categoryModel, int position) {
                Title = categoryModel.getTitle();
                if (categoryModel.getIsEndUp() == 1) {

                    Intent intent = new Intent(activity, DetailActivity.class);
                    int id = categoryModel.getId();
                    intent.putExtra(C.PUT_CATID, id);
                    intent.putExtra(C.PUT_CATTITLE, Title);
                    startActivity(intent);
                } else {

                    listId.add(categoryModel.getId());
                    listName.add(categoryModel.getTitle());
                    setData(categoryModel.getId());
                    inittoolbar(Title);
                }


            }
        });
    }

    private void setData(int parentId) {
//        List<CategoryModel> list = db.getCategoryByParentId(parentId);
//
//        for (int i = 0; i < list.size(); i++) {
//
//            new CopyPic(activity, list.get(i).getIcon());
//        }
        adapter.removeAll();
//        adapter.AddToList(list);
        categoryList.setAdapter(adapter);
    }

    private void getData() {
        parentId = 0;
        Subtitle = "بیمه عمر";
        listId.add(parentId);
        listName.add(Subtitle);
    }

    private void initView() {
        activity = this;

        db = new DbHandler(activity);
        adapter = new CategoryAdapter(activity);
        categoryList = findViewById(R.id.category_List);
        categoryList.setLayoutManager(new LinearLayoutManager(activity));
        BackIcon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        LOGO = (ImageView) findViewById(R.id.cheshme_oghab_logo);
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        emptyList = (TextView) findViewById(R.id.empty_List);


    }

    private void inittoolbar(String title) {
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        tooltxt.setText(title);

        BackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listId.size() == 1) {

                   finish();

                } else {
                    listId.remove(listId.size() - 1);
                    listName.remove(listName.size() - 1);
                    tooltxt.setText(listName.get(listName.size()-1));
                    setData(listId.get(listId.size() - 1));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (listId.size() == 1) {

            super.onBackPressed();
        } else {
            listId.remove(listId.size() - 1);
            listName.remove(listName.size() - 1);
            tooltxt.setText(listName.get(listName.size()-1));
            setData(listId.get(listId.size() - 1));
        }
    }
}
