package ir.bestdroid.dobay.utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class A extends Application {


    public static String KEY = "ff-";
    public static String DB_PATH;
    public static String IMG_PATH;
    public static String DB_NAME = "bimeOmr.db";

    public static boolean isShowLog = true;
    public static boolean isShowToast = false;


    public static final String KEYPERMISSION = "keyPermission_";

    public static boolean doubleBackToExitPressedOnce;

    public static Context myContext;


    @Override
    public void onCreate() {

        super.onCreate();
        ContextWrapper cw = new ContextWrapper(getApplicationContext());

//        DB_PATH = cw.getFilesDir().getAbsolutePath() + "/databases/";
        DB_PATH = "/data/data/" + getPackageName() + "/databases/";
        IMG_PATH = "/data/data/" + getPackageName() + "/files/";
        myContext = getApplicationContext();
        File file = new File(DB_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        copyDataBase();
    }


    private void copyDataBase() {
        Log.i("Database",
                "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            myInput = myContext.getAssets().open(DB_NAME);
            // transfer bytes from the inputfile to the
            // outputfile
            myOutput = new FileOutputStream(DB_PATH + DB_NAME);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static void copyDataImage(String name) {
        Log.i("Database",
                "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            myInput = myContext.getAssets().open(name);
            // transfer bytes from the inputfile to the
            // outputfile
            myOutput = new FileOutputStream(IMG_PATH + name);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void L(String key, String value) {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = " ~~~~~~ ( " + msg[0].replace(".java", " > ") + msg[1] + ")";

        if (isShowLog) {
            Log.i(KEY + key, " ========> " + value + line);
        }

    }

    public static void L(String key, int value) {


        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = " ~~~~~~ ( " + msg[0].replace(".java", " > ") + msg[1] + ")";

        if (isShowLog) {
            Log.i(KEY + key, " ========> " + String.valueOf(value) + line);
        }


    }

    public static void L(String key, boolean value) {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = " ~~~~~~ ( " + msg[0].replace(".java:", " > ") + msg[1] + ")";

        if (isShowLog) {
            Log.i(KEY + key, " ========> " + String.valueOf(value) + line);
        }


    }

    public static void T(String Frag) {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = " ~~~~~~ ( " + msg[0].replace(".java:", " > ") + msg[1] + ")";

        if (isShowLog) {
            Log.i(KEY, " >> Toast =====>> " + Frag + line);
        }

    }

    public static void C() {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = "( " + msg[0].replace(".java", " > ") + msg[1] + ")";
        if (isShowLog) {
            Log.i(KEY + "CLICK", " =====>> " + line);
        }

    }

    public static void T(int Frag) {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = " ~~~~~~ ( " + msg[0].replace(".java:", " > ") + msg[1] + ")";
        if (isShowLog) {
            Log.i(KEY, " >> Toast =====>> " + Frag + line);
        }

    }

    public static boolean screenShotIsOn = false;

    public static void A() {

        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = "(" + msg[0] + ")";
        if (isShowLog) {
            Log.i(KEY + "A", " >> Activity ==> " + line.replace(".java", ""));
        }


    }

    public static void AD() {


        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = "(" + msg[0] + ")";
        if (isShowLog) {
            Log.i(KEY + "A", " >> Adapter ==> " + line.replace(".java", ""));
        }


    }

    public static void F() {


        String[] msg = trace(Thread.currentThread().getStackTrace(), 3);
        String line = "(" + msg[0] + ")";
        if (isShowLog) {
            Log.i(KEY + "F", " >> Fragment ==> " + line.replace(".java", ""));
        }


    }

    public static String getname(String address) {

        String[] names = address.split("/");
        return names[names.length - 1]
                .replace("%28", "(")
                .replace("%29", ")")
                .replace("%20", "_");
    }

    public static String getformat(String name) {

        return name.substring(name.lastIndexOf("."));
    }

    public static String[] trace(final StackTraceElement e[], final int level) {
        if (e != null && e.length >= level) {
            final StackTraceElement s = e[level];
            if (s != null) {
                return new String[]{
                        e[level].getFileName(), e[level].getMethodName() + "[" + e[level].getLineNumber() + "]"
                };
            }
        }
        return null;
    }

    public static boolean isValidPhoneNo(String phoneNo) {
        return !TextUtils.isEmpty(phoneNo) && Patterns.PHONE.matcher(phoneNo).matches() && phoneNo.length() >= 11;
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidName(String name) {
        if (name.length() < 3) {
            return false;
        } else {
            return true;
        }
    }

    public static void setBoolean(Context context, String key, boolean value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value).apply();
    }

    public static void setPermissionBoolean(Context context, String key, boolean value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEYPERMISSION + key, value).apply();
    }

    public static void setPermissionBoolean(Context context, int key, boolean value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEYPERMISSION + key, value).apply();
    }

    public static boolean getPermissionBoolean(Context context, int key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(KEYPERMISSION + key, false);

    }

    public static boolean getPermissionBoolean(Context context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(KEYPERMISSION + key, false);

    }

    public static boolean getBoolean(Context context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);

    }

    public static boolean getBooleanTrue(Context context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, true);

    }

    public static void setString(Context context, String key, String value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        if (value == null) {

            editor.putString(key, "").apply();

        } else {

            editor.putString(key, value).apply();
        }

    }

    public static String getString(Context context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        if (preferences.getString(key, "") == null) {

            return "";
        } else {

            return preferences.getString(key, "");
        }


    }


    public static String getString(Context context, String key, String defaoult) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        if (preferences.getString(key, defaoult) == null) {

            return defaoult;
        } else {

            return preferences.getString(key, defaoult);
        }


    }


    public static void setInt(Context context, String key, int value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value).apply();
    }

    public static void setLong(Context context, String key, long value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value).apply();
    }

    public static int getInt(Activity context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);

    }

    public static int getInt(Activity context, String key, int defaults) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, defaults);

    }

    public static long getLong(Activity context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getLong(key, 0);

    }

    public static int getInt(Context context, String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);

    }

    public static void setDelay(long mill, final OnDelay onDelay) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                onDelay.AfterOnDelay();
            }
        }, mill);


    }

    public interface OnDelay {
        void AfterOnDelay();
    }

    public static String deCodeBase64(String value) throws UnsupportedEncodingException {

        byte[] data = Base64.decode(value, Base64.DEFAULT);
        String text = new String(data, "UTF-8");
        return text;

    }

    public static String enCodeBase64(String value) throws UnsupportedEncodingException {
        byte[] data = value.getBytes("UTF-8");
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64;
    }

    public static String sFormatDuration(long duration) {
        int seconds = (int) (duration / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format(Locale.ENGLISH, "%02d", minutes) + ":" + String.format(Locale.ENGLISH, "%02d", seconds);
    }

    public static boolean isDownloadFromPath(String path, String name) {


        File file1 = new File(path, name);
        long size = file1.length();
        if (size < 300) {

            return false;

        } else {

            return true;

        }


    }

    public static int countOfFiles(String folder) {
        File dir = new File(folder);
        File[] files = dir.listFiles();
        return files.length;
    }


    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
        //..................................


    }

    public static boolean isNetworkAvailable2(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
        //..................................


    }

    public static void anim_item(View view) {

        view.setScaleX(0);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("scaleX", 1));

        animator.setDuration(50);
        animator.start();

    }

    public static String serialiseListString(ArrayList<String> strings) {
        /*compile 'com.google.code.gson:gson:2.8.0'*/

        return new Gson().toJson(strings);


    }

    public static ArrayList<String> deSerialiseListString(String lists) {


        ArrayList<String> myList = new ArrayList<>();
        if (lists != null) {

            JSONArray jsonVideo = null;
            try {
                jsonVideo = new JSONArray(lists);

                for (int i = 0; i < jsonVideo.length(); i++) {
                    String l = jsonVideo.getString(i);
                    myList.add(l);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return myList;


    }


    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            String[] files;
            files = dir.list();
            for (int i = 0; i < files.length; i++) {
                File myFile = new File(dir, files[i]);
                myFile.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(Context context, String file) {
        try {
            File dir = new File(file);
            String[] files;
            files = dir.list();
            for (int i = 0; i < files.length; i++) {
                File myFile = new File(dir, files[i]);
                myFile.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(Context context, File dir) {
        try {
            String[] files;
            files = dir.list();
            for (int i = 0; i < files.length; i++) {
                File myFile = new File(dir, files[i]);
                dir.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CopyFIle(File sourceFile, File destinationFile,String FileName) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }
        if (!destinationFile.exists()) {
            destinationFile.mkdirs();
        }
        File destFile = new File(destinationFile, FileName);
        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void hideSoftKeyboard(Activity context) {
        if (context.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static List<String> listOfWordInSentens(String Sentens) {

        List<String> mylist = new ArrayList<>();
        String g = Sentens.replace(",", " ").replace("/", " ").replace(".", " ");

        String[] f = g.split(" ");


        for (int i = 0; i < f.length; i++) {

            if (!f[i].equals("")) {

                mylist.add(f[i]);


            }


        }

        return mylist;

    }

    public static void doFinish(Activity activity) {
        if (doubleBackToExitPressedOnce) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
            activity.finish();

            return;

        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(activity, "برای خارج شدن از برنامه دکمه Back را دوبار بزنید", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;

            }
        }, 2000);
    }

    public static List<String> listsFiles(String folder) {
        List<String> list = new ArrayList<>();


        File dir = new File(folder);
        for (File f : dir.listFiles()) {

            list.add(f.getName());


            // Do your stuff
        }

        return list;


    }

    public static void toast(Context ctx, String message) {
        if (isShowToast) {

            Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();

        }

    }

    public static Context getContext() {
        return myContext;
    }


    public static String freeSpace(Activity activity, File path) {

        File paths;
        if (path != null) {
            paths = Environment.getDataDirectory();
        } else {
            paths = path;

        }
        StatFs stat = new StatFs(paths.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        String ff = Formatter.formatFileSize(activity, availableBlocks * blockSize);

        return ff;

    }

    public static boolean isSdCardSupportDevice() {


        Boolean isSDPresent = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        Boolean isSDSupportedDevice = Environment.isExternalStorageRemovable();

        if (!isSDSupportedDevice && isSDPresent) {
            return true;
        } else {
            return false;
        }
    }

    public static void CopyMyPick(Activity activity,String path,String name) {


        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            myInput = activity.getAssets().open(name);
            // transfer bytes from the inputfile to the
            // outputfile
            File fileO=new File(path +"/"+ name);
            myOutput = new FileOutputStream(fileO);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void copy(File src, File path,String name) throws IOException {

        if (!path.exists()){
            path.mkdirs();
        }

        File targetFile=new File(path.toString(),name);
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(targetFile);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void changeTabsFont(TabLayout tabLayout, Typeface typeface) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(typeface);
                }
            }
        }
    }

}
