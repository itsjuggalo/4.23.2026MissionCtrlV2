package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzuy extends zzaky<zzuy, zza> implements zzame {
    private static final zzuy zzc;
    private static volatile zzamp<zzuy> zzd;
    private int zze;
    private zzvb zzf;

    public static final class zza extends zzaky.zza<zzuy, zza> implements zzame {
        public final zza zza(zzvb zzvbVar) {
            zzh();
            zzuy.zza((zzuy) this.zza, zzvbVar);
            return this;
        }

        private zza() {
            super(zzuy.zzc);
        }
    }

    static {
        zzuy zzuyVar = new zzuy();
        zzc = zzuyVar;
        zzaky.zza((Class<zzuy>) zzuy.class, zzuyVar);
    }

    private zzuy() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzvb zzc() {
        zzvb zzvbVar = this.zzf;
        return zzvbVar == null ? zzvb.zze() : zzvbVar;
    }

    public static zzuy zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzuy) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzva.zza[i4 - 1]) {
            case 1:
                return new zzuy();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzuy> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzuy.class) {
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

    public static /* synthetic */ void zza(zzuy zzuyVar, zzvb zzvbVar) {
        zzvbVar.getClass();
        zzuyVar.zzf = zzvbVar;
        zzuyVar.zze |= 1;
    }
}
