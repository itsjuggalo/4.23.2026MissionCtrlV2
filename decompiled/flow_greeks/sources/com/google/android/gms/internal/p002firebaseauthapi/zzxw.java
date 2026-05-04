package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxw extends zzalf<zzxw, zza> implements zzamo {
    private static final zzxw zzc;
    private static volatile zzamv<zzxw> zzd;
    private int zze;
    private String zzf = "";
    private zzxb zzg;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class zza extends zzalf.zzb<zzxw, zza> implements zzamo {
        public final zza zza(zzxb zzxbVar) {
            zzg();
            zzxw.zza((zzxw) this.zza, zzxbVar);
            return this;
        }

        private zza() {
            super(zzxw.zzc);
        }

        public final zza zza(String str) {
            zzg();
            zzxw.zza((zzxw) this.zza, str);
            return this;
        }
    }

    static {
        zzxw zzxwVar = new zzxw();
        zzc = zzxwVar;
        zzalf.zza((Class<zzxw>) zzxw.class, zzxwVar);
    }

    private zzxw() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzxw zzd() {
        return zzc;
    }

    public final zzxb zza() {
        zzxb zzxbVar = this.zzg;
        return zzxbVar == null ? zzxb.zzc() : zzxbVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public static zzxw zza(zzajv zzajvVar, zzaku zzakuVar) {
        return (zzxw) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    public final Object zza(int i10, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzxy.zza[i10 - 1]) {
            case 1:
                return new zzxw();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxw> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzxw.class) {
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

    public static /* synthetic */ void zza(zzxw zzxwVar, zzxb zzxbVar) {
        zzxbVar.getClass();
        zzxwVar.zzg = zzxbVar;
        zzxwVar.zze |= 1;
    }

    public static /* synthetic */ void zza(zzxw zzxwVar, String str) {
        str.getClass();
        zzxwVar.zzf = str;
    }
}
