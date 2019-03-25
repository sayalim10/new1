package com.devn.delivery.screens.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.devn.delivery.R;
import com.devn.delivery.screens.collection.OrderCollection;
import com.devn.delivery.screens.returnprocess.dinner.ReturnVenderDinnerScreen;

public class Authentication  extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_screen);

        button = (Button) findViewById(R.id.id_login_screen_login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home ();
            }
        });
    }

    public void home(){
        Intent intent = new Intent(this,  OrderCollection.class);
        startActivity(intent);

    }

}
