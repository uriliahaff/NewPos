package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class fragHome extends Fragment  {
    int i;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        i=actPrincipal.obtenerConfigActual();
        View VistaADevolver=null;
        if (i == 1) {
            VistaADevolver=inflador.inflate(R.layout.home, container, false);        //Muestro popUp
            actPrincipal.mostrarPopUp();

        }
        if (i == 2) {
            ImageView flecha=actPrincipal.findViewById(R.id.flecha);flecha.setVisibility(View.GONE);

            VistaADevolver=inflador.inflate(R.layout.home_intelectual, container, false);
        }
        return VistaADevolver;
    }
}
