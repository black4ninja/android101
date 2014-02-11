package com.brounie.Capacitacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created by Toshiba on 5/01/14.
 */
public class Demo2 extends SherlockActivity {
    private TextView text;
    private Button button1;
    private Capacitacion app;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_2);

        String value = "";

        //Get Intent
        Intent intent = getIntent();
        if(intent != null){
            value = intent.getStringExtra("message");
        }

        app = (Capacitacion) getApplication();

        text = (TextView) findViewById(R.id.demo2_textview);
        button1 = (Button) findViewById(R.id.demo2_button1);


        text.setText(value);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.message = "Hola llegue a Demo 3";

                Intent myIntent = new Intent(Demo2.this, Demo3.class);
                Demo2.this.startActivity(myIntent);
            }
        });
    }
}
