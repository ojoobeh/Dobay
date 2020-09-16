package ir.bestdroid.dobay.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class PermissionActivity extends AppCompatActivity {

    public int PERMISSION_ALL;

    public String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public String READ_SMS = Manifest.permission.READ_SMS;
    public String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public String INTERNET = Manifest.permission.INTERNET;
    public String SEND_SMS = Manifest.permission.SEND_SMS;
    public String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;

    public void setPermission(int PERMISSION_ALL, String... PERMISSIONS) {
        this.PERMISSION_ALL = PERMISSION_ALL;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (!hasPermissions(PermissionActivity.this, PERMISSIONS)) {
                ActivityCompat.requestPermissions(PermissionActivity.this, PERMISSIONS, PERMISSION_ALL);
            } else {

                setReSult(true);

            }


        } else {

            setReSult(true);
        }


    }

    private void setReSult(boolean isTrue) {

        A.setPermissionBoolean(PermissionActivity.this,PERMISSION_ALL,isTrue);

        if (setPermissionResult != null) {

            setPermissionResult.GetResoltPermission(PERMISSION_ALL, isTrue);
        } else {

            Log.i("ff-", "setPermissionResult Is Null");
        }

    }

    public static boolean hasPermissions(Activity activity, String... permissions) {

        if (activity != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == PERMISSION_ALL && grantResults[0] >= 0) {
            setReSult(true);
        } else {
            setReSult(false);
        }


    }


    SetPermissionResult setPermissionResult;

    public interface SetPermissionResult {

        void GetResoltPermission(int requestPermission, boolean isPermissionSet);
    }
}
