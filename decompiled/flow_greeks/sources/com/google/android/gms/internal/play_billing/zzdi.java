package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdi extends zzfi implements zzgm {
    private static final zzdi zzb;
    private int zzd;
    private zzdn zze;
    private zzdn zzf;
    private int zzg;

    static {
        zzdi zzdiVar = new zzdi();
        zzb = zzdiVar;
        zzfi.zzw(zzdi.class, zzdiVar);
    }

    private zzdi() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzdq.zza()});
        }
        if (i11 == 3) {
            return new zzdi();
        }
        zzdl zzdlVar = null;
        if (i11 == 4) {
            return new zzdh(zzdlVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
