package ir.bestdroid.dobay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.model.CategoryModel;
import ir.bestdroid.dobay.model.DetailModel;
import ir.bestdroid.dobay.model.ErrorModels;
import ir.bestdroid.dobay.model.MainCategoryModel;
import ir.bestdroid.dobay.model.Sub2CategoryModel;
import ir.bestdroid.dobay.model.SubCategoryModel;
import ir.bestdroid.dobay.newModels.books.DataBooks;
import ir.bestdroid.dobay.newModels.paragraphs.DataParagraphs;
import ir.bestdroid.dobay.newModels.season.DataSeasons;


public class DbHandler extends SQLiteOpenHelper {
    Context context;
    public int fav;
    public static final String DBNAME = "bimeOmr.db";
    public static final String TB_APPINFO = "app_info";
    public static final String TB_SEASONS = "seasons";
    public static final String TB_PARAGRAPHS = "paragraphs";


    public static final String K_APPINFO_ID = "id";
    public static final String K_APPINFO_TITLE = "title";
    public static final String K_APPINFO_IMAGE = "image";
    public static final String K_APPINFO_VIDEO = "video";
    public static final String K_APPINFO_SEASONCOUNT = "seasonCount";
    public static final String K_APPINFO_PAGECOUNT = "pageCount";
    public static final String K_APPINFO_AUTHOR = "author";
    public static final String K_APPINFO_RELEASEDATE = "releaseDate";
    public static final String K_APPINFO_DESCRIPTION = "description";
    public static final String K_APPINFO_STATUS = "status";
    public static final String K_APPINFO_CREATE_AT = "created_at";
    public static final String K_APPINFO_UPDATE_AT = "updated_at";
    public static final String K_APPINFO_UPDATE_A = "a";
    public static final String K_APPINFO_UPDATE_B = "b";
    public static final String K_APPINFO_UPDATE_C = "c";
    public static final String K_APPINFO_UPDATE_D = "d";
    public static final String K_APPINFO_UPDATE_E = "e";

    /*
     K_APPINFO_ID ;
     K_APPINFO_TITLE
     K_APPINFO_IMAGE
     K_APPINFO_VIDEO
     K_APPINFO_SEASONCOUNT
     K_APPINFO_PAGECOUNT
     K_APPINFO_AUTHOR
     K_APPINFO_RELEASEDATE
     K_APPINFO_DESCRIPTION
     K_APPINFO_STATUS
     K_APPINFO_CREATE_AT
     K_APPINFO_UPDATE_AT
     K_APPINFO_UPDATE_A
     K_APPINFO_UPDATE_B
     K_APPINFO_UPDATE_C
     K_APPINFO_UPDATE_D
     K_APPINFO_UPDATE_E
    */


    public static final String K_SEASONS_ID = "id";
    public static final String K_SEASONS_TITLE = "title";
    public static final String K_SEASONS_BOOK_ID = "book_id";
    public static final String K_SEASONS_ORD = "ord";
    public static final String K_SEASONS_IMAGE = "image";
    public static final String K_SEASONS_DESCRIPTION = "description";
    public static final String K_SEASONS_ZIPFILE = "zipFile";
    public static final String K_SEASONS_STATUS = "status";
    public static final String K_SEASONS_CREATE_AT = "created_at";
    public static final String K_SEASONS_UPDATE_AT = "updated_at";
    public static final String K_SEASONS_VERSION = "version";


     /*
      K_SEASONS_ID
      K_SEASONS_TITLE
      K_SEASONS_BOOK_ID
      K_SEASONS_ORD
      K_SEASONS_IMAGE
      K_SEASONS_DESCRIPTION
      K_SEASONS_ZIPFILE
      K_SEASONS_STATUS
      K_SEASONS_CREATE_AT
      K_SEASONS_UPDATE_AT
      K_SEASONS_VERSION
      */


