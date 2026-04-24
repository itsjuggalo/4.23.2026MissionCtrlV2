package com.google.android.gms.internal.common;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzal {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i6 = 0; i6 < i; i6++) {
            if (objArr[i6] == null) {
                throw new NullPointerException(d.f(i6, "at index "));
            }
        }
        return objArr;
    }
}
