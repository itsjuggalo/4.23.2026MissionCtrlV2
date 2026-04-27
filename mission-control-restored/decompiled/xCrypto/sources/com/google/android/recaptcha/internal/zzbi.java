package com.google.android.recaptcha.internal;

import java.util.concurrent.Executors;
import t3.AbstractC1822k;
import t3.AbstractC1831o0;
import t3.C1803a0;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi {
    private final L zza = M.b();
    private final L zzb;
    private final L zzc;
    private final L zzd;

    public zzbi() {
        L lA = M.a(AbstractC1831o0.b(Executors.newSingleThreadExecutor()));
        AbstractC1822k.d(lA, null, null, new zzbh(null), 3, null);
        this.zzb = lA;
        this.zzc = M.a(C1803a0.b());
        L lA2 = M.a(AbstractC1831o0.b(Executors.newSingleThreadExecutor()));
        AbstractC1822k.d(lA2, null, null, new zzbg(null), 3, null);
        this.zzd = lA2;
    }

    public final L zza() {
        return this.zzc;
    }

    public final L zzb() {
        return this.zza;
    }

    public final L zzc() {
        return this.zzd;
    }

    public final L zzd() {
        return this.zzb;
    }
}
