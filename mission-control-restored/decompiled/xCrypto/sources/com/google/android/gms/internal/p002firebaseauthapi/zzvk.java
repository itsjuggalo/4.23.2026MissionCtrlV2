package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzvk extends zzaky<zzvk, zza> implements zzame {
    private static final zzvk zzc;
    private static volatile zzamp<zzvk> zzd;
    private int zze;
    private int zzf;
    private zzajp zzg = zzajp.zza;

    public static final class zza extends zzaky.zza<zzvk, zza> implements zzame {
        public final zza zza(zzvn zzvnVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzvnVar);
            return this;
        }

        private zza() {
            super(zzvk.zzc);
        }

        public final zza zza(zzvt zzvtVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzvtVar);
            return this;
        }

        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzajpVar);
            return this;
        }
    }

    static {
        zzvk zzvkVar = new zzvk();
        zzc = zzvkVar;
        zzaky.zza((Class<zzvk>) zzvk.class, zzvkVar);
    }

    private zzvk() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvk zzc() {
        return zzc;
    }

    public final zzvn zzd() {
        zzvn zzvnVarZza = zzvn.zza(this.zze);
        return zzvnVarZza == null ? zzvn.UNRECOGNIZED : zzvnVarZza;
    }

    public final zzvt zze() {
        zzvt zzvtVarZza = zzvt.zza(this.zzf);
        return zzvtVarZza == null ? zzvt.UNRECOGNIZED : zzvtVarZza;
    }

    public final zzajp zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i4, Object obj, Object obj2) {
        zzamp zzcVar;
        switch (zzvm.zza[i4 - 1]) {
            case 1:
                return new zzvk();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzvk> zzampVar = zzd;
                if (zzampVar != null) {
                    return zzampVar;
                }
                synchronized (zzvk.class) {
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

    public static /* synthetic */ void zza(zzvk zzvkVar, zzvn zzvnVar) {
        zzvkVar.zze = zzvnVar.zza();
    }

    public static /* synthetic */ void zza(zzvk zzvkVar, zzvt zzvtVar) {
        zzvkVar.zzf = zzvtVar.zza();
    }

    public static /* synthetic */ void zza(zzvk zzvkVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzvkVar.zzg = zzajpVar;
    }
}
