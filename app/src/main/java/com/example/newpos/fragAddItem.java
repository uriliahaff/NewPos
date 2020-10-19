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
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.protobuf.StringValue;

public class fragAddItem extends Fragment {

    //onCreateView
    Button btn;
    EditText editText;
    public int i;
    View VistaADevolver;
    int config;
    MainActivity actPrincipal;
    String item;
    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        actPrincipal = (MainActivity) getActivity();
        config = actPrincipal.obtenerConfigActual();
        if (config == 1) {
            VistaADevolver = inflador.inflate(R.layout.add_item_form, container, false);
            editText = VistaADevolver.findViewById(R.id.editText);
            btn = VistaADevolver.findViewById(R.id.btn2);
            i = actPrincipal.devolverFragment();
            Log.d("fragment",i+"");
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (i == 30) {
                        String titulo = editText.getText().toString();
                        actPrincipal.ObtenerTitulo(titulo);
                    }
                    if (i == 301) {
                        String titulo = editText.getText().toString();
                        actPrincipal.ObtenerTitulo(titulo);
                    }
                    if (i == 302) {
                        String idioma = editText.getText().toString();
                        actPrincipal.ObtenerTitulo(idioma);
                    }
                    if (i == 32) {
                        String start = editText.getText().toString();
                        actPrincipal.ObtenerInicio(start);
                    }
                    if (i == 321) {
                        String start = editText.getText().toString();
                        actPrincipal.ObtenerNivelHabilidad(start);
                    }
                    if (i == 322) {
                        String habilidad = editText.getText().toString();
                        actPrincipal.ObtenerNivelHabilidad(habilidad);
                    }
                    if (i == 33) {
                        String end = editText.getText().toString();
                        actPrincipal.ObtenerFinal(end);
                    }
                    if (i == 34) {
                        String subtittle = editText.getText().toString();
                        actPrincipal.ObtenerSubtitulo(subtittle);
                    }
                    actPrincipal.addItemContinue();
                }
            });
            //If para ver si llegue a la ultima parte
            if (i == 3 || i == 321 || i == 322) {
                btn = VistaADevolver.findViewById(R.id.btn2);
                String sTitulo = getString(R.string.Add);
                btn.setText(sTitulo);
            }
            //Muestro popUp
            actPrincipal.mostrarPopUp();
        }
        if(config==2){
            item=actPrincipal.enviarTypeItem();
            if(item=="1"){
                VistaADevolver = inflador.inflate(R.layout.add_item_uno, container, false);
                TextView txt=VistaADevolver.findViewById(R.id.txtTitulo);
                txt.setText(getString(R.string.AddEstudios));
            }
            if(item=="2"){
                VistaADevolver = inflador.inflate(R.layout.add_item_uno, container, false);
                TextView txt=VistaADevolver.findViewById(R.id.txtTitulo);
                txt.setText(getString(R.string.AddExperience));
            }
            if(item=="3"){
                VistaADevolver = inflador.inflate(R.layout.add_item_dos, container, false);
                TextView txt=VistaADevolver.findViewById(R.id.txtTitulo);
                txt.setText(getString(R.string.AddSkill));
            }
            if(item=="4"){
                VistaADevolver = inflador.inflate(R.layout.add_item_tres, container, false);
                TextView txt=VistaADevolver.findViewById(R.id.txtTitulo);
                txt.setText(getString(R.string.AddIdioma));
            }
            if(item=="1"||item=="2"){
                Button btn=VistaADevolver.findViewById(R.id.bSave);
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.d("agregarItemIntelectual","Vamos a declarar");
                        EditText txtTitulo=VistaADevolver.findViewById(R.id.editUno);
                        EditText txtFechaInicio=VistaADevolver.findViewById(R.id.editDos);
                        EditText txtFechaFinal=VistaADevolver.findViewById(R.id.editTres);
                        EditText txtSubTitulo=VistaADevolver.findViewById(R.id.editCuatro);
                        actPrincipal.ObtenerTitulo(txtTitulo.getText().toString());
                        actPrincipal.ObtenerSubtitulo(txtSubTitulo.getText().toString());
                        actPrincipal.ObtenerInicio(txtFechaInicio.getText().toString());
                        actPrincipal.ObtenerFinal(txtFechaFinal.getText().toString());
                        Log.d("agregarItemIntelectual","Cargamos datos");
                        actPrincipal.subirItem();
                    }
                });
            }
            if(item=="3"){
                Button btn=VistaADevolver.findViewById(R.id.bSave);
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.d("agregarItemIntelectual","Vamos a declarar");
                        Log.d("agregarItemIntelectual","Vamos a declarar");
                        EditText txtTitulo=VistaADevolver.findViewById(R.id.editUno);
                        SeekBar sksHabilidad=VistaADevolver.findViewById(R.id.seekBar);
                        actPrincipal.ObtenerTitulo(txtTitulo.getText().toString());
                        actPrincipal.ObtenerNivelHabilidad((String.valueOf(sksHabilidad.getProgress())));
                        Log.d("agregarItemIntelectual","Cargamos datos");
                        actPrincipal.subirItem();
                    }
                });
            }
            if(item=="4"){
                Button btn=VistaADevolver.findViewById(R.id.bSave);
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.d("agregarItemIntelectual","Vamos a declarar");
                        EditText txtTitulo=VistaADevolver.findViewById(R.id.editUno);
                        EditText txtHabilidad=VistaADevolver.findViewById(R.id.editDos);
                        actPrincipal.ObtenerTitulo(txtTitulo.getText().toString());
                        actPrincipal.ObtenerNivelHabilidad(txtHabilidad.getText().toString());
                        Log.d("agregarItemIntelectual","Cargamos datos");
                        actPrincipal.subirItem();
                    }
                });
            }
            Button btnCancel=VistaADevolver.findViewById(R.id.bCancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    actPrincipal.cancelar();
                }
            });
        }
        return VistaADevolver;
    }
}