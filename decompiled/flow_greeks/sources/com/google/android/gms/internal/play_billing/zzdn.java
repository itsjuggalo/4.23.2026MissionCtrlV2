package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdn extends zzfi implements zzgm {
    private static final zzdn zzb;
    private int zzd;
    private String zze = "";

    static {
        zzdn zzdnVar = new zzdn();
        zzb = zzdnVar;
        zzfi.zzw(zzdn.class, zzdnVar);
    }

    private zzdn() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i11 == 3) {
            return new zzdn();
        }
        zzdo zzdoVar = null;
        if (i11 == 4) {
            return new zzdm(zzdoVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
