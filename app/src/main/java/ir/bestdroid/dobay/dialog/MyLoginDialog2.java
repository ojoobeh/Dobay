package ir.bestdroid.dobay.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.goodiebag.pinview.Pinview;

import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.connection.APIWebService;
import ir.bestdroid.dobay.connection.RetrofitWebServiceAdapter;
import ir.bestdroid.dobay.database.Db_Other;
import ir.bestdroid.dobay.model.newServerModels.AgentList;
import ir.bestdroid.dobay.model.newServerModels.DatumUser;
import ir.bestdroid.dobay.model.newServerModels.UserCallBack;
import ir.bestdroid.dobay.utils.A;
import ir.bestdroid.dobay.utils.C;
import ir.bestdroid.dobay.utils.L;
import ir.bestdroid.dobay.utils.NetworkCheck;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyLoginDialog2 {

    Dialog dialog01;
    Dialog dialog02;
    private AfterLogin afterLogin;

    Activity activity;


    DatumUser users = new DatumUser();
    Button button01;
    Button button02;


    Timer timer;

    TextView txtTitle, txtContent;
    EditText edtPhoneNumber;

    String mobile;
    Db_Other db_other;


    ProgressBar progressBar;
    int verNumber;

    public MyLoginDialog2(final Activity context, final AfterLogin afterLogin) {

        final int PERMISSION_ALL = 400;
        this.activity = context;
        db_other = new Db_Other(activity);

        dialog01 = new Dialog(context);
        this.afterLogin = afterLogin;
        dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog01.setContentView(R.layout.layout_login01);
        dialog01.setCancelable(false);


        PackageInfo pinfo = null;
        try {
            pinfo = activity.getPackageManager().getPackageInfo("com.danasetayesh.essentialwords", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String verName = pinfo.versionName;
        verNumber = pinfo.versionCode;


        dialog01.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.argb(0, 200, 200, 200)));


        dialog01.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        dialog01.show();

        ImageView imgBack = dialog01.findViewById(R.id.imgBack);
        button01 = dialog01.findViewById(R.id.button);
        txtTitle = dialog01.findViewById(R.id.txtTitle);
        txtContent = dialog01.findViewById(R.id.txtContent);
        progressBar = dialog01.findViewById(R.id.progressBar);

        txtTitle.setText(L.Dialog04(context));
        txtContent.setText(L.Dialog05(context));
        button01.setText(L.Ok(context));
        edtPhoneNumber = dialog01.findViewById(R.id.edtPhoneNumber);

        edtPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mobile = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog01.dismiss();
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String number=

//                Toast.makeText(context, ccp.getNumber(), Toast.LENGTH_SHORT).show();


                isPermissionSet();


//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    boolean isPerSet = A.getBoolean(context, C.PERMISIIONISSET2);
//                    if (!isPerSet) {
//
//                        new PermissionDialog(context, L.Permission_READPHONESTATE_TitleDialog(context), new PermissionDialog.setYesDialog() {
//                            @Override
//                            public void setOkDialog(Dialog dialog, boolean isOk) {
//
//                                if (isOk) {
//                                    A.setBoolean(context, C.PERMISIIONISSET2, true);
//                                    String[] PERMISSIONS = {
//
//                                            Manifest.permission.READ_PHONE_STATE
//
//                                    };
//
//
//                                    if (!hasPermissions(context, PERMISSIONS)) {
//                                        ActivityCompat.requestPermissions(context, PERMISSIONS, PERMISSION_ALL);
//                                    } else {
//
//                                        isPermissionSet();
//
//                                    }
//                                }
//
//
//                            }
//                        });
//
//                    } else {
//
//                        String[] PERMISSIONS = {
//
//                                Manifest.permission.READ_PHONE_STATE
//
//                        };
//
//
//                        if (!hasPermissions(context, PERMISSIONS)) {
//                            ActivityCompat.requestPermissions(context, PERMISSIONS, PERMISSION_ALL);
//                        } else {
//
//
//
//                        }
//                    }
//
//
//                } else {
//                    isPermissionSet();
//                }


            }
        });

        L.setFonts(activity,

                txtTitle,
                txtContent,
                button01,
                edtPhoneNumber);


    }

    private void isPermissionSet() {

        int len = edtPhoneNumber.getText().toString().length();
        if (len < 11) {

            Toast.makeText(activity, "تعداد ارقام وارد شده صحیح نیست", Toast.LENGTH_SHORT).show();

        } else {

            String tt = edtPhoneNumber.getText().toString().substring(0, 2);

            if (tt.equals("09")) {

                button01.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
//                doLogin(edtPhoneNumber.getText().toString().replace(" ", ""));
                doLogin();


            } else {

                Toast.makeText(activity, "شماره تلفن اشتباه است", Toast.LENGTH_SHORT).show();
            }


        }



    }

    String imei;

    private void doLogin() {


        imei = getUniqueIMEIId();
        Call<UserCallBack> messageCall = RetrofitWebServiceAdapter.createAPI().login(
                edtPhoneNumber.getText().toString(),
                imei,
                verNumber,
                C.api_key);
        messageCall.enqueue(new Callback<UserCallBack>() {
            @Override
            public void onResponse(Call<UserCallBack> call, final Response<UserCallBack> response) {
                //  hideLoginLoading();

                button01.setEnabled(true);
                progressBar.setVisibility(View.GONE);

                if (response.body() != null) {


                    if (response.body().getSuccess().equals("1")) {
                        A.L("Ver", response.body().getData().get(0).getVerify());


                        users = response.body().getData().get(0);


                        setDiaog02(false, L.TaidShomareh(activity),
                                L.SendCodeContent(activity, users.getMobile()));

                    } else {
                        Toast.makeText(activity, response.body().getMsg() + "", Toast.LENGTH_SHORT).show();
                        button01.setEnabled(true);
                    }
                } else {

                    button01.setEnabled(true);
                    Toast.makeText(activity,
                            "اشکالی در برقراری ارتباط بوجود آمده است", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<UserCallBack> call, Throwable t) {
                A.L("Throwable", t.getMessage());
                button01.setEnabled(true);
                Toast.makeText(activity, "ارتباط با سرور برقرار نشد", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });


    }

    String finalCode;

    boolean isOkResendCode = false;
    ProgressBar progResend;
    int Time = 60;
    int tt = Time;

    String finalVeriFy = "";

    private void setDiaog02(boolean isFromEmail, String title, String content) {


        dialog02 = new Dialog(activity);
        dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog02.setContentView(R.layout.layout_login02);
        dialog02.setCancelable(false);


        dialog02.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.argb(0, 200, 200, 200)));


        dialog02.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        dialog02.show();

//        if (LessonsActivity.rootLoading!=null){
//            LessonsActivity.rootLoading.setVisibility(View.GONE);
//        }


        final ImageView imgBack = dialog02.findViewById(R.id.imgBack);
        TextView txtTitle = dialog02.findViewById(R.id.txtTitle);
        TextView txtContent = dialog02.findViewById(R.id.txtContent);
        final TextView btnReSendCode = dialog02.findViewById(R.id.btnReSendCode);
        button02 = dialog02.findViewById(R.id.button02);
        progResend = dialog02.findViewById(R.id.progResend);
        button02.setText(L.Ok(activity));



        txtTitle.setText(title);
        txtContent.setText(content);


        btnReSendCode.setTextColor(activity.getResources().getColor(R.color.gray500));
        imgBack.setImageResource(R.drawable.ic_arrow_left_gray);
        isOkResendCode = false;

        timer = new Timer();
        tt = Time;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tt--;


                        if (tt > 0) {


                            btnReSendCode.setText(L.TimerSend(activity, getStringTimer(tt)));

                        } else {

                            stopTimer();
                            btnReSendCode.setText(L.SendAgain(activity));
                            btnReSendCode.setTextColor(activity.getResources().getColor(R.color.colorBlue2));
                            imgBack.setImageResource(R.drawable.ic_arrow_left);
                            isOkResendCode = true;
                        }
                    }
                });

            }
        }, 0, 1000);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOkResendCode) {
                    dialog02.dismiss();



                }


            }
        });




        btnReSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOkResendCode) {

                    btnReSendCode.setTextColor(activity.getResources().getColor(R.color.gray500));
                    imgBack.setImageResource(R.drawable.ic_arrow_left_gray);
                    isOkResendCode = false;

                    timer = new Timer();
                    tt = Time;


                    progResend.setVisibility(View.VISIBLE);


                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    tt--;


                                    if (tt > 0) {


                                        btnReSendCode.setText(L.TimerSend(activity, getStringTimer(tt)));


                                    } else {

                                        stopTimer();
                                        btnReSendCode.setText(L.SendAgain(activity));
                                        btnReSendCode.setTextColor(activity.getResources().getColor(R.color.black));
                                        imgBack.setImageResource(R.drawable.ic_arrow_left);
                                        isOkResendCode = true;
                                    }
                                }
                            });

                        }
                    }, 0, 1000);

                    reSendCode();
                }

            }
        });


        L.setFonts(activity,

                txtTitle,
                txtContent,
                button01,
                btnReSendCode);


        final Pinview pin = dialog02.findViewById(R.id.pinview);
        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                //Make api calls here or what not
                A.hideSoftKeyboard(activity);


                finalVeriFy = pin.getValue();
                doVerifyNull(users, pinview.getValue());

