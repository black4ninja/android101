package com.brounie.Capacitacion.Parse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brounie.Capacitacion.Models.ImageItem;
import com.brounie.Capacitacion.R;
import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * Created by Toshiba on 7/01/14.
 */
public class ParseAdapter extends ArrayAdapter<ParseObject> {
    Context context;
    int layoutResourceId;
    ParseObject data[];

    public ParseAdapter(Context context, int layoutResourceId, ArrayList<ParseObject> data) {
        super(context, layoutResourceId, data.toArray(new ParseObject[data.size()]));
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data.toArray(new ParseObject[data.size()]);
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
            holder.nombre = (TextView)row.findViewById(R.id.parse_pais);
            holder.numero = (TextView)row.findViewById(R.id.parse_codigo);

            row.setTag(holder);

        }
        else
        {
            holder = (GenericListHolder) row.getTag();
        }

        final ParseObject objeto = data[position];

        holder.nombre.setText(objeto.getString("Nombre"));
        holder.numero.setText(objeto.getString("Numero"));

        return row;
    }

    static class GenericListHolder
    {
        TextView nombre;
        TextView numero;
    }
}