package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzuk extends zzaky<zzuk, zza> implements zzame {
    private static final zzuk zzc;
    private static volatile zzamp<zzuk> zzd;
    private int zze;
    private zzajp zzf = zzajp.zza;

    public static final class zza extends zzaky.zza<zzuk, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzuk.zza((zzuk) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzuk.zzc);
        }
    }

    static {
        zzuk zzukVar = new zzuk();
        zzc = zzukVar;
        zzaky.zza((Class<zzuk>) zzuk.class, zzukVar);
    }

    private zzuk() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzuk> zze() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajp zzd() {
        return this.zzf;
    }

    public static zzuk zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzuk) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzuj.zza[i4 - 1]) {
            case 1:
                return new zzuk();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzuk> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzuk.class) {
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

    public static /* synthetic */ void zza(zzuk zzukVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzukVar.zzf = zzajpVar;
    }
}
