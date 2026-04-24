package com.google.android.gms.internal.measurement;

import U1.l;
import U1.o;

/* JADX INFO: loaded from: classes.dex */
public final class zzrb implements l {
    private static final zzrb zza = new zzrb();
    private final l zzb = new o(new zzrd());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // U1.l
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzrc get() {
        return (zzrc) this.zzb.get();
    }
}
