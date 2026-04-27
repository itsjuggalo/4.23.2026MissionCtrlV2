package com.google.android.recaptcha.internal;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import java.util.List;
import p2.C1698D;

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
    public final Object zzh(int i4, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zznd.zzF(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u000b\u0003\u001b", new Object[]{"zze", "zzf", "zzg", zzue.class});
        }
        if (i5 == 3) {
            return new zzuf();
        }
        zzug zzugVar = null;
        if (i5 == 4) {
            return new zzuc(zzugVar);
        }
        if (i5 == 5) {
            return zzb;
        }
        if (i5 != 6) {
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
        int i4;
        switch (this.zze) {
            case 0:
                i4 = 2;
                break;
            case 1:
                i4 = 3;
                break;
            case 2:
                i4 = 4;
                break;
            case 3:
                i4 = 5;
                break;
            case 4:
                i4 = 6;
                break;
            case 5:
                i4 = 7;
                break;
            case 6:
                i4 = 8;
                break;
            case 7:
                i4 = 9;
                break;
            case 8:
                i4 = 10;
                break;
            case 9:
                i4 = 11;
                break;
            case 10:
                i4 = 12;
                break;
            case 11:
                i4 = 13;
                break;
            case 12:
                i4 = 14;
                break;
            case 13:
                i4 = 15;
                break;
            case 14:
                i4 = 16;
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                i4 = 17;
                break;
            case 16:
                i4 = 18;
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                i4 = 19;
                break;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                i4 = 20;
                break;
            case 19:
                i4 = 21;
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                i4 = 22;
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                i4 = 23;
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                i4 = 24;
                break;
            case Build.API_LEVELS.API_23 /* 23 */:
                i4 = 25;
                break;
            case 24:
                i4 = 26;
                break;
            case 25:
                i4 = 27;
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                i4 = 28;
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                i4 = 29;
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
                i4 = 30;
                break;
            case Build.API_LEVELS.API_29 /* 29 */:
                i4 = 31;
                break;
            case 30:
                i4 = 32;
                break;
            case Build.API_LEVELS.API_31 /* 31 */:
                i4 = 33;
                break;
            case 32:
                i4 = 34;
                break;
            case Build.API_LEVELS.API_33 /* 33 */:
                i4 = 35;
                break;
            case Build.API_LEVELS.API_34 /* 34 */:
                i4 = 36;
                break;
            case Build.API_LEVELS.API_35 /* 35 */:
                i4 = 37;
                break;
            case Build.API_LEVELS.API_36 /* 36 */:
                i4 = 38;
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                i4 = 39;
                break;
            case 38:
                i4 = 40;
                break;
            case 39:
                i4 = 41;
                break;
            case 40:
                i4 = 42;
                break;
            case 41:
                i4 = 43;
                break;
            default:
                i4 = 0;
                break;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }
}
