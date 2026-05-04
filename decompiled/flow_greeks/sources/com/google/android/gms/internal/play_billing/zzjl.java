package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjl extends zzfi implements zzgm {
    private static final zzjl zzb;
    private int zzd;
    private int zzf;
    private zzfn zze = zzfi.zzr();
    private String zzg = "";

    static {
        zzjl zzjlVar = new zzjl();
        zzb = zzjlVar;
        zzfi.zzw(zzjl.class, zzjlVar);
    }

    private zzjl() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzjl();
        }
        zzjk zzjkVar = null;
        if (i11 == 4) {
            return new zzjj(zzjkVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
