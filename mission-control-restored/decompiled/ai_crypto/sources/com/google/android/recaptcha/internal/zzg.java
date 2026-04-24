package com.google.android.recaptcha.internal;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzg extends l implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(zze zzeVar, String str, long j7, d dVar) {
        super(2, dVar);
        this.zzb = zzeVar;
        this.zzc = str;
        this.zzd = j7;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzg(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzg) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzc;
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 != 0) {
            objZzc = ((p) obj).j();
        } else {
            zze zzeVar = this.zzb;
            String str = this.zzc;
            long j7 = this.zzd;
            this.zza = 1;
            objZzc = zzeVar.zzc(str, j7, this);
            if (objZzc == objE) {
                return objE;
            }
        }
        return p.a(objZzc);
    }
}
