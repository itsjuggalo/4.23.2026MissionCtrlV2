package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdo extends zzco {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzdo(Object[] objArr, int i4, int i5) {
        this.zza = objArr;
        this.zzb = i4;
        this.zzc = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzbe.zza(i4, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i4 + i4 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public final boolean zzf() {
        return true;
    }
}
