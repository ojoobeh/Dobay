package ir.bestdroid.dobay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.Gravity;
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
import ir.bestdroid.dobay.model.DetailModel;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.MyDownloadManager;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.Holder_Detail> {

    private Activity activity;
    private List<DetailModel> detailModels = new ArrayList<>();
    private OnnItemSelect onnItemSelect;

    private String filePath;

    Typeface typeface;
    int fontSize;
    String fontName;

    public DetailAdapter(Activity activity) {

        this.activity = activity;
        filePath = C.BASEPATH;
        fontName = A.getString(activity, C.FONTNAME, C.BYEKAN);
        typeface = Typeface.createFromAsset(activity.getAssets(), "font/" + fontName);
        fontSize = A.getInt(activity, C.FONTSIZE, 15);
    }


    public void AddToList(List<DetailModel> list) {
        this.detailModels.addAll(list);
        notifyDataSetChanged();
    }

    public void RemoveAll() {
        detailModels.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder_Detail onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_detail_list, viewGroup, false);
        return new Holder_Detail(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder_Detail holder_detail, final int position) {
        final DetailModel model = detailModels.get(position);


        if (detailModels.get(position).getLink()!=null && !detailModels.get(position).getLink().equals("0")) {

            holder_detail.txtContent.setTextColor(activity.getResources().getColor(R.color.blue));
            holder_detail.txtContent.setBackgroundResource(R.drawable.back_simple_corner_6dp);
            holder_detail.txtContent.setGravity(Gravity.LEFT);
            holder_detail.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(detailModels.get(position).getLink()));
                    activity.startActivity(i);

                }
            });
        }


        if (model.getContent() == null || model.getContent().equals("0") || model.getContent().equals("")) {
            holder_detail.txtContent.setVisibility(View.GONE);
        } else {

            try {

//                if (model.getId()!=860){

                holder_detail.txtContent.setVisibility(View.VISIBLE);
                String content = model.getContent().replace("*", "-");
                holder_detail.txtContent.setText(content);
//                }

            } catch (Exception e) {

                A.L("Error!!", e.toString());
            }


        }

        if (model.getWidth() != null && model.getWidth().equals("0")) {

            holder_detail.imgPic.setMinimumWidth(Integer.valueOf(model.getWidth()));
            holder_detail.imgPic.setMaxWidth(Integer.valueOf(model.getWidth()));
        }


        if (model.getHeight() != null && model.getHeight().equals("0")) {

            holder_detail.imgPic.setMinimumWidth(Integer.valueOf(model.getHeight()));
            holder_detail.imgPic.setMaxWidth(Integer.valueOf(model.getHeight()));
        }




        if (model.getA().equals("B")){
            holder_detail.txtContent.setTypeface(null, Typeface.BOLD);
        }


        if (model.getPic() == null || model.getPic().equals("0") || model.getPic().equals("")) {
            holder_detail.imgPic.setVisibility(View.GONE);
        } else {


            holder_detail.imgPic.setVisibility(View.VISIBLE);
            final File file = new File(filePath + model.getPic());

            if (!file.exists()) {

                A.L("Not Found", file.toString());
                new MyDownloadManager(activity,
                        C.BASEFILEURL + model.getPic().replace(" ", "%20"),
                        filePath,
                        false,
                        new MyDownloadManager.AfterDownload() {
                            @Override
                            public void DownloadComplete(boolean isDownload) {

                                if (isDownload) {

                                    Picasso.with(activity)
                                            .load(file)
                                            .into(holder_detail.imgPic);


                                }
                            }
                        }
                );
            } else {

                Picasso.with(activity)
                        .load(file)
                        .into(holder_detail.imgPic);

            }


        }


    }

    @Override
    public int getItemCount() {
        if (detailModels != null) {
            return detailModels.size();
        } else {

            return 0;
        }
    }

    public class Holder_Detail extends RecyclerView.ViewHolder {
        TextView txtContent;
        ImageView imgPic;

        public Holder_Detail(@NonNull View itemView) {
            super(itemView);
            txtContent = itemView.findViewById(R.id.txtContent);
            imgPic = itemView.findViewById(R.id.imgPic);

            txtContent.setTypeface(typeface);
            txtContent.setTextSize(fontSize);
        }
    }

    public void SetOnItemClicked(OnnItemSelect onnItemSelect) {

        this.onnItemSelect = onnItemSelect;
    }

    public interface OnnItemSelect {
        void OnItemClicked(DetailModel categoryModel, int position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
