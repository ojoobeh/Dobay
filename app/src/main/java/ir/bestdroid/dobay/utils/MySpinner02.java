package ir.bestdroid.dobay.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ir.bestdroid.dobay.R;


public class MySpinner02 extends ArrayAdapter<String> implements
        DialogInterface.OnMultiChoiceClickListener {
    // Initialise custom font, for example:
    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "font/"+ A.getString(getContext(),C.FONTNAME,C.BYEKAN));



    // (In reality I used a manager which caches the Typeface objects)
    // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

    public MySpinner02(Context context, int resource, String[] items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTextSize(15);
        if(position==0)
//            view.setTextColor(Color.rgb(117,117,117));
            view.setTextColor(Color.GRAY);

        else
            view.setTextColor(Color.BLACK);
//            view.setTextColor(Color.rgb(64,64,64));

        view.setBackgroundColor(Color.TRANSPARENT);
        view.setPadding(3, 5, 23, 3);
        view.setGravity(Gravity.CENTER_VERTICAL|Gravity.START);
        view.setTypeface(font);




//        if(position==0)
//            view.setTextColor(Color.GRAY);
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTextSize(16);
      //  view.setTextColor(Color.BLACK);
        view.setTextColor(getContext().getResources().getColor(R.color.white));
        view.setPadding(0, 3, 3, 0);
        view.setTypeface(font);
        view.setGravity(Gravity.CENTER);
        if(position==0) {

        }

        return view;

    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

    }


}
