package com.google.android.gms.internal.measurement;

import H2.m;
import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class zzcf {
    private static final ThreadLocal zza = new zzce();

    public static SharedPreferences zza(Context context, String str, int i7, zzca zzcaVar) {
        zzbv.zza();
        zzcd zzcdVar = str.equals("") ? new zzcd() : null;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        ThreadLocal threadLocal = zza;
        m.d(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            zza.set(Boolean.TRUE);
            throw th;
        }
    }
}