    public static final String K_PARAGRAPH_ID = "id";
    public static final String K_PARAGRAPH_TITLE = "title";
    public static final String K_PARAGRAPH_SEASON_ID = "season_id";
    public static final String K_PARAGRAPH_TEXT = "text";
    public static final String K_PARAGRAPH_SOUND = "sound";
    public static final String K_PARAGRAPH_IMAGE = "image";
    public static final String K_PARAGRAPH_VIDEO = "video";
    public static final String K_PARAGRAPH_ORD = "ord";
    public static final String K_PARAGRAPH_STATUS = "status";
    public static final String K_PARAGRAPH_CREATE_AT = "created_at";
    public static final String K_PARAGRAPH_UPDATE_AT = "updated_at";

    /*
    K_PARAGRAPH_ID
    K_PARAGRAPH_TITLE
    K_PARAGRAPH_SEASON_ID
    K_PARAGRAPH_TEXT
    K_PARAGRAPH_SOUND
    K_PARAGRAPH_IMAGE
    K_PARAGRAPH_VIDEO
    K_PARAGRAPH_ORD
    K_PARAGRAPH_STATUS
    K_PARAGRAPH_CREATE_AT
    K_PARAGRAPH_UPDATE_AT
    */


    public DbHandler(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query_AppInfo = "CREATE TABLE " + TB_APPINFO + "(" +
                K_APPINFO_ID + " INTEGER, " +
                K_APPINFO_TITLE + " TEXT, " +
                K_APPINFO_IMAGE + " TEXT, " +
                K_APPINFO_VIDEO + " TEXT, " +
                K_APPINFO_SEASONCOUNT + " INTEGER, " +
                K_APPINFO_PAGECOUNT + " INTEGER, " +
                K_APPINFO_AUTHOR + " TEXT, " +
                K_APPINFO_RELEASEDATE + " TEXT, " +
                K_APPINFO_DESCRIPTION + " TEXT, " +
                K_APPINFO_STATUS + " TEXT, " +
                K_APPINFO_CREATE_AT + " TEXT, " +
                K_APPINFO_UPDATE_AT + " TEXT, " +
                K_APPINFO_UPDATE_A + " TEXT, " +
                K_APPINFO_UPDATE_B + " TEXT, " +
                K_APPINFO_UPDATE_C + " TEXT, " +
                K_APPINFO_UPDATE_D + " TEXT, " +
                K_APPINFO_UPDATE_E + " TEXT" +
                ")";

        db.execSQL(query_AppInfo);


        String query_SEASONS = "CREATE TABLE " + TB_SEASONS + "(" +
                K_SEASONS_ID + " INTEGER, " +
                K_SEASONS_TITLE + " TEXT, " +
                K_SEASONS_BOOK_ID + " INTEGER, " +
                K_SEASONS_ORD + " INTEGER, " +
                K_SEASONS_IMAGE + " TEXT, " +
                K_SEASONS_DESCRIPTION + " TEXT, " +
                K_SEASONS_ZIPFILE + " TEXT, " +
                K_SEASONS_STATUS + " TEXT, " +
                K_SEASONS_CREATE_AT + " TEXT, " +
                K_SEASONS_VERSION + " INTEGER, " +
                K_SEASONS_UPDATE_AT + " TEXT" +
                ")";

        db.execSQL(query_SEASONS);


        String query_PARAGRAPHS = "CREATE TABLE " + TB_PARAGRAPHS + "(" +
                K_PARAGRAPH_ID + " INTEGER, " +
                K_PARAGRAPH_TITLE + " TEXT, " +
                K_PARAGRAPH_SEASON_ID + " INTEGER, " +
                K_PARAGRAPH_TEXT + " TEXT, " +
                K_PARAGRAPH_SOUND + " TEXT, " +
                K_PARAGRAPH_IMAGE + " TEXT, " +
                K_PARAGRAPH_VIDEO + " TEXT, " +
                K_PARAGRAPH_ORD + " INTEGER, " +
                K_PARAGRAPH_STATUS + " TEXT, " +
                K_PARAGRAPH_CREATE_AT + " TEXT, " +
                K_PARAGRAPH_UPDATE_AT + " TEXT" +
                ")";

        db.execSQL(query_PARAGRAPHS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*************** INSERT ***************/

    public void insertAppInfo(DataBooks books) {


        deleteAppInfo();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(K_APPINFO_ID, books.getId());
        cv.put(K_APPINFO_TITLE, books.getTitle());
        cv.put(K_APPINFO_IMAGE, books.getImage());
        cv.put(K_APPINFO_VIDEO, books.getVideo());
        cv.put(K_APPINFO_SEASONCOUNT, books.getSeasonCount());
        cv.put(K_APPINFO_PAGECOUNT, books.getPageCount());
        cv.put(K_APPINFO_AUTHOR, books.getAuthor());
        cv.put(K_APPINFO_RELEASEDATE, books.getReleaseDate());
        cv.put(K_APPINFO_DESCRIPTION, books.getDescription());
        cv.put(K_APPINFO_STATUS, books.getStatus());
        cv.put(K_APPINFO_CREATE_AT, books.getCreatedAt());
        cv.put(K_APPINFO_UPDATE_AT, books.getUpdatedAt());

        db.insert(TB_APPINFO, null, cv);
        db.close();

    }

    public void insertSeasons(DataSeasons seasons) {


        deleteAppInfo();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(K_SEASONS_ID, seasons.getId());
        cv.put(K_SEASONS_TITLE, seasons.getTitle());
        cv.put(K_SEASONS_BOOK_ID, seasons.getBookId());
        cv.put(K_SEASONS_ORD, seasons.getOrd());
        cv.put(K_SEASONS_IMAGE, seasons.getImage());
        cv.put(K_SEASONS_DESCRIPTION, seasons.getDescription());
        cv.put(K_SEASONS_ZIPFILE, seasons.getZipFile());
        cv.put(K_SEASONS_STATUS, seasons.getStatus());
        cv.put(K_SEASONS_CREATE_AT, seasons.getCreatedAt());
        cv.put(K_SEASONS_UPDATE_AT, seasons.getUpdatedAt());
        cv.put(K_SEASONS_VERSION, seasons.getVersion());

        db.insert(TB_SEASONS, null, cv);
        db.close();

    }

    public void insertParagraphs(DataParagraphs paragraphs) {


        deleteAppInfo();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(K_PARAGRAPH_ID, paragraphs.getId());
        cv.put(K_PARAGRAPH_TITLE, paragraphs.getTitle());
        cv.put(K_PARAGRAPH_SEASON_ID, paragraphs.getSeasonId());
        cv.put(K_PARAGRAPH_TEXT, paragraphs.getText());
        cv.put(K_PARAGRAPH_SOUND, paragraphs.getSound());
        cv.put(K_PARAGRAPH_IMAGE, paragraphs.getImage());
        cv.put(K_PARAGRAPH_VIDEO, paragraphs.getVideo());
        cv.put(K_PARAGRAPH_ORD, paragraphs.getOrd());
        cv.put(K_PARAGRAPH_STATUS, paragraphs.getStatus());
        cv.put(K_PARAGRAPH_CREATE_AT, paragraphs.getCreatedAt());
        cv.put(K_PARAGRAPH_UPDATE_AT, paragraphs.getUpdatedAt());

        db.insert(TB_PARAGRAPHS, null, cv);
        db.close();

    }


    /*************** GET LIST ***************/


    public List<DataSeasons> getListSeasons() {

        List<DataSeasons> list = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_APPINFO, null);
        if (cursor.moveToFirst()) {

            do {


                DataSeasons seasons = new DataSeasons();
                seasons.setId(cursor.getInt(cursor.getColumnIndex(K_SEASONS_ID)));
                seasons.setTitle(cursor.getString(cursor.getColumnIndex(K_SEASONS_TITLE)));
                seasons.setBookId(cursor.getInt(cursor.getColumnIndex(K_SEASONS_BOOK_ID)));
                seasons.setOrd(cursor.getInt(cursor.getColumnIndex(K_SEASONS_ORD)));
                seasons.setImage(cursor.getString(cursor.getColumnIndex(K_SEASONS_IMAGE)));
                seasons.setDescription(cursor.getString(cursor.getColumnIndex(K_SEASONS_DESCRIPTION)));
                seasons.setZipFile(cursor.getString(cursor.getColumnIndex(K_SEASONS_ZIPFILE)));
                seasons.setStatus(cursor.getString(cursor.getColumnIndex(K_SEASONS_STATUS)));
                seasons.setCreatedAt(cursor.getString(cursor.getColumnIndex(K_SEASONS_CREATE_AT)));
                seasons.setUpdatedAt(cursor.getString(cursor.getColumnIndex(K_SEASONS_UPDATE_AT)));
                seasons.setVersion(cursor.getInt(cursor.getColumnIndex(K_SEASONS_VERSION)));
                list.add(seasons);
            } while (cursor.moveToNext());

            db.close();
            cursor.close();


        }

        return list;
    }

    public List<DataParagraphs> getListParagraphBySeasonId(int seasonId) {

        List<DataParagraphs> list = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_APPINFO + " WHERE " +
                K_PARAGRAPH_SEASON_ID + " = '" + seasonId + "'", null);
        if (cursor.moveToFirst()) {

            do {

                DataParagraphs paragraphs = new DataParagraphs();
                paragraphs.setId(cursor.getInt(cursor.getColumnIndex(K_PARAGRAPH_ID)));
                paragraphs.setTitle(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_TITLE)));
                paragraphs.setSeasonId(cursor.getInt(cursor.getColumnIndex(K_PARAGRAPH_SEASON_ID)));
                paragraphs.setText(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_TEXT)));
                paragraphs.setSound(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_SOUND)));
                paragraphs.setImage(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_IMAGE)));
                paragraphs.setVideo(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_VIDEO)));
                paragraphs.setOrd(cursor.getInt(cursor.getColumnIndex(K_PARAGRAPH_ORD)));
                paragraphs.setStatus(cursor.getInt(cursor.getColumnIndex(K_PARAGRAPH_STATUS)));
                paragraphs.setCreatedAt(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_CREATE_AT)));
                paragraphs.setUpdatedAt(cursor.getString(cursor.getColumnIndex(K_PARAGRAPH_UPDATE_AT)));
                list.add(paragraphs);

            } while (cursor.moveToNext());

            db.close();
            cursor.close();


        }

        return list;
    }


    /*************** GET OBJECT ***************/

    public DataBooks getBooks() {

        DataBooks books = new DataBooks();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_APPINFO, null);
        if (cursor.moveToFirst()) {

            books.setId(cursor.getInt(cursor.getColumnIndex(K_APPINFO_ID)));
            books.setTitle(cursor.getString(cursor.getColumnIndex(K_APPINFO_TITLE)));
            books.setImage(cursor.getString(cursor.getColumnIndex(K_APPINFO_IMAGE)));
            books.setVideo(cursor.getString(cursor.getColumnIndex(K_APPINFO_VIDEO)));
            books.setSeasonCount(cursor.getInt(cursor.getColumnIndex(K_APPINFO_SEASONCOUNT)));
            books.setPageCount(cursor.getInt(cursor.getColumnIndex(K_APPINFO_PAGECOUNT)));
            books.setAuthor(cursor.getString(cursor.getColumnIndex(K_APPINFO_AUTHOR)));
            books.setReleaseDate(cursor.getString(cursor.getColumnIndex(K_APPINFO_RELEASEDATE)));
            books.setDescription(cursor.getString(cursor.getColumnIndex(K_APPINFO_DESCRIPTION)));
            books.setStatus(cursor.getInt(cursor.getColumnIndex(K_APPINFO_STATUS)));
            books.setCreatedAt(cursor.getString(cursor.getColumnIndex(K_APPINFO_CREATE_AT)));
            books.setUpdatedAt(cursor.getString(cursor.getColumnIndex(K_APPINFO_UPDATE_AT)));
        }

        db.close();
        cursor.close();


        return books;
    }


    /*************** UPDATE ***************/


    /*************** DELETE ***************/

    private void deleteAppInfo() {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TB_APPINFO, null, null);
    }


}
