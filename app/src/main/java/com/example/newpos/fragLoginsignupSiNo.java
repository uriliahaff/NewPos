package com.example.newpos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class fragLoginsignupSiNo extends Fragment  {

    //onCreateView

    // "Atar" el fragment al layout correspondiente
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflador.inflate(R.layout.signup_login_sino, container, false);
        return VistaADevolver;
    }
}
