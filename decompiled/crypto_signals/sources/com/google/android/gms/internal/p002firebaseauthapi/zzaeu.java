package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import u1.C1204f;

/* JADX INFO: loaded from: classes.dex */
public final class zzaeu {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int iC = C1204f.f10286b.c(context, 12451000);
            zza = Boolean.valueOf(iC == 0 || iC == 2);
        }
        return zza.booleanValue();
    }
}
