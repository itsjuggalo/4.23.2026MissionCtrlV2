package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpe implements r {
    private static final zzpe zza = new zzpe();
    private final r zzb = s.b(new zzpg());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // H2.r
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpf get() {
        return (zzpf) this.zzb.get();
    }
}
