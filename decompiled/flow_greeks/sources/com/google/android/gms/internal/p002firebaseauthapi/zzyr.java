package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyr extends zzalf<zzyr, zza> implements zzamo {
    private static final zzyr zzc;
    private static volatile zzamv<zzyr> zzd;
    private int zze;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class zza extends zzalf.zzb<zzyr, zza> implements zzamo {
        private zza() {
            super(zzyr.zzc);
        }
    }

    static {
        zzyr zzyrVar = new zzyr();
        zzc = zzyrVar;
        zzalf.zza((Class<zzyr>) zzyr.class, zzyrVar);
    }

    private zzyr() {
    }

    public static zzyr zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyr zza(zzajv zzajvVar, zzaku zzakuVar) {
        return (zzyr) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    public final Object zza(int i10, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzyq.zza[i10 - 1]) {
            case 1:
                return new zzyr();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyr> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyr.class) {
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
}
