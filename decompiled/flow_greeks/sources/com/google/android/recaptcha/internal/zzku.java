package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzku {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i10, zzkt zzktVar) throws zznn {
        int iZzi = zzi(bArr, i10, zzktVar);
        int i11 = zzktVar.zza;
        if (i11 < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 > bArr.length - iZzi) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i11 == 0) {
            zzktVar.zzc = zzle.zzb;
            return iZzi;
        }
        zzktVar.zzc = zzle.zzk(bArr, iZzi, i11);
        return iZzi + i11;
    }

    public static int zzb(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    public static int zzc(zzow zzowVar, byte[] bArr, int i10, int i11, int i12, zzkt zzktVar) throws zznn {
        Object objZze = zzowVar.zze();
        int iZzm = zzm(objZze, zzowVar, bArr, i10, i11, i12, zzktVar);
        zzowVar.zzf(objZze);
        zzktVar.zzc = objZze;
        return iZzm;
    }

    public static int zzd(zzow zzowVar, byte[] bArr, int i10, int i11, zzkt zzktVar) throws zznn {
        Object objZze = zzowVar.zze();
        int iZzn = zzn(objZze, zzowVar, bArr, i10, i11, zzktVar);
        zzowVar.zzf(objZze);
        zzktVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzow zzowVar, int i10, byte[] bArr, int i11, int i12, zznk zznkVar, zzkt zzktVar) throws zznn {
        int iZzd = zzd(zzowVar, bArr, i11, i12, zzktVar);
        zznkVar.add(zzktVar.zzc);
        while (iZzd < i12) {
            int iZzi = zzi(bArr, iZzd, zzktVar);
            if (i10 != zzktVar.zza) {
                break;
            }
            iZzd = zzd(zzowVar, bArr, iZzi, i12, zzktVar);
            zznkVar.add(zzktVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i10, zznk zznkVar, zzkt zzktVar) throws zznn {
        zzne zzneVar = (zzne) zznkVar;
        int iZzi = zzi(bArr, i10, zzktVar);
        int i11 = zzktVar.zza + iZzi;
        while (iZzi < i11) {
            iZzi = zzi(bArr, iZzi, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        if (iZzi == i11) {
            return iZzi;
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(byte[] bArr, int i10, zzkt zzktVar) throws zznn {
        int iZzi = zzi(bArr, i10, zzktVar);
        int i11 = zzktVar.zza;
        if (i11 < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 == 0) {
            zzktVar.zzc = "";
            return iZzi;
        }
        zzktVar.zzc = new String(bArr, iZzi, i11, zznl.zza);
        return iZzi + i11;
    }

    public static int zzh(int i10, byte[] bArr, int i11, int i12, zzpm zzpmVar, zzkt zzktVar) throws zznn {
        if ((i10 >>> 3) == 0) {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iZzl = zzl(bArr, i11, zzktVar);
            zzpmVar.zzj(i10, Long.valueOf(zzktVar.zzb));
            return iZzl;
        }
        if (i13 == 1) {
            zzpmVar.zzj(i10, Long.valueOf(zzp(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iZzi = zzi(bArr, i11, zzktVar);
            int i14 = zzktVar.zza;
            if (i14 < 0) {
                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i14 > bArr.length - iZzi) {
                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i14 == 0) {
                zzpmVar.zzj(i10, zzle.zzb);
            } else {
                zzpmVar.zzj(i10, zzle.zzk(bArr, iZzi, i14));
            }
            return iZzi + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw new zznn("Protocol message contained an invalid tag (zero).");
            }
            zzpmVar.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        zzpm zzpmVarZzf = zzpm.zzf();
        int i16 = zzktVar.zze + 1;
        zzktVar.zze = i16;
        zzq(i16);
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iZzi2 = zzi(bArr, i11, zzktVar);
            int i18 = zzktVar.zza;
            if (i18 == i15) {
                i17 = i18;
                i11 = iZzi2;
                break;
            }
            i11 = zzh(i18, bArr, iZzi2, i12, zzpmVarZzf, zzktVar);
            i17 = i18;
        }
        zzktVar.zze--;
        if (i11 > i12 || i17 != i15) {
            throw new zznn("Failed to parse the message.");
        }
        zzpmVar.zzj(i10, zzpmVarZzf);
        return i11;
    }

    public static int zzi(byte[] bArr, int i10, zzkt zzktVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzj(b10, bArr, i11, zzktVar);
        }
        zzktVar.zza = b10;
        return i11;
    }

    public static int zzj(int i10, byte[] bArr, int i11, zzkt zzktVar) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            zzktVar.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzktVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzktVar.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzktVar.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzktVar.zza = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int zzk(int i10, byte[] bArr, int i11, int i12, zznk zznkVar, zzkt zzktVar) {
        zzne zzneVar = (zzne) zznkVar;
        int iZzi = zzi(bArr, i11, zzktVar);
        zzneVar.zzh(zzktVar.zza);
        while (iZzi < i12) {
            int iZzi2 = zzi(bArr, iZzi, zzktVar);
            if (i10 != zzktVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        return iZzi;
    }

    public static int zzl(byte[] bArr, int i10, zzkt zzktVar) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzktVar.zzb = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & 127)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & 127)) << i13;
            b10 = b11;
            i12 = i14;
        }
        zzktVar.zzb = j11;
        return i12;
    }

    public static int zzm(Object obj, zzow zzowVar, byte[] bArr, int i10, int i11, int i12, zzkt zzktVar) throws zznn {
        int i13 = zzktVar.zze + 1;
        zzktVar.zze = i13;
        zzq(i13);
        int iZzc = ((zzol) zzowVar).zzc(obj, bArr, i10, i11, i12, zzktVar);
        zzktVar.zze--;
        zzktVar.zzc = obj;
        return iZzc;
    }

    public static int zzn(Object obj, zzow zzowVar, byte[] bArr, int i10, int i11, zzkt zzktVar) throws zznn {
        int iZzj = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iZzj = zzj(i12, bArr, iZzj, zzktVar);
            i12 = zzktVar.zza;
        }
        int i13 = iZzj;
        if (i12 < 0 || i12 > i11 - i13) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i14 = zzktVar.zze + 1;
        zzktVar.zze = i14;
        zzq(i14);
        int i15 = i13 + i12;
        zzowVar.zzi(obj, bArr, i13, i15, zzktVar);
        zzktVar.zze--;
        zzktVar.zzc = obj;
        return i15;
    }

    public static int zzo(int i10, byte[] bArr, int i11, int i12, zzkt zzktVar) throws zznn {
        if ((i10 >>> 3) == 0) {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return zzl(bArr, i11, zzktVar);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return zzi(bArr, i11, zzktVar) + zzktVar.zza;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = zzi(bArr, i11, zzktVar);
            i15 = zzktVar.zza;
            if (i15 == i14) {
                break;
            }
            i11 = zzo(i15, bArr, i11, i12, zzktVar);
        }
        if (i11 > i12 || i15 != i14) {
            throw new zznn("Failed to parse the message.");
        }
        return i11;
    }

    public static long zzp(byte[] bArr, int i10) {
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | ((((long) bArr[i10 + 7]) & 255) << 56);
    }

    private static void zzq(int i10) throws zznn {
        if (i10 >= zzb) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
