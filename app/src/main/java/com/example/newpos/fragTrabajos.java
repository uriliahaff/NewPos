package com.example.newpos;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class fragTrabajos extends Fragment  {
    int i;
    View VistaADevolver;
    LinearLayout empleosLayout;
    ArrayList<job> arrayListJobs;
    ImageView logo;
    Bitmap logoBP;
    int posicion;
    ArrayList<View> arrayEmpleos;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final MainActivity actPrincipal;
        actPrincipal = (MainActivity) getActivity();
        i=actPrincipal.obtenerConfigActual();
        arrayEmpleos=new ArrayList<>();
        VistaADevolver=null;
        if (i == 1) {

        }
        if (i == 2) {
            VistaADevolver=inflador.inflate(R.layout.trabajos_intelectual, container, false);
            arrayListJobs=actPrincipal.obtenerListaEmpleos();
            empleosLayout=VistaADevolver.findViewById(R.id.layoutTrabajos);
            if (arrayListJobs.size()!=0){
                for(int i=0;i<arrayListJobs.size();i++){
                    job unJob=arrayListJobs.get(i);
                    View child_1 = getLayoutInflater().inflate(R.layout.item_trabajo, null);
                    TextView txtSecundario=child_1.findViewById(R.id.Secundario);
                    TextView txtTitulo=child_1.findViewById(R.id.Principal);
                    TextView txtPath=child_1.findViewById(R.id.txtPath);
                    txtTitulo.setText(unJob.get_jobCompany());
                    txtSecundario.setText(unJob.get_jobName());
                    final String path=unJob.get_documentPath();
                    txtPath.setText(path);
                    child_1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Log.d("itemEditar","Se pulso");
                            actPrincipal.recibirEmpleo(path);
                        }
                    });
                    empleosLayout.addView(child_1);
                }
            }
            else {

            }

}

        return VistaADevolver;
    }



}

