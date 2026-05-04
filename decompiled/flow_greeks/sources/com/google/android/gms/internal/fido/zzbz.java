package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzbz extends zzbu {
    private final zzcc zza;

    public zzbz(zzcc zzccVar, int i10) {
        super(zzccVar.size(), i10);
        this.zza = zzccVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbu
    public final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
