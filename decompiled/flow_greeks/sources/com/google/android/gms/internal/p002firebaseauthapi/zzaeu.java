package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import m5.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaeu {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int iH = f.f().h(context, 12451000);
            zza = Boolean.valueOf(iH == 0 || iH == 2);
        }
        return zza.booleanValue();
    }
}
