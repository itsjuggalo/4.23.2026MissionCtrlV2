package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
final class zzeq extends l implements o {
    final /* synthetic */ zzes zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeq(zzes zzesVar, d dVar) {
        super(2, dVar);
        this.zza = zzesVar;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzeq(this.zza, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeq) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I5.c.e();
        q.b(obj);
        zzes zzesVar = this.zza;
        synchronized (zzeo.class) {
            try {
                zzei zzeiVar = zzesVar.zze;
                if (zzeiVar != null && zzeiVar.zzb() == 0) {
                    Timer timer = zzes.zza;
                    if (timer != null) {
                        timer.cancel();
                    }
                    zzes.zza = null;
                }
                zzesVar.zzg();
            } catch (Throwable th) {
                throw th;
            }
        }
        return E.f1657a;
    }
}
