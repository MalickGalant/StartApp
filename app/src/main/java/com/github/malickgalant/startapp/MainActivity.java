package com.github.malickgalant.startapp;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewLink);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView tv2 = findViewById(R.id.textViewLink2);
        tv2.setMovementMethod(LinkMovementMethod.getInstance());

        String html2 = "<p>Hyperlink** on portal <a href=\"https://www.adball.online\" target=\"_blank\">Login</a> </p><p>Best<a href=\"https://github.com/MalickaGalant/StartApp\" target=\"_blank\">Guardians</a></p><p>Not hyperlink on portal https://www.adball.online</p><p>idem https://www.reddit.com</p>";
        TextView tv3 = findViewById(R.id.textViewLink3);
        tv3.setText(getHtml(html2));
        tv3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public Spanned getHtml(String html){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            return Html.fromHtml(html);
        }

        return Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT);
    }
}
