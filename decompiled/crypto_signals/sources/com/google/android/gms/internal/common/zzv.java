package com.google.android.gms.internal.common;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    public static int zza(int i, int i6, String str) {
        String strZza;
        if (i >= 0 && i < i6) {
            return i;
        }
        if (i < 0) {
            strZza = zzab.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i6 < 0) {
                throw new IllegalArgumentException(d.f(i6, "negative size: "));
            }
            strZza = zzab.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i6, String str) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(zzd(i, i6, "index"));
        }
        return i;
    }

    public static void zzc(int i, int i6, int i7) {
        if (i < 0 || i6 < i || i6 > i7) {
            throw new IndexOutOfBoundsException((i < 0 || i > i7) ? zzd(i, i7, "start index") : (i6 < 0 || i6 > i7) ? zzd(i6, i7, "end index") : zzab.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    private static String zzd(int i, int i6, String str) {
        if (i < 0) {
            return zzab.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return zzab.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(d.f(i6, "negative size: "));
    }
}
