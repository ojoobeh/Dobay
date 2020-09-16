package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;


public class SettingActivity extends AppCompatActivity {
    protected CardView constraintLayout;
    protected RadioGroup radioGroup;
    protected ImageView backIcon;
    protected TextView tooltxt;
    protected ImageView cheshmeOghabLogo;
    protected Toolbar maintoolbar;
    Button cancleimg, okimg;
    Activity activity;

    RadioButton rbyekan, rbIranSans, rbHoma;

    TextView txtdefault;

    String fontname;
    int fontsize;

    int defaultFontRb;
    int imgnum;
    int imgnum2;
    // String imgpath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_setting);
        A.A();

        initView();
        setshared();
        cliced();
        setpicker();
        setradio();
        setdefault();
    }

    private void setdefault() {

        defaultFontRb = A.getInt(activity, C.DEFAULTFONTRB);
        fontname = A.getString(activity, C.FONTNAME, C.BYEKAN);
        setfontname(fontname);

        if (defaultFontRb == 1) {
            rbyekan.setChecked(true);
            rbIranSans.setChecked(false);
            rbHoma.setChecked(false);
        }

        if (defaultFontRb == 2) {
            rbyekan.setChecked(false);
            rbIranSans.setChecked(true);
            rbHoma.setChecked(false);
        }

        if (defaultFontRb == 3) {
            rbyekan.setChecked(false);
            rbIranSans.setChecked(false);
            rbHoma.setChecked(true);
        }
        //imgnum = A.getInt(activity, C.IMGNUMBER);


        // imgpath=A.getString(activity,C.IMGPATH);


    }

    private void setradio() {
        rbHoma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fontname = C.BHOMA;
                    setfontname(fontname);
                    defaultFontRb = 3;
                }


            }
        });

        rbIranSans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fontname = C.IRANSANS;
                    Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + fontname);
                    setfontname(fontname);
                    defaultFontRb = 2;
                }
            }
        });

        rbyekan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fontname = C.BYEKAN;
                    setfontname(fontname);
                    defaultFontRb = 1;
                }
            }
        });

    }

    private void setpicker() {

//        clickpiker.setPickerValue(A.getInt(activity, C.FONTSIZE, 15));
//        clickpiker.setClickNumberPickerListener(new ClickNumberPickerListener() {
//            @Override
//            public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
//
//                if (currentValue < 10) {
//                    clickpiker.setPickerValue(10f);
//                }
//                fontsize = (int) currentValue;
//                txtdefault.setTextSize(fontsize);
//
//            }
//        });
    }

    private void cliced() {


        okimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                A.setInt(activity, C.FONTSIZE, fontsize);
                A.setString(activity, C.FONTNAME, fontname);
                A.setInt(activity, C.DEFAULTFONTRB, defaultFontRb);


                finish();


            }
        });


        cancleimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void setshared() {
        fontname = A.getString(activity, C.FONTNAME, C.BYEKAN);
        fontsize = A.getInt(activity, C.FONTSIZE, 15);


        setfontname(fontname);

        txtdefault.setTextSize(fontsize);

        if (fontname == C.BYEKAN) {
            rbyekan.setChecked(true);

        } else if (fontname == C.IRANSANS) {
            rbIranSans.setChecked(true);

        } else if (fontname == C.BHOMA) {
            rbHoma.setChecked(true);
        }
        //set MainAcivity BackGround


        A.L("Font Size 01 > ", A.getInt(activity, C.FONTSIZE, 15));


    }

    public void setfontname(String name) {

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + name);
        txtdefault.setTypeface(typeface);

    }


    private void initView() {
        txtdefault = (TextView) findViewById(R.id.txtdefault);
        constraintLayout = (CardView) findViewById(R.id.constraintLayout);
        rbyekan = (RadioButton) findViewById(R.id.rbyekan);
        rbIranSans = (RadioButton) findViewById(R.id.rbIranSans);
        rbHoma = (RadioButton) findViewById(R.id.rbHoma);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        activity = this;
        txtdefault = findViewById(R.id.txtdefault);
        rbyekan = findViewById(R.id.rbyekan);
        rbIranSans = findViewById(R.id.rbIranSans);
        rbHoma = findViewById(R.id.rbHoma);
        okimg = findViewById(R.id.okimg);
        cancleimg = findViewById(R.id.cancleimg);
        backIcon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        cheshmeOghabLogo = (ImageView) findViewById(R.id.cheshme_oghab_logo);
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        tooltxt.setText("تنظیمات");
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void imgclicked() {


    }

    public void setRbChecked(RadioButton rbDef) {
        rbDef.setChecked(true);
    }


    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
    }



}