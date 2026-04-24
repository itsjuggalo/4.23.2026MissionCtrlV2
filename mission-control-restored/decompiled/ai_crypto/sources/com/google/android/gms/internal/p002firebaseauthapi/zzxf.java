package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
public final class zzxf extends zzaky<zzxf, zzb> implements zzame {
    private static final zzxf zzc;
    private static volatile zzamp<zzxf> zzd;
    private int zze;
    private zzalc<zza> zzf = zzaky.zzp();

    public static final class zza extends zzaky<zza, C0184zza> implements zzame {
        private static final zza zzc;
        private static volatile zzamp<zza> zzd;
        private String zze = "";
        private int zzf;
        private int zzg;
        private int zzh;

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase-auth-api.zzxf$zza$zza, reason: collision with other inner class name */
        public static final class C0184zza extends zzaky.zza<zza, C0184zza> implements zzame {
            public final C0184zza zza(int i7) {
                zzh();
                ((zza) this.zza).zzg = i7;
                return this;
            }

            private C0184zza() {
                super(zza.zzc);
            }

            public final C0184zza zza(zzxu zzxuVar) {
                zzh();
                zza.zza((zza) this.zza, zzxuVar);
                return this;
            }

            public final C0184zza zza(zzwt zzwtVar) {
                zzh();
                zza.zza((zza) this.zza, zzwtVar);
                return this;
            }

            public final C0184zza zza(String str) {
                zzh();
                zza.zza((zza) this.zza, str);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzaky.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static C0184zza zza() {
            return (C0184zza) zzc.zzm();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
        public final Object zza(int i7, Object obj, Object obj2) {
            switch (zzxe.zza[i7 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0184zza();
                case 3:
                    return zzaky.zza(zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzamp<zza> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
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

        public static /* synthetic */ void zza(zza zzaVar, zzxu zzxuVar) {
            zzaVar.zzh = zzxuVar.zza();
        }

        public static /* synthetic */ void zza(zza zzaVar, zzwt zzwtVar) {
            zzaVar.zzf = zzwtVar.zza();
        }

        public static /* synthetic */ void zza(zza zzaVar, String str) {
            str.getClass();
            zzaVar.zze = str;
        }
    }

    public static final class zzb extends zzaky.zza<zzxf, zzb> implements zzame {
        public final zzb zza(zza zzaVar) {
            zzh();
            zzxf.zza((zzxf) this.zza, zzaVar);
            return this;
        }

        private zzb() {
            super(zzxf.zzc);
        }

        public final zzb zza(int i7) {
            zzh();
            ((zzxf) this.zza).zze = i7;
            return this;
        }
    }

    static {
        zzxf zzxfVar = new zzxf();
        zzc = zzxfVar;
        zzaky.zza((Class<zzxf>) zzxf.class, zzxfVar);
    }

    private zzxf() {
    }

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i7, Object obj, Object obj2) {
        switch (zzxe.zza[i7 - 1]) {
            case 1:
                return new zzxf();
            case 2:
                return new zzb();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxf> zzcVar = zzd;
                if (zzcVar == null) {
                    synchronized (zzxf.class) {
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

    public static /* synthetic */ void zza(zzxf zzxfVar, zza zzaVar) {
        zzaVar.getClass();
        zzalc<zza> zzalcVar = zzxfVar.zzf;
        if (!zzalcVar.zzc()) {
            zzxfVar.zzf = zzaky.zza(zzalcVar);
        }
        zzxfVar.zzf.add(zzaVar);
    }
}
