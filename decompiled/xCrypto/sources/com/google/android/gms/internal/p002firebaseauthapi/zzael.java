package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import z1.C1989g;

/* JADX INFO: loaded from: classes.dex */
public final class zzael {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int iH = C1989g.f().h(context, 12451000);
            zza = Boolean.valueOf(iH == 0 || iH == 2);
        }
        return zza.booleanValue();
    }
}
