package com.brounie.Capacitacion.Listas;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import com.actionbarsherlock.app.SherlockActivity;
import com.brounie.Capacitacion.Capacitacion;
import com.brounie.Capacitacion.Models.ImageItem;
import com.brounie.Capacitacion.Models.ListGenerator;
import com.brounie.Capacitacion.R;

import java.util.ArrayList;

/**
 * Created by Toshiba on 5/01/14.
 */
public class DemoListView extends SherlockActivity {
    private Capacitacion app;
    private Context context = this;
    private ListView list;
    private DemoAdapter adapter;
    private ArrayList<String> data;
    private EditText searchField;
    private ArrayList<String> dataSearched;

    /*GriView*/
    private GridView gridView;
    private DemoGridAdapter customGridAdapter;
    private ArrayList<ImageItem> dataGrid;


    /*Layouts*/
    private LinearLayout list_layout, grid_layout;
    private Button list_button, grid_button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_demo_listview);


        app =(Capacitacion) getApplication();

        list = (ListView) findViewById(R.id.list);

        data = ListGenerator.getCountryList();

        adapter = new DemoAdapter(context, R.layout.list_demo_listview_item, data);

        list.setAdapter(adapter);

        searchField = (EditText) findViewById(R.id.list_search);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dataSearched = new ArrayList<String>();

                if(data != null){
                    for (int i = 0; i <data.size() ; i++) {
                        String temp = data.get(i);
                        if(temp.contains(s)){
                            dataSearched.add(temp);
                        }
                    }

                    if(dataSearched.size() > 0){
                        adapter = new DemoAdapter(context, R.layout.list_demo_listview_item, dataSearched);
                        list.setAdapter(adapter);
                    }else{
                        adapter = new DemoAdapter(context, R.layout.list_demo_listview_item, data);
                        list.setAdapter(adapter);
                    }

                }
            }
        });


        /*Grid*/
        dataGrid = ListGenerator.getImages();

        gridView = (GridView) findViewById(R.id.grid);

        customGridAdapter = new DemoGridAdapter(this, R.layout.list_demo_griview_item, dataGrid, app);
        gridView.setAdapter(customGridAdapter);


        /*Lists*/
        list_layout = (LinearLayout) findViewById(R.id.layout_list);
        grid_layout = (LinearLayout) findViewById(R.id.layout_grid);
        list_button = (Button) findViewById(R.id.btn_to_grid);
        grid_button = (Button) findViewById(R.id.btn_to_list);

        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_layout.setVisibility(View.GONE);
                grid_layout.setVisibility(View.VISIBLE);
            }
        });

        grid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_layout.setVisibility(View.VISIBLE);
                grid_layout.setVisibility(View.GONE);
            }
        });
    }
}
