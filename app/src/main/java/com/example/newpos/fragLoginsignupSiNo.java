package com.example.newpos;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class fragLoginsignupSiNo extends Fragment  {
int i;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=null;
        final MainActivity actPrincipal;
        actPrincipal = (MainActivity) getActivity();
        i = actPrincipal.obtenerConfigActual();
        if (i == 1) {
            VistaADevolver=inflador.inflate(R.layout.signup_login_sino, container, false);
            //Muestro popUp
            actPrincipal.mostrarPopUp();

        }
        if (i == 2) {
            VistaADevolver=inflador.inflate(R.layout.sing_in_intelectual, container, false);
            Button btnLogIn= VistaADevolver.findViewById(R.id.bLogIn);
            final EditText edtMail= VistaADevolver.findViewById(R.id.editTextMail);
            final EditText edtPassword= VistaADevolver.findViewById(R.id.editTextPassword);
            final View finalVistaADevolver = VistaADevolver;
            btnLogIn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.d("itemEditar","Se pulso");
                    String mail,password;
                    mail=edtMail.getText().toString();
                    password=edtPassword.getText().toString();
                    actPrincipal.enviarMail(mail);
                    actPrincipal.enviarPassword(password);
                }

            });
        }

        //Muestro popUp
        return VistaADevolver;
    }
}
