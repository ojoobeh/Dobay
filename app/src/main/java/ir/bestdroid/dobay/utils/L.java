package ir.bestdroid.dobay.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import ir.bestdroid.dobay.R;


public class L {

    public static final String Montserrat_Regular = "font/Montserrat-Regular.ttf";
    public static final String Montserrat_Bold = "font/Montserrat-Bold.ttf";
    public static final String Montserrat_Medium = "font/Montserrat-Medium.ttf";

    public static final String IRANSansWeb_Bold = "font/IRANSansWeb_Bold.ttf";
    public static final String IRANSansWeb_Medium = "font/IRANSansWeb_Medium.ttf";
    public static final String IRANSansWeb_Light = "font/IRANSansWeb_Light.ttf";

    public static String TellaFriend(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اشتراک با دوستان";
        } else {
            return "Spread the Love";
        }
    }

    public static String DeleteVideoWeeks(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "آزاد کردن فضا";
        } else {
            return "Free Space";
        }
    }

    public static String AboutUs(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "درباره ما";
        } else {
            return "About Us";
        }
    }

    public static String Setting(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تنظیمات";
        } else {
            return "Setting";
        }
    }


    public static String Favorites(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "علاقه مندی ها";
        } else {
            return "Favorites";
        }
    }

    public static String Preference(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تنظیمات";
        } else {
            return "Preferences";
        }
    }

    public static String UpdateToPremium(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ارتقاع به نسخه کامل";
        } else {
            return "Update To Premium";
        }
    }


    public static void UpdateToPremium(TextView textView, Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            Typeface tf = Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Medium);
            textView.setTypeface(tf);
            textView.setText("ارتقاع به نسخه کامل");
        } else {

            Typeface tf = Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Bold);


            textView.setTypeface(tf);
            textView.setText("Update To Premium");
        }
    }


    public static String Profile(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پروفایل";
        } else {
            return "Profile";
        }
    }

    public static String Help(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "معرفی اپلیکیشن";
        } else {
            return "Intro";
        }
    }

    public static String RateApp(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ارسال نظر در گوگل پلی";
        } else {
            return "Rate this App";
        }
    }

    public static String ShareApp(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اشتراک با دوستان";
        } else {
            return "Share with Friends";
        }
    }

    public static String Frequent(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "سوالات متداول";
        } else {
            return "Frequent questions";
        }
    }

    public static String Exit(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "خروج";
        } else {
            return "Exit";
        }
    }

    public static String CheckSpam(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "درصورت عدم دریافت ایمیل، پوشه Spam را چک کنید";
        } else {
            return "Check your Spam folder, if you're not receiving Email";
        }
    }
    public static String Advertisement(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اسپانسرینگ و تبلیغات";
        } else {
            return "sponsoring & advertising";
        }
    }
    public static String deleteLessonsFolder(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاک کردن فایل دروس";
        } else {
            return "Delete lessons";
        }
    }


    public static String titlePayPal(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "فعال سازی";
        } else {
            return "Activation";
        }
    }

    public static String payPayPal(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پرداخت با پی پل";
        } else {
            return "Payment";
        }
    }
    public static String CouponCode(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کد فعالسازی را وارد کنید";
        } else {
            return "Enter activation code";
        }
    }

    public static String agentListPayPal(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لیست نمایندگان";
        } else {
            return "Agent List";
        }
    }
    public static String btnSendCodeByEmail(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ارسال کد از طریق ایمیل";
        } else {
            return "Send by email";
        }
    }

    public static String SendAgain(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ارسال مجدد پیامک کد";
        } else {
            return "Resend Sms";
        }
    }

    public static String CouponPaypal(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کپن تخفیف";
        } else {
            return "do you have coupon";
        }
    }

    public static String Cancel(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "انصراف";
        } else {
            return "Cancel";
        }
    }

    public static String No(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "خیر";
        } else {
            return "No";
        }
    }

    public static String Yes(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "بله";
        } else {
            return "Yes";
        }
    }
   public static String go(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "برو";
        } else {
            return "Go";
        }
    }


    public static String Dialog01(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "آیا از حساب کاربری خود خارج میشوید؟!";
        } else {
            return "Do you wish to exit your account?!";
        }
    }

    public static String ExitProfile(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "خروج از حساب کاربری";
        } else {
            return "Exit Profile";
        }
    }

    public static String actiVeSmartCode(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "فعال شدن مرور هوشمند";
        } else {
            return "Activating Smart Review";
        }
    }

    public static String studiedYet(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "این درس هنوز مطالعه نشده است !";
        } else {
            return "This lesson isn't studied yet";
        }
    }

    public static String studiedYet02(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ابتدا باید از بخش \"504WORDS\" تمامی لغات را مطالعه کنید تا مرور هوشمند این درس فعال شود.";
        } else {
            return "You should begin studying this lesson with \"504 WORDS\" in main menu, so the smart review will be activated";
        }
    }


    public static String Dialog02(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "آیا از حذف تاریخچه مرور خود مطمئن هستید ؟";
        } else {
            return "Do you wish to delete all your review history?! ";
        }
    }
    public static String DeleteHistoryTitle(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاک کردن تاریخچه مرور هوشمند و دیکته";
        } else {
            return "Delete Smart Review & Writing history ";
        }
    }

    public static String DialogDeleteLesson(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "آیا از حذف این درس  مطمئن هستید ؟";
        } else {
            return "Do you wish to delete all your review history?! ";
        }
    }
    public static String DialogDeleteLessonTitle(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاک کردن پوشه درس";
        } else {
            return "Delete Lessons Folder ";
        }
    }


    public static String Dialog03(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تمامی لغات مرور نشده، با فرض بلد نبودن ثبت میشود\n  آیا خارج میشوید ؟";
        } else {
            return "Words that have not been reviewed will be assumed as you do not know!\n  Do you wish to exit?";
        }
    }

    public static String Dialog08(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "درس به صورت کامل مرور نشده !";
        } else {
            return "The lesson is not completely reviewed!";
        }
    }
    public static String getEmailTitle0(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لطفا ایمیل خود را وارد کنید";
        } else {
            return "Please enter your email address";
        }
    }

     public static String getEmailTitle1(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کد تایید به ایمیل شما ارسال میشود";
        } else {
            return "verification code will be sent to your address";
        }
    }
     public static String send(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ارسال";
        } else {
            return "Send";
        }
    }




    public static String RETRY(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "امتحان مجدد";
        } else {
            return "RETRY";
        }
    }

    public static String CorrectAnswers(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاسخ صحیح";
        } else {
            return "Check Answers";
        }
    }

    public static String RESULT(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "نتیجه";
        } else {
            return "RESULT";
        }
    }

    public static String ConnectToBank(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "در حال اتصال به درگاه بانکی";
        } else {
            return "Connecting To Payment Portal...";
        }
    }

    public static String PleaseWait(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لطفا منتظر بمانید..";
        } else {
            return "Please Wait...";
        }
    }

    public static String TurnOffVpn(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "(فیلترشکن خاموش باشد!)";
        } else {
            return "Turn Off Vpn!";
        }
    }

    public static String Dialog04(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لطفا ابتدا وارد حساب کاربری شوید";
        } else {
            return "Please sign up/sign in";
        }
    }

    public static String Dialog05(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "به این منظور شماره همراه خود را وارد کنید \n تا کد تایید برای شما ارسال شود";
        } else {
            return "enter your cellphone number \n to get started";
        }
    }

    public static String Ok(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تایید";
        } else {
            return "Ok";
        }
    }



    public static String SendCodeContent(Activity activity, String number) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کدی که تا لحظاتی دیگر برای شماره \n" + number + " ارسال می شود را وارد کنید";
        } else {
            return "Enter the verification code sent to\n" + number + "";
        }
    }

    public static String SendCodeContentToEmail(Activity activity, String email) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کد تایید ارسال شده به ایمیل " + "\n"+email+"\n" + " را وارد کنید.";
        } else {
            return "Enter the verification code sent to\n" + email + "";
        }
    }



    public static String TaidShomareh(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تایید شماره";
        } else {
            return "Verify";
        }
    }

        public static String TaidShomareh2(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ایمیل ارسال شد";
        } else {
            return "Email is sent";
        }
    }

    public static String TimerSend(Activity activity, String number) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "برای ارسال مجدد کد " + number + " ثانیه صبر کنید";
        } else {
            return number + " Seconds to resend code";
        }
    }

    public static String VeriFyIsNotOk(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کد فعالسازی معتبر نیست!";
        } else {
            return "Verification code is false";
        }
    }

    public static String OthersApp(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "دانلود محصولات دیگر";
        } else {
            return "Download Other Products";
        }
    }

    public static String ConnectionError(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اشکالی در ارسال درخواست شما بوجود امده است، لطفا دوباره تلاش کنید.";
        } else {
            return "Internet connection is not available, Please try again!";
        }
    }

    public static String Dialog06(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "زمان زیادی از موعد مرور این درس گذشته!";
        } else {
            return "You haven't reviewed this lesson according to schedule!";
        }
    }

    public static String Dialog07(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "به این دلیل این مرحله تکرار خواهد شد.";
        } else {
            return "So previous step will be repeated.";
        }
    }

    public static String Dialog08(Activity activity, int param) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "طبق برنامه تا موعد مرور این درس " + param + " روز باقی مانده \n تاریخ مرور در نظر گرفته نشود؟ یا جایگزین مرور قبل شود؟ ";
        } else {
            return "According to schedule you have " + param + "days left\nto review this lesson\nthis review will not be counted";
        }
    }

    public static String Dialog9(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرور خارج از برنامه !";
        } else {
            return "Out of Schedule Review!";
        }
    }

    public static String JaiGozin(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "جایگزین شود";
        } else {
            return "No";
        }
    }


    public static String DarNazarGerefteNashavad(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "درنظر گرفته نشود";
        } else {
            return "Yes";
        }
    }

    public static String Permission_READANDWRITE_TitleDialog(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return activity.getResources().getString(R.string.permissionWarning);
        } else {
            return "Please select ALLOW in the coming dialog, so that the application can use yor device memory for downloading Pictures & Videos related to each new word";
        }
    }

    public static String Permission_READPHONESTATE_TitleDialog(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "این اپلیکیشن بعد از فعال سازی صرفا بر روی یکدستگاه قابل استفاده خواهد بود، بدین منظور نیاز است تا کد منحصر بفرد دستگاه شما شناسایی شود\nلطفا در پنجره ای که باز خواهد شد بر روی تایید کلیک کنید";
        } else {
            return "این اپلیکیشن بعد از فعال سازی صرفا بر روی یکدستگاه قابل استفاده خواهد بود، بدین منظور نیاز است تا کد منحصر بفرد دستگاه شما شناسایی شود\nلطفا در پنجره ای که باز خواهد شد بر روی تایید کلیک کنید";
        }
    }


    public static String Font_Size(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اندازه فونت";
        } else {
            return "Font Size";
        }


    }


    public static String Notification(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "اعلان مرور هوشمند";
        } else {
            return "NOTIFICATION";
        }

    }

    public static String LessonReviewReminder(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تنظیم ساعت یاد آوری مرور";
        } else {
            return "Lesson Review Reminder";
        }

    }


    public static String Sound(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "صداها";
        } else {
            return "SOUND";
        }

    }


    public static String AutomaticWordPronunciation(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پخش اتوماتیک تلفظ";
        } else {
            return "Automatic Word Pronunciation";
        }

    }


    public static String Accent(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لهجه";
        } else {
            return "ACCENT";
        }

    }

    public static String YourDefaultAccent(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "لهجه پیش فرض شما";
        } else {
            return "Your Default Accent";
        }

    }

    public static String HISTORY(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "تاریخچه";
        } else {
            return "HISTORY";
        }

    }


    public static String DeleteReviewHistory(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاک کردن تاریخچه مرور";
        } else {
            return "Delete Review History";
        }

    }
    public static String DeleteLessons(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "پاک کردن پوشه هر درس ";
        } else {
            return "Delete Every Lessons Folder";
        }

    }    public static String DeleteLessons0(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "آزادسازی فضا";
        } else {
            return "Free Space";
        }

    }

    public static String SELECTLANGUAGE(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "زبان رابط کاربری";
        } else {
            return "SELECT UI LANGUAGE";
        }

    }


    public static String Level1Review(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرحله اول مرور";
        } else {
            return "Level 1 Review";
        }
    }


    public static String Level2Review(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرحله دوم مرور";
        } else {
            return "Level 2 Review";
        }
    }


    public static String Level3Review(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرحله سوم مرور";
        } else {
            return "Level 3 Review";
        }
    }


    public static String Level4Review(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرحله چهارم مرور";
        } else {
            return "Level 4 Review";
        }
    }


    public static String Level5Review(Activity activity) {
        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "مرحله پنجم مرور";
        } else {
            return "Level 5 Review";
        }
    }


    public static String getIntro01(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "504 لغت ضروری همراه با تصاویر مفهومی، تلفظ آمریکایی و انگلیسی، و مثال.";
        } else {
            return "504 Essential Words Upcoming with Reminding Pictures, American & English Pronunciation & Usage Examples.";
        }
    }

