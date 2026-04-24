package com.google.android.gms.internal.location;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzbt<E> extends zzbs<E> {
    static final zzbs<Object> zza = new zzbt(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzbt(Object[] objArr, int i4) {
        this.zzb = objArr;
        this.zzc = i4;
    }

    @Override // java.util.List
    public final E get(int i4) {
        zzbm.zza(i4, this.zzc, FirebaseAnalytics.Param.INDEX);
        return (E) this.zzb[i4];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzbs, com.google.android.gms.internal.location.zzbp
    public final int zzg(Object[] objArr, int i4) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
