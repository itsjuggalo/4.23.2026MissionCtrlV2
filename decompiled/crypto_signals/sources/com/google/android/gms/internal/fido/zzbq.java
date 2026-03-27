package com.google.android.gms.internal.fido;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzbq {
    public static Object zza(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(d.f(i, "at index "));
    }

    public static Object[] zzb(Object[] objArr, int i) {
        for (int i6 = 0; i6 < i; i6++) {
            zza(objArr[i6], i6);
        }
        return objArr;
    }
}
