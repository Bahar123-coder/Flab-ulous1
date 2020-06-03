package com.example.flab_ulous.report;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil {
    public static Dialog createDialog(Context context, String title, String message, String positiveButton, DialogInterface.OnClickListener positiveClickListener, String negativeButton, DialogInterface.OnClickListener negativeClickListener) {
        if (context == null) return null;
        AlertDialog.Builder alertDialogBuilder = getAlertDialogBuilder(context, title, message);
        alertDialogBuilder.setPositiveButton(positiveButton, positiveClickListener);
        alertDialogBuilder.setNegativeButton(negativeButton, negativeClickListener);
        return alertDialogBuilder.create();
    }

    private static AlertDialog.Builder getAlertDialogBuilder(Context context, String title, String message) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(message);
        return alertBuilder;
    }
}
