package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class fragPopUp extends Fragment  {
    //onCreateView
    TextView titulo;
    TextView texto;
    String sTitulo;
    String sTexto;
    MainActivity actPrincipal;
    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.pop_up, container, false);
        actPrincipal=(MainActivity) getActivity();
        int num=actPrincipal.devolverFragment();
        Log.d("fragment",num+"");
        titulo=VistaADevolver.findViewById(R.id.tittle);
        texto=VistaADevolver.findViewById(R.id.text);
        //If para ver en que fragment estoy
        if(num==1){
            sTitulo=getString(R.string.Options);
            sTexto=getString(R.string.text1);
        }
        if(num==2){
            sTitulo=getString(R.string.Log_In);
            sTexto=getString(R.string.text2);
        }
        if(num==3){
            sTitulo=getString(R.string.Log_In);
            sTexto=getString(R.string.text3);
        }
        if(num==4){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text4);
        }
        if(num==5){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text5);
        }
        if(num==6){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text6);
        }
        if(num==7){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text15);
        }
        if(num==8){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text16);
        }
        if(num==9){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text7);
        }
        if(num==10){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text8);
        }
        if(num==11){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text9);
        }
        if(num==12){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text10);
        }
        if(num==14){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text12);
        }
        if(num==15){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text13);
        }
        if(num==16){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text14);
        }

        if(num==17){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text17);
        }
        if(num==18){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text18);
        }
        if(num==19){
            sTitulo=getString(R.string.Sign_Up);
            sTexto=getString(R.string.text19);
        }
        if(num==20){
            sTitulo=getString(R.string.Home);
            sTexto=getString(R.string.text20);
        }
        if(num==21){
            sTitulo=getString(R.string.My_Profile);
            sTexto=getString(R.string.text21);
        }
        if(num==22){
            sTitulo=getString(R.string.Profile);
            sTexto=getString(R.string.text22);
        }
        if(num==23){
            sTitulo=getString(R.string.CV);
            String items=actPrincipal.enviarCV();
            texto.setTextSize(8);
            sTexto=items+getString(R.string.text23);
        }

        if(num==24){
            sTitulo=getString(R.string.EditCV);
            sTexto=getString(R.string.text24);
        }
        if(num==25){
            sTitulo=getString(R.string.Education);
            texto.setTextSize(10);
            String item=actPrincipal.enviarTexto("1");
            sTexto=item+getString(R.string.text25);
        }
        if(num==26){
            sTitulo=getString(R.string.JobExperience);
            texto.setTextSize(10);
            String item=actPrincipal.enviarTexto("2");
            sTexto=item+getString(R.string.text25);
        }
        if(num==27){
            sTitulo=getString(R.string.Skills);
            texto.setTextSize(10);
            String item=actPrincipal.enviarTexto("3");
            sTexto=item+getString(R.string.text25);
        }
        if(num==28){
            sTitulo=getString(R.string.Language);
            texto.setTextSize(10);
            String item=actPrincipal.enviarTexto("4");
            sTexto=item+getString(R.string.text25);
        }
        if(num==29){
            sTitulo=getString(R.string.Edit);
            String item=actPrincipal.enviarItemEditar();
            sTexto=item+getString(R.string.text29);
        }
        if(num==291){
            sTitulo=getString(R.string.Edit);
            String item=actPrincipal.enviarItemEditar();
            sTexto=item+getString(R.string.text291);
        }
        if(num==292){
            sTitulo=getString(R.string.Edit);
            String item=actPrincipal.enviarItemEditar();
            sTexto=item+getString(R.string.text29);
        }
        if(num==293){
            sTitulo=getString(R.string.Edit);
            String item=actPrincipal.enviarItemEditar();
            sTexto=item+getString(R.string.text29);
        }
        if(num==30){
            sTitulo=getString(R.string.Name);
            sTexto=getString(R.string.text26);
        }
        if(num==301){
            sTitulo=getString(R.string.Tittle);
            sTexto=getString(R.string.text26);
        }
        if(num==302){
            sTitulo=getString(R.string.Tittle);
            sTexto=getString(R.string.text26);
        }
        if(num==31){
            sTitulo=getString(R.string.Edit)+" "+getString(R.string.Education);
            titulo.setTextSize(20);
            sTexto=getString(R.string.text31);
        }
        if(num==311){
            sTitulo=getString(R.string.Edit)+" "+getString(R.string.JobExperience);
            titulo.setTextSize(20);
            sTexto=getString(R.string.text31);
        }
        if(num==312){
            sTitulo=getString(R.string.Edit)+" "+getString(R.string.Skills);
            titulo.setTextSize(20);
            sTexto=getString(R.string.text31);
        }
        if(num==313){
            sTitulo=getString(R.string.Edit)+" "+getString(R.string.Language);
            titulo.setTextSize(20);
            sTexto=getString(R.string.text31);
        }
        if(num==32){
            sTitulo=getString(R.string.startDate);
            sTexto=getString(R.string.text26);
        }
        if(num==321){
            sTitulo=getString(R.string.Hability);
            sTexto=getString(R.string.text271);
        }
        if(num==322){
            sTitulo=getString(R.string.Language);
            sTexto=getString(R.string.text272);
        }
        if(num==33){
            sTitulo=getString(R.string.endDate);
            sTexto=getString(R.string.text26);
        }
        if(num==34){
            sTitulo=getString(R.string.Description);
            sTexto=getString(R.string.text27);
        }
        if(num==35){
            sTitulo=getString(R.string.Jobs);
            sTexto=getString(R.string.text32);
        }
        if(num==36){
            sTitulo=getString(R.string.Jobs);
            sTexto=getString(R.string.text33);
        }
        if(num==37){
            sTitulo=getString(R.string.Jobs);
            sTexto=getString(R.string.text34);
        }
        if(num==38){
            sTitulo=getString(R.string.Applications);
            sTexto=getString(R.string.text35);
        }
        if(num==39){
            sTitulo=getString(R.string.Applications);
            sTexto=getString(R.string.text36);
        }
        if(num==40){
            sTitulo=getString(R.string.Applications);
            sTexto=getString(R.string.text37);
        }
        if(num==41){
            sTitulo=getString(R.string.More);
            sTexto=getString(R.string.text38);
        }
        titulo.setText(sTitulo);
        texto.setText(sTexto);
        AccessibilityManager manager = (AccessibilityManager) getContext()
                .getSystemService(getContext().ACCESSIBILITY_SERVICE);
        if (manager.isEnabled()) {
            AccessibilityEvent e = AccessibilityEvent.obtain();
            e.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);
            e.setClassName(getClass().getName());
            e.setPackageName(getContext().getPackageName());
            e.getText().add(sTitulo);
            e.getText().add(sTexto);
            manager.sendAccessibilityEvent(e);
        }
        texto.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        return VistaADevolver;
    }
}
