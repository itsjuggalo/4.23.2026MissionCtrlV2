package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.b.f;

/* JADX INFO: loaded from: classes.dex */
final class zzap {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzap(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.zza) + f.f8805b + String.valueOf(this.zzb) + " and " + String.valueOf(this.zza) + f.f8805b + String.valueOf(this.zzc));
    }
}
