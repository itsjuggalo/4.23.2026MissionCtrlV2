package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzcn extends zzco {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzco zzc;

    public zzcn(zzco zzcoVar, int i7, int i8) {
        this.zzc = zzcoVar;
        this.zza = i7;
        this.zzb = i8;
    }

    @Override // java.util.List
    public final Object get(int i7) {
        zzbe.zza(i7, this.zzb, "index");
        return this.zzc.get(i7 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzco, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i7, int i8) {
        return subList(i7, i8);
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
    public final zzco subList(int i7, int i8) {
        zzbe.zze(i7, i8, this.zzb);
        int i9 = this.zza;
        return this.zzc.subList(i7 + i9, i8 + i9);
    }
}
