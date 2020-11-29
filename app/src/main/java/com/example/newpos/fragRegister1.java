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

import androidx.annotation.Nullable;

import com.hbb20.CCPCountry;
import com.hbb20.CountryCodePicker;

public class fragRegister1 extends Fragment  {
int j; int w;
User usuarioRegistro;
    EditText edt;
    ImageView icon,iconsi,iconno,iconSubir;
    CountryCodePicker ccp;
    String password1,password2;
    //onCreateView
Button btn,btnSi,btnNo, btnSubir;
    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver=null;
        usuarioRegistro=new User();
        final MainActivity actPrincipal;
        actPrincipal=(MainActivity) getActivity();
        j=actPrincipal.obtenerConfigActual();
          w=actPrincipal.devolverFragment();
        if(j==1){
            VistaADevolver=inflador.inflate(R.layout.register_1, container, false);
            final Button btnContinue= VistaADevolver.findViewById(R.id.btnC);
            final View finalVistaADevolver1 = VistaADevolver;
            iconSubir=VistaADevolver.findViewById(R.id.iconSubir);
            btnSi=VistaADevolver.findViewById(R.id.bLogSi);
            btnNo=VistaADevolver.findViewById(R.id.bLogNo);

            btnContinue.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(w==20){
                        usuarioRegistro.set_userDescription(edt.getText().toString());
                        actPrincipal.irRegistro(usuarioRegistro);
                        edt.setText("");
                    }
                    else {
                        w++;
                        edt = finalVistaADevolver1.findViewById(R.id.editText);
                        ccp = finalVistaADevolver1.findViewById(R.id.ccp);

                        if(w==5){
                            usuarioRegistro.set_userName(edt.getText().toString());
                            edt.setText("");
                        }
                        if(w==6){
                            usuarioRegistro.set_userLastName(edt.getText().toString());
                            edt.setText("");
                        }
                        if(w==7){
                            usuarioRegistro.set_userEmail(edt.getText().toString());
                            edt.setText("");
                        }
                        if(w==8){
                            password1= edt.getText().toString();
                            edt.setText("");
                        }
                        if(w==9){
                            password2= edt.getText().toString();
                            if(password1.equals(password2)){
                                usuarioRegistro.set_userPassword(edt.getText().toString());
                                edt.setText("");
                            }
                            else {actPrincipal.atras();}
                        }
                        if(w==10){
                            usuarioRegistro.set_userBirthDate(edt.getText().toString());
                            edt.setText("");
                            edt.setVisibility(View.GONE);
                            ccp.setVisibility(View.VISIBLE);
                        }
                        if(w==11){
                            usuarioRegistro.set_userNationality(ccp.getSelectedCountryNameCode());
                        }
                        if(w==12){
                            usuarioRegistro.set_userResidenceCountry(ccp.getSelectedCountryNameCode());
                            edt.setVisibility(View.VISIBLE);
                            ccp.setVisibility(View.GONE);
                        }
                        if(w==13){
                            usuarioRegistro.set_userProvince(edt.getText().toString());
                            edt.setText("");
                            actPrincipal.continuarRegistro();
                            w++;
                        }
                        if(w==15){
                            usuarioRegistro.set_userAdrees(edt.getText().toString());
                            edt.setText("");
                        }
                        if(w==16){
                            usuarioRegistro.set_userPhoneNumber(edt.getText().toString());
                            edt.setText("");
                        }
                        if(w==17){
                            usuarioRegistro.set_userTelephoneNumber(edt.getText().toString());
                            edt.setText("");
                            btnSi.setVisibility(View.VISIBLE);
                            btnNo.setVisibility(View.VISIBLE);
                            btnContinue.setVisibility(View.GONE);
                            edt.setVisibility(View.GONE);
                        }

                        if(w==18){
                            btnSi.setVisibility(View.GONE);
                            btnNo.setVisibility(View.GONE);
                            btnContinue.setVisibility(View.VISIBLE);
                            btnSubir.setVisibility(View.GONE);
                            edt.setVisibility(View.VISIBLE);
                            iconSubir.setVisibility(View.GONE);

                        }

                        if(w==19){
                            usuarioRegistro.set_userDescription(edt.getText().toString());
                            actPrincipal.irRegistro(usuarioRegistro);
                            edt.setText("");
                        }

                        actPrincipal.mostrarPopUp();
                        actPrincipal.continuarRegistro();
                    }

                }
            });

            btnNo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.d("registro","No");
                    btnSi.setVisibility(View.GONE);
                    btnNo.setVisibility(View.GONE);
                    btnContinue.setVisibility(View.VISIBLE);
                    edt.setVisibility(View.VISIBLE);
                    actPrincipal.continuarRegistro();
                    actPrincipal.mostrarPopUp();
                    btnContinue.setText("Registrarse");
                    w=18;
                    actPrincipal.mostrarPopUp();
                    actPrincipal.continuarRegistro();
                }
            });

            btnSi.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.d("registro","Si");
                    btnSi.setVisibility(View.GONE);
                    btnNo.setVisibility(View.GONE);
                    btnContinue.setVisibility(View.VISIBLE);
                    edt.setVisibility(View.GONE);
                    btnSubir.setVisibility(View.VISIBLE);
                    iconSubir.setVisibility(View.VISIBLE);
                    actPrincipal.mostrarPopUp();
                    actPrincipal.continuarRegistro();
                    w=17;
                }
            });

         actPrincipal.mostrarPopUp();
        }
        if(j==2){
            VistaADevolver=inflador.inflate(R.layout.register_1_intelectual, container, false);
            actPrincipal.mostrarPopUp();

            if (w<9) {
                Button btn = VistaADevolver.findViewById(R.id.bLog);
                btn.setVisibility(View.GONE);
            }
        final Button btnContinue=VistaADevolver.findViewById(R.id.bLogIn);
        Button btnOmitir=VistaADevolver.findViewById(R.id.bLog);
        btnSi=VistaADevolver.findViewById(R.id.bLogSi);
        btnNo=VistaADevolver.findViewById(R.id.bLogNo);
        btnSubir=VistaADevolver.findViewById(R.id.bSubirArchivo);
        iconSubir=VistaADevolver.findViewById(R.id.iconSubir);
        icon=VistaADevolver.findViewById(R.id.icon);
        iconsi=VistaADevolver.findViewById(R.id.iconSi);
        iconno=VistaADevolver.findViewById(R.id.iconNo);

        final View finalVistaADevolver = VistaADevolver;
        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(w==20){
                    usuarioRegistro.set_userDescription(edt.getText().toString());
                    actPrincipal.irRegistro(usuarioRegistro);
                    edt.setText("");
                }
                else {

                w++;
                edt = finalVistaADevolver.findViewById(R.id.editText);
                ccp = finalVistaADevolver.findViewById(R.id.ccp);

                if(w==5){
                    usuarioRegistro.set_userName(edt.getText().toString());
                    edt.setText("");
                }
                if(w==6){
                    usuarioRegistro.set_userLastName(edt.getText().toString());
                    edt.setText("");
                }
                if(w==7){
                    usuarioRegistro.set_userEmail(edt.getText().toString());
                    edt.setText("");
                }
                if(w==8){
                    password1= edt.getText().toString();
                    edt.setText("");
                }
                if(w==9){
                    password2= edt.getText().toString();
                    if(password1.equals(password2)){
                        usuarioRegistro.set_userPassword(edt.getText().toString());
                        edt.setText("");
                    }
                    else {actPrincipal.atras();}
                }
                if(w==10){
                    usuarioRegistro.set_userBirthDate(edt.getText().toString());
                    edt.setText("");
                    edt.setVisibility(View.GONE);
                    ccp.setVisibility(View.VISIBLE);
                }
                if(w==11){
                    usuarioRegistro.set_userNationality(ccp.getSelectedCountryNameCode());
                }
                if(w==12){
                    usuarioRegistro.set_userResidenceCountry(ccp.getSelectedCountryNameCode());
                    edt.setVisibility(View.VISIBLE);
                    ccp.setVisibility(View.GONE);
                }
                if(w==13){
                    usuarioRegistro.set_userProvince(edt.getText().toString());
                    edt.setText("");
                    actPrincipal.continuarRegistro();
                    w++;
                }
                if(w==15){
                    usuarioRegistro.set_userAdrees(edt.getText().toString());
                    edt.setText("");
                }
                if(w==16){
                    usuarioRegistro.set_userPhoneNumber(edt.getText().toString());
                    edt.setText("");
                }
                if(w==17){
                    usuarioRegistro.set_userTelephoneNumber(edt.getText().toString());
                    edt.setText("");
                    btnSi.setVisibility(View.VISIBLE);
                    btnNo.setVisibility(View.VISIBLE);
                    btnContinue.setVisibility(View.GONE);
                    icon.setVisibility(View.GONE);
                    iconsi.setVisibility(View.VISIBLE);
                    iconno.setVisibility(View.VISIBLE);
                    edt.setVisibility(View.GONE);
                }

                    if(w==18){
                        btnSi.setVisibility(View.GONE);
                        btnNo.setVisibility(View.GONE);
                        btnContinue.setVisibility(View.VISIBLE);
                        icon.setVisibility(View.VISIBLE);
                        iconsi.setVisibility(View.GONE);
                        btnSubir.setVisibility(View.GONE);
                        iconSubir.setVisibility(View.GONE);
                        iconno.setVisibility(View.GONE);
                        edt.setVisibility(View.VISIBLE);

                    }

                if(w==19){
                    usuarioRegistro.set_userDescription(edt.getText().toString());
                    actPrincipal.irRegistro(usuarioRegistro);
                    edt.setText("");
                }
                if (w>=9){
                    Button btn= finalVistaADevolver.findViewById(R.id.bLog);
                    btn.setVisibility(View.VISIBLE);
                }
                    actPrincipal.mostrarPopUp();
                    actPrincipal.continuarRegistro();
            }

            }
        });

        btnOmitir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actPrincipal.irRegistro(usuarioRegistro);
            }
        });

        btnSi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            Log.d("registro","Si");
                btnSi.setVisibility(View.GONE);
                btnNo.setVisibility(View.GONE);
                btnContinue.setVisibility(View.VISIBLE);
                icon.setVisibility(View.VISIBLE);
                iconsi.setVisibility(View.GONE);
                iconno.setVisibility(View.GONE);
                edt.setVisibility(View.GONE);
            btnSubir.setVisibility(View.VISIBLE);
            iconSubir.setVisibility(View.VISIBLE);
                actPrincipal.mostrarPopUp();
                actPrincipal.continuarRegistro();
                w=17;
            }
        });

        btnSubir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("registro","No");
                btnSi.setVisibility(View.GONE);
                btnNo.setVisibility(View.GONE);
                btnContinue.setVisibility(View.VISIBLE);
                icon.setVisibility(View.VISIBLE);
                iconsi.setVisibility(View.GONE);
                iconno.setVisibility(View.GONE);
                edt.setVisibility(View.VISIBLE);
                actPrincipal.continuarRegistro();
                actPrincipal.mostrarPopUp();
                btnContinue.setText("Registrarse");
w=18;
actPrincipal.mostrarPopUp();
                actPrincipal.continuarRegistro();
            }
        });

        }

        return VistaADevolver;
    }

}
