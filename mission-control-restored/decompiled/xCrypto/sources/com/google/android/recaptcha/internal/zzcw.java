package com.google.android.recaptcha.internal;

import W2.p;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzcw extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(zzdc zzdcVar, e eVar) {
        super(eVar);
        this.zzb = zzdcVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo10execute0E7RQCE = this.zzb.mo10execute0E7RQCE(null, 0L, this);
        return objMo10execute0E7RQCE == AbstractC0787c.e() ? objMo10execute0E7RQCE : p.a(objMo10execute0E7RQCE);
    }
}
