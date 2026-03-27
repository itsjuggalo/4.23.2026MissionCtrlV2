package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzty extends zzaky<zzty, zza> implements zzame {
    private static final zzty zzc;
    private static volatile zzamp<zzty> zzd;
    private int zze;
    private zzajp zzf = zzajp.zza;

    public static final class zza extends zzaky.zza<zzty, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzty.zza((zzty) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzty.zzc);
        }
    }

    static {
        zzty zztyVar = new zzty();
        zzc = zztyVar;
        zzaky.zza((Class<zzty>) zzty.class, zztyVar);
    }

    private zzty() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzty> zze() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajp zzd() {
        return this.zzf;
    }

    public static zzty zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzty) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zztx.zza[i7 - 1]) {
            case 1:
                return new zzty();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzty> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzty.class) {
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

    public static /* synthetic */ void zza(zzty zztyVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zztyVar.zzf = zzajpVar;
    }
}
