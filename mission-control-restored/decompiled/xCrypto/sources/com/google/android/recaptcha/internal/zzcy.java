package com.google.android.recaptcha.internal;

import W2.p;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzcy extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzdc zzdcVar, e eVar) {
        super(eVar);
        this.zzb = zzdcVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzf = this.zzb.zzf(null, 0L, this);
        return objZzf == AbstractC0787c.e() ? objZzf : p.a(objZzf);
    }
}
