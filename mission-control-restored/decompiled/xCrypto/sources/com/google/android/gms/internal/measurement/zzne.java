package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzne {
    private final zznd zza;

    private zzne(zzos zzosVar, Object obj, zzos zzosVar2, Object obj2) {
        this.zza = new zznd(zzosVar, "", zzosVar2, "");
    }

    public static zzne zza(zzos zzosVar, Object obj, zzos zzosVar2, Object obj2) {
        return new zzne(zzosVar, "", zzosVar2, "");
    }

    public static void zzb(zzll zzllVar, zznd zzndVar, Object obj, Object obj2) {
        zzlv.zzf(zzllVar, zzndVar.zza, 1, obj);
        zzlv.zzf(zzllVar, zzndVar.zzc, 2, obj2);
    }

    public static int zzc(zznd zzndVar, Object obj, Object obj2) {
        return zzlv.zzh(zzndVar.zza, 1, obj) + zzlv.zzh(zzndVar.zzc, 2, obj2);
    }

    public final int zzd(int i4, Object obj, Object obj2) {
        zznd zzndVar = this.zza;
        int iZzz = zzll.zzz(i4 << 3);
        int iZzc = zzc(zzndVar, obj, obj2);
        return iZzz + zzll.zzz(iZzc) + iZzc;
    }

    public final zznd zze() {
        return this.zza;
    }
}
