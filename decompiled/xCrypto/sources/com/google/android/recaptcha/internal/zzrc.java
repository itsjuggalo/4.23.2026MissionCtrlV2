package com.google.android.recaptcha.internal;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class zzrc extends zznd implements zzoj {
    private static final zzrc zzb;
    private static volatile zzoq zzd;
    private int zze;
    private Object zzg;
    private int zzh;
    private int zzi;
    private long zzn;
    private zzml zzo;
    private int zzp;
    private zzqq zzq;
    private zzro zzr;
    private zzpj zzt;
    private zzml zzu;
    private int zzw;
    private int zzf = 0;
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzs = "";
    private zzni zzv = zznd.zzy();

    static {
        zzrc zzrcVar = new zzrc();
        zzb = zzrcVar;
        zznd.zzI(zzrc.class, zzrcVar);
    }

    private zzrc() {
    }

    public static /* synthetic */ void zzO(zzrc zzrcVar, int i4) {
        zzni zzniVar = zzrcVar.zzv;
        if (!zzniVar.zzc()) {
            zzrcVar.zzv = zznd.zzz(zzniVar);
        }
        zzrcVar.zzv.zzh(0);
    }

    public static /* synthetic */ void zzP(zzrc zzrcVar, String str) {
        str.getClass();
        zzrcVar.zzj = str;
    }

    public static /* synthetic */ void zzR(zzrc zzrcVar, zzqq zzqqVar) {
        zzrcVar.zzq = zzqqVar;
        zzrcVar.zze |= 2;
    }

    public static /* synthetic */ void zzS(zzrc zzrcVar, String str) {
        str.getClass();
        zzrcVar.zzk = str;
    }

    public static /* synthetic */ void zzT(zzrc zzrcVar, zzro zzroVar) {
        zzroVar.getClass();
        zzrcVar.zzr = zzroVar;
        zzrcVar.zze |= 4;
    }

    public static /* synthetic */ void zzU(zzrc zzrcVar, int i4) {
        zzrcVar.zze |= 32;
        zzrcVar.zzw = i4;
    }

    public static /* synthetic */ void zzab(zzrc zzrcVar, int i4) {
        if (i4 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzrcVar.zzi = i4 - 2;
    }

    public static zzra zzi() {
        return (zzra) zzb.zzq();
    }

    public static zzrc zzk() {
        return zzb;
    }

    public static zzrc zzl(byte[] bArr) {
        return (zzrc) zznd.zzx(zzb, bArr);
    }

    public final String zzM() {
        return this.zzk;
    }

    public final String zzN() {
        return this.zzl;
    }

    public final boolean zzX() {
        return (this.zze & 2) != 0;
    }

    public final int zzY() {
        int i4;
        switch (this.zzh) {
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
            default:
                i4 = 0;
                break;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public final int zzZ() {
        int i4 = this.zzp;
        int i5 = i4 != 0 ? i4 != 1 ? i4 != 2 ? 0 : 4 : 3 : 2;
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }

    @Deprecated
    public final long zzf() {
        return this.zzn;
    }

    public final zzqq zzg() {
        zzqq zzqqVar = this.zzq;
        return zzqqVar == null ? zzqq.zzj() : zzqqVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i4, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zznd.zzF(zzb, "\u0000\u0011\u0001\u0001\u0001\u0013\u0011\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004\f\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bȈ\tȈ\nဉ\u0000\u000bဉ\u0003\rဉ\u0004\u000eȈ\u000f<\u0000\u0011'\u0012င\u0005\u0013\f", new Object[]{"zzg", "zzf", "zze", "zzh", "zzk", "zzn", "zzp", "zzq", "zzr", "zzs", "zzl", "zzm", "zzo", "zzt", "zzu", "zzj", zzqg.class, "zzv", "zzw", "zzi"});
        }
        if (i5 == 3) {
            return new zzrc();
        }
        zzrb zzrbVar = null;
        if (i5 == 4) {
            return new zzra(zzrbVar);
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
        synchronized (zzrc.class) {
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
}
