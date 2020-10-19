package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class fragVerPerfil extends Fragment  {

    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.ver_perfil, container, false);
        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        //Muestro popUp
        actPrincipal.mostrarPopUp();
        return VistaADevolver;
    }
}
