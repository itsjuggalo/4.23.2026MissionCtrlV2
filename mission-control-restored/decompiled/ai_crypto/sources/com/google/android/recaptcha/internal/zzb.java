package com.google.android.recaptcha.internal;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzb extends l implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(zze zzeVar, String str, d dVar) {
        super(2, dVar);
        this.zzb = zzeVar;
        this.zzc = str;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzb(this.zzb, this.zzc, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzf;
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 != 0) {
            objZzf = ((p) obj).j();
        } else {
            zze zzeVar = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            objZzf = zzeVar.zzf(str, this);
            if (objZzf == objE) {
                return objE;
            }
        }
        return p.a(objZzf);
    }
}
