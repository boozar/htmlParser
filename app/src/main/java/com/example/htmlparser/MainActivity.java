package com.example.htmlparser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public static boolean state;
    static TextView textView;
    static HTMLgetter page;
    Button loadButton;

    static void showNews(){
        if(page.page != null){
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            textView.setMovementMethod(new ScrollingMovementMethod());

            Elements posts = page.page.getElementsByClass("col-12");
            String stringPost = "<ol>";
            for (Element post: posts){
                stringPost += "<li><a href='" + post.child(0).child(0).child(0).child(0).absUrl("href") + "'>" + post.child(0).child(0).child(0).child(0).text() + "</a></li>";
            }
            stringPost +="</ol>";
            textView.setText(Html.fromHtml(page.page.title() + "\n\n"+ stringPost));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton =findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        state = false;

    }

    public void parsePostClick(View view) {
        page = new HTMLgetter();
        Toast.makeText(getApplicationContext(),"Data load started", Toast.LENGTH_LONG).show();
        page.execute();
    }
}