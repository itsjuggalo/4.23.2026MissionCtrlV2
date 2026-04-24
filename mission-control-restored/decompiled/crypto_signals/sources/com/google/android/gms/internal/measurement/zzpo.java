package com.google.android.gms.internal.measurement;

import U1.l;
import U1.o;

/* JADX INFO: loaded from: classes.dex */
public final class zzpo implements l {
    private static final zzpo zza = new zzpo();
    private final l zzb = new o(new zzpq());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // U1.l
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpp get() {
        return (zzpp) this.zzb.get();
    }
}
