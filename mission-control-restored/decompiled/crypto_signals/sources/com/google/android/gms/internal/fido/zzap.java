package com.google.android.gms.internal.fido;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzap {
    public static int zza(int i, int i6, String str) {
        String strZza;
        if (i >= 0 && i < i6) {
            return i;
        }
        if (i < 0) {
            strZza = zzaq.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i6 < 0) {
                throw new IllegalArgumentException(d.f(i6, "negative size: "));
            }
            strZza = zzaq.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i6, String str) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(zzf(i, i6, "index"));
        }
        return i;
    }

    public static void zzc(boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z6, String str, char c6) {
        if (!z6) {
            throw new IllegalArgumentException(zzaq.zza(str, Character.valueOf(c6)));
        }
    }

    public static void zze(int i, int i6, int i7) {
        if (i < 0 || i6 < i || i6 > i7) {
            throw new IndexOutOfBoundsException((i < 0 || i > i7) ? zzf(i, i7, "start index") : (i6 < 0 || i6 > i7) ? zzf(i6, i7, "end index") : zzaq.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    private static String zzf(int i, int i6, String str) {
        if (i < 0) {
            return zzaq.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return zzaq.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(d.f(i6, "negative size: "));
    }
}
