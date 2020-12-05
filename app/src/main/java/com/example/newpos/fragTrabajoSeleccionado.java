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

import com.bumptech.glide.Glide;

public class fragTrabajoSeleccionado extends Fragment  {
job unJob;
    EditText txtUno,txtCuatro;
    EditText txtDos,txtTres;
    SeekBar skr;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.trabajo_seleccionado_intelectual, container, false);
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        unJob=actPrincipal.enviarEmpleo();
        Log.d("fragEditItemIntelectual","Recibi el item: "+unJob.get_jobCompany()+"-"+unJob.get_jobName());
        TextView txtPrincipal = VistaADevolver.findViewById(R.id.txtTitulo);
        TextView txtSecundario = VistaADevolver.findViewById(R.id.txtSecundario);
        TextView txt3 = VistaADevolver.findViewById(R.id.txtTres);
        TextView txt4 = VistaADevolver.findViewById(R.id.txtCuatro);
        TextView txt5 = VistaADevolver.findViewById(R.id.txtCinco);
        TextView txt6 = VistaADevolver.findViewById(R.id.txtSeis);
        TextView txt7 = VistaADevolver.findViewById(R.id.txtSiete);


        txtPrincipal.setText(unJob.get_jobCompany());
        txtSecundario.setText(unJob.get_jobName());
        txt3.setText(unJob.get_jobRequired());
        txt4.setText(unJob.get_jobCity());
        txt5.setText(unJob.get_jobAdress());
        txt6.setText(unJob.get_jobDays());
        txt7.setText(unJob.get_jobTime());
        return VistaADevolver;
    }
}
