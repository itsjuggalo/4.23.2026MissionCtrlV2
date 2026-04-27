package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
public final class zzal {
    public static Object[] zza(Object[] objArr, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (objArr[i5] == null) {
                throw new NullPointerException("at index " + i5);
            }
        }
        return objArr;
    }
}
