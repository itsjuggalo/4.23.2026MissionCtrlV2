package com.google.android.recaptcha.internal;

import G4.f;
import H4.t;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzjb {
    public static final Map zza() {
        LinkedHashMap linkedHashMapS = t.S(new f(-4, zzba.zzo), new f(-12, zzba.zzp), new f(-6, zzba.zzk), new f(-11, zzba.zzm), new f(-13, zzba.zzq), new f(-14, zzba.zzr), new f(-2, zzba.zzl), new f(-7, zzba.zzs), new f(-5, zzba.zzt), new f(-9, zzba.zzu), new f(-8, zzba.zzE), new f(-15, zzba.zzn), new f(-1, zzba.zzv), new f(-3, zzba.zzx), new f(-10, zzba.zzy));
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            linkedHashMapS.put(-16, zzba.zzw);
        }
        if (i >= 27) {
            linkedHashMapS.put(1, zzba.zzA);
            linkedHashMapS.put(2, zzba.zzB);
            linkedHashMapS.put(0, zzba.zzC);
            linkedHashMapS.put(3, zzba.zzD);
        }
        if (i >= 29) {
            linkedHashMapS.put(4, zzba.zzz);
        }
        return linkedHashMapS;
    }
}
