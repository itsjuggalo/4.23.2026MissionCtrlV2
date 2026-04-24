package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzub extends zzaky<zzub, zza> implements zzame {
    private static final zzub zzc;
    private static volatile zzamp<zzub> zzd;
    private int zze;
    private int zzf;

    public static final class zza extends zzaky.zza<zzub, zza> implements zzame {
        public final zza zza(int i4) {
            zzh();
            ((zzub) this.zza).zze = i4;
            return this;
        }

        private zza() {
            super(zzub.zzc);
        }
    }

    static {
        zzub zzubVar = new zzub();
        zzc = zzubVar;
        zzaky.zza((Class<zzub>) zzub.class, zzubVar);
    }

    private zzub() {
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

    public static zzub zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzub) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzua.zza[i4 - 1]) {
            case 1:
                return new zzub();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzub> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzub.class) {
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
