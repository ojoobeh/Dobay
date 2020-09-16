package ir.bestdroid.dobay.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.model.ShoppingModelist;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.Holder_Shopping> {


    private final Activity activity;
    private final List<ShoppingModelist> list;

    OnItemClickListener onItemClickListener;


    public ShoppingAdapter(Activity activity, List<ShoppingModelist> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_Shopping onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_shopping02, viewGroup, false);
        return new Holder_Shopping(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Shopping holder_shopping, final int position) {
        final ShoppingModelist model = list.get(position);

        holder_shopping.txtTitle.setText(model.getTitle());
        holder_shopping.txtTitle.setText(model.getTitle());
        holder_shopping.txtTotalPrice.setText(String.format(Locale.ENGLISH, "%,d", Integer.valueOf(model.getPrice())) + " تومان ");

        if (model.getPhoto_file() != null) {

            Picasso.with(activity).load(model.getPhoto_file()).into(holder_shopping.imgShow);
        }

        holder_shopping.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onItemClickListener.OnItemClick(position,model);
            }
        });


    }

    @Override
    public int getItemCount() {

        if (list != null) {
            return list.size();
        } else {

            return 0;
        }
    }


    public class Holder_Shopping extends RecyclerView.ViewHolder {

        protected TextView txtTitle;
        protected TextView txtTotalPrice;
        protected LinearLayout rootColor;
        protected ImageView imgShow;

        public Holder_Shopping(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View rootView) {
            txtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
            txtTotalPrice = (TextView) rootView.findViewById(R.id.txtTotalPrice);
            imgShow = rootView.findViewById(R.id.imgShow);
        }
    }

    public void setOnItemClick(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClick(int position, ShoppingModelist productDetails);
    }
}
