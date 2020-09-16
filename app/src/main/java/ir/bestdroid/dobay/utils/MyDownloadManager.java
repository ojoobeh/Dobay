package ir.bestdroid.dobay.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyDownloadManager {

    private final Context context;
    private final String downloadUrl;
    private final String filePath;
    private boolean openFolderAfterDownload;
    private AfterDownload afterDownload;
    private boolean showProgresbar = true;
    private String title = "";
    private String fileName = "";
    private String fileName2 = "";
    private String filename = "";
    private boolean setCancelable = false;
    private boolean openFolderDown = false;

    private ProgressDialog dialog;

    boolean OpenFolderAfterDownload = false;

    InputStream input;
    OutputStream output;

    public MyDownloadManager(Context context,
                             String downloadUrl,
                             String filePath,
                             AfterDownload afterDownload) {
        this.context = context;
        this.downloadUrl = downloadUrl;
        this.filePath = filePath;
        this.afterDownload = afterDownload;

        new Downloads().execute(downloadUrl);
        A.L("Download From", downloadUrl);
    }
 public MyDownloadManager(Context context,
                             String downloadUrl,
                             String filePath,
                             boolean showProgresbar,
                             AfterDownload afterDownload) {
        this.context = context;
        this.downloadUrl = downloadUrl;
        this.filePath = filePath;
        this.afterDownload = afterDownload;

        this.showProgresbar=showProgresbar;

        new Downloads().execute(downloadUrl);
        A.L("Download From", downloadUrl);
    }


    public class Downloads extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setProgress(0);
            dialog.setMax(100);


            if (title.isEmpty()) {

                dialog.setMessage("در حال دریافت .منتظر بمانید...");

            }

            dialog.setIndeterminate(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setCancelable(setCancelable);
            A.L("showProgresbar", showProgresbar);


            fileName2 = "";

            if (fileName.isEmpty()) {

                String tt = downloadUrl.replace("%20"," ");
                A.L("tt", tt);
                fileName2 = downloadUrl.substring(tt.lastIndexOf("/") + 1).replace("%20"," ");
            } else {
                fileName2 = fileName;

            }


            final File file = new File(filePath, fileName2);
            dialog.setButton("انصراف", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    try {

                        if (output != null) {
                            output.close();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    A.L("FileName", file.toString());
                    file.delete();
                    cancel(true);


                }
            });

            if (showProgresbar) {

                dialog.show();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            try {
                url = new URL(strings[0]);

                URLConnection conection = url.openConnection();
                conection.connect();
                int lenghtOfFile = conection.getContentLength();

                input = new BufferedInputStream(url.openStream(), 8 * 1024);

                filename = "";

                if (fileName.isEmpty()) {

                    String tt = downloadUrl;
                    filename = downloadUrl.substring(tt.lastIndexOf("/") + 1).replace("%20", " ");
                    A.L("tt", filename);
                } else {
                    filename = fileName;

                }
                File outPotFile = new File(filePath, filename);


                if (!outPotFile.getParentFile().exists()) {

                    outPotFile.getParentFile().mkdirs();

                }

                if (outPotFile.exists()) {

                    String ext = filename.contains(".") ?

                            filename.substring(0, filename.lastIndexOf(".") + 1) :
                            "";

                    String name = filename.contains(".") ?
                            filename.substring(0, filename.lastIndexOf(".")) :
                            filename;

                    outPotFile = new File(filePath, name + "-2" + ext);


                }


                output = new FileOutputStream(outPotFile);
                byte[] bufer = new byte[1024];
                int count = 0;

                int downloaded = 0;
                while ((count = input.read(bufer)) != -1) {

                    downloaded += count;
                    output.write(bufer, 0, count);

                    publishProgress(String.valueOf(downloaded * 100 / lenghtOfFile));


                }

                final File finalOutPotFile = outPotFile;

                output.flush();
                return outPotFile.getAbsolutePath();


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            dialog.setProgress(Integer.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {

                Toast.makeText(context, "دسترسی ب اینترنت  خود را بررسی کنید", Toast.LENGTH_SHORT).show();
                afterDownload.DownloadComplete(false);

            } else {

                afterDownload.DownloadComplete(true);

            }


            super.onPostExecute(s);
            if (dialog != null && dialog.isShowing()) {

                dialog.dismiss();
            }
        }
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }

    public void setCancelable(boolean cancelable) {

        this.setCancelable = cancelable;

    }

    public void openAfterDownload(boolean openFolder) {

        this.openFolderDown = openFolder;

    }

    public void setTitle(String title) {

        this.title = title;
    }

    public interface AfterDownload {
        void DownloadComplete(boolean isDownload);
    }


}