package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i10, zzdw zzdwVar) throws zzfq {
        int iZzi = zzi(bArr, i10, zzdwVar);
        int i11 = zzdwVar.zza;
        if (i11 < 0) {
            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 > bArr.length - iZzi) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i11 == 0) {
            zzdwVar.zzc = zzei.zzb;
            return iZzi;
        }
        zzdwVar.zzc = zzei.zzj(bArr, iZzi, i11);
        return iZzi + i11;
    }

    public static int zzb(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    public static int zzc(zzgv zzgvVar, byte[] bArr, int i10, int i11, int i12, zzdw zzdwVar) throws zzfq {
        Object objZze = zzgvVar.zze();
        int iZzm = zzm(objZze, zzgvVar, bArr, i10, i11, i12, zzdwVar);
        zzgvVar.zzf(objZze);
        zzdwVar.zzc = objZze;
        return iZzm;
    }

    public static int zzd(zzgv zzgvVar, byte[] bArr, int i10, int i11, zzdw zzdwVar) throws zzfq {
        Object objZze = zzgvVar.zze();
        int iZzn = zzn(objZze, zzgvVar, bArr, i10, i11, zzdwVar);
        zzgvVar.zzf(objZze);
        zzdwVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzgv zzgvVar, int i10, byte[] bArr, int i11, int i12, zzfn zzfnVar, zzdw zzdwVar) throws zzfq {
        int iZzd = zzd(zzgvVar, bArr, i11, i12, zzdwVar);
        zzfnVar.add(zzdwVar.zzc);
        while (iZzd < i12) {
            int iZzi = zzi(bArr, iZzd, zzdwVar);
            if (i10 != zzdwVar.zza) {
                break;
            }
            iZzd = zzd(zzgvVar, bArr, iZzi, i12, zzdwVar);
            zzfnVar.add(zzdwVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i10, zzfn zzfnVar, zzdw zzdwVar) throws zzfq {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int iZzi = zzi(bArr, i10, zzdwVar);
        int i11 = zzdwVar.zza + iZzi;
        while (iZzi < i11) {
            iZzi = zzi(bArr, iZzi, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        if (iZzi == i11) {
            return iZzi;
        }
        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(byte[] bArr, int i10, zzdw zzdwVar) throws zzfq {
        int i11;
        int iZzi = zzi(bArr, i10, zzdwVar);
        int i12 = zzdwVar.zza;
        if (i12 < 0) {
            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i12 == 0) {
            zzdwVar.zzc = "";
            return iZzi;
        }
        int i13 = zzhr.zza;
        int length = bArr.length;
        if ((((length - iZzi) - i12) | iZzi | i12) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzi), Integer.valueOf(i12)));
        }
        int i14 = iZzi + i12;
        char[] cArr = new char[i12];
        int i15 = 0;
        while (iZzi < i14) {
            byte b10 = bArr[iZzi];
            if (!zzhp.zzd(b10)) {
                break;
            }
            iZzi++;
            cArr[i15] = (char) b10;
            i15++;
        }
        int i16 = i15;
        while (iZzi < i14) {
            int i17 = iZzi + 1;
            byte b11 = bArr[iZzi];
            if (zzhp.zzd(b11)) {
                cArr[i16] = (char) b11;
                i16++;
                iZzi = i17;
                while (iZzi < i14) {
                    byte b12 = bArr[iZzi];
                    if (zzhp.zzd(b12)) {
                        iZzi++;
                        cArr[i16] = (char) b12;
                        i16++;
                    }
                }
            } else {
                if (b11 < -32) {
                    if (i17 >= i14) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    i11 = i16 + 1;
                    iZzi += 2;
                    zzhp.zzc(b11, bArr[i17], cArr, i16);
                } else if (b11 < -16) {
                    if (i17 >= i14 - 1) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    i11 = i16 + 1;
                    int i18 = iZzi + 2;
                    iZzi += 3;
                    zzhp.zzb(b11, bArr[i17], bArr[i18], cArr, i16);
                } else {
                    if (i17 >= i14 - 2) {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                    byte b13 = bArr[i17];
                    int i19 = iZzi + 3;
                    byte b14 = bArr[iZzi + 2];
                    iZzi += 4;
                    zzhp.zza(b11, b13, b14, bArr[i19], cArr, i16);
                    i16 += 2;
                }
                i16 = i11;
            }
        }
        zzdwVar.zzc = new String(cArr, 0, i16);
        return i14;
    }

    public static int zzh(int i10, byte[] bArr, int i11, int i12, zzhi zzhiVar, zzdw zzdwVar) throws zzfq {
        if ((i10 >>> 3) == 0) {
            throw new zzfq("Protocol message contained an invalid tag (zero).");
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iZzl = zzl(bArr, i11, zzdwVar);
            zzhiVar.zzj(i10, Long.valueOf(zzdwVar.zzb));
            return iZzl;
        }
        if (i13 == 1) {
            zzhiVar.zzj(i10, Long.valueOf(zzo(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iZzi = zzi(bArr, i11, zzdwVar);
            int i14 = zzdwVar.zza;
            if (i14 < 0) {
                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i14 > bArr.length - iZzi) {
                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i14 == 0) {
                zzhiVar.zzj(i10, zzei.zzb);
            } else {
                zzhiVar.zzj(i10, zzei.zzj(bArr, iZzi, i14));
            }
            return iZzi + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw new zzfq("Protocol message contained an invalid tag (zero).");
            }
            zzhiVar.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        zzhi zzhiVarZzf = zzhi.zzf();
        int i16 = zzdwVar.zze + 1;
        zzdwVar.zze = i16;
        zzp(i16);
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iZzi2 = zzi(bArr, i11, zzdwVar);
            int i18 = zzdwVar.zza;
            if (i18 == i15) {
                i17 = i18;
                i11 = iZzi2;
                break;
            }
            i11 = zzh(i18, bArr, iZzi2, i12, zzhiVarZzf, zzdwVar);
            i17 = i18;
        }
        zzdwVar.zze--;
        if (i11 > i12 || i17 != i15) {
            throw new zzfq("Failed to parse the message.");
        }
        zzhiVar.zzj(i10, zzhiVarZzf);
        return i11;
    }

    public static int zzi(byte[] bArr, int i10, zzdw zzdwVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzj(b10, bArr, i11, zzdwVar);
        }
        zzdwVar.zza = b10;
        return i11;
    }

    public static int zzj(int i10, byte[] bArr, int i11, zzdw zzdwVar) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            zzdwVar.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzdwVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzdwVar.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzdwVar.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzdwVar.zza = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int zzk(int i10, byte[] bArr, int i11, int i12, zzfn zzfnVar, zzdw zzdwVar) {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int iZzi = zzi(bArr, i11, zzdwVar);
        zzfjVar.zzg(zzdwVar.zza);
        while (iZzi < i12) {
            int iZzi2 = zzi(bArr, iZzi, zzdwVar);
            if (i10 != zzdwVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        return iZzi;
    }

    public static int zzl(byte[] bArr, int i10, zzdw zzdwVar) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzdwVar.zzb = j10;
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
        zzdwVar.zzb = j11;
        return i12;
    }

    public static int zzm(Object obj, zzgv zzgvVar, byte[] bArr, int i10, int i11, int i12, zzdw zzdwVar) throws zzfq {
        int i13 = zzdwVar.zze + 1;
        zzdwVar.zze = i13;
        zzp(i13);
        int iZzc = ((zzgo) zzgvVar).zzc(obj, bArr, i10, i11, i12, zzdwVar);
        zzdwVar.zze--;
        zzdwVar.zzc = obj;
        return iZzc;
    }

    public static int zzn(Object obj, zzgv zzgvVar, byte[] bArr, int i10, int i11, zzdw zzdwVar) throws zzfq {
        int iZzj = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iZzj = zzj(i12, bArr, iZzj, zzdwVar);
            i12 = zzdwVar.zza;
        }
        int i13 = iZzj;
        if (i12 < 0 || i12 > i11 - i13) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i14 = zzdwVar.zze + 1;
        zzdwVar.zze = i14;
        zzp(i14);
        int i15 = i13 + i12;
        zzgvVar.zzh(obj, bArr, i13, i15, zzdwVar);
        zzdwVar.zze--;
        zzdwVar.zzc = obj;
        return i15;
    }

    public static long zzo(byte[] bArr, int i10) {
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | ((((long) bArr[i10 + 7]) & 255) << 56);
    }

    private static void zzp(int i10) throws zzfq {
        if (i10 >= zzb) {
            throw new zzfq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
