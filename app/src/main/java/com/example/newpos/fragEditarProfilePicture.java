package com.example.newpos;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class fragEditarProfilePicture extends Fragment  {
    int i;
    //onCreateView
    CircleImageView profileImage;
     MainActivity actPrincipal;
     Bitmap bp,foto;

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        actPrincipal = (MainActivity) getActivity();
        i = actPrincipal.obtenerConfigActual();
        User usuario = actPrincipal.enviarUsuario();
        View VistaADevolver = null;
        if (i == 2) {
            VistaADevolver = inflador.inflate(R.layout.editar_profile_picture, container, false);        //Muestro popUp
            ImageView flecha = actPrincipal.findViewById(R.id.flecha);
            flecha.setVisibility(View.VISIBLE);

        }
        if (i == 3) {
            ImageView flecha = actPrincipal.findViewById(R.id.flecha);
            flecha.setVisibility(View.VISIBLE);

            VistaADevolver = inflador.inflate(R.layout.home_intelectual, container, false);
        }
        boolean fotoEditadaNueva = actPrincipal.enviarSiSeCambio();
        profileImage = VistaADevolver.findViewById(R.id.profile_image);

        if (fotoEditadaNueva == true) {
            Log.d("fotoEditadaNueva","Hay imagen nueva");

            foto= actPrincipal.traerImagenSeleccionada();
            profileImage.setImageBitmap(foto);
            actPrincipal.changeEstadoEdit();
        }

        else {

            Log.d("fotoEditadaNueva","No hay imagen nueva");

            foto = actPrincipal.traerImagenDePerfil();
            if (foto == null) {
                descargarFoto miTarea=new descargarFoto();
                miTarea.execute(usuario.get_userProfilePicture());
            } else {
                profileImage.setImageBitmap(foto);
            }
        }

        Button btnGuardar= VistaADevolver.findViewById(R.id.bSave);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actPrincipal.editarImagen(foto);

            }
        });

        return VistaADevolver;

    }
    private class descargarFoto extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... Ruta) {
            Bitmap imagenConvertida=null;
            try {
                URL miRuta= new URL(Ruta[0]);
                HttpURLConnection conexionURL=(HttpURLConnection) miRuta.openConnection();
                if (conexionURL.getResponseCode()==200){
                    InputStream cuerpoDatos=conexionURL.getInputStream();
                    BufferedInputStream lectorEntrada=new BufferedInputStream(cuerpoDatos);
                    imagenConvertida= BitmapFactory.decodeStream(lectorEntrada);
                    conexionURL.disconnect();
                }
            }catch (Exception error){
                Log.d("Descarga","Error: "+error);
            }
            return imagenConvertida;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap!=null){
                profileImage.setImageBitmap(bitmap);
                bp=bitmap;

                enviar();
            }else {
                profileImage.setImageResource(R.drawable.profilepicture);
            }
        }


        public void enviar(){
            actPrincipal.recibirProfile(bp);
        }


    }

}
