package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzcn extends zzco {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzco zzc;

    public zzcn(zzco zzcoVar, int i4, int i5) {
        this.zzc = zzcoVar;
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzbe.zza(i4, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i4 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzco, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i4, int i5) {
        return subList(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzco
    /* JADX INFO: renamed from: zzi */
    public final zzco subList(int i4, int i5) {
        zzbe.zze(i4, i5, this.zzb);
        int i6 = this.zza;
        return this.zzc.subList(i4 + i6, i5 + i6);
    }
}
