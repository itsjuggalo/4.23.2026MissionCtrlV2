package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.b;
import id.m;
import ng.x;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzea extends m implements k {
    Object zza;
    int zzb;
    final /* synthetic */ zzec zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ x zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzea(zzec zzecVar, long j10, x xVar, e eVar) {
        super(1, eVar);
        this.zzc = zzecVar;
        this.zzd = j10;
        this.zze = xVar;
    }

    @Override // id.a
    public final e create(e eVar) {
        return new zzea(this.zzc, this.zzd, this.zze, eVar);
    }

    @Override // pd.k
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzea) create((e) obj)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        zzbd e10;
        zzen zzenVar2;
        Object objF = c.f();
        int i10 = this.zzb;
        if (i10 == 0) {
            s.b(obj);
            zzen zzenVarZzf = this.zzc.zzb.zzf(41);
            try {
                zzdt zzdtVar = this.zzc.zza;
                long j10 = this.zzd;
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objZzo = zzdtVar.zzo(j10, this);
                if (objZzo != objF) {
                    zzenVar2 = zzenVarZzf;
                    obj = objZzo;
                }
                return objF;
            } catch (zzbd e11) {
                zzenVar = zzenVarZzf;
                e10 = e11;
                this.zzc.zzd = e10;
                zzenVar.zzb(e10);
                throw e10;
            }
        }
        if (i10 != 1) {
            zzenVar = (zzen) this.zza;
            try {
                s.b(obj);
                zzenVar.zza();
                this.zzc.zzf = zzcm.zzb;
                return b.a(this.zze.H(h0.f3852a));
            } catch (zzbd e12) {
                e10 = e12;
                this.zzc.zzd = e10;
                zzenVar.zzb(e10);
                throw e10;
            }
        }
        zzenVar2 = (zzen) this.zza;
        try {
            s.b(obj);
        } catch (zzbd e13) {
            e10 = e13;
            zzenVar = zzenVar2;
            this.zzc.zzd = e10;
            zzenVar.zzb(e10);
            throw e10;
        }
        zzsc zzscVar = (zzsc) obj;
        this.zzc.zze = zzscVar;
        zzdt zzdtVar2 = this.zzc.zza;
        long j11 = this.zzd;
        this.zza = zzenVar2;
        this.zzb = 2;
        if (zzdtVar2.zzn(zzscVar, j11, this) != objF) {
            zzenVar = zzenVar2;
            zzenVar.zza();
            this.zzc.zzf = zzcm.zzb;
            return b.a(this.zze.H(h0.f3852a));
        }
        return objF;
    }
}
