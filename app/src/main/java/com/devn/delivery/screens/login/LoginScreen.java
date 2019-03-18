package com.devn.delivery.screens.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.devn.delivery.R;
import butterknife.BindView;
import butterknife.OnTextChanged;

public class LoginScreen extends AppCompatActivity {
    private Button button;

    @BindView(R.id.id_login_screen_u_name_et)
    EditText uNameET;

    @BindView(R.id.id_login_screen_login_btn)
    Button loginBtn;

    @BindView(R.id.id_login_screen_userid_wrapper)
    TextInputLayout usernameWrapper;

    @OnTextChanged(R.id.id_login_screen_u_name_et)
    void onUserIDTextChanged() {
        usernameWrapper.setErrorEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        button = (Button) findViewById(R.id.id_login_screen_login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify ();
            }
        });
    }

    public void verify(){
        Intent intent = new Intent(this, Authentication.class);
        startActivity(intent);

    }


 //   private DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
 //      @Override
 //      public void onClick(DialogInterface dialog, int which) {
 //           LoginScreen.this.finish();
 //      }
 //  };

   // protected String actionbarTitle() {
   //     return this.TAG();
 //   }

 //   protected void onBackButtonPressed() {
    //    Alert.INSTANCE(LoginScreen.this).show(Alert.TYPE.OK_CANCEL, "Do you want to exit from application?", new String[]{"No", "Yes"}, yesListener);
   //      }

}
