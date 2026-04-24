package com.google.android.gms.internal.fido;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
final class zzas {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 == null) {
            throw new NullPointerException(AbstractC1024h.c("null value in entry: ", obj.toString(), "=null"));
        }
    }
}
