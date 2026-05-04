package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zztx extends zzalf<zztx, zza> implements zzamo {
    private static final zztx zzc;
    private static volatile zzamv<zztx> zzd;
    private int zze;
    private zzua zzf;
    private int zzg;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class zza extends zzalf.zzb<zztx, zza> implements zzamo {
        public final zza zza(int i10) {
            zzg();
            ((zztx) this.zza).zzg = i10;
            return this;
        }

        private zza() {
            super(zztx.zzc);
        }

        public final zza zza(zzua zzuaVar) {
            zzg();
            zztx.zza((zztx) this.zza, zzuaVar);
            return this;
        }
    }

    static {
        zztx zztxVar = new zztx();
        zzc = zztxVar;
        zzalf.zza((Class<zztx>) zztx.class, zztxVar);
    }

    private zztx() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzua zzd() {
        zzua zzuaVar = this.zzf;
        return zzuaVar == null ? zzua.zzd() : zzuaVar;
    }

    public static zztx zza(zzajv zzajvVar, zzaku zzakuVar) {
        return (zztx) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    public final Object zza(int i10, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zztz.zza[i10 - 1]) {
            case 1:
                return new zztx();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztx> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zztx.class) {
                    try {
                        zzaVar = zzd;
                        if (zzaVar == null) {
                            zzaVar = new zzalf.zza(zzc);
                            zzd = zzaVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public static /* synthetic */ void zza(zztx zztxVar, zzua zzuaVar) {
        zzuaVar.getClass();
        zztxVar.zzf = zzuaVar;
        zztxVar.zze |= 1;
    }
}
