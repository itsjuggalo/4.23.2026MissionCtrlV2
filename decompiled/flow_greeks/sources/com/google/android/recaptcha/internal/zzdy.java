package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.y2;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdy extends m implements k {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzec zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(long j10, zzec zzecVar, e eVar) {
        super(1, eVar);
        this.zzb = j10;
        this.zzc = zzecVar;
    }

    @Override // id.a
    public final e create(e eVar) {
        return new zzdy(this.zzb, this.zzc, eVar);
    }

    @Override // pd.k
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzdy) create((e) obj)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            long j10 = this.zzb;
            zzdx zzdxVar = new zzdx(this.zzc, null);
            this.zza = 1;
            if (y2.c(j10, zzdxVar, this) == objF) {
                return objF;
            }
        }
        return h0.f3852a;
    }
}
