package com.brounie.Capacitacion.Listas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brounie.Capacitacion.R;

import java.util.ArrayList;

/**
 * Created by Toshiba on 5/01/14.
 */
public class DemoAdapter  extends ArrayAdapter<String> {
    Context context;
    int layoutResourceId;
    String data[];

    public DemoAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
        super(context, layoutResourceId, data.toArray(new String[data.size()]));
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data.toArray(new String[data.size()]);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row = convertView;
        GenericListHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new GenericListHolder();
            holder.nombre = (TextView)row.findViewById(R.id.list_demo_title);


            row.setTag(holder);

        }
        else
        {
            holder = (GenericListHolder) row.getTag();
        }

        final String objeto = data[position];

        holder.nombre.setText(objeto);

        return row;
    }

    static class GenericListHolder
    {
        TextView nombre;
    }
}