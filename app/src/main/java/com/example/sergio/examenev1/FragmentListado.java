package com.example.sergio.examenev1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FragmentListado extends Fragment {

    //TODO cambiar por otras más adelante si hay tiempo
    private Localidad[] localidads = {
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
            new Localidad("Añana","aniana_salinas","157","21,92","www.aniana.com"),
    };

    private ListView lstListado;
    private LocalidadesListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);

        lstListado = (ListView) getView().findViewById(R.id.lst_listado);
        lstListado.setAdapter(new AdaptadorLocalidades(this));
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (listener != null){
                    Localidad l = (Localidad) lstListado.getAdapter().getItem(pos);
                    String web = l.getWeb();
                    //TODO llamar a la web
                    Log.i("log","llamar a la web");
                }
            }
        });
    }

    class AdaptadorLocalidades extends ArrayAdapter<Localidad> {
        Activity context;

        AdaptadorLocalidades(Fragment context) {
            super(context.getActivity(), R.layout.listitem_localidad, localidads);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_localidad,null);

            TextView txt_idLocalidad = (TextView) item.findViewById(R.id.txt_idLocalidad);
            TextView txt_poblacion = (TextView) item.findViewById(R.id.txt_poblacion);
            TextView txt_superficie = (TextView) item.findViewById(R.id.txt_superficie);
            TextView txt_web = (TextView) item.findViewById(R.id.txt_web);
            ImageView img = (ImageView) item.findViewById(R.id.img);

            txt_idLocalidad.setText(localidads[position].getIdLocalidad());
            txt_poblacion.setText(localidads[position].getHabitantes());
            txt_superficie.setText(localidads[position].getSuperficie());
            txt_web.setText(localidads[position].getWeb());
            //TODO falta la imagen.jpg

            return item;
        }
    }

    public interface LocalidadesListener{
        void onLocalidadSeleccinada(Localidad l);
    }

    public void setLocalidadListener(LocalidadesListener listener){
        this.listener = listener;
    }
}

