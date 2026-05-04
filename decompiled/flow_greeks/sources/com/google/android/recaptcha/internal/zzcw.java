package com.google.android.recaptcha.internal;

import cd.r;
import gd.e;
import hd.c;
import id.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzcw extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(zzdc zzdcVar, e eVar) {
        super(eVar);
        this.zzb = zzdcVar;
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo17execute0E7RQCE = this.zzb.mo17execute0E7RQCE(null, 0L, this);
        return objMo17execute0E7RQCE == c.f() ? objMo17execute0E7RQCE : r.a(objMo17execute0E7RQCE);
    }
}
