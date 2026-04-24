package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes.dex */
final class zzaw extends zzar {
    private final zzaz zza;

    public zzaw(zzaz zzazVar, int i4) {
        super(zzazVar.size(), i4);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.fido.zzar
    public final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
