package com.google.android.recaptcha.internal;

import E5.t;
import F5.J;
import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzjb {
    public static final Map zza() {
        Map mapI = J.i(t.a(-4, zzba.zzo), t.a(-12, zzba.zzp), t.a(-6, zzba.zzk), t.a(-11, zzba.zzm), t.a(-13, zzba.zzq), t.a(-14, zzba.zzr), t.a(-2, zzba.zzl), t.a(-7, zzba.zzs), t.a(-5, zzba.zzt), t.a(-9, zzba.zzu), t.a(-8, zzba.zzE), t.a(-15, zzba.zzn), t.a(-1, zzba.zzv), t.a(-3, zzba.zzx), t.a(-10, zzba.zzy));
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26) {
            mapI.put(-16, zzba.zzw);
        }
        if (i7 >= 27) {
            mapI.put(1, zzba.zzA);
            mapI.put(2, zzba.zzB);
            mapI.put(0, zzba.zzC);
            mapI.put(3, zzba.zzD);
        }
        if (i7 >= 29) {
            mapI.put(4, zzba.zzz);
        }
        return mapI;
    }
}
