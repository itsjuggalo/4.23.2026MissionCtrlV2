package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* JADX INFO: loaded from: classes.dex */
final class zzajl {
    private static volatile int zza = 100;

    public static double zza(byte[] bArr, int i4) {
        return Double.longBitsToDouble(zzd(bArr, i4));
    }

    public static float zzb(byte[] bArr, int i4) {
        return Float.intBitsToFloat(zzc(bArr, i4));
    }

    public static int zzc(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    public static int zzd(byte[] bArr, int i4, zzajk zzajkVar) {
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        if (j4 >= 0) {
            zzajkVar.zzb = j4;
            return i5;
        }
        int i6 = i4 + 2;
        byte b4 = bArr[i5];
        long j5 = (j4 & 127) | (((long) (b4 & 127)) << 7);
        int i7 = 7;
        while (b4 < 0) {
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            i7 += 7;
            j5 |= ((long) (b5 & 127)) << i7;
            b4 = b5;
            i6 = i8;
        }
        zzajkVar.zzb = j5;
        return i6;
    }

    public static int zza(byte[] bArr, int i4, zzajk zzajkVar) {
        int iZzc = zzc(bArr, i4, zzajkVar);
        int i5 = zzajkVar.zza;
        if (i5 < 0) {
            throw zzalf.zzf();
        }
        if (i5 > bArr.length - iZzc) {
            throw zzalf.zzj();
        }
        if (i5 == 0) {
            zzajkVar.zzc = zzajp.zza;
            return iZzc;
        }
        zzajkVar.zzc = zzajp.zza(bArr, iZzc, i5);
        return iZzc + i5;
    }

    public static int zzb(zzamv<?> zzamvVar, int i4, byte[] bArr, int i5, int i6, zzalc<?> zzalcVar, zzajk zzajkVar) {
        int iZza = zza(zzamvVar, bArr, i5, i6, zzajkVar);
        zzalcVar.add(zzajkVar.zzc);
        while (iZza < i6) {
            int iZzc = zzc(bArr, iZza, zzajkVar);
            if (i4 != zzajkVar.zza) {
                break;
            }
            iZza = zza(zzamvVar, bArr, iZzc, i6, zzajkVar);
            zzalcVar.add(zzajkVar.zzc);
        }
        return iZza;
    }

    public static int zzc(byte[] bArr, int i4, zzajk zzajkVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 < 0) {
            return zza(b4, bArr, i5, zzajkVar);
        }
        zzajkVar.zza = b4;
        return i5;
    }

    public static long zzd(byte[] bArr, int i4) {
        return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
    }

    public static int zzb(byte[] bArr, int i4, zzajk zzajkVar) {
        int iZzc = zzc(bArr, i4, zzajkVar);
        int i5 = zzajkVar.zza;
        if (i5 < 0) {
            throw zzalf.zzf();
        }
        if (i5 == 0) {
            zzajkVar.zzc = "";
            return iZzc;
        }
        zzajkVar.zzc = zzant.zzb(bArr, iZzc, i5);
        return iZzc + i5;
    }

    public static int zza(int i4, byte[] bArr, int i5, int i6, Object obj, zzamc zzamcVar, zzano<zzann, zzann> zzanoVar, zzajk zzajkVar) {
        if (zzajkVar.zzd.zza(zzamcVar, i4 >>> 3) == null) {
            return zza(i4, bArr, i5, i6, zzamg.zzc(obj), zzajkVar);
        }
        zzaky.zzb zzbVar = (zzaky.zzb) obj;
        zzbVar.zza();
        zzakr<zzaky.zze> zzakrVar = zzbVar.zzc;
        throw new NoSuchMethodError();
    }

    private static <T> int zza(zzamv<T> zzamvVar, byte[] bArr, int i4, int i5, int i6, zzajk zzajkVar) {
        T tZza = zzamvVar.zza();
        int iZza = zza(tZza, zzamvVar, bArr, i4, i5, i6, zzajkVar);
        zzamvVar.zzd(tZza);
        zzajkVar.zzc = tZza;
        return iZza;
    }

