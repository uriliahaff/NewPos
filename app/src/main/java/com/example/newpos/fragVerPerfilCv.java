package com.example.newpos;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.api.Distribution;

import java.util.ArrayList;

public class fragVerPerfilCv extends Fragment  {
    int i;
    LinearLayout layoutEducation;
    LinearLayout layoutExperiencia;
    LinearLayout layoutSkills;
    LinearLayout layoutIdiomas;
    ArrayList<itemCV> arrayListEducacion;
    ArrayList<itemCV> arrayListExperiencia;
    ArrayList<itemCV> arrayListSkills;
    ArrayList<itemCV> arrayListIdioma;
    ImageView flecha;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        i=actPrincipal.obtenerConfigActual();
        View VistaADevolver=null;
        if (i == 1) {
            VistaADevolver=inflador.inflate(R.layout.ver_perfil_cv, container, false);        //Muestro popUp
            actPrincipal.mostrarPopUp();
        }
        if (i == 2) {
            VistaADevolver=inflador.inflate(R.layout.ver_perfil_cv_intelectual, container, false);

            User usuario=actPrincipal.enviarUsuario();

            TextView txtName=VistaADevolver.findViewById(R.id.textViewNombre);
            String nombre= usuario.get_userName()+" "+usuario.get_userLastName();
            txtName.setText(nombre);

            arrayListEducacion=actPrincipal.obtenerListaEducacion();
            arrayListExperiencia=actPrincipal.obtenerListaExperiencia();
            arrayListSkills=actPrincipal.obtenerListaSkills();
            arrayListIdioma=actPrincipal.obtenerListaIdioma();
            layoutEducation=VistaADevolver.findViewById(R.id.layoutEducacion);
            layoutExperiencia=VistaADevolver.findViewById(R.id.layoutExperiencia);
            layoutSkills=VistaADevolver.findViewById(R.id.layoutSkills);
            layoutIdiomas=VistaADevolver.findViewById(R.id.layoutIdioma);
            if (arrayListEducacion.size()!=0){
                for(int i=0;i<arrayListEducacion.size();i++){
                    View child_1 = getLayoutInflater().inflate(R.layout.item_educacion, null);
                    TextView txtSecundario=child_1.findViewById(R.id.Secundario);
                    itemCV item=arrayListEducacion.get(i);
                    TextView txtTitulo=child_1.findViewById(R.id.Principal);
                    txtTitulo.setText(item.get_itemCVTittle()+" / "+item.get_itemCVStart()+"-"+item.get_itemCVEnd());
                    txtSecundario.setText(item.get_itemCVSubTittle());
                    layoutEducation.addView(child_1);
                }
            }
            if (arrayListExperiencia.size()!=0) {
                    for (int i = 0; i < arrayListExperiencia.size(); i++) {
                        View child_1 = getLayoutInflater().inflate(R.layout.item_educacion, null);
                        TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                        itemCV item = arrayListExperiencia.get(i);
                        TextView txtTitulo = child_1.findViewById(R.id.Principal);
                        txtTitulo.setText(item.get_itemCVTittle() + " / " + item.get_itemCVStart() + "-" + item.get_itemCVEnd());
                        txtSecundario.setText(item.get_itemCVSubTittle());
                        layoutExperiencia.addView(child_1);
                }
            }
            if (arrayListSkills.size()!=0){
                for (int i = 0; i < arrayListSkills.size(); i++) {
                    View child_1 = getLayoutInflater().inflate(R.layout.item_skills, null);
                    itemCV item = arrayListSkills.get(i);
                    LinearLayout n1=child_1.findViewById(R.id.b1);n1.setVisibility(View.GONE);
                    LinearLayout n2=child_1.findViewById(R.id.b2);n2.setVisibility(View.GONE);
                    LinearLayout n3=child_1.findViewById(R.id.b3);n3.setVisibility(View.GONE);
                    LinearLayout n4=child_1.findViewById(R.id.b4);n4.setVisibility(View.GONE);
                    LinearLayout n5=child_1.findViewById(R.id.b5);n5.setVisibility(View.GONE);
                    LinearLayout n6=child_1.findViewById(R.id.b6);n6.setVisibility(View.GONE);
                    LinearLayout n7=child_1.findViewById(R.id.b7);n7.setVisibility(View.GONE);
                    LinearLayout n8=child_1.findViewById(R.id.b8);n8.setVisibility(View.GONE);
                    LinearLayout n9=child_1.findViewById(R.id.b9);n9.setVisibility(View.GONE);
                    LinearLayout n10=child_1.findViewById(R.id.b10);n10.setVisibility(View.GONE);
                switch (item.get_itemCVHabilidad()){

                        case "1":
                            n1.setVisibility(View.VISIBLE);
                            break;
                        case "2":
                            n2.setVisibility(View.VISIBLE);
                            break;
                        case "3":
                            n3.setVisibility(View.VISIBLE);
                            break;
                        case "4":
                            n4.setVisibility(View.VISIBLE);
                            break;
                        case "5":
                            n5.setVisibility(View.VISIBLE);
                            break;
                        case "6":
                            n6.setVisibility(View.VISIBLE);
                            break;
                        case "7":
                            n7.setVisibility(View.VISIBLE);
                            break;
                        case "8":
                            n8.setVisibility(View.VISIBLE);
                            break;
                        case "9":
                            n9.setVisibility(View.VISIBLE);
                            break;
                        case "10":
                            n10.setVisibility(View.VISIBLE);
                            break;
                    }
                    TextView txtTitulo = child_1.findViewById(R.id.Principal);
                    txtTitulo.setText(item.get_itemCVTittle());
                    layoutSkills.addView(child_1);
                }
            }
            if (arrayListIdioma.size()!=0){
                for (int i = 0; i < arrayListIdioma.size(); i++) {
                    View child_1 = getLayoutInflater().inflate(R.layout.item_idioma, null);
                    TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                    itemCV item = arrayListIdioma.get(i);
                    TextView txtTitulo = child_1.findViewById(R.id.Principal);
                    txtTitulo.setText(item.get_itemCVTittle());
                    txtSecundario.setText("( "+item.get_itemCVHabilidad()+" )");
                    layoutIdiomas.addView(child_1);
                }
            }
        }
        return VistaADevolver;
    }
}

