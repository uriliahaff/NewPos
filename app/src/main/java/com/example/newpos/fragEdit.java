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

public class fragEdit extends Fragment  {
    EditText editTxt;
    String s;
    Button btn;
    int pos;
    int fecha;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        s="";
        VistaADevolver=inflador.inflate(R.layout.edit, container, false);
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        //Muestro popUp
        actPrincipal.mostrarPopUp();
        editTxt=VistaADevolver.findViewById(R.id.editText);
        btn = VistaADevolver.findViewById(R.id.btn);
        pos=actPrincipal.devolerEditor();
        fecha=actPrincipal.enviarPosicionFecha();
        if(pos==1){
            s=actPrincipal.enviarTituloItemEditar();
        }
        else if (pos==2){
            if(fecha==0){
                s=actPrincipal.enviarPrimeraFechaItemEditar();
            }else if (fecha==1){
                s=actPrincipal.enviarSegundaFechaItemEditar();
            }
        }
        else if (pos==3){
            s=actPrincipal.enviarSubTituloItemEditar();
        }
        else if(pos==4){
            s=actPrincipal.enviarHabiliadItemEditar();

        }
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Log.d("onClick","Se apreto el boton para guardar");
                if(pos==1){
                    s=editTxt.getText().toString();
                    actPrincipal.enviarTituloEditar(s);
                }
                if(pos==2){
                    s=editTxt.getText().toString();
                    if(fecha==0){
                        actPrincipal.enviarPrimeraFecha(s);
                        Log.d("onClick","La primera fecha es: "+s);
                    }
                    else{
                        actPrincipal.enviarSegundaFecha(s);
                        Log.d("onClick","La segunda fecha es: "+s);
                    }

                }
                if(pos==3){
                    s=editTxt.getText().toString();
                    actPrincipal.enviarSubTituloEditar(s);
                }
                if(pos==4){
                    s=editTxt.getText().toString();
                    actPrincipal.enviarSubTituloEditar(s);
                }
                actPrincipal.saveEdit();
                if(pos==2){
                    if(fecha==0){
                        fecha++;
                        actPrincipal.modificarFechas();
                        if (fecha==1){
                            s=actPrincipal.enviarSegundaFechaItemEditar();
                            editTxt.setText(s);
                        }
                    }
                }
            }
        });
        editTxt.setText(s);

        return VistaADevolver;
    }
}
