package com.google.android.recaptcha.internal;

import E5.p;
import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzcw extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(zzdc zzdcVar, H5.d dVar) {
        super(dVar);
        this.zzb = zzdcVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo3execute0E7RQCE = this.zzb.mo3execute0E7RQCE(null, 0L, this);
        return objMo3execute0E7RQCE == I5.c.e() ? objMo3execute0E7RQCE : p.a(objMo3execute0E7RQCE);
    }
}
