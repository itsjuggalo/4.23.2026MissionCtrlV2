package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.InterfaceC1847x;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzeb extends l implements o {
    int zza;
    final /* synthetic */ zzec zzb;
    final /* synthetic */ InterfaceC1847x zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzec zzecVar, InterfaceC1847x interfaceC1847x, long j4, e eVar) {
        super(2, eVar);
        this.zzb = zzecVar;
        this.zzc = interfaceC1847x;
        this.zzd = j4;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzeb(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeb) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Exception {
        zzbd zzbdVar;
        zzeb zzebVar;
        zzbd e4;
        Object objE = AbstractC0787c.e();
        if (this.zza != 0) {
            try {
                q.b(obj);
                zzebVar = this;
            } catch (zzbd e5) {
                zzbdVar = e5;
                zzebVar = this;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.G(zzbdVar);
            }
        } else {
            q.b(obj);
            try {
                zzbq zzbqVar = zzbq.zza;
                zzdz zzdzVar = new zzdz(this.zzb);
                zzea zzeaVar = new zzea(this.zzb, this.zzd, this.zzc, null);
                this.zza = 1;
                zzebVar = this;
                try {
                    obj = zzbqVar.zza(zzdzVar, 100L, 1000L, 2.0d, zzeaVar, zzebVar);
                    if (obj == objE) {
                        return objE;
                    }
                } catch (zzbd e6) {
                    e4 = e6;
                    zzbdVar = e4;
                    zzebVar.zzb.zzf = zzcm.zzd;
                    zzebVar.zzc.G(zzbdVar);
                }
            } catch (zzbd e7) {
                e4 = e7;
                zzebVar = this;
                zzbdVar = e4;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.G(zzbdVar);
            }
        }
        ((Boolean) obj).getClass();
        return E.f5463a;
    }
}
