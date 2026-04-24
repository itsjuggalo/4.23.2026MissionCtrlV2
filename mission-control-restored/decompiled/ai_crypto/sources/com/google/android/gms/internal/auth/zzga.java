package com.google.android.gms.internal.auth;

import com.amazon.c.a.a.c;
import java.lang.reflect.Field;
import java.util.Arrays;
import k4.C2105D;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i7, int i8, zzfx zzfxVar, int i9, boolean z7, int[] iArr2, int i10, int i11, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i7;
        this.zzf = i8;
        this.zzh = iArr2;
        this.zzi = i10;
        this.zzj = i11;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i7, int i8) {
        zzhj.zzn(obj, zzl(i8) & 1048575, i7);
    }

    private final void zzB(Object obj, int i7, Object obj2) {
        zzb.putObject(obj, zzo(i7) & 1048575, obj2);
        zzz(obj, i7);
    }

    private final void zzC(Object obj, int i7, int i8, Object obj2) {
        zzb.putObject(obj, zzo(i8) & 1048575, obj2);
        zzA(obj, i7, i8);
    }

    private final boolean zzD(Object obj, Object obj2, int i7) {
        return zzE(obj, i7) == zzE(obj2, i7);
    }

    private final boolean zzE(Object obj, int i7) {
        int iZzl = zzl(i7);
        long j7 = iZzl & 1048575;
        if (j7 != 1048575) {
            return (zzhj.zzc(obj, j7) & (1 << (iZzl >>> 20))) != 0;
        }
        int iZzo = zzo(i7);
        long j8 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j8)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j8)) != 0;
            case 2:
                return zzhj.zzd(obj, j8) != 0;
            case 3:
                return zzhj.zzd(obj, j8) != 0;
            case 4:
                return zzhj.zzc(obj, j8) != 0;
            case 5:
                return zzhj.zzd(obj, j8) != 0;
            case 6:
                return zzhj.zzc(obj, j8) != 0;
            case 7:
                return zzhj.zzt(obj, j8);
            case 8:
                Object objZzf = zzhj.zzf(obj, j8);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzef) {
                    return !zzef.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return zzhj.zzf(obj, j8) != null;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return !zzef.zzb.equals(zzhj.zzf(obj, j8));
            case 11:
                return zzhj.zzc(obj, j8) != 0;
            case 12:
                return zzhj.zzc(obj, j8) != 0;
            case 13:
                return zzhj.zzc(obj, j8) != 0;
            case 14:
                return zzhj.zzd(obj, j8) != 0;
            case 15:
                return zzhj.zzc(obj, j8) != 0;
            case c.f10119g /* 16 */:
                return zzhj.zzd(obj, j8) != 0;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzhj.zzf(obj, j8) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i7, int i8, int i9, int i10) {
        return i8 == 1048575 ? zzE(obj, i7) : (i9 & i10) != 0;
    }

    private static boolean zzG(Object obj, int i7, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i7 & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i7, int i8) {
        return zzhj.zzc(obj, (long) (zzl(i8) & 1048575)) == i7;
    }

    public static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzhaVarZzd = zzha.zzd();
        zzevVar.zzc = zzhaVarZzd;
        return zzhaVarZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.auth.zzga zzj(java.lang.Class r31, com.google.android.gms.internal.auth.zzfu r32, com.google.android.gms.internal.auth.zzgc r33, com.google.android.gms.internal.auth.zzfl r34, com.google.android.gms.internal.auth.zzgz r35, com.google.android.gms.internal.auth.zzem r36, com.google.android.gms.internal.auth.zzfs r37) {
        /*
            Method dump skipped, instruction units count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzj(java.lang.Class, com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzgc, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz, com.google.android.gms.internal.auth.zzem, com.google.android.gms.internal.auth.zzfs):com.google.android.gms.internal.auth.zzga");
    }

    private static int zzk(Object obj, long j7) {
        return ((Integer) zzhj.zzf(obj, j7)).intValue();
    }

    private final int zzl(int i7) {
        return this.zzc[i7 + 2];
    }

    private final int zzm(int i7, int i8) {
        int length = (this.zzc.length / 3) - 1;
        while (i8 <= length) {
            int i9 = (length + i8) >>> 1;
            int i10 = i9 * 3;
            int i11 = this.zzc[i10];
            if (i7 == i11) {
                return i10;
            }
            if (i7 < i11) {
                length = i9 - 1;
            } else {
                i8 = i9 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i7) {
        return (i7 >>> 20) & 255;
    }

    private final int zzo(int i7) {
        return this.zzc[i7 + 1];
    }

    private static long zzp(Object obj, long j7) {
        return ((Long) zzhj.zzf(obj, j7)).longValue();
    }

    private final zzey zzq(int i7) {
        int i8 = i7 / 3;
        return (zzey) this.zzd[i8 + i8 + 1];
    }

    private final zzgi zzr(int i7) {
        int i8 = i7 / 3;
        int i9 = i8 + i8;
        zzgi zzgiVar = (zzgi) this.zzd[i9];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZzb = zzgf.zza().zzb((Class) this.zzd[i9 + 1]);
        this.zzd[i9] = zzgiVarZzb;
        return zzgiVarZzb;
    }

    private final Object zzs(int i7) {
        int i8 = i7 / 3;
        return this.zzd[i8 + i8];
    }

    private final Object zzt(Object obj, int i7) {
        zzgi zzgiVarZzr = zzr(i7);
        int iZzo = zzo(i7) & 1048575;
        if (!zzE(obj, i7)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, iZzo);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private final Object zzu(Object obj, int i7, int i8) {
        zzgi zzgiVarZzr = zzr(i8);
        if (!zzI(obj, i7, i8)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i8) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private static Field zzv(Class cls, String str) {
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

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzx(Object obj, Object obj2, int i7) {
        if (zzE(obj2, i7)) {
            int iZzo = zzo(i7) & 1048575;
            Unsafe unsafe = zzb;
            long j7 = iZzo;
            Object object = unsafe.getObject(obj2, j7);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i7] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i7);
            if (!zzE(obj, i7)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j7, objZzd);
                } else {
                    unsafe.putObject(obj, j7, object);
                }
                zzz(obj, i7);
                return;
            }
            Object object2 = unsafe.getObject(obj, j7);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j7, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i7) {
        int i8 = this.zzc[i7];
        if (zzI(obj2, i8, i7)) {
            int iZzo = zzo(i7) & 1048575;
            Unsafe unsafe = zzb;
            long j7 = iZzo;
            Object object = unsafe.getObject(obj2, j7);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i7] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i7);
            if (!zzI(obj, i8, i7)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j7, objZzd);
                } else {
                    unsafe.putObject(obj, j7, object);
                }
                zzA(obj, i8, i7);
                return;
            }
            Object object2 = unsafe.getObject(obj, j7);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j7, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i7) {
        int iZzl = zzl(i7);
        long j7 = 1048575 & iZzl;
        if (j7 == 1048575) {
            return;
        }
        zzhj.zzn(obj, j7, (1 << (iZzl >>> 20)) | zzhj.zzc(obj, j7));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i7;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9 += 3) {
            int iZzo = zzo(i9);
            int i10 = this.zzc[i9];
            long j7 = 1048575 & iZzo;
            int iHashCode = 37;
            switch (zzn(iZzo)) {
                case 0:
                    i7 = i8 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j7));
                    byte[] bArr = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 1:
                    i7 = i8 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j7));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 2:
                    i7 = i8 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j7);
                    byte[] bArr2 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 3:
                    i7 = i8 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j7);
                    byte[] bArr3 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 4:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 5:
                    i7 = i8 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j7);
                    byte[] bArr4 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 6:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 7:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzfa.zza(zzhj.zzt(obj, j7));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 8:
                    i7 = i8 * 53;
                    iFloatToIntBits = ((String) zzhj.zzf(obj, j7)).hashCode();
                    i8 = i7 + iFloatToIntBits;
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    Object objZzf = zzhj.zzf(obj, j7);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i8 = (i8 * 53) + iHashCode;
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 11:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 12:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 13:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 14:
                    i7 = i8 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j7);
                    byte[] bArr5 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 15:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j7);
                    i8 = i7 + iFloatToIntBits;
                    break;
                case c.f10119g /* 16 */:
                    i7 = i8 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j7);
                    byte[] bArr6 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i7 + iFloatToIntBits;
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    Object objZzf2 = zzhj.zzf(obj, j7);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i8 = (i8 * 53) + iHashCode;
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case c.f10120h /* 32 */:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 50:
                    i7 = i8 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                    i8 = i7 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j7)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j7)).floatValue());
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = zzp(obj, j7);
                        byte[] bArr8 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = zzp(obj, j7);
                        byte[] bArr9 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = zzp(obj, j7);
                        byte[] bArr10 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j7)).booleanValue());
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = ((String) zzhj.zzf(obj, j7)).hashCode();
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = zzp(obj, j7);
                        byte[] bArr11 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzk(obj, j7);
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        jDoubleToLongBits = zzp(obj, j7);
                        byte[] bArr12 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzI(obj, i10, i9)) {
                        i7 = i8 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j7).hashCode();
                        i8 = i7 + iFloatToIntBits;
                    }
                    break;
            }
        }
        return (i8 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0b0f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0e27 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0b21 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:681:0x0e3f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(java.lang.Object r40, byte[] r41, int r42, int r43, int r44, com.google.android.gms.internal.auth.zzdt r45) throws com.google.android.gms.internal.auth.zzfb {
        /*
            Method dump skipped, instruction units count: 3938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zze(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i7 = 0; i7 < this.zzc.length; i7 += 3) {
            int iZzo = zzo(i7);
            int i8 = this.zzc[i7];
            long j7 = 1048575 & iZzo;
            switch (zzn(iZzo)) {
                case 0:
                    if (zzE(obj2, i7)) {
                        zzhj.zzl(obj, j7, zzhj.zza(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 1:
                    if (zzE(obj2, i7)) {
                        zzhj.zzm(obj, j7, zzhj.zzb(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 2:
                    if (zzE(obj2, i7)) {
                        zzhj.zzo(obj, j7, zzhj.zzd(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 3:
                    if (zzE(obj2, i7)) {
                        zzhj.zzo(obj, j7, zzhj.zzd(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 4:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 5:
                    if (zzE(obj2, i7)) {
                        zzhj.zzo(obj, j7, zzhj.zzd(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 6:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 7:
                    if (zzE(obj2, i7)) {
                        zzhj.zzk(obj, j7, zzhj.zzt(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 8:
                    if (zzE(obj2, i7)) {
                        zzhj.zzp(obj, j7, zzhj.zzf(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    zzx(obj, obj2, i7);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    if (zzE(obj2, i7)) {
                        zzhj.zzp(obj, j7, zzhj.zzf(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 11:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 12:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 13:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 14:
                    if (zzE(obj2, i7)) {
                        zzhj.zzo(obj, j7, zzhj.zzd(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case 15:
                    if (zzE(obj2, i7)) {
                        zzhj.zzn(obj, j7, zzhj.zzc(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case c.f10119g /* 16 */:
                    if (zzE(obj2, i7)) {
                        zzhj.zzo(obj, j7, zzhj.zzd(obj2, j7));
                        zzz(obj, i7);
                    }
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    zzx(obj, obj2, i7);
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case c.f10120h /* 32 */:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(obj, obj2, j7);
                    break;
                case 50:
                    int i9 = zzgk.zza;
                    zzhj.zzp(obj, j7, zzfs.zza(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzI(obj2, i8, i7)) {
                        zzhj.zzp(obj, j7, zzhj.zzf(obj2, j7));
                        zzA(obj, i8, i7);
                    }
                    break;
                case 60:
                    zzy(obj, obj2, i7);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzI(obj2, i8, i7)) {
                        zzhj.zzp(obj, j7, zzhj.zzf(obj2, j7));
                        zzA(obj, i8, i7);
                    }
                    break;
                case 68:
                    zzy(obj, obj2, i7);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i7, int i8, zzdt zzdtVar) throws zzfb {
        zzb(obj, bArr, i7, i8, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzf;
        int length = this.zzc.length;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int iZzo = zzo(i7);
            long j7 = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    if (!zzD(obj, obj2, i7) || Double.doubleToLongBits(zzhj.zza(obj, j7)) != Double.doubleToLongBits(zzhj.zza(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzD(obj, obj2, i7) || Float.floatToIntBits(zzhj.zzb(obj, j7)) != Float.floatToIntBits(zzhj.zzb(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzD(obj, obj2, i7) || zzhj.zzd(obj, j7) != zzhj.zzd(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzD(obj, obj2, i7) || zzhj.zzd(obj, j7) != zzhj.zzd(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzD(obj, obj2, i7) || zzhj.zzd(obj, j7) != zzhj.zzd(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzD(obj, obj2, i7) || zzhj.zzt(obj, j7) != zzhj.zzt(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzD(obj, obj2, i7) || !zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    if (!zzD(obj, obj2, i7) || !zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    if (!zzD(obj, obj2, i7) || !zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzD(obj, obj2, i7) || zzhj.zzd(obj, j7) != zzhj.zzd(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzD(obj, obj2, i7) || zzhj.zzc(obj, j7) != zzhj.zzc(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case c.f10119g /* 16 */:
                    if (!zzD(obj, obj2, i7) || zzhj.zzd(obj, j7) != zzhj.zzd(obj2, j7)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    if (!zzD(obj, obj2, i7) || !zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case c.f10120h /* 32 */:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7));
                    break;
                case 50:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzl = zzl(i7) & 1048575;
                    if (zzhj.zzc(obj, jZzl) != zzhj.zzc(obj2, jZzl) || !zzgk.zzf(zzhj.zzf(obj, j7), zzhj.zzf(obj2, j7))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzf) {
                return false;
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzi(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzi(java.lang.Object):boolean");
    }
}
