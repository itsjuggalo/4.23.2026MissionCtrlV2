package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzel extends s implements Function0 {
    public static final zzel zza = new zzel();

    public zzel() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i4 = zzav.zza;
        Object objZzb = zzau.zza().zzb(zzaz.class.getName().hashCode());
        if (objZzb != null) {
            return (zzaz) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
