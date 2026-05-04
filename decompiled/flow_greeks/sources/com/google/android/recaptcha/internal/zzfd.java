package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfd extends v implements Function0 {
    public static final zzfd zza = new zzfd();

    public zzfd() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i10 = zzav.zza;
        Object objZzb = zzau.zza().zzb(zzaq.class.getName().hashCode());
        if (objZzb != null) {
            return (zzaq) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
