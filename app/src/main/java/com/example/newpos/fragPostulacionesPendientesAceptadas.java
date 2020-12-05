package com.example.newpos;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class fragPostulacionesPendientesAceptadas extends Fragment  {
int i;
LinearLayout aceptadasLayout, deniedLayout;
LinearLayout requestLayout,texto,barrita;
boolean denied;
ArrayList<postulation> listPostulations,list1,list2,list0;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        listPostulations = null;list0=new ArrayList<>();list1=new ArrayList<>();list2=new ArrayList<>();
        denied = false;
        final MainActivity actPrincipal;
        actPrincipal = (MainActivity) getActivity();
        i = actPrincipal.obtenerConfigActual();
        listPostulations = actPrincipal.traerPostulaciones();
        VistaADevolver = null;
        if (i == 1) {
            VistaADevolver = inflador.inflate(R.layout.postulaciones_pendientes_aceptadas, container, false);
            actPrincipal.mostrarPopUp();
        }
        if (i == 2) {
            VistaADevolver = inflador.inflate(R.layout.postulaciones_intelectual, container, false);
            aceptadasLayout = VistaADevolver.findViewById(R.id.layoutAcceptPostulations);
            requestLayout = VistaADevolver.findViewById(R.id.layoutRquestPostulations);
            deniedLayout = VistaADevolver.findViewById(R.id.layoutDeniedPostulations);
            for (int i = 0; i < listPostulations.size(); i++) {
                postulation unPostulation = listPostulations.get(i);
                String aux = unPostulation.get_postulationStatus();
                if (aux == null) {

                } else {
                    if (aux.equals("0")) {
                        list0.add(unPostulation);
                    } else if (aux.equals("1")) {
                        list1.add(unPostulation);
                    } else if (aux.equals("2")) {
                        list2.add(unPostulation);
                    }
                }
            }
            if (list0.size() == 0) {
                View child_1 = getLayoutInflater().inflate(R.layout.no_postulation, null);
                TextView txtTitulo = child_1.findViewById(R.id.Principal);
                TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                txtTitulo.setText(getString(R.string.Sorry));
                txtSecundario.setText(getString(R.string.SorryPostulaciones1));
                requestLayout.addView(child_1);

            } else {
                for (int i = 0; i < list0.size(); i++) {
                    postulation unPostulation = list0.get(i);
                View child_1 = getLayoutInflater().inflate(R.layout.item_postulaciones, null);
                TextView txtTitulo = child_1.findViewById(R.id.Principal);
                TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                ImageView img= child_1.findViewById(R.id.imgCompany);

                if (unPostulation.get_logo()!=null) {
                        Glide.with(this).load(unPostulation.get_logo()).into(img);

                }
                TextView txtPath = child_1.findViewById(R.id.txtPath);
                txtTitulo.setText(unPostulation.get_jobCompany());
                txtSecundario.setText(unPostulation.get_jobName());
                final String path = unPostulation.get_documentPath();
                txtPath.setText(path);
                child_1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.d("itemEditar", "Se pulso");
                        actPrincipal.recibirPostulaciones(path);
                    }
                });
                    requestLayout.addView(child_1);
            }
        }
            if (list1.size() == 0) {
                View child_1 = getLayoutInflater().inflate(R.layout.no_postulation, null);
                TextView txtTitulo = child_1.findViewById(R.id.Principal);
                TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                txtTitulo.setText(getString(R.string.Sorry));
                txtSecundario.setText(getString(R.string.SorryPostulaciones));
                aceptadasLayout.addView(child_1);
            } else {
                for (int i = 0; i < list1.size(); i++) {
                    postulation unPostulation = list1.get(i);
                    View child_1 = getLayoutInflater().inflate(R.layout.item_postulaciones, null);
                    TextView txtTitulo = child_1.findViewById(R.id.Principal);
                    TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                    TextView txtPath = child_1.findViewById(R.id.txtPath);
                    txtTitulo.setText(unPostulation.get_jobCompany());
                    txtSecundario.setText(unPostulation.get_jobName());
                    final String path = unPostulation.get_documentPath();
                    ImageView img= child_1.findViewById(R.id.imgCompany);

                    if (unPostulation.get_logo()!=null) {
                        Glide.with(this).load(unPostulation.get_logo()).into(img);

                    }

                    txtPath.setText(path);
                    child_1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Log.d("itemEditar", "Se pulso");
                            actPrincipal.recibirPostulaciones(path);
                        }
                    });
                    aceptadasLayout.addView(child_1);
                }
            }
            if (list2.size() == 0) {

            } else {
                for (int i = 0; i < list2.size(); i++) {
                    postulation unPostulation = list2.get(i);
                    View child_1 = getLayoutInflater().inflate(R.layout.item_postulaciones, null);
                    TextView txtTitulo = child_1.findViewById(R.id.Principal);
                    TextView txtSecundario = child_1.findViewById(R.id.Secundario);
                    TextView txtPath = child_1.findViewById(R.id.txtPath);
                    txtTitulo.setText(unPostulation.get_jobCompany());
                    txtSecundario.setText(unPostulation.get_jobName());
                    final String path = unPostulation.get_documentPath();
                    txtPath.setText(path);
                    ImageView img= child_1.findViewById(R.id.imgCompany);

                    if (unPostulation.get_logo()!=null) {
                        Glide.with(this).load(unPostulation.get_logo()).into(img);

                    }


                    child_1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Log.d("itemEditar", "Se pulso");
                            actPrincipal.recibirPostulaciones(path);
                        }
                    });
                    if (denied == false) {
                        denied = true;
                        texto = VistaADevolver.findViewById(R.id.texto);
                        texto.setVisibility(View.VISIBLE);
                        barrita = VistaADevolver.findViewById(R.id.Barra);
                        barrita.setVisibility(View.VISIBLE);
                    }
                    deniedLayout.addView(child_1);                }
            }
    }
        return VistaADevolver;
    }
}