    public static int zza(zzamv<?> zzamvVar, int i4, byte[] bArr, int i5, int i6, zzalc<Object> zzalcVar, zzajk zzajkVar) {
        int i7 = (i4 & (-8)) | 4;
        int iZza = zza(zzamvVar, bArr, i5, i6, i7, zzajkVar);
        zzalcVar.add(zzajkVar.zzc);
        while (iZza < i6) {
            int iZzc = zzc(bArr, iZza, zzajkVar);
            if (i4 != zzajkVar.zza) {
                break;
            }
            iZza = zza(zzamvVar, bArr, iZzc, i6, i7, zzajkVar);
            zzalcVar.add(zzajkVar.zzc);
        }
        return iZza;
    }

    public static <T> int zza(zzamv<T> zzamvVar, byte[] bArr, int i4, int i5, zzajk zzajkVar) {
        T tZza = zzamvVar.zza();
        int iZza = zza(tZza, zzamvVar, bArr, i4, i5, zzajkVar);
        zzamvVar.zzd(tZza);
        zzajkVar.zzc = tZza;
        return iZza;
    }

    public static int zza(byte[] bArr, int i4, zzalc<?> zzalcVar, zzajk zzajkVar) {
        zzakz zzakzVar = (zzakz) zzalcVar;
        int iZzc = zzc(bArr, i4, zzajkVar);
        int i5 = zzajkVar.zza + iZzc;
        while (iZzc < i5) {
            iZzc = zzc(bArr, iZzc, zzajkVar);
            zzakzVar.zzc(zzajkVar.zza);
        }
        if (iZzc == i5) {
            return iZzc;
        }
        throw zzalf.zzj();
    }

    public static int zza(int i4, byte[] bArr, int i5, int i6, zzann zzannVar, zzajk zzajkVar) {
        if ((i4 >>> 3) == 0) {
            throw zzalf.zzc();
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            int iZzd = zzd(bArr, i5, zzajkVar);
            zzannVar.zza(i4, Long.valueOf(zzajkVar.zzb));
            return iZzd;
        }
        if (i7 == 1) {
            zzannVar.zza(i4, Long.valueOf(zzd(bArr, i5)));
            return i5 + 8;
        }
        if (i7 == 2) {
            int iZzc = zzc(bArr, i5, zzajkVar);
            int i8 = zzajkVar.zza;
            if (i8 >= 0) {
                if (i8 > bArr.length - iZzc) {
                    throw zzalf.zzj();
                }
                if (i8 == 0) {
                    zzannVar.zza(i4, zzajp.zza);
                } else {
                    zzannVar.zza(i4, zzajp.zza(bArr, iZzc, i8));
                }
                return iZzc + i8;
            }
            throw zzalf.zzf();
        }
        if (i7 != 3) {
            if (i7 == 5) {
                zzannVar.zza(i4, Integer.valueOf(zzc(bArr, i5)));
                return i5 + 4;
            }
            throw zzalf.zzc();
        }
        zzann zzannVarZzd = zzann.zzd();
        int i9 = (i4 & (-8)) | 4;
        int i10 = zzajkVar.zze + 1;
        zzajkVar.zze = i10;
        zza(i10);
        int i11 = 0;
        while (true) {
            if (i5 >= i6) {
                break;
            }
            int iZzc2 = zzc(bArr, i5, zzajkVar);
            i11 = zzajkVar.zza;
            if (i11 == i9) {
                i5 = iZzc2;
                break;
            }
            i5 = zza(i11, bArr, iZzc2, i6, zzannVarZzd, zzajkVar);
        }
        zzajkVar.zze--;
        if (i5 <= i6 && i11 == i9) {
            zzannVar.zza(i4, zzannVarZzd);
            return i5;
        }
        throw zzalf.zzg();
    }

