package com.brounie.Capacitacion.Parse;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockActivity;
import com.brounie.Capacitacion.Capacitacion;
import com.brounie.Capacitacion.R;
import com.parse.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 5/01/14.
 */
public class DemoParse extends SherlockActivity {
    private Context context = this;
    private Capacitacion app;
    private ListView listView;
    private ArrayList<ParseObject> data;
    private ParseAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_demo);


        app = (Capacitacion) getApplication();

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        listView = (ListView) findViewById(R.id.list_parse);

        ParseQuery query = new ParseQuery("Paises");
        query.findInBackground(new FindCallback() {
            @Override
            public void done(List list, ParseException e) {
                if(e == null){
                    data = new ArrayList<ParseObject>();
                    for (int i = 0; i <list.size() ; i++) {
                        ParseObject temp = (ParseObject) list.get(i);
                        data.add(temp);
                    }
                    adapter = new ParseAdapter(context, R.layout.parse_demo_item, data);

                    listView.setAdapter(adapter);

                }

            }
        });

    }
}
