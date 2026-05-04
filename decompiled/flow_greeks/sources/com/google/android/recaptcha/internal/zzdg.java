package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import ng.w2;
import ng.y2;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdg extends m implements o {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzdt zzdtVar, String str, long j10, zzsp zzspVar, e eVar) {
        super(2, eVar);
        this.zzc = zzdtVar;
        this.zzd = str;
        this.zze = j10;
        this.zzf = zzspVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        Exception e10;
        w2 e11;
        zzbd e12;
        Object objF = c.f();
        if (this.zzb != 0) {
            zzenVar = (zzen) this.zza;
            try {
                s.b(obj);
            } catch (zzbd e13) {
                e12 = e13;
                zzbd zzbdVarZzs = this.zzc.zzs(e12, e12);
                zzenVar.zzb(zzbdVarZzs);
                throw zzbdVarZzs;
            } catch (w2 e14) {
                e11 = e14;
                zzbd zzbdVarZzs2 = this.zzc.zzs(e11, new zzbd(zzbb.zzc, zzba.zzb, e11.getMessage()));
                zzenVar.zzb(zzbdVarZzs2);
                throw zzbdVarZzs2;
            } catch (Exception e15) {
                e10 = e15;
                zzbd zzbdVarZzs3 = this.zzc.zzs(e10, new zzbd(zzbb.zzc, zzba.zzZ, e10.getMessage()));
                zzenVar.zzb(zzbdVarZzs3);
                throw zzbdVarZzs3;
            }
        } else {
            s.b(obj);
            zzen zzenVarZzf = this.zzc.zzu(this.zzd).zzf(28);
            try {
                long j10 = this.zze;
                zzdf zzdfVar = new zzdf(this.zzc, this.zzf, zzenVarZzf, null);
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objC = y2.c(j10, zzdfVar, this);
                if (objC == objF) {
                    return objF;
                }
                zzenVar = zzenVarZzf;
                obj = objC;
            } catch (zzbd e16) {
                zzenVar = zzenVarZzf;
                e12 = e16;
                zzbd zzbdVarZzs4 = this.zzc.zzs(e12, e12);
                zzenVar.zzb(zzbdVarZzs4);
                throw zzbdVarZzs4;
            } catch (w2 e17) {
                zzenVar = zzenVarZzf;
                e11 = e17;
                zzbd zzbdVarZzs22 = this.zzc.zzs(e11, new zzbd(zzbb.zzc, zzba.zzb, e11.getMessage()));
                zzenVar.zzb(zzbdVarZzs22);
                throw zzbdVarZzs22;
            } catch (Exception e18) {
                zzenVar = zzenVarZzf;
                e10 = e18;
                zzbd zzbdVarZzs32 = this.zzc.zzs(e10, new zzbd(zzbb.zzc, zzba.zzZ, e10.getMessage()));
                zzenVar.zzb(zzbdVarZzs32);
                throw zzbdVarZzs32;
            }
        }
        return (zzsr) obj;
    }
}
