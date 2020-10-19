package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class fragPostulacionPulsada extends Fragment  {

    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver=null;
        MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        int auxiliar=actPrincipal.enviarAuxiliarPostulacion();
        Log.d("fragPostulacionPulsada",auxiliar+"");
        postulation unJob = actPrincipal.enviarPostulacionItem();
        Log.d("fragPostulacionPulsada",unJob.get_jobTime()+"");
        if(auxiliar==0){
            VistaADevolver=inflador.inflate(R.layout.postulacion_pendiente_intelectual, container, false);
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
        }
        else if(auxiliar==1){
            VistaADevolver=inflador.inflate(R.layout.postulacion_aceptada_intelectual, container, false);
            TextView txtPrincipal = VistaADevolver.findViewById(R.id.txtTitulo);
            TextView txtPrincipal1 = VistaADevolver.findViewById(R.id.txtTitulo1);
            TextView txtSecundario = VistaADevolver.findViewById(R.id.txtSecundario);
            TextView txtSecundario1 = VistaADevolver.findViewById(R.id.txtSecundario1);
            TextView texto1 = VistaADevolver.findViewById(R.id.txtTexto);
            TextView texto2 = VistaADevolver.findViewById(R.id.txtTexto1);
            TextView mail1 = VistaADevolver.findViewById(R.id.txtMail);
            TextView mail2 = VistaADevolver.findViewById(R.id.txtMail1);
            TextView txt3 = VistaADevolver.findViewById(R.id.txtTres);
            TextView txt4 = VistaADevolver.findViewById(R.id.txtCuatro);
            TextView txt5 = VistaADevolver.findViewById(R.id.txtCinco);
            TextView txt6 = VistaADevolver.findViewById(R.id.txtSeis);
            TextView txt7 = VistaADevolver.findViewById(R.id.txtSiete);
            txtPrincipal.setText(unJob.get_jobCompany());
            txtPrincipal1.setText(unJob.get_jobCompany());
            txtSecundario.setText(unJob.get_jobName());
            txtSecundario1.setText(unJob.get_jobName());
            txt3.setText(unJob.get_jobRequired());
            txt4.setText(unJob.get_jobCity());
            txt5.setText(unJob.get_jobAdress());
            txt6.setText(unJob.get_jobDays());
            txt7.setText(unJob.get_jobTime());
            texto1.setText("El mensaje de "+unJob.get_jobCompany()+" es:");
            texto2.setText('"'+unJob.get_companyMensaje()+'"');
            mail1.setText("El mail de "+unJob.get_jobCompany()+" es:");
            mail2.setText(unJob.get_companyMail());
        }
        else if(auxiliar==2){
            VistaADevolver=inflador.inflate(R.layout.postulacion_noaceptada_intelectual, container, false);
            TextView txtSecundario = VistaADevolver.findViewById(R.id.Secundario);
            txtSecundario.setText(getString(R.string.PostulationRechazada1) + " " + unJob.get_jobCompany() + " " + getString(R.string.PostulationRechazada2));
        }

        return VistaADevolver;
    }
}
