package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zztv extends zzaky<zztv, zza> implements zzame {
    private static final zztv zzc;
    private static volatile zzamp<zztv> zzd;
    private int zze;

    public static final class zza extends zzaky.zza<zztv, zza> implements zzame {
        public final zza zza(int i7) {
            zzh();
            ((zztv) this.zza).zze = i7;
            return this;
        }

        private zza() {
            super(zztv.zzc);
        }
    }

    static {
        zztv zztvVar = new zztv();
        zzc = zztvVar;
        zzaky.zza((Class<zztv>) zztv.class, zztvVar);
    }

    private zztv() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztv zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zztu.zza[i7 - 1]) {
            case 1:
                return new zztv();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zztv> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zztv.class) {
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
