package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class fragVerPerfil extends Fragment  {
int i;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        i=actPrincipal.obtenerConfigActual();
        View VistaADevolver=null;
        if (i == 1) {
        VistaADevolver=inflador.inflate(R.layout.ver_perfil, container, false);
            actPrincipal.mostrarPopUp();
        }
        if(i==2){
            VistaADevolver=inflador.inflate(R.layout.editar_usuario, container, false);
        }
        //Muestro popUp
        return VistaADevolver;
    }
}
