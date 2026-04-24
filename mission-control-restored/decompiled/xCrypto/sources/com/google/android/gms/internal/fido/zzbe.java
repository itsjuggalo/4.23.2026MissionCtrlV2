package com.google.android.gms.internal.fido;

import java.util.AbstractMap;

/* JADX INFO: loaded from: classes.dex */
final class zzbe extends zzaz {
    final /* synthetic */ zzbf zza;

    public zzbe(zzbf zzbfVar) {
        this.zza = zzbfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        return new AbstractMap.SimpleImmutableEntry(this.zza.zza.zze.zzd.get(i4), this.zza.zza.zzf.get(i4));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zza.size();
    }
}
