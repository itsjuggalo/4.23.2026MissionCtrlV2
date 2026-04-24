package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzyc extends zzaky<zzyc, zza> implements zzame {
    private static final zzyc zzc;
    private static volatile zzamp<zzyc> zzd;
    private int zze;

    public static final class zza extends zzaky.zza<zzyc, zza> implements zzame {
        public final zza zza(int i4) {
            zzh();
            ((zzyc) this.zza).zze = i4;
            return this;
        }

        private zza() {
            super(zzyc.zzc);
        }
    }

    static {
        zzyc zzycVar = new zzyc();
        zzc = zzycVar;
        zzaky.zza((Class<zzyc>) zzyc.class, zzycVar);
    }

    private zzyc() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzyc zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzye.zza[i4 - 1]) {
            case 1:
                return new zzyc();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzyc> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzyc.class) {
                    try {
                        zzcVar = zzd;
                        if (zzcVar == null) {
                            zzcVar = new zzaky.zzc(zzc);
                            zzd = zzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzcVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }
}
