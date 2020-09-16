package ir.bestdroid.dobay.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Text_View extends TextView {
    public Text_View(Context context) {
        super(context);
        initView();
    }

    public Text_View(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public Text_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    public void initView(){
        Typeface typeface=Typeface.createFromAsset(getContext().getAssets(),"font/yekan.ttf");
        setTypeface(typeface);
    }
}
