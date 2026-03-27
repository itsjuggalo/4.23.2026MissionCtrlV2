package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzkl {
    public static void zza(boolean z6, String str, long j4, long j6) {
        if (z6) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j4 + ", " + j6 + ")");
    }

    public static void zzb(boolean z6) {
        if (!z6) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
