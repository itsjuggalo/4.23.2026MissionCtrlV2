package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzu {
    public static int zza(int i10, int i11) {
        String strZza;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            strZza = zzac.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                throw new IllegalArgumentException("negative size: " + i11);
            }
            strZza = zzac.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(zzb(i10, i11, FirebaseAnalytics.Param.INDEX));
        }
        return i10;
    }

    private static String zzb(int i10, int i11, String str) {
        if (i10 < 0) {
            return zzac.zza("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return zzac.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }

    public static int zza(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(zzb(i10, i11, str));
        }
        return i10;
    }

    public static <T> T zza(T t10) {
        t10.getClass();
        return t10;
    }

    public static void zza(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(zzp.zza(obj));
        }
    }

    public static void zza(int i10, int i11, int i12) {
        String strZzb;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 < 0 || i10 > i12) {
                strZzb = zzb(i10, i12, "start index");
            } else if (i11 >= 0 && i11 <= i12) {
                strZzb = zzac.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            } else {
                strZzb = zzb(i11, i12, "end index");
            }
            throw new IndexOutOfBoundsException(strZzb);
        }
    }
}
