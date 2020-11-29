package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.hbb20.CountryCodePicker;

public class fragVerPerfil extends Fragment  {
int i;
User usuario;
    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        i=actPrincipal.obtenerConfigActual();
        View VistaADevolver=null;
         usuario=actPrincipal.enviarUsuario();

        if (i == 1) {
        VistaADevolver=inflador.inflate(R.layout.ver_perfil, container, false);
        actPrincipal.mostrarPopUp();



        }


        if(i==2){
            VistaADevolver=inflador.inflate(R.layout.editar_usuario, container, false);
            final EditText name =VistaADevolver.findViewById(R.id.editName);
            name.setText(usuario.get_userName());
            final EditText apellido =VistaADevolver.findViewById(R.id.editApellido);
            apellido.setText(usuario.get_userLastName());
            final EditText fecha =VistaADevolver.findViewById(R.id.editDate);
            fecha.setText(usuario.get_userBirthDate());
            final CountryCodePicker nacionalidad =VistaADevolver.findViewById(R.id.ccp);
            nacionalidad.setCountryForNameCode(usuario.get_userNationality());
            final CountryCodePicker ccpRecidence =VistaADevolver.findViewById(R.id.ccpRecidence);
            ccpRecidence.setCountryForNameCode(usuario.get_userResidenceCountry());

            final EditText province =VistaADevolver.findViewById(R.id.editEstado);
            province.setText(usuario.get_userProvince());
            final EditText adress =VistaADevolver.findViewById(R.id.editDireccion);
            adress.setText(usuario.get_userAdrees());
            final CountryCodePicker celular =VistaADevolver.findViewById(R.id.ccpcelular);
            final EditText eCelular =VistaADevolver.findViewById(R.id.editCelular);
            celular.registerCarrierNumberEditText(eCelular);
            celular.setCountryForNameCode(usuario.get_userResidenceCountry());

            eCelular.setText(usuario.get_userPhoneNumber());
            final  EditText telefono =VistaADevolver.findViewById(R.id.editTelefono);
            telefono.setText(usuario.get_userTelephoneNumber());
            final EditText descripcion =VistaADevolver.findViewById(R.id.editAcerca);
            descripcion.setText(usuario.get_userDescription());

            Button btn= VistaADevolver.findViewById(R.id.bSave);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                User usuarioEditado=new User();
                usuarioEditado.set_userName(name.getText().toString());
                usuarioEditado.set_userLastName(apellido.getText().toString());
                usuarioEditado.set_userBirthDate(fecha.getText().toString());
                usuarioEditado.set_userNationality(nacionalidad.getSelectedCountryNameCode());
                usuarioEditado.set_userResidenceCountry(ccpRecidence.getSelectedCountryNameCode());
                usuarioEditado.set_userProvince(province.getText().toString());
                usuarioEditado.set_userAdrees(adress.getText().toString());
                usuarioEditado.set_userPhoneNumber(eCelular.getText().toString());
                usuarioEditado.set_userTelephoneNumber(telefono.getText().toString());
                usuarioEditado.set_userDescription(descripcion.getText().toString());
                actPrincipal.enviarUsuarioEditar(usuarioEditado);

                }
            });
        }
        //Muestro popUp
        return VistaADevolver;
    }
}