public static String getIntro01_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "شما استفاده کاربردی واژگان جدید را فرا خواهید گرفت";
        } else {
            return "You will truly learn, and even feel how to use each word in your real life, while enjoying the process.";
        }
    }


    public static String getIntro02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "یادگیری با فیلم";
        } else {
            return "Learn in Context";
        }
    }

    public static String getIntro02_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "صدها ویدیو از کاربرد لغات را تماشا کنید. این ویدیوها با دقت از فیلمهای سینمایی، سریال ها و اخبار انتخاب شده است. یادگیری هیچگاه اینقدر لذت بخش نبوده است!";
        } else {
            return "Watch hundreds of carefully selected videos from movies, TV series, news etc. to master new vocab usage. Learning has never been more enjoyable!";
        }
    }


    public static String getIntro03(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "یادگیری خود را تثبیت کنید";
        } else {
            return "Consolidate What You Learn";
        }
    }
    public static String getIntro03_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "برنامه Smart Reviw برای مرور هوشمند دروس طراحی شده است که در آن مطابق منحنی فراموشی \"اِبینگ هوس\" زمان مرور هر درس برای شما نمایش داده میشود. کافیست مطابق این برنامه هر درس را 5 بار مرور کنید تا دیگر هیچگاه فراموش نکنید.";
        } else {
            return "\"Smart Review\" is your Reviewing Program, specially designed according to \"Ebbinghous Forgetting Curve\". Review each lesson 5 times and you will never forget.";
        }
    }


    public static String getIntro04(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "فرایند یادگیری خود را تست کنید";
        } else {
            return "Test Your Learning Progress";
        }
    }
    public static String getIntro04_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "با آزمون 4 گزینه ای برای هر درس، میزان یادگیری خود را محک بزنید";
        } else {
            return "Easily assess whether you have mastered new vocab and measure your progress.";
        }
    }


    public static String getIntro05(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "دیکشنری لمسی";
        } else {
            return "Touch for Translations";
        }
    }
    public static String getIntro05_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "کافیست هر کلمه را لمس کنید، تا دیکشنری به صورت اتوماتیک باز شود. این امکان ویژه برای کلمات انگلیسی و حتی فارسی قابل استفاده است تا ترجمه همیشه در دسترس شما باشد";
        } else {
            return "Touch each word and the dictionary will be opened automatically. This helpful option works for either English or Persian.";
        }
    }

 public static String SubmitCode(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "ثبت کد";
        } else {
            return "Activate";
        }
    }


    public static String getIntro06(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "برنامه دیکشنری داخلی با بیش از 170.000 واژه";
        } else {
            return "";
        }
    }
    public static String getIntro06_02(Activity activity) {

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {
            return "برای ترجمه انگلیسی به فارسی یا فارسی به انگلیسی واژگان مورد نظر شما و افزودن به لیست علاقه مندی ها";
        } else {
            return "Built in dictionary with more than 170,000 words. English to Persian and vice-a-versa.";
        }
    }


    public static void setFonts( Activity activity,TextView... textView) {

        Typeface typeface=null;

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Medium);

            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        } else {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Bold);


            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        }

    }

    public static void setFontsBold( Activity activity,TextView... textView) {

        Typeface typeface=null;

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Bold);

            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        } else {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Bold);


            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        }

    }
    public static void setFonts(Context activity, TextView... textView) {

        Typeface typeface=null;

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Medium);

            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        } else {

            typeface= Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Bold);


            for (int i = 0; i < textView.length; i++) {

                textView[i].setTypeface(typeface);
            }

        }

    }
    public static void setFontsIntro(Context activity, TextView textView1, TextView textView2) {

        Typeface typeface1=null;
        Typeface typeface2=null;

        String langouge = A.getString(activity, C.SH_LANGUAGE, C.PERSIAN);
        if (langouge.equals(C.PERSIAN)) {

            typeface1= Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Bold);

            typeface2= Typeface.createFromAsset(activity.getAssets(),
                    IRANSansWeb_Medium);

            textView1.setTypeface(typeface1);
            textView2.setTypeface(typeface2);


        } else {

            typeface1= Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Bold);

            typeface2= Typeface.createFromAsset(activity.getAssets(),
                    Montserrat_Medium);
            textView1.setTypeface(typeface1);
            textView2.setTypeface(typeface2);

            textView1.setTextSize(16);
            textView2.setTextSize(16);



        }

    }



}
