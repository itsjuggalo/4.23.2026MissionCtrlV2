package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzxr extends zzaky<zzxr, zza> implements zzame {
    private static final zzxr zzc;
    private static volatile zzamp<zzxr> zzd;
    private int zze;
    private String zzf = "";
    private zzww zzg;

    public static final class zza extends zzaky.zza<zzxr, zza> implements zzame {
        public final zza zza(zzww zzwwVar) {
            zzh();
            zzxr.zza((zzxr) this.zza, zzwwVar);
            return this;
        }

        private zza() {
            super(zzxr.zzc);
        }

        public final zza zza(String str) {
            zzh();
            zzxr.zza((zzxr) this.zza, str);
            return this;
        }
    }

    static {
        zzxr zzxrVar = new zzxr();
        zzc = zzxrVar;
        zzaky.zza((Class<zzxr>) zzxr.class, zzxrVar);
    }

    private zzxr() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzxr zzd() {
        return zzc;
    }

    public final zzww zza() {
        zzww zzwwVar = this.zzg;
        return zzwwVar == null ? zzww.zzc() : zzwwVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public static zzxr zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzxr) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzxq.zza[i4 - 1]) {
            case 1:
                return new zzxr();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxr> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzxr.class) {
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

    public static /* synthetic */ void zza(zzxr zzxrVar, zzww zzwwVar) {
        zzwwVar.getClass();
        zzxrVar.zzg = zzwwVar;
        zzxrVar.zze |= 1;
    }

    public static /* synthetic */ void zza(zzxr zzxrVar, String str) {
        str.getClass();
        zzxrVar.zzf = str;
    }
}
