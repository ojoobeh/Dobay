package ir.bestdroid.dobay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.model.newServerModels.AgentList;
import ir.bestdroid.dobay.model.newServerModels.DatumUser;
import ir.bestdroid.dobay.utils.A;

public class Db_Other extends SQLiteOpenHelper {


    public final Context context;


    public static final String DB_NAME = "new504_others.db";

    public static final String TB_MKUT = "mkut";
    public static final String TB_MKUT_LIST = "mkutList";


    public static final String KEY_MKUT_A = "a";
    public static final String KEY_MKUT_B = "b";
    public static final String KEY_MKUT_C = "c";
    public static final String KEY_MKUT_D = "d";
    public static final String KEY_MKUT_E = "e";
    public static final String KEY_MKUT_F = "f";
    public static final String KEY_MKUT_G = "g";
    public static final String KEY_MKUT_H = "h";
    public static final String KEY_MKUT_I = "i";
    public static final String KEY_MKUT_J = "j";
    public static final String KEY_MKUT_K = "k";
    public static final String KEY_MKUT_L = "l";
    public static final String KEY_MKUT_M = "m";

    public static final String KEY_MKUT_LIST_A = "a";
    public static final String KEY_MKUT_LIST_B = "b";
    public static final String KEY_MKUT_LIST_C = "c";
    public static final String KEY_MKUT_LIST_D = "d";
    public static final String KEY_MKUT_LIST_E = "e";
    public static final String KEY_MKUT_LIST_F = "f";
    public static final String KEY_MKUT_LIST_G = "g";
    public static final String KEY_MKUT_LIST_H = "h";
    public static final String KEY_MKUT_LIST_I = "i";
    public static final String KEY_MKUT_LIST_J = "j";
    public static final String KEY_MKUT_LIST_K = "k";
    public static final String KEY_MKUT_LIST_L = "l";
    public static final String KEY_MKUT_LIST_M = "m";
    public static final String KEY_MKUT_LIST_N = "n";
    public static final String KEY_MKUT_LIST_O = "o";
    public static final String KEY_MKUT_LIST_P = "p";


    public static String TAG = "DataBases";


    public static String DB_PATH;
    public static String DB_PATHFINAL;

    public SQLiteDatabase database;
    public static final int DVVERSION = 1;
    private int MYDEVICEVERSION;


    public Db_Other(Context context) {
        super(context, DB_NAME, null, DVVERSION);
        this.context = context;
        MYDEVICEVERSION = android.os.Build.VERSION.SDK_INT;

        String packageName = context.getPackageName();

//        DB_PATH = String.format("//data//data//%s//databases//", packageName);
        DB_PATH = context.getDatabasePath(DB_NAME).toString().replace(DB_NAME, "");

        openDataBase();

        // prepare if need to upgrade
        int cur_version = database.getVersion();
        if (cur_version == 0) database.setVersion(DVVERSION);
        if (cur_version < DVVERSION) {
            try {
                copyDataBase();
                Log.d(TAG, "Upgrade DB from v." + cur_version + " to v." + DVVERSION);
                database.setVersion(1);
            } catch (IOException e) {
                Log.d(TAG, "Upgrade error");
                throw new Error("Error upgrade database!");
            }
        }


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    /*COPY AND CREATE DATABASE*/


    public void createDataBase() {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e(TAG, "Copying error");
                throw new Error("Error copying database!");
            }
        } else {
            Log.i(this.getClass().toString(), "Database already exists");
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDb = null;
        try {
            String path = DB_PATH + DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            Log.e(TAG, "Error while checking db");
        }

        if (checkDb != null) {
            checkDb.close();
        }
        return checkDb != null;
    }

