package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzjf {
    public static void zza(boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z6, String str, char c6) {
        if (!z6) {
            throw new IllegalArgumentException(zzji.zza(str, Character.valueOf(c6)));
        }
    }

    public static void zzd(int i, int i6, int i7) {
        if (i < 0 || i6 < i || i6 > i7) {
            throw new IndexOutOfBoundsException((i < 0 || i > i7) ? zzf(i, i7, "start index") : (i6 < 0 || i6 > i7) ? zzf(i6, i7, "end index") : zzji.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    public static void zze(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzf(int i, int i6, String str) {
        return i < 0 ? zzji.zza("%s (%s) must not be negative", str, Integer.valueOf(i)) : zzji.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
    }
}
