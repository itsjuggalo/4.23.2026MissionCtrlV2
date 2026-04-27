package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzxt extends zzaky<zzxt, zza> implements zzame {
    private static final zzxt zzc;
    private static volatile zzamp<zzxt> zzd;
    private String zze = "";
    private zzalc<zzwz> zzf = zzaky.zzp();

    public static final class zza extends zzaky.zza<zzxt, zza> implements zzame {
        private zza() {
            super(zzxt.zzc);
        }
    }

    static {
        zzxt zzxtVar = new zzxt();
        zzc = zzxtVar;
        zzaky.zza((Class<zzxt>) zzxt.class, zzxtVar);
    }

    private zzxt() {
    }

    public static zzxt zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzxv.zza[i7 - 1]) {
            case 1:
                return new zzxt();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzwz.class});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxt> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzxt.class) {
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
