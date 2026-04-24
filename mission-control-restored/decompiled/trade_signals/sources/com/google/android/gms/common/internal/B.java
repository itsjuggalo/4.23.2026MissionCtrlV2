package com.google.android.gms.common.internal;

import S1.InterfaceC0876h;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class B implements DialogInterface.OnClickListener {
    public static B b(Activity activity, Intent intent, int i8) {
        return new C1305z(intent, activity, i8);
    }

    public static B c(InterfaceC0876h interfaceC0876h, Intent intent, int i8) {
        return new A(intent, interfaceC0876h, 2);
    }

    public abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e8) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e8);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
