package com.example.newpos;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class fragSettings extends Fragment  {
int i;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver=null;
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        //Muestro popUp
        i = actPrincipal.obtenerConfigActual();
        if (i == 1) {
            VistaADevolver = inflador.inflate(R.layout.settings_visual, container, false);
            actPrincipal.mostrarPopUp();
        }
        if (i == 2) {
            VistaADevolver = inflador.inflate(R.layout.settings_intelectual, container, false);
            final Switch swtIntelectual = VistaADevolver.findViewById(R.id.switch2);
            final Switch swtVisual = VistaADevolver.findViewById(R.id.switch1);
            Switch swtDefault = VistaADevolver.findViewById(R.id.switch3);

            swtIntelectual.setChecked(true);
            swtIntelectual.setEnabled(false);

            swtVisual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                    if(swtVisual.isChecked() == true){
                        builder.setTitle("Configuraciones");
                        builder.setMessage("Estas seguro de que sea cambiar la configuracion a 'Discapcidad intelectual'?");

                        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                actPrincipal.changeConfiguracionVisual();
                                dialog.dismiss();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                swtVisual.setChecked(false);
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                }
            });
        }
        return VistaADevolver;
    }
}
