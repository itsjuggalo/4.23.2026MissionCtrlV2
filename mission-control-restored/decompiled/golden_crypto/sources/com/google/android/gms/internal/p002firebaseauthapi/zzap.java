package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.b.f;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzap {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    final IllegalArgumentException zza() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.zza) + f.b + String.valueOf(this.zzb) + " and " + String.valueOf(this.zza) + f.b + String.valueOf(this.zzc));
    }

    zzap(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }
}
