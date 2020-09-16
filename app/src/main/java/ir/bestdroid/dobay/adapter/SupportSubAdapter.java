package ir.bestdroid.dobay.adapter;

import android.app.Activity;
import android.graphics.Typeface;
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
import ir.bestdroid.dobay.model.SupportDetails;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.MyDownloadManager;

public class SupportSubAdapter extends RecyclerView.Adapter<SupportSubAdapter.Holder_Support> {


    private Activity activity;
    private List<SupportDetails> categoryModels = new ArrayList<>();
    private OnnItemSelect onnItemSelect;

    private String filePath;


    Typeface typeface;
    int fontSize;
    String fontName;

    public SupportSubAdapter(Activity activity, List<SupportDetails> list){
        this.activity = activity;

        filePath = C.BASEPATH;
        fontName= A.getString(activity,C.FONTNAME2,C.IRANSANS);
        typeface=Typeface.createFromAsset(activity.getAssets(),"font/"+fontName);
        fontSize=A.getInt(activity,C.FONTSIZE2,15);
    }

    public void AddToList(List<SupportDetails> list) {
        this.categoryModels.addAll(list);
        notifyDataSetChanged();
    }

    public void removeAll() {
        categoryModels.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public Holder_Support onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(activity).inflate(R.layout.item_category_list,viewGroup,false);
        return new Holder_Support(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_Support holder_support, final int position) {
        final SupportDetails model=categoryModels.get(position);

        holder_support.txtTitle.setText(model.getTitle());

        if (model.getPhoto_file()!=null && !model.getPhoto_file().equals("0")) {

            final File file = new File(filePath + model.getPhoto_file());

            if (!file.exists()) {
                A.L("FileNot Found", model.getPhoto_file());

                new MyDownloadManager(activity,
                         model.getPhoto_file(),
                        filePath + model.getPhoto_file(),
                        false,
                        new MyDownloadManager.AfterDownload() {
                            @Override
                            public void DownloadComplete(boolean isDownload) {
//
                                if (isDownload) {
                                    Picasso.with(activity)
                                            .load(file)
                                            .into(holder_support.imgIcon);
//
                                }
                            }
                        }
                );
            } else {
//
                Picasso.with(activity)
                        .load(file)
                        .into(holder_support.imgIcon);
//
            }

        }

        holder_support.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class Holder_Support extends RecyclerView.ViewHolder{

        TextView txtTitle;
        ImageView imgIcon;


        public Holder_Support(@NonNull View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txtTitle);
            imgIcon=itemView.findViewById(R.id.imgIcon);

            txtTitle.setTypeface(typeface);
        }
    }

    public void SetOnItemClicked(OnnItemSelect onnItemSelect){

        this.onnItemSelect = onnItemSelect;
    }
    public interface OnnItemSelect{
        void OnItemClicked(SupportDetails categoryModel, int position);
    }
}
