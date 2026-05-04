package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import ng.x;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzeb extends m implements o {
    int zza;
    final /* synthetic */ zzec zzb;
    final /* synthetic */ x zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzec zzecVar, x xVar, long j10, e eVar) {
        super(2, eVar);
        this.zzb = zzecVar;
        this.zzc = xVar;
        this.zzd = j10;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzeb(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeb) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Exception {
        zzbd zzbdVar;
        zzeb zzebVar;
        zzbd e10;
        Object objF = c.f();
        if (this.zza != 0) {
            try {
                s.b(obj);
                zzebVar = this;
            } catch (zzbd e11) {
                zzbdVar = e11;
                zzebVar = this;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.E(zzbdVar);
            }
        } else {
            s.b(obj);
            try {
                zzbq zzbqVar = zzbq.zza;
                zzdz zzdzVar = new zzdz(this.zzb);
                zzea zzeaVar = new zzea(this.zzb, this.zzd, this.zzc, null);
                this.zza = 1;
                zzebVar = this;
                try {
                    obj = zzbqVar.zza(zzdzVar, 100L, 1000L, 2.0d, zzeaVar, zzebVar);
                    if (obj == objF) {
                        return objF;
                    }
                } catch (zzbd e12) {
                    e10 = e12;
                    zzbdVar = e10;
                    zzebVar.zzb.zzf = zzcm.zzd;
                    zzebVar.zzc.E(zzbdVar);
                }
            } catch (zzbd e13) {
                e10 = e13;
                zzebVar = this;
                zzbdVar = e10;
                zzebVar.zzb.zzf = zzcm.zzd;
                zzebVar.zzc.E(zzbdVar);
            }
        }
        ((Boolean) obj).getClass();
        return h0.f3852a;
    }
}
