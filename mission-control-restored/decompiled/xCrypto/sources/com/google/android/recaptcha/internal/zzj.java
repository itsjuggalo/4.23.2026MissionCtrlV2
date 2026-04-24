package com.google.android.recaptcha.internal;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends l implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzsc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(zze zzeVar, long j4, zzsc zzscVar, e eVar) {
        super(2, eVar);
        this.zzb = zzeVar;
        this.zzc = j4;
        this.zzd = zzscVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzj(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzj) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZze;
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 != 0) {
            objZze = ((p) obj).j();
        } else {
            zze zzeVar = this.zzb;
            long j4 = this.zzc;
            zzsc zzscVar = this.zzd;
            this.zza = 1;
            objZze = zzeVar.zze(j4, zzscVar, this);
            if (objZze == objE) {
                return objE;
            }
        }
        return p.a(objZze);
    }
}
