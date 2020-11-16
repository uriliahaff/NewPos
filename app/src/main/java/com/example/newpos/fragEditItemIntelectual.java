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

public class fragEditItemIntelectual extends Fragment  {
itemCV itemEditar;
    EditText txtUno,txtCuatro;
    EditText txtDos,txtTres;
    SeekBar skr;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        itemEditar=actPrincipal.enviarItemEditarIntelectual();
        Log.d("fragEditItemIntelectual","Recibi el item: "+itemEditar.get_itemCVTittle()+"-"+itemEditar.get_itemCVTypeId());
        View VistaADevolver=null;
        if(itemEditar.get_itemCVTypeId().equals("1")||itemEditar.get_itemCVTypeId().equals("2")){
            VistaADevolver=inflador.inflate(R.layout.editar_item_intelectual_uno, container, false);
            txtUno=VistaADevolver.findViewById(R.id.editUno);
            txtDos=VistaADevolver.findViewById(R.id.editDos);
            txtTres=VistaADevolver.findViewById(R.id.editTres);
            txtCuatro=VistaADevolver.findViewById(R.id.editCuatro);
            txtUno.setText(itemEditar.get_itemCVTittle());
            txtDos.setText(itemEditar.get_itemCVStart());
            txtTres.setText(itemEditar.get_itemCVEnd());
            txtCuatro.setText(itemEditar.get_itemCVSubTittle());
        }
        if(itemEditar.get_itemCVTypeId().equals("3")){
            VistaADevolver=inflador.inflate(R.layout.editar_item_intelectual_dos, container, false);
            txtUno=VistaADevolver.findViewById(R.id.editUno);
            skr=VistaADevolver.findViewById(R.id.seekBar);
            txtUno.setText(itemEditar.get_itemCVTittle());
            skr.setProgress(Integer.parseInt(itemEditar.get_itemCVHabilidad()));
        }
        if(itemEditar.get_itemCVTypeId().equals("4")) {
            VistaADevolver = inflador.inflate(R.layout.editar_item_intelectual_tres, container, false);
            txtUno = VistaADevolver.findViewById(R.id.editUno);
            txtDos = VistaADevolver.findViewById(R.id.editDos);
            txtUno.setText(itemEditar.get_itemCVTittle());
            txtDos.setText(itemEditar.get_itemCVHabilidad());
        }
        Button btn=VistaADevolver.findViewById(R.id.bSave);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("itemEditar","Vamo a ir a editar");
                itemCV unItem=new itemCV();
                unItem.set_itemCVTypeId(itemEditar.get_itemCVTypeId());
                unItem.set_itemCVTittle(txtUno.getText().toString());
                unItem.set_documentPath(itemEditar.get_documentPath());
                if(itemEditar.get_itemCVTypeId().equals("1")||itemEditar.get_itemCVTypeId().equals("2")){
                    unItem.set_itemCVStart(txtDos.getText().toString());
                    unItem.set_itemCVEnd(txtTres.getText().toString());
                    unItem.set_itemCVSubTittle(txtCuatro.getText().toString());
                }
                if(itemEditar.get_itemCVTypeId().equals("3")){
            unItem.set_itemCVHabilidad(String.valueOf(skr.getProgress()));
                }
                if(itemEditar.get_itemCVTypeId().equals("4")) {
                    unItem.set_itemCVHabilidad(txtDos.getText().toString());
                }
            actPrincipal.editarItemIntelectual(unItem);
            }
        });
        Button btnCancel = VistaADevolver.findViewById(R.id.bCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actPrincipal.cancelar();
            }
        });
        ImageView delete=VistaADevolver.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actPrincipal.eliminar(itemEditar.get_documentPath());
            }
        });
        return VistaADevolver;
    }
}
