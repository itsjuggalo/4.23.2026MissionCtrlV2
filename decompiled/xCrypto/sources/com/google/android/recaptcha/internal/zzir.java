package com.google.android.recaptcha.internal;

import W2.p;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzir extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzja zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzir(zzja zzjaVar, e eVar) {
        super(eVar);
        this.zzb = zzjaVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzh = this.zzb.zzh(null, this);
        return objZzh == AbstractC0787c.e() ? objZzh : p.a(objZzh);
    }
}
