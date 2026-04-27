package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    public zzay(zzaz zzazVar, int i, int i6) {
        this.zzc = zzazVar;
        this.zza = i;
        this.zzb = i6;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzap.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    /* JADX INFO: renamed from: zzg */
    public final zzaz subList(int i, int i6) {
        zzap.zze(i, i6, this.zzb);
        zzaz zzazVar = this.zzc;
        int i7 = this.zza;
        return zzazVar.subList(i + i7, i6 + i7);
    }
}
