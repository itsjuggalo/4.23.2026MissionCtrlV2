package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0864b;
import b3.l;
import i3.k;
import t3.InterfaceC1847x;

/* JADX INFO: loaded from: classes.dex */
final class zzea extends l implements k {
    Object zza;
    int zzb;
    final /* synthetic */ zzec zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ InterfaceC1847x zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzea(zzec zzecVar, long j4, InterfaceC1847x interfaceC1847x, e eVar) {
        super(1, eVar);
        this.zzc = zzecVar;
        this.zzd = j4;
        this.zze = interfaceC1847x;
    }

    @Override // b3.AbstractC0863a
    public final e create(e eVar) {
        return new zzea(this.zzc, this.zzd, this.zze, eVar);
    }

    @Override // i3.k
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzea) create((e) obj)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        zzbd e4;
        zzen zzenVar2;
        Object objE = AbstractC0787c.e();
        int i4 = this.zzb;
        if (i4 == 0) {
            q.b(obj);
            zzen zzenVarZzf = this.zzc.zzb.zzf(41);
            try {
                zzdt zzdtVar = this.zzc.zza;
                long j4 = this.zzd;
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objZzo = zzdtVar.zzo(j4, this);
                if (objZzo != objE) {
                    zzenVar2 = zzenVarZzf;
                    obj = objZzo;
                }
                return objE;
            } catch (zzbd e5) {
                zzenVar = zzenVarZzf;
                e4 = e5;
                this.zzc.zzd = e4;
                zzenVar.zzb(e4);
                throw e4;
            }
        }
        if (i4 != 1) {
            zzenVar = (zzen) this.zza;
            try {
                q.b(obj);
                zzenVar.zza();
                this.zzc.zzf = zzcm.zzb;
                return AbstractC0864b.a(this.zze.K(E.f5463a));
            } catch (zzbd e6) {
                e4 = e6;
                this.zzc.zzd = e4;
                zzenVar.zzb(e4);
                throw e4;
            }
        }
        zzenVar2 = (zzen) this.zza;
        try {
            q.b(obj);
        } catch (zzbd e7) {
            e4 = e7;
            zzenVar = zzenVar2;
            this.zzc.zzd = e4;
            zzenVar.zzb(e4);
            throw e4;
        }
        zzsc zzscVar = (zzsc) obj;
        this.zzc.zze = zzscVar;
        zzdt zzdtVar2 = this.zzc.zza;
        long j5 = this.zzd;
        this.zza = zzenVar2;
        this.zzb = 2;
        if (zzdtVar2.zzn(zzscVar, j5, this) != objE) {
            zzenVar = zzenVar2;
            zzenVar.zza();
            this.zzc.zzf = zzcm.zzb;
            return AbstractC0864b.a(this.zze.K(E.f5463a));
        }
        return objE;
    }
}
