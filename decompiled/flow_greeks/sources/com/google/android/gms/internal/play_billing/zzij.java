package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzij extends zzfi implements zzgm {
    private static final zzij zzb;

    static {
        zzij zzijVar = new zzij();
        zzb = zzijVar;
        zzfi.zzw(zzij.class, zzijVar);
    }

    private zzij() {
    }

    public static zzij zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        zzii zziiVar = null;
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0000", null);
        }
        if (i11 == 3) {
            return new zzij();
        }
        if (i11 == 4) {
            return new zzih(zziiVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
