package com.google.android.recaptcha;

import W2.p;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, e eVar) {
        super(eVar);
        this.zzb = recaptcha;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objM9getClientBWLJW6A = this.zzb.m9getClientBWLJW6A(null, null, 0L, this);
        return objM9getClientBWLJW6A == AbstractC0787c.e() ? objM9getClientBWLJW6A : p.a(objM9getClientBWLJW6A);
    }
}
