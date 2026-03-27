package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzaj extends l implements o {
    int zza;
    final /* synthetic */ zzan zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(zzan zzanVar, d dVar) {
        super(2, dVar);
        this.zzb = zzanVar;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzaj(this.zzb, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaj) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 == 0) {
            this.zzb.zze = zzao.zza;
            zzan zzanVar = this.zzb;
            this.zza = 1;
            if (zzanVar.zze(this) == objE) {
                return objE;
            }
        }
        return E.f1657a;
    }
}
