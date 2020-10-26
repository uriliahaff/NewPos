package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class fragLogin2 extends Fragment  {
    Button btn;
    EditText editText;
    String password;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.sign_up_password, container, false);
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        //Muestro popUp
        actPrincipal.mostrarPopUp();
        btn=VistaADevolver.findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("itemEditar","Se pulso");
                editText=VistaADevolver.findViewById(R.id.editText);
                password=editText.getText().toString();
                actPrincipal.enviarPassword(password);
            }
        });
        return VistaADevolver;
    }
}
