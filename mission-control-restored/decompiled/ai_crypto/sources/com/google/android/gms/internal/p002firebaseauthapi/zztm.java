package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zztm extends zzaky<zztm, zza> implements zzame {
    private static final zztm zzc;
    private static volatile zzamp<zztm> zzd;
    private int zze;

    public static final class zza extends zzaky.zza<zztm, zza> implements zzame {
        public final zza zza(int i7) {
            zzh();
            ((zztm) this.zza).zze = i7;
            return this;
        }

        private zza() {
            super(zztm.zzc);
        }
    }

    static {
        zztm zztmVar = new zztm();
        zzc = zztmVar;
        zzaky.zza((Class<zztm>) zztm.class, zztmVar);
    }

    private zztm() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztm zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zztl.zza[i7 - 1]) {
            case 1:
                return new zztm();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zztm> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zztm.class) {
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
