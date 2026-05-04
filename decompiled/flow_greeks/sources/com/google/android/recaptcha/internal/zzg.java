package com.google.android.recaptcha.internal;

import cd.h0;
import cd.r;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzg extends m implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(zze zzeVar, String str, long j10, e eVar) {
        super(2, eVar);
        this.zzb = zzeVar;
        this.zzc = str;
        this.zzd = j10;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzg(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzg) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzc;
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 != 0) {
            objZzc = ((r) obj).j();
        } else {
            zze zzeVar = this.zzb;
            String str = this.zzc;
            long j10 = this.zzd;
            this.zza = 1;
            objZzc = zzeVar.zzc(str, j10, this);
            if (objZzc == objF) {
                return objF;
            }
        }
        return r.a(objZzc);
    }
}
