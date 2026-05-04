package com.google.android.recaptcha.internal;

import bb.d0;
import io.flutter.Build;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuf extends zznd implements zzoj {
    private static final zzuf zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private zznk zzg = zznd.zzB();

    static {
        zzuf zzufVar = new zzuf();
        zzb = zzufVar;
        zznd.zzI(zzuf.class, zzufVar);
        zzls zzlsVarZzg = zzls.zzg();
        zzpw zzpwVar = zzpw.zzi;
        zznd.zzs(zzlsVarZzg, "", null, null, 490775251, zzpwVar, String.class);
        zznd.zzs(zzls.zzg(), "", null, null, 490775252, zzpwVar, String.class);
    }

    private zzuf() {
    }

    public final int zzf() {
        return this.zze;
    }

    public final int zzg() {
        return this.zzf;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u000b\u0003\u001b", new Object[]{"zze", "zzf", "zzg", zzue.class});
        }
        if (i11 == 3) {
            return new zzuf();
        }
        zzug zzugVar = null;
        if (i11 == 4) {
            return new zzuc(zzugVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        if (i11 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzuf.class) {
            try {
                zzmyVar = zzd;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzb);
                    zzd = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }

    public final List zzj() {
        return this.zzg;
    }

    public final int zzk() {
        int i10;
        switch (this.zze) {
            case 0:
                i10 = 2;
                break;
            case 1:
                i10 = 3;
                break;
            case 2:
                i10 = 4;
                break;
            case 3:
                i10 = 5;
                break;
            case 4:
                i10 = 6;
                break;
            case 5:
                i10 = 7;
                break;
            case 6:
                i10 = 8;
                break;
            case 7:
                i10 = 9;
                break;
            case 8:
                i10 = 10;
                break;
            case 9:
                i10 = 11;
                break;
            case 10:
                i10 = 12;
                break;
            case 11:
                i10 = 13;
                break;
            case 12:
                i10 = 14;
                break;
            case 13:
                i10 = 15;
                break;
            case 14:
                i10 = 16;
                break;
            case 15:
                i10 = 17;
                break;
            case 16:
                i10 = 18;
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                i10 = 19;
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                i10 = 20;
                break;
            case 19:
                i10 = 21;
                break;
            case 20:
                i10 = 22;
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                i10 = 23;
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                i10 = 24;
                break;
            case Build.API_LEVELS.API_23 /* 23 */:
                i10 = 25;
                break;
            case 24:
                i10 = 26;
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                i10 = 27;
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                i10 = 28;
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                i10 = 29;
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
                i10 = 30;
                break;
            case Build.API_LEVELS.API_29 /* 29 */:
                i10 = 31;
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
                i10 = 32;
                break;
            case Build.API_LEVELS.API_31 /* 31 */:
                i10 = 33;
                break;
            case 32:
                i10 = 34;
                break;
            case Build.API_LEVELS.API_33 /* 33 */:
                i10 = 35;
                break;
            case Build.API_LEVELS.API_34 /* 34 */:
                i10 = 36;
                break;
            case Build.API_LEVELS.API_35 /* 35 */:
                i10 = 37;
                break;
            case Build.API_LEVELS.API_36 /* 36 */:
                i10 = 38;
                break;
            case 37:
                i10 = 39;
                break;
            case 38:
                i10 = 40;
                break;
            case 39:
                i10 = 41;
                break;
            case 40:
                i10 = 42;
                break;
            case 41:
                i10 = 43;
                break;
            default:
                i10 = 0;
                break;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }
}
