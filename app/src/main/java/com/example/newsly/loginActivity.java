package com.example.newsly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
TextView sign_text , f_text;
Button login_btn;
commonMethod commonMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign_text = findViewById(R.id.signin_text);
        login_btn = findViewById(R.id.login_btn);
       commonMethod= new commonMethod();
        String str_login ="Don\\'t have a account? Sign Up";
        SpannableString ss = new SpannableString(str_login);
        ForegroundColorSpan fcs_1 = new ForegroundColorSpan(Color.BLACK);
        ss.setSpan(fcs_1,str_login.length()-8,str_login.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://social-media-integra-1.flycricket.io/privacy.html")));

                commonMethod.intentActivity(loginActivity.this,signupActivity.class);;
            }
        };
        ss.setSpan(clickableSpan,str_login.length()-8,str_login.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sign_text.setText(ss);
        sign_text.setMovementMethod(LinkMovementMethod.getInstance());
        f_text = findViewById(R.id.f_password);
        String str_pass ="Forget Password?";
        SpannableString sp = new SpannableString(str_pass);
        ForegroundColorSpan fcsp = new ForegroundColorSpan(Color.BLACK);
        sp.setSpan(fcsp,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://social-media-integra-1.flycricket.io/privacy.html")));

                commonMethod.intentActivity(loginActivity.this,signupActivity.class);;
            }
        };
        sp.setSpan(clickableSpan1,0,str_pass.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        f_text.setText(sp);
        f_text.setMovementMethod(LinkMovementMethod.getInstance());

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod.intentActivity(loginActivity.this,homePage.class);;

            }
        });
    }
}