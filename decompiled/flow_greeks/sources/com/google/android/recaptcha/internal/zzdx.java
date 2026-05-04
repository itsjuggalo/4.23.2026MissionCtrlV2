package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import ng.x;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdx extends m implements o {
    int zza;
    final /* synthetic */ zzec zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdx(zzec zzecVar, e eVar) {
        super(2, eVar);
        this.zzb = zzecVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzdx(this.zzb, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdx) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            x xVar = this.zzb.zzc;
            this.zza = 1;
            if (xVar.await(this) == objF) {
                return objF;
            }
        }
        return h0.f3852a;
    }
}
