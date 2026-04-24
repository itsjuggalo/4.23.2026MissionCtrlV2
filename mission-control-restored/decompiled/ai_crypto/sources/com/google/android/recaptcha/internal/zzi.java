package com.google.android.recaptcha.internal;

import E5.p;
import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzi extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzl zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(zzl zzlVar, H5.d dVar) {
        super(dVar);
        this.zzb = zzlVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzc = this.zzb.zzc(0L, null, null, this);
        return objZzc == I5.c.e() ? objZzc : p.a(objZzc);
    }
}
