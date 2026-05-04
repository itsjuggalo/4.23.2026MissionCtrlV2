package com.google.android.recaptcha.internal;

import android.os.Build;
import cd.w;
import dd.o0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjb {
    public static final Map zza() {
        Map mapN = o0.n(w.a(-4, zzba.zzo), w.a(-12, zzba.zzp), w.a(-6, zzba.zzk), w.a(-11, zzba.zzm), w.a(-13, zzba.zzq), w.a(-14, zzba.zzr), w.a(-2, zzba.zzl), w.a(-7, zzba.zzs), w.a(-5, zzba.zzt), w.a(-9, zzba.zzu), w.a(-8, zzba.zzE), w.a(-15, zzba.zzn), w.a(-1, zzba.zzv), w.a(-3, zzba.zzx), w.a(-10, zzba.zzy));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            mapN.put(-16, zzba.zzw);
        }
        if (i10 >= 27) {
            mapN.put(1, zzba.zzA);
            mapN.put(2, zzba.zzB);
            mapN.put(0, zzba.zzC);
            mapN.put(3, zzba.zzD);
        }
        if (i10 >= 29) {
            mapN.put(4, zzba.zzz);
        }
        return mapN;
    }
}
