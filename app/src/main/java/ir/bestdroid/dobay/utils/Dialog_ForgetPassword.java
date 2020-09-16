package ir.bestdroid.dobay.utils;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ir.bestdroid.dobay.R;


public class Dialog_ForgetPassword {

    Dialog dialog;

    private TextView txttitle;
    private Button btnyes, btnno;
    EditText edtPhoneNumber;

    public Dialog_ForgetPassword(Context context, String title, String yes, String no, final setYesDialog setYesDialog) {


        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_forget_password);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.argb(0, 200, 200, 200)));

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        btnyes = dialog.findViewById(R.id.btnYes);
        btnno = dialog.findViewById(R.id.btnNo);
        txttitle = dialog.findViewById(R.id.txttitle);
        edtPhoneNumber = dialog.findViewById(R.id.edtPhoneNumber);

        //btnDownloadNow.setOnClickListener(this);
        //	btnDownloadLater.setOnClickListener(this);

        dialog.show();

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                setYesDialog.setOkDialog(dialog, false, edtPhoneNumber.getText().toString());


            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                setYesDialog.setOkDialog(dialog, true, edtPhoneNumber.getText().toString());


            }
        });

        if (!title.equals("")){

            txttitle.setText(title);
        }
        if (!yes.equals("")) {

            btnyes.setText(yes);
        }

        if (!no.equals("")) {

            btnno.setText(no);
        }


    }

    public interface setYesDialog {

        void setOkDialog(Dialog dialog, boolean isOk, String phoneNumber);
    }
}
