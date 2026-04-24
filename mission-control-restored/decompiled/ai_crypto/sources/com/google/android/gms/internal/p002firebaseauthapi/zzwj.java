package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzwj extends zzaky<zzwj, zza> implements zzame {
    private static final zzwj zzc;
    private static volatile zzamp<zzwj> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public static final class zza extends zzaky.zza<zzwj, zza> implements zzame {
        public final zza zza(zzwb zzwbVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzwbVar);
            return this;
        }

        private zza() {
            super(zzwj.zzc);
        }

        public final zza zza(zzwe zzweVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzweVar);
            return this;
        }

        public final zza zza(zzwd zzwdVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzwdVar);
            return this;
        }
    }

    static {
        zzwj zzwjVar = new zzwj();
        zzc = zzwjVar;
        zzaky.zza((Class<zzwj>) zzwj.class, zzwjVar);
    }

    private zzwj() {
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwj zzf() {
        return zzc;
    }

    public final zzwb zza() {
        zzwb zzwbVarZza = zzwb.zza(this.zzg);
        return zzwbVarZza == null ? zzwb.UNRECOGNIZED : zzwbVarZza;
    }

    public final zzwe zzb() {
        zzwe zzweVarZza = zzwe.zza(this.zzf);
        return zzweVarZza == null ? zzwe.UNRECOGNIZED : zzweVarZza;
    }

    public final zzwd zzc() {
        zzwd zzwdVarZza = zzwd.zza(this.zze);
        return zzwdVarZza == null ? zzwd.UNRECOGNIZED : zzwdVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzwi.zza[i7 - 1]) {
            case 1:
                return new zzwj();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzwj> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzwj.class) {
                        try {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzaky.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return zzcVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwb zzwbVar) {
        zzwjVar.zzg = zzwbVar.zza();
    }

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwe zzweVar) {
        zzwjVar.zzf = zzweVar.zza();
    }

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwd zzwdVar) {
        zzwjVar.zze = zzwdVar.zza();
    }
}
