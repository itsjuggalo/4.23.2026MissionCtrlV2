package com.google.android.gms.internal.play_billing;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import p2.C1698D;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzip<T> implements zzix<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzjq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzim zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzjj zzl;
    private final zzgx zzm;

    private zzip(int[] iArr, Object[] objArr, int i4, int i5, zzim zzimVar, boolean z4, int[] iArr2, int i6, int i7, zzir zzirVar, zzhz zzhzVar, zzjj zzjjVar, zzgx zzgxVar, zzih zzihVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        boolean z5 = false;
        if (zzgxVar != null && (zzimVar instanceof zzhh)) {
            z5 = true;
        }
        this.zzh = z5;
        this.zzi = iArr2;
        this.zzj = i6;
        this.zzk = i7;
        this.zzl = zzjjVar;
        this.zzm = zzgxVar;
        this.zzg = zzimVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i4) {
        if (zzI(obj2, i4)) {
            int iZzs = zzs(i4) & 1048575;
            Unsafe unsafe = zzb;
            long j4 = iZzs;
            Object object = unsafe.getObject(obj2, j4);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
            }
            zzix zzixVarZzv = zzv(i4);
            if (!zzI(obj, i4)) {
                if (zzL(object)) {
                    Object objZze = zzixVarZzv.zze();
                    zzixVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j4, objZze);
                } else {
                    unsafe.putObject(obj, j4, object);
                }
                zzD(obj, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, j4);
            if (!zzL(object2)) {
                Object objZze2 = zzixVarZzv.zze();
                zzixVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j4, objZze2);
                object2 = objZze2;
            }
            zzixVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i4) {
        int i5 = this.zzc[i4];
        if (zzM(obj2, i5, i4)) {
            int iZzs = zzs(i4) & 1048575;
            Unsafe unsafe = zzb;
            long j4 = iZzs;
            Object object = unsafe.getObject(obj2, j4);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
            }
            zzix zzixVarZzv = zzv(i4);
            if (!zzM(obj, i5, i4)) {
                if (zzL(object)) {
                    Object objZze = zzixVarZzv.zze();
                    zzixVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j4, objZze);
                } else {
                    unsafe.putObject(obj, j4, object);
                }
                zzE(obj, i5, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, j4);
            if (!zzL(object2)) {
                Object objZze2 = zzixVarZzv.zze();
                zzixVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j4, objZze2);
                object2 = objZze2;
            }
            zzixVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i4) {
        int iZzp = zzp(i4);
        long j4 = 1048575 & iZzp;
        if (j4 == 1048575) {
            return;
        }
        zzjq.zzq(obj, j4, (1 << (iZzp >>> 20)) | zzjq.zzc(obj, j4));
    }

    private final void zzE(Object obj, int i4, int i5) {
        zzjq.zzq(obj, zzp(i5) & 1048575, i4);
    }

    private final void zzF(Object obj, int i4, Object obj2) {
        zzb.putObject(obj, zzs(i4) & 1048575, obj2);
        zzD(obj, i4);
    }

    private final void zzG(Object obj, int i4, int i5, Object obj2) {
        zzb.putObject(obj, zzs(i5) & 1048575, obj2);
        zzE(obj, i4, i5);
    }

    private final boolean zzH(Object obj, Object obj2, int i4) {
        return zzI(obj, i4) == zzI(obj2, i4);
    }

    private final boolean zzI(Object obj, int i4) {
        int iZzp = zzp(i4);
        long j4 = iZzp & 1048575;
        if (j4 != 1048575) {
            return (zzjq.zzc(obj, j4) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i4);
        long j5 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzjq.zza(obj, j5)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzjq.zzb(obj, j5)) != 0;
            case 2:
                return zzjq.zzd(obj, j5) != 0;
            case 3:
                return zzjq.zzd(obj, j5) != 0;
            case 4:
                return zzjq.zzc(obj, j5) != 0;
            case 5:
                return zzjq.zzd(obj, j5) != 0;
            case 6:
                return zzjq.zzc(obj, j5) != 0;
            case 7:
                return zzjq.zzw(obj, j5);
            case 8:
                Object objZzf = zzjq.zzf(obj, j5);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzgk) {
                    return !zzgk.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzjq.zzf(obj, j5) != null;
            case 10:
                return !zzgk.zzb.equals(zzjq.zzf(obj, j5));
            case 11:
                return zzjq.zzc(obj, j5) != 0;
            case 12:
                return zzjq.zzc(obj, j5) != 0;
            case 13:
                return zzjq.zzc(obj, j5) != 0;
            case 14:
                return zzjq.zzd(obj, j5) != 0;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return zzjq.zzc(obj, j5) != 0;
            case 16:
                return zzjq.zzd(obj, j5) != 0;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzjq.zzf(obj, j5) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i4, int i5, int i6, int i7) {
        return i5 == 1048575 ? zzI(obj, i4) : (i6 & i7) != 0;
    }

    private static boolean zzK(Object obj, int i4, zzix zzixVar) {
        return zzixVar.zzk(zzjq.zzf(obj, i4 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzhk) {
            return ((zzhk) obj).zzA();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i4, int i5) {
        return zzjq.zzc(obj, (long) (zzp(i5) & 1048575)) == i4;
    }

    private static boolean zzN(Object obj, long j4) {
        return ((Boolean) zzjq.zzf(obj, j4)).booleanValue();
    }

    private static final void zzO(int i4, Object obj, zzjw zzjwVar) {
        if (obj instanceof String) {
            zzjwVar.zzG(i4, (String) obj);
        } else {
            zzjwVar.zzd(i4, (zzgk) obj);
        }
    }

    public static zzjk zzd(Object obj) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVar = zzhkVar.zzc;
        if (zzjkVar != zzjk.zzc()) {
            return zzjkVar;
        }
        zzjk zzjkVarZzf = zzjk.zzf();
        zzhkVar.zzc = zzjkVarZzf;
        return zzjkVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.play_billing.zzip zzl(java.lang.Class r32, com.google.android.gms.internal.play_billing.zzij r33, com.google.android.gms.internal.play_billing.zzir r34, com.google.android.gms.internal.play_billing.zzhz r35, com.google.android.gms.internal.play_billing.zzjj r36, com.google.android.gms.internal.play_billing.zzgx r37, com.google.android.gms.internal.play_billing.zzih r38) {
        /*
            Method dump skipped, instruction units count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzij, com.google.android.gms.internal.play_billing.zzir, com.google.android.gms.internal.play_billing.zzhz, com.google.android.gms.internal.play_billing.zzjj, com.google.android.gms.internal.play_billing.zzgx, com.google.android.gms.internal.play_billing.zzih):com.google.android.gms.internal.play_billing.zzip");
    }

    private static double zzm(Object obj, long j4) {
        return ((Double) zzjq.zzf(obj, j4)).doubleValue();
    }

    private static float zzn(Object obj, long j4) {
        return ((Float) zzjq.zzf(obj, j4)).floatValue();
    }

    private static int zzo(Object obj, long j4) {
        return ((Integer) zzjq.zzf(obj, j4)).intValue();
    }

    private final int zzp(int i4) {
        return this.zzc[i4 + 2];
    }

    private final int zzq(int i4, int i5) {
        int length = (this.zzc.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int i8 = this.zzc[i7];
            if (i4 == i8) {
                return i7;
            }
            if (i4 < i8) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i4) {
        return (i4 >>> 20) & 255;
    }

    private final int zzs(int i4) {
        return this.zzc[i4 + 1];
    }

    private static long zzt(Object obj, long j4) {
        return ((Long) zzjq.zzf(obj, j4)).longValue();
    }

    private final zzhm zzu(int i4) {
        int i5 = i4 / 3;
        return (zzhm) this.zzd[i5 + i5 + 1];
    }

    private final zzix zzv(int i4) {
        Object[] objArr = this.zzd;
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzix zzixVar = (zzix) objArr[i6];
        if (zzixVar != null) {
            return zzixVar;
        }
        zzix zzixVarZzb = zziu.zza().zzb((Class) objArr[i6 + 1]);
        this.zzd[i6] = zzixVarZzb;
        return zzixVarZzb;
    }

    private final Object zzw(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    private final Object zzx(Object obj, int i4) {
        zzix zzixVarZzv = zzv(i4);
        int iZzs = zzs(i4) & 1048575;
        if (!zzI(obj, i4)) {
            return zzixVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzixVarZzv.zze();
        if (object != null) {
            zzixVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i4, int i5) {
        zzix zzixVarZzv = zzv(i5);
        if (!zzM(obj, i4, i5)) {
            return zzixVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i5) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzixVarZzv.zze();
        if (object != null) {
            zzixVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x04bb A[PHI: r17
      0x04bb: PHI (r17v34 int) = (r17v27 int), (r17v35 int) binds: [B:214:0x0595, B:180:0x04b9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.play_billing.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 2180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zzb(Object obj) {
        int i4;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzc.length; i7 += 3) {
            int iZzs = zzs(i7);
            int[] iArr = this.zzc;
            int i8 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i9 = iArr[i7];
            long j4 = i8;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i4 = i6 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzjq.zza(obj, j4));
                    byte[] bArr = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 1:
                    i4 = i6 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzjq.zzb(obj, j4));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 2:
                    i4 = i6 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j4);
                    byte[] bArr2 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 3:
                    i4 = i6 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j4);
                    byte[] bArr3 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 4:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 5:
                    i4 = i6 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j4);
                    byte[] bArr4 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 6:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 7:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzhp.zza(zzjq.zzw(obj, j4));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 8:
                    i4 = i6 * 53;
                    iFloatToIntBits = ((String) zzjq.zzf(obj, j4)).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 9:
                    i5 = i6 * 53;
                    Object objZzf = zzjq.zzf(obj, j4);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i6 = i5 + iHashCode;
                    break;
                case 10:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 11:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 12:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 13:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 14:
                    i4 = i6 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j4);
                    byte[] bArr5 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j4);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 16:
                    i4 = i6 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j4);
                    byte[] bArr6 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    i5 = i6 * 53;
                    Object objZzf2 = zzjq.zzf(obj, j4);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i6 = i5 + iHashCode;
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_22 /* 22 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case 24:
                case 25:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case 30:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case FirestoreIndexValueWriter.INDEX_TYPE_GEOPOINT /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_ARRAY /* 50 */:
                    i4 = i6 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j4));
                        byte[] bArr7 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j4));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_VECTOR /* 53 */:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = zzt(obj, j4);
                        byte[] bArr8 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = zzt(obj, j4);
                        byte[] bArr9 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_MAP /* 55 */:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = zzt(obj, j4);
                        byte[] bArr10 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzhp.zza(zzN(obj, j4));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = ((String) zzjq.zzf(obj, j4)).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE_SEGMENT /* 60 */:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case UserMetadata.MAX_ATTRIBUTES /* 64 */:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = zzt(obj, j4);
                        byte[] bArr11 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzo(obj, j4);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        jDoubleToLongBits = zzt(obj, j4);
                        byte[] bArr12 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j4).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i6 * 53) + ((zzhk) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzhh) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x03eb, code lost:
    
        r10 = r8;
        r8 = r1;
        r1 = r10;
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03ef, code lost:
    
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x046f, code lost:
    
        r4 = r41;
        r3 = r8;
        r6 = r10;
        r8 = r11;
        r9 = r14;
        r14 = r15;
        r15 = r21;
        r13 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04a5, code lost:
    
        r36 = r2;
        r2 = r1;
        r1 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x04d3, code lost:
    
        r3 = r2;
        r2 = r1;
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x052e, code lost:
    
        r22 = r2;
        r3 = r5;
        r2 = r10;
        r10 = r11;
        r9 = r14;
        r23 = r15;
        r8 = r18;
        r13 = r24;
        r12 = r25;
        r14 = r42;
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0143, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0ce6, code lost:
    
        r2 = r10;
        r3 = r13;
        r9 = r14;
        r10 = r18;
        r13 = r30;
        r12 = r31;
        r14 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0fe2, code lost:
    
        if (r13 == r3) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x0fe4, code lost:
    
        r22.putInt(r11, r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0fea, code lost:
    
        r1 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0fee, code lost:
    
        if (r1 >= r0.zzk) goto L718;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0ff0, code lost:
    
        r2 = r0.zzi;
        r3 = r0.zzc;
        r2 = r2[r1];
        r3 = r3[r2];
        r3 = com.google.android.gms.internal.play_billing.zzjq.zzf(r11, r0.zzs(r2) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x1006, code lost:
    
        if (r3 != null) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x100f, code lost:
    
        if (r0.zzu(r2) != null) goto L717;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x1012, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x1015, code lost:
    
        r3 = (com.google.android.gms.internal.play_billing.zzig) r3;
        r1 = (com.google.android.gms.internal.play_billing.zzif) r0.zzw(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x101d, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:617:0x1020, code lost:
    
        if (r14 != 0) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x1022, code lost:
    
        if (r7 != r4) goto L620;
     */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x102a, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzhr("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:622:0x102b, code lost:
    
        if (r7 > r4) goto L625;
     */
    /* JADX WARN: Code restructure failed: missing block: B:623:0x102d, code lost:
    
        if (r8 != r14) goto L625;
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x102f, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:626:0x1035, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzhr("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ee, code lost:
    
        r18 = r5;
        r5 = r6;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f2, code lost:
    
        r15 = 0;
        r29 = 1048575;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0c6e A[PHI: r0 r2 r7 r8 r10 r11 r13 r18 r22 r30
      0x0c6e: PHI (r0v36 com.google.android.gms.internal.play_billing.zzip<T>) = 
      (r0v3 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v3 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v3 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v3 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v11 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v34 com.google.android.gms.internal.play_billing.zzip<T>)
      (r0v3 com.google.android.gms.internal.play_billing.zzip<T>)
     binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r2v116 byte[]) = (r2v74 byte[]), (r2v78 byte[]), (r2v83 byte[]), (r2v86 byte[]), (r2v104 byte[]), (r2v109 byte[]), (r2v117 byte[]) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r7v99 int) = (r7v59 int), (r7v60 int), (r7v62 int), (r7v64 int), (r7v86 int), (r7v93 int), (r7v100 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r8v98 int) = (r8v67 int), (r8v68 int), (r8v70 int), (r8v72 int), (r8v90 int), (r8v94 int), (r8v99 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r10v73 com.google.android.gms.internal.play_billing.zzfz) = 
      (r10v39 com.google.android.gms.internal.play_billing.zzfz)
      (r10v40 com.google.android.gms.internal.play_billing.zzfz)
      (r10v42 com.google.android.gms.internal.play_billing.zzfz)
      (r10v44 com.google.android.gms.internal.play_billing.zzfz)
      (r10v56 com.google.android.gms.internal.play_billing.zzfz)
      (r10v67 com.google.android.gms.internal.play_billing.zzfz)
      (r10v74 com.google.android.gms.internal.play_billing.zzfz)
     binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r11v64 int) = (r11v37 int), (r11v38 int), (r11v40 int), (r11v42 int), (r11v57 int), (r11v61 int), (r11v65 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r13v66 int) = (r13v35 int), (r13v36 int), (r13v38 int), (r13v41 int), (r13v56 int), (r13v63 int), (r13v67 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r18v66 int) = (r18v27 int), (r18v28 int), (r18v30 int), (r18v32 int), (r18v50 int), (r18v62 int), (r18v67 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r22v49 sun.misc.Unsafe) = 
      (r22v21 sun.misc.Unsafe)
      (r22v22 sun.misc.Unsafe)
      (r22v24 sun.misc.Unsafe)
      (r22v26 sun.misc.Unsafe)
      (r22v37 sun.misc.Unsafe)
      (r22v41 sun.misc.Unsafe)
      (r22v50 sun.misc.Unsafe)
     binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]
      0x0c6e: PHI (r30v33 int) = (r30v6 int), (r30v7 int), (r30v9 int), (r30v11 int), (r30v22 int), (r30v29 int), (r30v34 int) binds: [B:482:0x0c42, B:462:0x0bc5, B:442:0x0b51, B:427:0x0aea, B:299:0x085b, B:224:0x06b8, B:203:0x0640] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0f59  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0fb5  */
    /* JADX WARN: Removed duplicated region for block: B:668:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0c8d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:686:0x0f73 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r38, byte[] r39, int r40, int r41, int r42, com.google.android.gms.internal.play_billing.zzfz r43) {
        /*
            Method dump skipped, instruction units count: 4294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzfz):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final Object zze() {
        return ((zzhk) this.zzg).zzp();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    @Override // com.google.android.gms.internal.play_billing.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int i5 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j4 = i5;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i4)) {
                        zzjq.zzo(obj, j4, zzjq.zza(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i4)) {
                        zzjq.zzp(obj, j4, zzjq.zzb(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i4)) {
                        zzjq.zzr(obj, j4, zzjq.zzd(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i4)) {
                        zzjq.zzr(obj, j4, zzjq.zzd(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i4)) {
                        zzjq.zzr(obj, j4, zzjq.zzd(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i4)) {
                        zzjq.zzm(obj, j4, zzjq.zzw(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i4)) {
                        zzjq.zzs(obj, j4, zzjq.zzf(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i4);
                    break;
                case 10:
                    if (zzI(obj2, i4)) {
                        zzjq.zzs(obj, j4, zzjq.zzf(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i4)) {
                        zzjq.zzr(obj, j4, zzjq.zzd(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    if (zzI(obj2, i4)) {
                        zzjq.zzq(obj, j4, zzjq.zzc(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i4)) {
                        zzjq.zzr(obj, j4, zzjq.zzd(obj2, j4));
                        zzD(obj, i4);
                    }
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    zzB(obj, obj2, i4);
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_22 /* 22 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case 24:
                case 25:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case 30:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case FirestoreIndexValueWriter.INDEX_TYPE_GEOPOINT /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzho zzhoVarZzd = (zzho) zzjq.zzf(obj, j4);
                    zzho zzhoVar = (zzho) zzjq.zzf(obj2, j4);
                    int size = zzhoVarZzd.size();
                    int size2 = zzhoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzhoVarZzd.zzc()) {
                            zzhoVarZzd = zzhoVarZzd.zzd(size2 + size);
                        }
                        zzhoVarZzd.addAll(zzhoVar);
                    }
                    if (size > 0) {
                        zzhoVar = zzhoVarZzd;
                    }
                    zzjq.zzs(obj, j4, zzhoVar);
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_ARRAY /* 50 */:
                    int i7 = zziz.zza;
                    zzjq.zzs(obj, j4, zzih.zza(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4)));
                    break;
                case 51:
                case 52:
                case FirestoreIndexValueWriter.INDEX_TYPE_VECTOR /* 53 */:
                case 54:
                case FirestoreIndexValueWriter.INDEX_TYPE_MAP /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i6, i4)) {
                        zzjq.zzs(obj, j4, zzjq.zzf(obj2, j4));
                        zzE(obj, i6, i4);
                    }
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE_SEGMENT /* 60 */:
                    zzC(obj, obj2, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case UserMetadata.MAX_ATTRIBUTES /* 64 */:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i6, i4)) {
                        zzjq.zzs(obj, j4, zzjq.zzf(obj2, j4));
                        zzE(obj, i6, i4);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i4);
                    break;
            }
        }
        zziz.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zziz.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzh(Object obj, byte[] bArr, int i4, int i5, zzfz zzfzVar) {
        zzc(obj, bArr, i4, i5, 0, zzfzVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.play_billing.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r19, com.google.android.gms.internal.play_billing.zzjw r20) {
        /*
            Method dump skipped, instruction units count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzjw):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            long j4 = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i4) || Double.doubleToLongBits(zzjq.zza(obj, j4)) != Double.doubleToLongBits(zzjq.zza(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i4) || Float.floatToIntBits(zzjq.zzb(obj, j4)) != Float.floatToIntBits(zzjq.zzb(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i4) || zzjq.zzd(obj, j4) != zzjq.zzd(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i4) || zzjq.zzd(obj, j4) != zzjq.zzd(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i4) || zzjq.zzd(obj, j4) != zzjq.zzd(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i4) || zzjq.zzw(obj, j4) != zzjq.zzw(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i4) || !zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i4) || !zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i4) || !zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i4) || zzjq.zzd(obj, j4) != zzjq.zzd(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    if (!zzH(obj, obj2, i4) || zzjq.zzc(obj, j4) != zzjq.zzc(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i4) || zzjq.zzd(obj, j4) != zzjq.zzd(obj2, j4)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    if (!zzH(obj, obj2, i4) || !zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_22 /* 22 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case 24:
                case 25:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case 30:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case FirestoreIndexValueWriter.INDEX_TYPE_GEOPOINT /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzE = zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4));
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_ARRAY /* 50 */:
                    zZzE = zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4));
                    break;
                case 51:
                case 52:
                case FirestoreIndexValueWriter.INDEX_TYPE_VECTOR /* 53 */:
                case 54:
                case FirestoreIndexValueWriter.INDEX_TYPE_MAP /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE_SEGMENT /* 60 */:
                case 61:
                case 62:
                case 63:
                case UserMetadata.MAX_ATTRIBUTES /* 64 */:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzp = zzp(i4) & 1048575;
                    if (zzjq.zzc(obj, jZzp) != zzjq.zzc(obj2, jZzp) || !zziz.zzE(zzjq.zzf(obj, j4), zzjq.zzf(obj2, j4))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzhk) obj).zzc.equals(((zzhk) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzhh) obj).zzb.equals(((zzhh) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // com.google.android.gms.internal.play_billing.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzk(java.lang.Object):boolean");
    }
}
