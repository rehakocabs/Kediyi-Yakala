package com.rk.kediyiyakala;

import android.content.Context;
import android.view.ContextThemeWrapper;

import androidx.appcompat.app.AlertDialog;

public class UyariDialog {

        //theme.xml dosyasından alerDialog methodunun özelliklerini çekiyor.
        //AlertDiaglog Arka Plan Rengi. vs.
    public static AlertDialog.Builder alertBuilder(Context context) {
        return new AlertDialog.Builder(new ContextThemeWrapper(context,
                R.style.ShowAlertDialogTheme));
    }
}
