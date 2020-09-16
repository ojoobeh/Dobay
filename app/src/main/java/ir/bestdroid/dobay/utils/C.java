package ir.bestdroid.dobay.utils;

import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

import ir.bestdroid.dobay.model.CategoryModel;
import ir.bestdroid.dobay.model.ShoppingModelist;


public class C {

    public static final String BASE_URL = "http://new504.kotobgram.com/";
    public static final String BASEPATH = Environment.getExternalStorageDirectory() + "/.BimeYaran/files/";
    public static final String BASEFILEURL = "http://cheshmeoghab.ir/public/files/";
    public static final String SH_MAIEFILEURL = "mainFileUrl";
    public static final String PUT_MAINCATID = "mainCatId";
    public static final String PUT_MAINCATTITLE = "mainCatTitle";
    public static final String PUT_CATID = "catId";
    public static final String PUT_CATTITLE = "catTitle";
    public static final String PUT_ID = "id";
    public static final String SH_ISSECOND = "isSecond";
    public static final String SH_ISLOGIN = "isLogin";
    public static final String SH_LANGUAGE = "language";
    public static final String PERSIAN = "persian";
    public static final String SH_USER_ID = "userId";
    public static final String SH_USER_USERNAME = "userNAme";
    public static final String SH_USER_COUNT = "userCount";
    public static final String SH_USER_PHONE = "phone";
    public static final String SH_USER_PASSWORD = "password";
    public static final String SH_USER_JUB = "jub";
    public static final String SH_USER_SHOPPING = "shopping";


    public static final String FONTSIZE = "fontsize";
    public static final String FONTNAME = "fontname";

    public static final String FONTSIZE2 = "fontsize2";
    public static final String FONTNAME2 = "fontname2";
    public static final String api_key = "b193f0330ccf5e8316b0eb858fd2fe7d";


    public static final String BYEKAN = "Yekan_C.ttf";
    public static final String BKODACK = "KOODB_T.ttf";
    public static final String IRANSANS = "iransans.ttf";
    public static final String BHOMA = "B_Homa.ttf";
    public static final String DEFAULTFONTRB = "defaultFontRB";
    public static final String DEFAULTIMG = "defultimg";
    public static final String IMGNUMBER = "imgnum";
    public static final String IMGPATH = "imgpath";
    public static final String IMGSELECTED = "imgSelected";

    public static final String MAINFILEDIRECTORY = Environment.getExternalStorageDirectory() + "/.BimeYaran/Folder";
    public static final String TARGETFILEDIRECTORY = Environment.getExternalStorageDirectory() + "/.BimeYaran/Files";

//    public static final String BackgroundPATH = "/data/data/com.setayeshco.cheshme_oghab/files";
    public static final String BackgroundPATH = BASEPATH;

    public static final String IMAGENAME = "imagename";

    public static final String BACKIMG1 = "image1.jpg";
    public static final String BACKIMG2 = "image2.jpg";
    public static final String BACKIMG3 = "image3.jpg";
    public static final String ADDGALLERY = "addgallery.jpg";


    public static List<CategoryModel> FakeListCategory() {


        List<CategoryModel> list = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            int id = i + 1;
            CategoryModel model = new CategoryModel();
            model.setId(id);
            model.setFav(0);
            model.setFileName("0");
            model.setIsEndUp(0);
            model.setParentId(0);

            switch (i) {
                case 0:

                    model.setTitle("خدمات تعمیرات الکترونیک");
                    model.setIcon("rahnama range fuse.png");


                    break;

                case 1:

                    model.setTitle("خدمات تعمیرات برق");
                    model.setIcon("fuse chist.png");


                    break;

                case 2:

                    model.setTitle("خدمات تعمیرات مکانیک");
                    model.setIcon("tablo bargh2.png");


                    break;

                case 3:

                    model.setTitle("محصولات مرتبط با مادگستر اسکانیا");
                    model.setIcon("rmahale rely.png");


                    break;

                case 4:

                    model.setTitle("همکاران چشم عقاب");
                    model.setIcon("nemone rely.png");


                    break;

                case 5:

                    model.setTitle("فرم ثبت ام همکاران چشم عقاب");
                    model.setIcon("ashnaei-ba-safe-kil.png");


                    break;


            }

            list.add(model);
        }


        return list;

    }


    public static List<ShoppingModelist> FakeShopping() {


        List<ShoppingModelist> list = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            int id = i + 1;
            ShoppingModelist model = new ShoppingModelist();
            model.setId(id);

            switch (i) {
                case 0:

                    model.setTitle("بسته 10 تایی");
                    model.setPrice("5000");

                    break;


                    

               case 1:

                    model.setTitle("بسته 20 تایی");
                    model.setPrice("10000");


                    break;

               case 2:

                    model.setTitle("بسته 30 تایی");
                    model.setPrice("20000");


                    break;

               case 3:

                    model.setTitle("بسته 60 تایی");
                    model.setPrice("30000");


                    break;




            }

            list.add(model);
        }


        return list;

    }

}
