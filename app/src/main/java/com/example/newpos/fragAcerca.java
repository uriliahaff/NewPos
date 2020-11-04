package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class fragAcerca extends Fragment  {
int i;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver=null;
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        //Muestro popUp
        i = actPrincipal.obtenerConfigActual();
        if (i == 1) {
            VistaADevolver = inflador.inflate(R.layout.acerca, container, false);
            actPrincipal.mostrarPopUp();
        }
        if (i == 2) {
            VistaADevolver = inflador.inflate(R.layout.acerca_intelectual, container, false);
            LinearLayout ln = VistaADevolver.findViewById(R.id.signOut);
            ln.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.d("itemEditar","Se pulso");
                    actPrincipal.LogOut(null);
                }
            });
        }
        return VistaADevolver;
    }
}