    public static int zza(int i4, byte[] bArr, int i5, zzajk zzajkVar) {
        int i6 = i4 & 127;
        int i7 = i5 + 1;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzajkVar.zza = i6 | (b4 << 7);
            return i7;
        }
        int i8 = i6 | ((b4 & 127) << 7);
        int i9 = i5 + 2;
        byte b5 = bArr[i7];
        if (b5 >= 0) {
            zzajkVar.zza = i8 | (b5 << 14);
            return i9;
        }
        int i10 = i8 | ((b5 & 127) << 14);
        int i11 = i5 + 3;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzajkVar.zza = i10 | (b6 << 21);
            return i11;
        }
        int i12 = i10 | ((b6 & 127) << 21);
        int i13 = i5 + 4;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzajkVar.zza = i12 | (b7 << 28);
            return i13;
        }
        int i14 = i12 | ((b7 & 127) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                zzajkVar.zza = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    public static int zza(int i4, byte[] bArr, int i5, int i6, zzalc<?> zzalcVar, zzajk zzajkVar) {
        zzakz zzakzVar = (zzakz) zzalcVar;
        int iZzc = zzc(bArr, i5, zzajkVar);
        zzakzVar.zzc(zzajkVar.zza);
        while (iZzc < i6) {
            int iZzc2 = zzc(bArr, iZzc, zzajkVar);
            if (i4 != zzajkVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzajkVar);
            zzakzVar.zzc(zzajkVar.zza);
        }
        return iZzc;
    }

    public static <T> int zza(Object obj, zzamv<T> zzamvVar, byte[] bArr, int i4, int i5, int i6, zzajk zzajkVar) {
        int i7 = zzajkVar.zze + 1;
        zzajkVar.zze = i7;
        zza(i7);
        int iZza = ((zzamg) zzamvVar).zza(obj, bArr, i4, i5, i6, zzajkVar);
        zzajkVar.zze--;
        zzajkVar.zzc = obj;
        return iZza;
    }

    public static <T> int zza(Object obj, zzamv<T> zzamvVar, byte[] bArr, int i4, int i5, zzajk zzajkVar) {
        int iZza = i4 + 1;
        int i6 = bArr[i4];
        if (i6 < 0) {
            iZza = zza(i6, bArr, iZza, zzajkVar);
            i6 = zzajkVar.zza;
        }
        int i7 = iZza;
        if (i6 >= 0 && i6 <= i5 - i7) {
            int i8 = zzajkVar.zze + 1;
            zzajkVar.zze = i8;
            zza(i8);
            int i9 = i7 + i6;
            zzamvVar.zza(obj, bArr, i7, i9, zzajkVar);
            zzajkVar.zze--;
            zzajkVar.zzc = obj;
            return i9;
        }
        throw zzalf.zzj();
    }

    public static int zza(int i4, byte[] bArr, int i5, int i6, zzajk zzajkVar) {
        if ((i4 >>> 3) == 0) {
            throw zzalf.zzc();
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            return zzd(bArr, i5, zzajkVar);
        }
        if (i7 == 1) {
            return i5 + 8;
        }
        if (i7 == 2) {
            return zzc(bArr, i5, zzajkVar) + zzajkVar.zza;
        }
        if (i7 != 3) {
            if (i7 == 5) {
                return i5 + 4;
            }
            throw zzalf.zzc();
        }
        int i8 = (i4 & (-8)) | 4;
        int i9 = 0;
        while (i5 < i6) {
            i5 = zzc(bArr, i5, zzajkVar);
            i9 = zzajkVar.zza;
            if (i9 == i8) {
                break;
            }
            i5 = zza(i9, bArr, i5, i6, zzajkVar);
        }
        if (i5 > i6 || i9 != i8) {
            throw zzalf.zzg();
        }
        return i5;
    }

    private static void zza(int i4) throws zzalf {
        if (i4 >= zza) {
            throw zzalf.zzh();
        }
    }
}
