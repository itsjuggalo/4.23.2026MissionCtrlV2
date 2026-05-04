package com.google.android.recaptcha;

import cd.r;
import gd.e;
import hd.c;
import id.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, e eVar) {
        super(eVar);
        this.zzb = recaptcha;
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objM16getClientBWLJW6A = this.zzb.m16getClientBWLJW6A(null, null, 0L, this);
        return objM16getClientBWLJW6A == c.f() ? objM16getClientBWLJW6A : r.a(objM16getClientBWLJW6A);
    }
}
