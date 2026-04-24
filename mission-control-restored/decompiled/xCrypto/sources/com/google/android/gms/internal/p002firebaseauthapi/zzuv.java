package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzuv extends zzaky<zzuv, zza> implements zzame {
    private static final zzuv zzc;
    private static volatile zzamp<zzuv> zzd;
    private int zze;
    private zzww zzf;

    public static final class zza extends zzaky.zza<zzuv, zza> implements zzame {
        public final zza zza(zzww zzwwVar) {
            zzh();
            zzuv.zza((zzuv) this.zza, zzwwVar);
            return this;
        }

        private zza() {
            super(zzuv.zzc);
        }
    }

    static {
        zzuv zzuvVar = new zzuv();
        zzc = zzuvVar;
        zzaky.zza((Class<zzuv>) zzuv.class, zzuvVar);
    }

    private zzuv() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzuv zzc() {
        return zzc;
    }

    public final zzww zzd() {
        zzww zzwwVar = this.zzf;
        return zzwwVar == null ? zzww.zzc() : zzwwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzux.zza[i4 - 1]) {
            case 1:
                return new zzuv();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzuv> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzuv.class) {
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

    public static /* synthetic */ void zza(zzuv zzuvVar, zzww zzwwVar) {
        zzwwVar.getClass();
        zzuvVar.zzf = zzwwVar;
        zzuvVar.zze |= 1;
    }
}
