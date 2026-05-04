package com.google.android.gms.internal.play_billing;

import com.amazon.a.a.o.b.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzbu {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzbu(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + f.f4599b + String.valueOf(obj2) + " and " + String.valueOf(obj3) + f.f4599b + String.valueOf(obj));
    }
}
