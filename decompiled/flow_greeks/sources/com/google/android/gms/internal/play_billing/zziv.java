package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zziv extends zzfi implements zzgm {
    private static final zziv zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zziv zzivVar = new zziv();
        zzb = zzivVar;
        zzfi.zzw(zziv.class, zzivVar);
    }

    private zziv() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new zziv();
        }
        zziu zziuVar = null;
        if (i11 == 4) {
            return new zzit(zziuVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
