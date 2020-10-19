package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class fragPostulaciones extends Fragment  {
int i;
job unJob;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View VistaADevolver;
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        unJob=actPrincipal.enviarEmpleo();
        Log.d("fragEditItemIntelectual","Recibi el item: "+unJob.get_jobCompany()+"-"+unJob.get_jobName());
            i=actPrincipal.obtenerConfigActual();
            VistaADevolver=null;
            if (i == 1) {
                VistaADevolver=inflador.inflate(R.layout.postulacion, container, false);
                actPrincipal.mostrarPopUp();
            }
            if (i == 2) {
                VistaADevolver=inflador.inflate(R.layout.postulacion_pulsada, container, false);

                TextView txtSecundario = VistaADevolver.findViewById(R.id.Secundario);
                txtSecundario.setText(getString(R.string.Postulation1) + " " + unJob.get_jobCompany() + " " + getString(R.string.Postulation2));
            }
        return VistaADevolver;
    }
}
