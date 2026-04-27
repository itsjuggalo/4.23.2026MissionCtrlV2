package com.google.android.recaptcha;

import E5.p;
import I5.c;
import J5.d;

/* JADX INFO: loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, H5.d dVar) {
        super(dVar);
        this.zzb = recaptcha;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objM2getClientBWLJW6A = this.zzb.m2getClientBWLJW6A(null, null, 0L, this);
        return objM2getClientBWLJW6A == c.e() ? objM2getClientBWLJW6A : p.a(objM2getClientBWLJW6A);
    }
}