    private void copyDataBase() throws IOException {
        InputStream externalDbStream = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;

        OutputStream localDbStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = externalDbStream.read(buffer)) > 0) {
            localDbStream.write(buffer, 0, bytesRead);
        }

        localDbStream.close();
        externalDbStream.close();

    }

    public SQLiteDatabase openDataBase() throws SQLException {
        String path = DB_PATH + DB_NAME;
        if (database == null) {
            createDataBase();
            database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        }

        return database;
    }

    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if (MYDEVICEVERSION >= 28) {


            db.disableWriteAheadLogging();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public int getLastId() {
        int id = 0;
        String selectQuery = "SELECT * FROM lessons ORDER BY id DESC";
//        String selectQuery = "SELECT * FROM " + TB_DIC_EN_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToLast()) {
            id = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return id;
    }

    public void addToMKUT(DatumUser user, List<AgentList> lists) {

        removeMKUT();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MKUT_A, C(String.valueOf(user.getId())));
        values.put(KEY_MKUT_B, C(String.valueOf(user.getName())));
        values.put(KEY_MKUT_C, C(String.valueOf(user.getEmail())));
        values.put(KEY_MKUT_D, C(String.valueOf(user.getMobile())));
        values.put(KEY_MKUT_E, C(user.getPackage1()));
        values.put(KEY_MKUT_F, C(user.getPackage2()));
        values.put(KEY_MKUT_G, C(user.getPackage3()));
        values.put(KEY_MKUT_H, C(user.getPackage4()));

        // Inserting Row

        long ff = db.insert(TB_MKUT, null, values);

        if (lists!=null){
            for (int i = 0; i < lists.size(); i++) {
                addToMKUTList(lists.get(i));
            }

        }


        A.C();
        db.close(); // Closing database connection


    }

    public void addToMKUT(DatumUser user) {

        removeMKUT();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MKUT_A, C(String.valueOf(user.getId())));
        values.put(KEY_MKUT_B, C(String.valueOf(user.getName())));
        values.put(KEY_MKUT_C, C(String.valueOf(user.getEmail())));
        values.put(KEY_MKUT_D, C(String.valueOf(user.getMobile())));
        values.put(KEY_MKUT_E, C(user.getPackage1()));
        values.put(KEY_MKUT_F, C(user.getPackage2()));
        values.put(KEY_MKUT_G, C(user.getPackage3()));
        values.put(KEY_MKUT_H, C(user.getPackage4()));

        // Inserting Row

        long ff = db.insert(TB_MKUT, null, values);


        A.C();
        db.close(); // Closing database connection


    }

    public void addToMKUTList(AgentList model) {

        removeMKUTList();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MKUT_LIST_A, C(String.valueOf(model.getId())));
        values.put(KEY_MKUT_LIST_B, C(String.valueOf(model.getName())));
        values.put(KEY_MKUT_LIST_C, C(String.valueOf(model.getAddress())));
        values.put(KEY_MKUT_LIST_D, C(String.valueOf(model.getEmail())));
        values.put(KEY_MKUT_LIST_E, C(String.valueOf(model.getLink())));
        values.put(KEY_MKUT_LIST_F, C(String.valueOf(model.getPhoneNumber())));
        values.put(KEY_MKUT_LIST_G, C(String.valueOf(model.getBankAccount())));
        values.put(KEY_MKUT_LIST_H, C(String.valueOf(model.getCreatedAt())));
        values.put(KEY_MKUT_LIST_I, C(String.valueOf(model.getUpdatedAt())));
        values.put(KEY_MKUT_LIST_J, C(String.valueOf(model.getStatus())));
        values.put(KEY_MKUT_LIST_K, C(String.valueOf(model.getLogo())));

        // Inserting Row

        long ff = db.insert(TB_MKUT_LIST, null, values);
        A.C();
        db.close(); // Closing database connection


    }


    public void updateToMKUT(String id, String key, String value) {

        if (value != null) {

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(key, C(value));

            // Inserting Row

            double updat = db.update(TB_MKUT, values, KEY_MKUT_A + " = '" + C(id) + "'", null);
            db.close(); // Closing database connection

        }


    }


    public DatumUser getMKUT() {
        String selectQuery = "SELECT * FROM "
                + TB_MKUT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        DatumUser user = new DatumUser();
        if (cursor.moveToFirst()) {


            String id = D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_A)));
            user.setId(Integer.valueOf(id));
            user.setName(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_B)).replace("null", "")));
            user.setEmail(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_C)).replace("null", "")));
            user.setMobile(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_D)).replace("null", "")));
            user.setPackage1(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_E)).replace("null", "")));
            user.setPackage2(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_F)).replace("null", "")));
            user.setPackage3(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_G)).replace("null", "")));
            user.setPackage4(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_H)).replace("null", "")));
            user.setAgentLists(getMKUTList());

            cursor.close();
            db.close();
        } else {


            user.setId(0);
            user.setName("");
            user.setEmail("");
            user.setMobile("");
            user.setPackage1("0");
            user.setPackage2("0");
            user.setPackage3("0");
            user.setPackage4("0");

        }
        return user;
    }

    public List<AgentList> getMKUTList() {

        List<AgentList> lists = new ArrayList<>();
        String selectQuery = "SELECT * FROM "
                + TB_MKUT_LIST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {


            do {
                AgentList user = new AgentList();

                String id = D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_A)));
                user.setId(Integer.valueOf(id));
                user.setName(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_B)).replace("null", "")));
                user.setAddress(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_C)).replace("null", "")));
                user.setEmail(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_D)).replace("null", "")));
                user.setEmail(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_E)).replace("null", "")));
                user.setPhoneNumber(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_F)).replace("null", "")));
                user.setBankAccount(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_G)).replace("null", "")));
                user.setCreatedAt(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_H)).replace("null", "")));
                user.setUpdatedAt(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_I)).replace("null", "")));
                user.setStatus(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_J)).replace("null", "")));
                user.setLogo(D(cursor.getString(cursor.getColumnIndex(KEY_MKUT_K)).replace("null", "")));

                lists.add(user);

            } while (cursor.moveToNext());


            cursor.close();
            db.close();
        }
        return lists;
    }


    public void removeMKUT() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_MKUT, null, null);
    }

    public void removeMKUTList() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_MKUT_LIST, null, null);
    }


    public String C(String param) {

        String f = param;

        try {
            f = A.enCodeBase64(param).replace("==", "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return f;
    }

    public String D(String param) {

        String f = param;

        try {
            f = A.deCodeBase64(param);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return f.replace("/n", "");
    }


}
