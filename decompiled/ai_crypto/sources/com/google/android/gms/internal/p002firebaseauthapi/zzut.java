package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzut extends zzaky<zzut, zza> implements zzame {
    private static final zzut zzc;
    private static volatile zzamp<zzut> zzd;

    public static final class zza extends zzaky.zza<zzut, zza> implements zzame {
        private zza() {
            super(zzut.zzc);
        }
    }

    static {
        zzut zzutVar = new zzut();
        zzc = zzutVar;
        zzaky.zza((Class<zzut>) zzut.class, zzutVar);
    }

    private zzut() {
    }

    public static zzut zzb() {
        return zzc;
    }

    public static zzut zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzut) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzus.zza[i7 - 1]) {
            case 1:
                return new zzut();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzamp<zzut> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzut.class) {
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
