package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzun extends zzaky<zzun, zza> implements zzame {
    private static final zzun zzc;
    private static volatile zzamp<zzun> zzd;
    private int zze;
    private int zzf;

    public static final class zza extends zzaky.zza<zzun, zza> implements zzame {
        public final zza zza(int i7) {
            zzh();
            ((zzun) this.zza).zze = i7;
            return this;
        }

        private zza() {
            super(zzun.zzc);
        }
    }

    static {
        zzun zzunVar = new zzun();
        zzc = zzunVar;
        zzaky.zza((Class<zzun>) zzun.class, zzunVar);
    }

    private zzun() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    public static zzun zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzun) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzum.zza[i7 - 1]) {
            case 1:
                return new zzun();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzun> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzun.class) {
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
}
