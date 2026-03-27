package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzga {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i4, zzfz zzfzVar) throws zzhr {
        int iZzh = zzh(bArr, i4, zzfzVar);
        int i5 = zzfzVar.zza;
        if (i5 < 0) {
            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i5 > bArr.length - iZzh) {
            throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i5 == 0) {
            zzfzVar.zzc = zzgk.zzb;
            return iZzh;
        }
        zzfzVar.zzc = zzgk.zzj(bArr, iZzh, i5);
        return iZzh + i5;
    }

    public static int zzb(byte[] bArr, int i4) {
        int i5 = bArr[i4] & 255;
        int i6 = bArr[i4 + 1] & 255;
        int i7 = bArr[i4 + 2] & 255;
        return ((bArr[i4 + 3] & 255) << 24) | (i6 << 8) | i5 | (i7 << 16);
    }

    public static int zzc(zzix zzixVar, byte[] bArr, int i4, int i5, int i6, zzfz zzfzVar) throws zzhr {
        Object objZze = zzixVar.zze();
        int iZzl = zzl(objZze, zzixVar, bArr, i4, i5, i6, zzfzVar);
        zzixVar.zzf(objZze);
        zzfzVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzix zzixVar, byte[] bArr, int i4, int i5, zzfz zzfzVar) throws zzhr {
        Object objZze = zzixVar.zze();
        int iZzm = zzm(objZze, zzixVar, bArr, i4, i5, zzfzVar);
        zzixVar.zzf(objZze);
        zzfzVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzix zzixVar, int i4, byte[] bArr, int i5, int i6, zzho zzhoVar, zzfz zzfzVar) throws zzhr {
        int iZzd = zzd(zzixVar, bArr, i5, i6, zzfzVar);
        zzhoVar.add(zzfzVar.zzc);
        while (iZzd < i6) {
            int iZzh = zzh(bArr, iZzd, zzfzVar);
            if (i4 != zzfzVar.zza) {
                break;
            }
            iZzd = zzd(zzixVar, bArr, iZzh, i6, zzfzVar);
            zzhoVar.add(zzfzVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i4, zzho zzhoVar, zzfz zzfzVar) throws zzhr {
        zzhl zzhlVar = (zzhl) zzhoVar;
        int iZzh = zzh(bArr, i4, zzfzVar);
        int i5 = zzfzVar.zza + iZzh;
        while (iZzh < i5) {
            iZzh = zzh(bArr, iZzh, zzfzVar);
            zzhlVar.zzg(zzfzVar.zza);
        }
        if (iZzh == i5) {
            return iZzh;
        }
        throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(int i4, byte[] bArr, int i5, int i6, zzjk zzjkVar, zzfz zzfzVar) throws zzhr {
        if ((i4 >>> 3) == 0) {
            throw new zzhr("Protocol message contained an invalid tag (zero).");
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            int iZzk = zzk(bArr, i5, zzfzVar);
            zzjkVar.zzj(i4, Long.valueOf(zzfzVar.zzb));
            return iZzk;
        }
        if (i7 == 1) {
            zzjkVar.zzj(i4, Long.valueOf(zzn(bArr, i5)));
            return i5 + 8;
        }
        if (i7 == 2) {
            int iZzh = zzh(bArr, i5, zzfzVar);
            int i8 = zzfzVar.zza;
            if (i8 < 0) {
                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i8 > bArr.length - iZzh) {
                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i8 == 0) {
                zzjkVar.zzj(i4, zzgk.zzb);
            } else {
                zzjkVar.zzj(i4, zzgk.zzj(bArr, iZzh, i8));
            }
            return iZzh + i8;
        }
        if (i7 != 3) {
            if (i7 != 5) {
                throw new zzhr("Protocol message contained an invalid tag (zero).");
            }
            zzjkVar.zzj(i4, Integer.valueOf(zzb(bArr, i5)));
            return i5 + 4;
        }
        int i9 = (i4 & (-8)) | 4;
        zzjk zzjkVarZzf = zzjk.zzf();
        int i10 = zzfzVar.zze + 1;
        zzfzVar.zze = i10;
        zzo(i10);
        int i11 = 0;
        while (true) {
            if (i5 >= i6) {
                break;
            }
            int iZzh2 = zzh(bArr, i5, zzfzVar);
            int i12 = zzfzVar.zza;
            if (i12 == i9) {
                i11 = i12;
                i5 = iZzh2;
                break;
            }
            i5 = zzg(i12, bArr, iZzh2, i6, zzjkVarZzf, zzfzVar);
            i11 = i12;
        }
        zzfzVar.zze--;
        if (i5 > i6 || i11 != i9) {
            throw new zzhr("Failed to parse the message.");
        }
        zzjkVar.zzj(i4, zzjkVarZzf);
        return i5;
    }

    public static int zzh(byte[] bArr, int i4, zzfz zzfzVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 < 0) {
            return zzi(b4, bArr, i5, zzfzVar);
        }
        zzfzVar.zza = b4;
        return i5;
    }

    public static int zzi(int i4, byte[] bArr, int i5, zzfz zzfzVar) {
        byte b4 = bArr[i5];
        int i6 = i5 + 1;
        int i7 = i4 & 127;
        if (b4 >= 0) {
            zzfzVar.zza = i7 | (b4 << 7);
            return i6;
        }
        int i8 = i7 | ((b4 & 127) << 7);
        int i9 = i5 + 2;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzfzVar.zza = i8 | (b5 << 14);
            return i9;
        }
        int i10 = i8 | ((b5 & 127) << 14);
        int i11 = i5 + 3;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzfzVar.zza = i10 | (b6 << 21);
            return i11;
        }
        int i12 = i10 | ((b6 & 127) << 21);
        int i13 = i5 + 4;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzfzVar.zza = i12 | (b7 << 28);
            return i13;
        }
        int i14 = i12 | ((b7 & 127) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                zzfzVar.zza = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    public static int zzj(int i4, byte[] bArr, int i5, int i6, zzho zzhoVar, zzfz zzfzVar) {
        zzhl zzhlVar = (zzhl) zzhoVar;
        int iZzh = zzh(bArr, i5, zzfzVar);
        zzhlVar.zzg(zzfzVar.zza);
        while (iZzh < i6) {
            int iZzh2 = zzh(bArr, iZzh, zzfzVar);
            if (i4 != zzfzVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzfzVar);
            zzhlVar.zzg(zzfzVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i4, zzfz zzfzVar) {
        long j4 = bArr[i4];
        int i5 = i4 + 1;
        if (j4 >= 0) {
            zzfzVar.zzb = j4;
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
        zzfzVar.zzb = j5;
        return i6;
    }

    public static int zzl(Object obj, zzix zzixVar, byte[] bArr, int i4, int i5, int i6, zzfz zzfzVar) throws zzhr {
        int i7 = zzfzVar.zze + 1;
        zzfzVar.zze = i7;
        zzo(i7);
        int iZzc = ((zzip) zzixVar).zzc(obj, bArr, i4, i5, i6, zzfzVar);
        zzfzVar.zze--;
        zzfzVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzix zzixVar, byte[] bArr, int i4, int i5, zzfz zzfzVar) throws zzhr {
        int iZzi = i4 + 1;
        int i6 = bArr[i4];
        if (i6 < 0) {
            iZzi = zzi(i6, bArr, iZzi, zzfzVar);
            i6 = zzfzVar.zza;
        }
        int i7 = iZzi;
        if (i6 < 0 || i6 > i5 - i7) {
            throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i8 = zzfzVar.zze + 1;
        zzfzVar.zze = i8;
        zzo(i8);
        int i9 = i7 + i6;
        zzixVar.zzh(obj, bArr, i7, i9, zzfzVar);
        zzfzVar.zze--;
        zzfzVar.zzc = obj;
        return i9;
    }

    public static long zzn(byte[] bArr, int i4) {
        return (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48) | ((((long) bArr[i4 + 7]) & 255) << 56);
    }

    private static void zzo(int i4) throws zzhr {
        if (i4 >= zzb) {
            throw new zzhr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
