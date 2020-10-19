package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class fragRegister1 extends Fragment  {

    //onCreateView
Button btn;
    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.register_1, container, false);
        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
       int i=actPrincipal.devolverFragment();
       //If para ver si llegue a la ultima parte
        if(i==19) {
            btn = VistaADevolver.findViewById(R.id.btn2);
            String sTitulo = getString(R.string.Sign_Up);
            btn.setText(sTitulo);
        }
        actPrincipal.mostrarPopUp();
        return VistaADevolver;
    }
}
