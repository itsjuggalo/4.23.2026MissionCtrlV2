package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.L;
import t3.V0;
import t3.X0;

/* JADX INFO: loaded from: classes.dex */
final class zzdg extends l implements o {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzdt zzdtVar, String str, long j4, zzsp zzspVar, e eVar) {
        super(2, eVar);
        this.zzc = zzdtVar;
        this.zzd = str;
        this.zze = j4;
        this.zzf = zzspVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        Exception e4;
        V0 e5;
        zzbd e6;
        Object objE = AbstractC0787c.e();
        if (this.zzb != 0) {
            zzenVar = (zzen) this.zza;
            try {
                q.b(obj);
            } catch (zzbd e7) {
                e6 = e7;
                zzbd zzbdVarZzs = this.zzc.zzs(e6, e6);
                zzenVar.zzb(zzbdVarZzs);
                throw zzbdVarZzs;
            } catch (V0 e8) {
                e5 = e8;
                zzbd zzbdVarZzs2 = this.zzc.zzs(e5, new zzbd(zzbb.zzc, zzba.zzb, e5.getMessage()));
                zzenVar.zzb(zzbdVarZzs2);
                throw zzbdVarZzs2;
            } catch (Exception e9) {
                e4 = e9;
                zzbd zzbdVarZzs3 = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzZ, e4.getMessage()));
                zzenVar.zzb(zzbdVarZzs3);
                throw zzbdVarZzs3;
            }
        } else {
            q.b(obj);
            zzen zzenVarZzf = this.zzc.zzu(this.zzd).zzf(28);
            try {
                long j4 = this.zze;
                zzdf zzdfVar = new zzdf(this.zzc, this.zzf, zzenVarZzf, null);
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objC = X0.c(j4, zzdfVar, this);
                if (objC == objE) {
                    return objE;
                }
                zzenVar = zzenVarZzf;
                obj = objC;
            } catch (zzbd e10) {
                zzenVar = zzenVarZzf;
                e6 = e10;
                zzbd zzbdVarZzs4 = this.zzc.zzs(e6, e6);
                zzenVar.zzb(zzbdVarZzs4);
                throw zzbdVarZzs4;
            } catch (V0 e11) {
                zzenVar = zzenVarZzf;
                e5 = e11;
                zzbd zzbdVarZzs22 = this.zzc.zzs(e5, new zzbd(zzbb.zzc, zzba.zzb, e5.getMessage()));
                zzenVar.zzb(zzbdVarZzs22);
                throw zzbdVarZzs22;
            } catch (Exception e12) {
                zzenVar = zzenVarZzf;
                e4 = e12;
                zzbd zzbdVarZzs32 = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzZ, e4.getMessage()));
                zzenVar.zzb(zzbdVarZzs32);
                throw zzbdVarZzs32;
            }
        }
        return (zzsr) obj;
    }
}
