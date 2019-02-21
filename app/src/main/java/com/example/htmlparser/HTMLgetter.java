package com.example.htmlparser;

import android.os.AsyncTask;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class HTMLgetter extends AsyncTask<Void, Void, Void>{
    String url;
    Document page;

    public HTMLgetter() {
        this.url = "https://github.com/it-school?tab=repositories";
        this.page = null;
    }
    public HTMLgetter(String url) {
        this.url = url;
        this.page = null;
    }
    @Override
    protected void onPreExecute(){super.onPreExecute();}

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            page =  Jsoup.parse(new URL(url),5000);
        } catch (IOException ex){
            ex.printStackTrace();
        }
 /*       try {

            page =  Jsoup.connect(url).get();
        } catch (IOException ex){
            ex.printStackTrace();
        }
*/
//           Log.d("", page.title());
        return null;
    }

    @Override
    protected void onPostExecute(Void result){
        MainActivity.showNews();
    }
}
