package com.brounie.Capacitacion;

import android.os.Bundle;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created by Toshiba on 5/01/14.
 */
public class Demo3 extends SherlockActivity {
    private Capacitacion app;
    private TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_3);


        app =(Capacitacion) getApplication();

        text = (TextView) findViewById(R.id.demo3_text);
        text.setText(app.message);
    }
}
