package ir.bestdroid.dobay.activity2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ir.bestdroid.dobay.R;
import ir.bestdroid.dobay.connection.ApiClient;
import ir.bestdroid.dobay.model.SupportDetailCallBack;
import ir.bestdroid.dobay.model.SupportDetails;
import ir.bestdroid.dobay.utils.A;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupportDetailActivity extends AppCompatActivity {
    protected WebView webView;
    Activity activity;

    int parentId;
    String parentTitle;

    protected ImageView back_icon;
    protected Toolbar maintoolbar;
    protected TextView tooltxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_detail);
        initView();
        getData();
        inittoolbar(parentTitle);
        A.A();
    }

    private void getData() {

        parentId = getIntent().getExtras().getInt("parentId", 0);
        parentTitle = getIntent().getExtras().getString("parentTitle", "پشتیبانی چشم عقاب");
        getAllSupport(parentId);

    }

    private void inittoolbar(String title) {
        maintoolbar = (Toolbar) findViewById(R.id.maintoolbar);
        back_icon = (ImageView) findViewById(R.id.back_icon);
        tooltxt = (TextView) findViewById(R.id.tooltxt);
        tooltxt.setText(title);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initView() {
        activity = this;
        webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }


    public void getAllSupport(int parentId) {
        Call<SupportDetailCallBack> errorCallBackCall = ApiClient.createAPI().getAllSupportDetails(parentId);
        errorCallBackCall.enqueue(new Callback<SupportDetailCallBack>() {
            @Override
            public void onResponse(Call<SupportDetailCallBack> call, Response<SupportDetailCallBack> response) {

                SupportDetails supportDetails = response.body().getTopic().get(0);
                setParam(supportDetails);


            }

            @Override
            public void onFailure(Call<SupportDetailCallBack> call, Throwable t) {

                A.T(t.toString());

            }
        });
    }

    private void setParam(SupportDetails supportDetails) {

        String details = supportDetails.getDetails();
        webView.loadDataWithBaseURL("", details, "text/html", "UTF-8", "");

    }

}
