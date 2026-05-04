package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zziz extends zzfi implements zzgm {
    private static final zziz zzb;
    private int zzd;
    private int zze;

    static {
        zziz zzizVar = new zziz();
        zzb = zzizVar;
        zzfi.zzw(zziz.class, zzizVar);
    }

    private zziz() {
    }

    public static /* synthetic */ void zzA(zziz zzizVar, int i10) {
        zzizVar.zze = i10 - 1;
        zzizVar.zzd |= 1;
    }

    public static zziw zzc() {
        return (zziw) zzb.zzl();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzix.zza});
        }
        if (i11 == 3) {
            return new zziz();
        }
        zziy zziyVar = null;
        if (i11 == 4) {
            return new zziw(zziyVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
