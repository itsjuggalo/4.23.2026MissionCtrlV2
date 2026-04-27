package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.InterfaceC0409l;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0446y implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f5293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5294c;

    public /* synthetic */ DialogInterfaceOnClickListenerC0446y(Intent intent, Object obj, int i) {
        this.f5292a = i;
        this.f5293b = intent;
        this.f5294c = obj;
    }

    public final void a() {
        switch (this.f5292a) {
            case 0:
                Intent intent = this.f5293b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f5294c).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f5293b;
                if (intent2 != null) {
                    ((InterfaceC0409l) this.f5294c).startActivityForResult(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
