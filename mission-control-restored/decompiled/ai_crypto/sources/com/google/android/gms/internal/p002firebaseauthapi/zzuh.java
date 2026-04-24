package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzuh extends zzaky<zzuh, zza> implements zzame {
    private static final zzuh zzc;
    private static volatile zzamp<zzuh> zzd;
    private int zze;
    private int zzf;

    public static final class zza extends zzaky.zza<zzuh, zza> implements zzame {
        public final zza zza(int i7) {
            zzh();
            ((zzuh) this.zza).zze = i7;
            return this;
        }

        private zza() {
            super(zzuh.zzc);
        }
    }

    static {
        zzuh zzuhVar = new zzuh();
        zzc = zzuhVar;
        zzaky.zza((Class<zzuh>) zzuh.class, zzuhVar);
    }

    private zzuh() {
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

    public static zzuh zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzuh) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzug.zza[i7 - 1]) {
            case 1:
                return new zzuh();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzuh> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzuh.class) {
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
