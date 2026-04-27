package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzu {
    public static int zza(int i, int i6) {
        String strZza;
        if (i >= 0 && i < i6) {
            return i;
        }
        if (i < 0) {
            strZza = zzac.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i6 < 0) {
                throw new IllegalArgumentException(d.f(i6, "negative size: "));
            }
            strZza = zzac.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i6) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(zzb(i, i6, "index"));
        }
        return i;
    }

    private static String zzb(int i, int i6, String str) {
        if (i < 0) {
            return zzac.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return zzac.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(d.f(i6, "negative size: "));
    }

    public static int zza(int i, int i6, String str) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(zzb(i, i6, str));
        }
        return i;
    }

    public static <T> T zza(T t6) {
        t6.getClass();
        return t6;
    }

    public static void zza(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(zzp.zza(obj));
        }
    }

    public static void zza(int i, int i6, int i7) {
        String strZzb;
        if (i < 0 || i6 < i || i6 > i7) {
            if (i < 0 || i > i7) {
                strZzb = zzb(i, i7, "start index");
            } else if (i6 >= 0 && i6 <= i7) {
                strZzb = zzac.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i));
            } else {
                strZzb = zzb(i6, i7, "end index");
            }
            throw new IndexOutOfBoundsException(strZzb);
        }
    }
}
