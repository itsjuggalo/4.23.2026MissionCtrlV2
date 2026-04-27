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
final class zzg extends l implements o {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(zze zzeVar, String str, long j4, e eVar) {
        super(2, eVar);
        this.zzb = zzeVar;
        this.zzc = str;
        this.zzd = j4;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzg(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzg) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzc;
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 != 0) {
            objZzc = ((p) obj).j();
        } else {
            zze zzeVar = this.zzb;
            String str = this.zzc;
            long j4 = this.zzd;
            this.zza = 1;
            objZzc = zzeVar.zzc(str, j4, this);
            if (objZzc == objE) {
                return objE;
            }
        }
        return p.a(objZzc);
    }
}
