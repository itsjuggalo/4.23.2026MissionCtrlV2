package com.google.android.recaptcha.internal;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends l implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzsc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(zze zzeVar, long j7, zzsc zzscVar, d dVar) {
        super(2, dVar);
        this.zzb = zzeVar;
        this.zzc = j7;
        this.zzd = zzscVar;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzj(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzj) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZze;
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 != 0) {
            objZze = ((p) obj).j();
        } else {
            zze zzeVar = this.zzb;
            long j7 = this.zzc;
            zzsc zzscVar = this.zzd;
            this.zza = 1;
            objZze = zzeVar.zze(j7, zzscVar, this);
            if (objZze == objE) {
                return objE;
            }
        }
        return p.a(objZze);
    }
}
