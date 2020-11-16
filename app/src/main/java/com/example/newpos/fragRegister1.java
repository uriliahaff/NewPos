package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class fragRegister1 extends Fragment  {
int j; int w;
User usuarioRegistro;
    EditText edt;
    String password1,password2;
    //onCreateView
Button btn;
    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver=null;
        usuarioRegistro=new User();
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        j=actPrincipal.obtenerConfigActual();
          w=actPrincipal.devolverFragment();
        if(j==1){
            VistaADevolver=inflador.inflate(R.layout.register_1, container, false);
            int i=actPrincipal.devolverFragment();
        //If para ver si llegue a la ultima parte
        if(i==19) {
        btn = VistaADevolver.findViewById(R.id.btn2);
        String sTitulo = getString(R.string.Sign_Up);
        btn.setText(sTitulo);
        }
         actPrincipal.mostrarPopUp();
        }
        if(j==2){
            VistaADevolver=inflador.inflate(R.layout.register_1_intelectual, container, false);
            actPrincipal.mostrarPopUp();

            if (w<9){
                Button btn= VistaADevolver.findViewById(R.id.bLog);
                btn.setVisibility(View.GONE);
            }
        }
    Button btnContinue=VistaADevolver.findViewById(R.id.bLogIn);
        Button btnOmitir=VistaADevolver.findViewById(R.id.bLog);
        final View finalVistaADevolver = VistaADevolver;
        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(w==19){
                    actPrincipal.home();
                    actPrincipal.mostarNavBar();
                }
                //Normalmente
                else if(w!=16){
                    Log.d("Fragment","Llegue");
                    w++;
                     edt = finalVistaADevolver.findViewById(R.id.editText);
                }
                //Fragment de si tiene o no registro
                else {
                actPrincipal.registro2();
                }
                if(w==4){
                    usuarioRegistro.set_userName(edt.getText().toString());
                    actPrincipal.continuarRegistro();
                }
                if(w==5){
                    usuarioRegistro.set_userLastName(edt.getText().toString());
                    actPrincipal.continuarRegistro();
                }
                if(w==6){
                    usuarioRegistro.set_userEmail(edt.getText().toString());
                    actPrincipal.continuarRegistro();
                }
                if(w==7){
                    password1= edt.getText().toString();
                    actPrincipal.continuarRegistro();
                }
                if(w==8){
                    password2= edt.getText().toString();
                    if(password1==password2){
                        usuarioRegistro.set_userPassword(edt.getText().toString());
                        actPrincipal.continuarRegistro();
                    }
                }
                if(w==9){
                    usuarioRegistro.set_userName(edt.getText().toString());
                    actPrincipal.continuarRegistro();
                }
                if(w==10){
                    usuarioRegistro.set_userName(edt.getText().toString());
                    actPrincipal.continuarRegistro();
                }
                actPrincipal.mostrarPopUp();
                if (w>=9){
                    Button btn= finalVistaADevolver.findViewById(R.id.bLog);
                    btn.setVisibility(View.VISIBLE);
                }
            }

        });

        btnOmitir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actPrincipal.omitirIngreso();
            }
        });

        return VistaADevolver;
    }
}
