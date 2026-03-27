package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzde extends s implements Function0 {
    public static final zzde zza = new zzde();

    public zzde() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i4 = zzav.zza;
        Object objZzb = zzau.zza().zzb(zzfu.class.getName().hashCode());
        if (objZzb != null) {
            return (zzfu) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
