package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import X2.x;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0864b;
import b3.l;
import i3.o;
import java.util.List;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
final class zzfq extends l implements o {
    int zza;
    final /* synthetic */ zzgd zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzft zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfq(zzgd zzgdVar, List list, zzft zzftVar, e eVar) {
        super(2, eVar);
        this.zzb = zzgdVar;
        this.zzc = list;
        this.zzd = zzftVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        zzfq zzfqVar = new zzfq(this.zzb, this.zzc, this.zzd, eVar);
        zzfqVar.zze = obj;
        return zzfqVar;
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfq) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            L l4 = (L) this.zze;
            while (true) {
                zzgd zzgdVar = this.zzb;
                if (zzgdVar.zza() < 0) {
                    break;
                }
                if (zzgdVar.zza() >= this.zzc.size() || !M.g(l4)) {
                    break;
                }
                zzuf zzufVar = (zzuf) this.zzc.get(this.zzb.zza());
                try {
                    zzft.zzf(this.zzd, zzufVar, this.zzb);
                } catch (Exception e4) {
                    zzufVar.zzk();
                    AbstractC0864b.c(zzufVar.zzg());
                    x.Q(zzufVar.zzj(), null, null, null, 0, null, new zzfp(this.zzd), 31, null);
                    zzft zzftVar = this.zzd;
                    zzgd zzgdVar2 = this.zzb;
                    this.zza = 1;
                    if (zzftVar.zzh(e4, zzgdVar2, this) == objE) {
                        return objE;
                    }
                }
            }
            return E.f5463a;
        }
        return E.f5463a;
    }
}
