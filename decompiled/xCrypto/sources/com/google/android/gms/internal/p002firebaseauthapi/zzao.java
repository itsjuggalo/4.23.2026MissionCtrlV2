package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzao extends zzaj {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaj zzc;

    public zzao(zzaj zzajVar, int i4, int i5) {
        this.zzc = zzajVar;
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzw.zza(i4, this.zzb);
        return this.zzc.get(i4 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj, java.util.List
    public final /* synthetic */ List subList(int i4, int i5) {
        return subList(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final Object[] zzf() {
        return this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj
    /* JADX INFO: renamed from: zza */
    public final zzaj subList(int i4, int i5) {
        zzw.zza(i4, i5, this.zzb);
        zzaj zzajVar = this.zzc;
        int i6 = this.zza;
        return (zzaj) zzajVar.subList(i4 + i6, i5 + i6);
    }
}
