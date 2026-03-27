package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzxl extends zzaky<zzxl, zza> implements zzame {
    private static final zzxl zzc;
    private static volatile zzamp<zzxl> zzd;
    private String zze = "";

    public static final class zza extends zzaky.zza<zzxl, zza> implements zzame {
        public final zza zza(String str) {
            zzh();
            zzxl.zza((zzxl) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxl.zzc);
        }
    }

    static {
        zzxl zzxlVar = new zzxl();
        zzc = zzxlVar;
        zzaky.zza((Class<zzxl>) zzxl.class, zzxlVar);
    }

    private zzxl() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxl zzc() {
        return zzc;
    }

    public final String zzd() {
        return this.zze;
    }

    public static zzxl zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzxl) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzxk.zza[i7 - 1]) {
            case 1:
                return new zzxl();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxl> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzxl.class) {
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

    public static /* synthetic */ void zza(zzxl zzxlVar, String str) {
        str.getClass();
        zzxlVar.zze = str;
    }
}
