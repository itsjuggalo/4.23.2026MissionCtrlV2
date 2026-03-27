package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzxz extends zzaky<zzxz, zza> implements zzame {
    private static final zzxz zzc;
    private static volatile zzamp<zzxz> zzd;
    private int zze;
    private int zzf;
    private zzyc zzg;

    public static final class zza extends zzaky.zza<zzxz, zza> implements zzame {
        public final zza zza(zzyc zzycVar) {
            zzh();
            zzxz.zza((zzxz) this.zza, zzycVar);
            return this;
        }

        private zza() {
            super(zzxz.zzc);
        }
    }

    static {
        zzxz zzxzVar = new zzxz();
        zzc = zzxzVar;
        zzaky.zza((Class<zzxz>) zzxz.class, zzxzVar);
    }

    private zzxz() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzyc zzd() {
        zzyc zzycVar = this.zzg;
        return zzycVar == null ? zzyc.zzd() : zzycVar;
    }

    public static zzxz zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzxz) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzyb.zza[i4 - 1]) {
            case 1:
                return new zzxz();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxz> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzxz.class) {
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

    public static /* synthetic */ void zza(zzxz zzxzVar, zzyc zzycVar) {
        zzycVar.getClass();
        zzxzVar.zzg = zzycVar;
        zzxzVar.zze |= 1;
    }
}
