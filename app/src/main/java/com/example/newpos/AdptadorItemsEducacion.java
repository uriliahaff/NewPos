package com.example.newpos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class AdptadorItemsEducacion  extends BaseAdapter {
    private ArrayList<itemCV> _MiLista;
    private Context contexto;
    int interna;
    public AdptadorItemsEducacion (ArrayList<itemCV> Lista, Context context ){
        _MiLista=Lista;
        contexto=context;
        interna=0;
        Log.d("getView",getCount()+" ");
    }
    public int getCount(){ return _MiLista.size(); }

    public itemCV getItem(int Pos){
        itemCV unItem=_MiLista.get(Pos);
        return unItem;
    }

    public long getItemId (int PosicionAObtener){
        return PosicionAObtener;
    }

    public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual){

        View vistaADevolver=null;

        LayoutInflater InfladorDeLayouts=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vistaADevolver=InfladorDeLayouts.inflate(R.layout.item_educacion,GrupoActual,false);

        return vistaADevolver;
    }

}
