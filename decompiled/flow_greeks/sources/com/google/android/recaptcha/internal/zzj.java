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
final class zzj extends m implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzsc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(zze zzeVar, long j10, zzsc zzscVar, e eVar) {
        super(2, eVar);
        this.zzb = zzeVar;
        this.zzc = j10;
        this.zzd = zzscVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzj(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzj) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZze;
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 != 0) {
            objZze = ((r) obj).j();
        } else {
            zze zzeVar = this.zzb;
            long j10 = this.zzc;
            zzsc zzscVar = this.zzd;
            this.zza = 1;
            objZze = zzeVar.zze(j10, zzscVar, this);
            if (objZze == objF) {
                return objF;
            }
        }
        return r.a(objZze);
    }
}