//                    A.setBoolean(activity, C.ISLOGIN, true);


//                    A.setInt(activity, C.SH_ID, user.getId());
//                    A.setString(activity, C.SH_NAME, user.getName());
//                    A.setString(activity, C.SH_EMAIL, user.getEmail());
//                    A.setString(activity, C.SH_PHONE, user.getPhone());
//                    A.setString(activity, C.MYSHOP, user.getMkurl());


            }

        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finalVeriFy = pin.getValue();
                doVerifyNull(users, finalVeriFy);


            }
        });


    }


    private void doVerifyNull(final DatumUser user, String verify) {
//        Toast.makeText(activity, imei+"", Toast.LENGTH_SHORT).show();

        Call<UserCallBack> setVerifyNuul = RetrofitWebServiceAdapter.createAPI()
                .verify(user.getMobile(), verify, imei, C.api_key);
        setVerifyNuul.enqueue(new Callback<UserCallBack>() {
            @Override
            public void onResponse(Call<UserCallBack> call, Response<UserCallBack> response) {
                progResend.setVisibility(View.GONE);
                if (response.body() != null) {
                    if (response.body().getSuccess().equals("1")) {

                        users = response.body().getData().get(0);
                        dialog01.dismiss();

                        doLogins(users, response.body().getAgentList());

                    } else {
                        Toast.makeText(activity, L.VeriFyIsNotOk(activity), Toast.LENGTH_SHORT).show();

                    }
                }


            }

            @Override
            public void onFailure(Call<UserCallBack> call, Throwable t) {
                progResend.setVisibility(View.GONE);
                Toast.makeText(activity, L.VeriFyIsNotOk(activity), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void doLogins(final DatumUser usser, List<AgentList> lists) {

        setPrices();
        db_other.addToMKUT(usser, lists);






        afterLogin.VenLogin(dialog02, true, usser.getMobile(), usser);

    }

    private void setPrices() {


    }

    private void reSendCode() {


        if (NetworkCheck.isDeviceConnectedToInternet(activity)) {

            //   showRefreshView
            APIWebService api = RetrofitWebServiceAdapter.createAPI();
            Call<UserCallBack> messageCall = api.login(
                    edtPhoneNumber.getText().toString(),
                    imei,
                    verNumber,
                    C.api_key);
            messageCall.enqueue(new Callback<UserCallBack>() {
                @Override
                public void onResponse(Call<UserCallBack> call, Response<UserCallBack> response) {
                    //  hideRegisterLoading();

                    Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();


                    progResend.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<UserCallBack> call, Throwable t) {
                    // hideRegisterLoading();
                    Toast.makeText(activity, L.ConnectionError(activity), Toast.LENGTH_SHORT).show();

                    Log.e("Throwable", t.toString());

                    progResend.setVisibility(View.GONE);
                }
            });
        } else {
            progResend.setVisibility(View.GONE);
        }


    }


    public interface AfterLogin {
        void VenLogin(Dialog dialog, boolean isOk, String phone, DatumUser user);
    }

    public void stopTimer() {
        if (timer != null) {


            timer.cancel();
            timer.purge();
        }
    }


    private String getStringTimer(int mil) {

        int sec = (int) (mil);

        int min = sec / 60;
        sec %= 60;

        String time = String.format(Locale.ENGLISH, "%02d", min) + ":" + String.format(Locale.ENGLISH, "%02d", sec);

        return time;

    }

    public String getUniqueIMEIId() {

        String androidId = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;

    }




}
