package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzdp extends s implements Function0 {
    public static final zzdp zza = new zzdp();

    public zzdp() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i7 = zzav.zza;
        Object objZzb = zzau.zza().zzb(zzfj.class.getName().hashCode());
        if (objZzb != null) {
            return (zzfj) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
