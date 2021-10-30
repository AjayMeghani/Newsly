package com.example.newsly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signupActivity extends AppCompatActivity {
    ImageView google,facebook,twitter;
    LoginButton loginButton;
    TextView login_text,tc;
    Button signup_btn;
    commonMethod commonMethod;
    CallbackManager callbackManager;
    private FirebaseAuth mAuth;
   final static String TAG = "fblogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();


        google = findViewById(R.id.google_pic);
//        loginButton = findViewById(R.id.login_button);
        facebook = findViewById(R.id.facebook_pic);
        commonMethod = new commonMethod();
//        twitter = findViewById(R.id.twitter_pic);
//        String g_URl ="https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FGoogle%20Link.svg?alt=media&token=a0bbbf16-f1ba-467d-8e69-3f9f93c1e4e0";
//        String f_URl = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2Ffb.svg?alt=media&token=281c3080-13cf-418a-a2f4-ca7cbc2bfecb";
//        String t_URL = "https://firebasestorage.googleapis.com/v0/b/newsly-164bb.appspot.com/o/Newsly_Images%2FTwitter%20Link.svg?alt=media&token=bcda1b40-7c00-40e4-a6cf-044b8c75edc1";
//
//        GlideToVectorYou.justLoadImage(signupActivity.this, Uri.parse(g_URl), google);
//        GlideToVectorYou.justLoadImage(signupActivity.this, Uri.parse(f_URl), facebook);
//        GlideToVectorYou.justLoadImage(signupActivity.this, Uri.parse(t_URL), twitter);
        // Initialize Facebook Login button
//        callbackManager = CallbackManager.Factory.create();

//        loginButton.setReadPermissions("email", "public_profile");
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Log.d(TAG, "facebook:onSuccess:" + loginResult);
//                handleFacebookAccessToken(loginResult.getAccessToken());
//            }
//
//            @Override
//            public void onCancel() {
//                Log.d(TAG, "facebook:onCancel");
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Log.d(TAG, "facebook:onError", error);
//            }
//        });
//        facebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v==facebook){
//                    loginButton.performClick();
//
//
//                }
//            }
//        });
//        LoginManager.getInstance().logOut();

        login_text = findViewById(R.id.login_text);
        String str_login ="Already have a Account? Login.";
        SpannableString ss = new SpannableString(str_login);
        int color = getResources().getColor(R.color.black);
        ForegroundColorSpan fcs = new ForegroundColorSpan(color);
        ss.setSpan(fcs,24,29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://social-media-integra-1.flycricket.io/privacy.html")));

                commonMethod.intentActivity(signupActivity.this,loginActivity.class);;
            }
        };
        ss.setSpan(clickableSpan,24,29,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        login_text.setText(ss);
        login_text.setMovementMethod(LinkMovementMethod.getInstance());
//        ss.setSpan(fcs,64,82, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tc = findViewById(R.id.tc);
        String str_tc = "By Signing up agree to our T&C";
        SpannableString st = new SpannableString(str_tc);
        ForegroundColorSpan fcst = new ForegroundColorSpan(Color.BLACK);
        st.setSpan(fcst,str_tc.length()-3,str_login.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

            commonMethod.intentActivity(signupActivity.this,loginActivity.class);
            }
        };
        st.setSpan(clickableSpan1,str_tc.length()-3,str_login.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tc.setText(st);
        tc.setMovementMethod(LinkMovementMethod.getInstance());
        signup_btn = findViewById(R.id.login_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonMethod.intentActivity(signupActivity.this,loginActivity.class);
                Toast.makeText(signupActivity.this, "Sign in Done", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
        updateUI();
        }
        
    }
    private void updateUI(){
        Toast.makeText(this, "logged in", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI( );
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(signupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI( );
                        }
                    }
                });
    }

}