package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzani extends zzaky<zzani, zza> implements zzame {
    private static final zzani zzc;
    private static volatile zzamp<zzani> zzd;
    private long zze;
    private int zzf;

    public static final class zza extends zzaky.zza<zzani, zza> implements zzame {
        public final zza zza(int i4) {
            if (!this.zza.zzu()) {
                zzi();
            }
            ((zzani) this.zza).zzf = i4;
            return this;
        }

        private zza() {
            super(zzani.zzc);
        }

        public final zza zza(long j4) {
            if (!this.zza.zzu()) {
                zzi();
            }
            ((zzani) this.zza).zze = j4;
            return this;
        }
    }

    static {
        zzani zzaniVar = new zzani();
        zzc = zzaniVar;
        zzaky.zza((Class<zzani>) zzani.class, zzaniVar);
    }

    private zzani() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzank.zza[i4 - 1]) {
            case 1:
                return new zzani();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzani> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzani.class) {
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
