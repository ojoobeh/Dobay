package ir.bestdroid.dobay.customTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Text_Cazablanka_Heavy extends TextView {
    public Text_Cazablanka_Heavy(Context context) {
        super(context);
        init();
    }

    public Text_Cazablanka_Heavy(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "font/Casablanca-Heavy.ttf");


        setTypeface(tf);
    }
}
