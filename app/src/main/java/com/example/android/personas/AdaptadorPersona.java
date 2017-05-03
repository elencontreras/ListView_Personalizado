package com.example.android.personas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 02/05/2017.
 */
//Puente entre codigo y la personalización del listview
public class AdaptadorPersona extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> personas;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas){
        this.contexto=contexto;
        this.personas=personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar Variables
        TextView nombre, apellido,edad;
        ImageView foto;
        LayoutInflater inflater; //permite modificar la forma como por defecto se hacen las cosas
        View itemView; //La forma que va a retornar por cada elemento

        //Uso del Inflater

        inflater=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //permisos para modificar la info a mostrar
        itemView=inflater.inflate(R.layout.item_persona,null);

        //Captura de los objetos

        nombre=(TextView)itemView.findViewById(R.id.txtNombrePersona);
        apellido=(TextView)itemView.findViewById(R.id.txtApellidoPersona);
        edad=(TextView)itemView.findViewById(R.id.txtEdadPersona);
        foto=(ImageView)itemView.findViewById(R.id.imgFoto);

        //Pasar información

        nombre.setText(personas.get(position).getNombre());
        apellido.setText(personas.get(position).getApellido());
        edad.setText(personas.get(position).getEdad());
        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));

        //Retornar ItemView
        return itemView;

    }
}
