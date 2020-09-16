package ir.bestdroid.dobay.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.model.CategoryModel;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.MyDownloadManager;

public class Sub2CategoryAdapter extends RecyclerView.Adapter<Sub2CategoryAdapter.Holder_CateGory> {

    private Activity activity;
    private List<CategoryModel> categoryModels = new ArrayList<>();
    private OnnItemSelect onnItemSelect;

    private String filePath;

    public Sub2CategoryAdapter(Activity activity) {

        this.activity = activity;

        filePath = C.BASEPATH;
    }

    public void AddToList(List<CategoryModel> list) {
        this.categoryModels.addAll(list);
        notifyDataSetChanged();
    }

    public void RemoveAll() {
        categoryModels.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder_CateGory onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(activity).inflate(R.layout.item_category_list,viewGroup,false);
        return new Holder_CateGory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_CateGory holder_cateGory, final int position) {
        final CategoryModel model=categoryModels.get(position);

        holder_cateGory.txtTitle.setText(model.getTitle());

        final File file = new File(filePath + model.getIcon());

        if (!file.exists()) {
            A.L("FileNot Found",model.getIcon());

            new MyDownloadManager(activity,
                    A.getString(activity, C.SH_MAIEFILEURL) + model.getIcon(),
                    filePath + model.getIcon(),
                    false,
                    new MyDownloadManager.AfterDownload() {
                        @Override
                        public void DownloadComplete(boolean isDownload) {

                            if (isDownload) {
                                Picasso.with(activity)
                                        .load(file)
                                        .into(holder_cateGory.imgIcon);

                            }
                        }
                    }
            );
        } else {

            Picasso.with(activity)
                    .load(file)
                    .into(holder_cateGory.imgIcon);

        }



        holder_cateGory.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onnItemSelect.OnItemClicked(model,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (categoryModels != null) {
            return categoryModels.size();
        } else {

            return 0;
        }
    }

    public class Holder_CateGory extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgIcon;
        public Holder_CateGory(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            imgIcon=itemView.findViewById(R.id.imgIcon);
        }
    }
    public void SetOnItemClicked(OnnItemSelect onnItemSelect){

        this.onnItemSelect = onnItemSelect;
    }
    public interface OnnItemSelect{
        void OnItemClicked(CategoryModel categoryModel, int position);
    }
}
