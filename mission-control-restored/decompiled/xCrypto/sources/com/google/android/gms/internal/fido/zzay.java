package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    public zzay(zzaz zzazVar, int i4, int i5) {
        this.zzc = zzazVar;
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzap.zza(i4, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i4 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i4, int i5) {
        return subList(i4, i5);
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

    @Override // com.google.android.gms.internal.fido.zzaz
    /* JADX INFO: renamed from: zzg */
    public final zzaz subList(int i4, int i5) {
        zzap.zze(i4, i5, this.zzb);
        zzaz zzazVar = this.zzc;
        int i6 = this.zza;
        return zzazVar.subList(i4 + i6, i5 + i6);
    }
}
