package com.google.android.gms.internal.p002firebaseauthapi;

import P1.C0653g;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzael {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int iH = C0653g.f().h(context, 12451000);
            zza = Boolean.valueOf(iH == 0 || iH == 2);
        }
        return zza.booleanValue();
    }
}
