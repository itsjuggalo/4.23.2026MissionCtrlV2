package com.revenuecat.purchases.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAlertDialogHelper implements AlertDialogHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(Function0 onPositiveButtonClicked, DialogInterface dialogInterface, int i4) {
        r.f(onPositiveButtonClicked, "$onPositiveButtonClicked");
        dialogInterface.dismiss();
        onPositiveButtonClicked.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(Function0 onNegativeButtonClicked, DialogInterface dialogInterface, int i4) {
        r.f(onNegativeButtonClicked, "$onNegativeButtonClicked");
        dialogInterface.dismiss();
        onNegativeButtonClicked.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(Function0 onNeutralButtonClicked, DialogInterface dialogInterface, int i4) {
        r.f(onNeutralButtonClicked, "$onNeutralButtonClicked");
        dialogInterface.dismiss();
        onNeutralButtonClicked.invoke();
    }

    @Override // com.revenuecat.purchases.utils.AlertDialogHelper
    public void showDialog(Activity activity, String title, String message, String positiveButtonText, String negativeButtonText, String neutralButtonText, final Function0 onPositiveButtonClicked, final Function0 onNegativeButtonClicked, final Function0 onNeutralButtonClicked) {
        r.f(activity, "activity");
        r.f(title, "title");
        r.f(message, "message");
        r.f(positiveButtonText, "positiveButtonText");
        r.f(negativeButtonText, "negativeButtonText");
        r.f(neutralButtonText, "neutralButtonText");
        r.f(onPositiveButtonClicked, "onPositiveButtonClicked");
        r.f(onNegativeButtonClicked, "onNegativeButtonClicked");
        r.f(onNeutralButtonClicked, "onNeutralButtonClicked");
        new AlertDialog.Builder(activity).setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DefaultAlertDialogHelper.showDialog$lambda$0(onPositiveButtonClicked, dialogInterface, i4);
            }
        }).setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DefaultAlertDialogHelper.showDialog$lambda$1(onNegativeButtonClicked, dialogInterface, i4);
            }
        }).setNeutralButton(neutralButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DefaultAlertDialogHelper.showDialog$lambda$2(onNeutralButtonClicked, dialogInterface, i4);
            }
        }).show();
    }
}
