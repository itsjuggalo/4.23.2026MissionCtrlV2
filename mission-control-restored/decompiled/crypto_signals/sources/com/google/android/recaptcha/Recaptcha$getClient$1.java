package com.google.android.recaptcha;

import G4.h;
import I4.d;
import J4.a;
import K4.c;

/* JADX INFO: loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends c {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, d dVar) {
        super(dVar);
        this.zzb = recaptcha;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objM1getClientBWLJW6A = this.zzb.m1getClientBWLJW6A(null, null, 0L, this);
        return objM1getClientBWLJW6A == a.f791a ? objM1getClientBWLJW6A : new h(objM1getClientBWLJW6A);
    }
}
