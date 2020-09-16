package ir.bestdroid.dobay.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import ir.bestdroid.dobay.R;


public class MyPayDialog {

    Dialog dialog;

    private TextView txttitle;
    private Button btnyes, btnno;

    public MyPayDialog(Activity activity,
                       String title,
                       String yes,
                       String no,
                       final setYesDialog setYesDialog) {


        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_pay_dialog);
        dialog.setCancelable(false);

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        btnyes = dialog.findViewById(R.id.btnDownloadNow);
        btnno = dialog.findViewById(R.id.btnDownloadLater);
        txttitle = dialog.findViewById(R.id.txttitle);

        //btnDownloadNow.setOnClickListener(this);
        //	btnDownloadLater.setOnClickListener(this);

        dialog.show();

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                setYesDialog.setOkDialog(dialog, false);


            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                setYesDialog.setOkDialog(dialog, true);


            }
        });

        if (!title.equals("")) {
            txttitle.setText(title);
        }
        txttitle.setText(title);
        if (!yes.equals("")) {

            btnyes.setText(yes);
        }

        if (!no.equals("")) {

            btnno.setText(no);
        }


    }

    public interface setYesDialog {

        void setOkDialog(Dialog dialog, boolean isOk);
    }
}
