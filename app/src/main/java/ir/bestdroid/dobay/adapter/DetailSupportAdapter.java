package ir.bestdroid.dobay.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.model.DetailModel;
import ir.bestdroid.dobay.model.SupportDetails;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;

public class DetailSupportAdapter extends RecyclerView.Adapter<DetailSupportAdapter.Holder_Detail> {

    private Activity activity;
    private List<SupportDetails> detailModels = new ArrayList<>();
    private OnnItemSelect onnItemSelect;

    private String filePath;

    Typeface typeface;
    int fontSize;
    String fontName;
    public DetailSupportAdapter(Activity activity) {

        this.activity = activity;
        filePath = C.BASEPATH;
        fontName=A.getString(activity,C.FONTNAME,C.BYEKAN);
        typeface=Typeface.createFromAsset(activity.getAssets(),"font/"+fontName);
        fontSize=A.getInt(activity,C.FONTSIZE,15);
    }


    public void AddToList(List<SupportDetails> list) {
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
        View view = LayoutInflater.from(activity).inflate(R.layout.item_detail_list02, viewGroup, false);
        return new Holder_Detail(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder_Detail holder_detail, final int position) {
        final SupportDetails model = detailModels.get(position);

        if (model.getTitle()==null) {
            holder_detail.txtContent.setVisibility(View.GONE);
        } else {

            holder_detail.txtContent.setVisibility(View.VISIBLE);
        }


        holder_detail.txtContent.setText(model.getTitle());

        if (model.getPhoto_file()==null) {
            holder_detail.imgPic.setVisibility(View.GONE);
        } else {
            holder_detail.imgPic.setVisibility(View.VISIBLE);
            Picasso.with(activity)
                    .load(model.getPhoto_file())
                    .into(holder_detail.imgPic);

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
        JustifiedTextView txtContent;
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
}
