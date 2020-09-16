package ir.bestdroid.dobay.customTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Text_IRANSansWeb_Medium extends TextView {
    public Text_IRANSansWeb_Medium(Context context) {
        super(context);
        init();
    }

    public Text_IRANSansWeb_Medium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }




    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "font/IRANSansWeb_Medium.ttf");
        setTypeface(tf);
    }
}
