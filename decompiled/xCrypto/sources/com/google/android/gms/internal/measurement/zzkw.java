package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzkw {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i4, zzkv zzkvVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 < 0) {
            return zzb(b4, bArr, i5, zzkvVar);
        }
        zzkvVar.zza = b4;
        return i5;
    }

    public static int zzb(int i4, byte[] bArr, int i5, zzkv zzkvVar) {
        byte b4 = bArr[i5];
        int i6 = i5 + 1;
        int i7 = i4 & 127;
        if (b4 >= 0) {
            zzkvVar.zza = i7 | (b4 << 7);
            return i6;
        }
        int i8 = i7 | ((b4 & 127) << 7);
        int i9 = i5 + 2;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzkvVar.zza = i8 | (b5 << 14);
            return i9;
        }
        int i10 = i8 | ((b5 & 127) << 14);
        int i11 = i5 + 3;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzkvVar.zza = i10 | (b6 << 21);
            return i11;
        }
        int i12 = i10 | ((b6 & 127) << 21);
        int i13 = i5 + 4;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzkvVar.zza = i12 | (b7 << 28);
            return i13;
        }
        int i14 = i12 | ((b7 & 127) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                zzkvVar.zza = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    public static int zzc(byte[] bArr, int i4, zzkv zzkvVar) {
        long j4 = bArr[i4];
        int i5 = i4 + 1;
        if (j4 >= 0) {
            zzkvVar.zzb = j4;
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
        zzkvVar.zzb = j5;
        return i6;
    }

    public static int zzd(byte[] bArr, int i4) {
        int i5 = bArr[i4] & 255;
        int i6 = bArr[i4 + 1] & 255;
        int i7 = bArr[i4 + 2] & 255;
        return ((bArr[i4 + 3] & 255) << 24) | (i6 << 8) | i5 | (i7 << 16);
    }

    public static long zze(byte[] bArr, int i4) {
        return (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48) | ((((long) bArr[i4 + 7]) & 255) << 56);
    }

    public static int zzf(byte[] bArr, int i4, zzkv zzkvVar) throws zzmq {
        int i5;
        int iZza = zza(bArr, i4, zzkvVar);
        int i6 = zzkvVar.zza;
        if (i6 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 == 0) {
            zzkvVar.zzc = "";
            return iZza;
        }
        int i7 = zzor.zza;
        int length = bArr.length;
        if ((((length - iZza) - i6) | iZza | i6) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZza), Integer.valueOf(i6)));
        }
        int i8 = iZza + i6;
        char[] cArr = new char[i6];
        int i9 = 0;
        while (iZza < i8) {
            byte b4 = bArr[iZza];
            if (!zzop.zza(b4)) {
                break;
            }
            iZza++;
            cArr[i9] = (char) b4;
            i9++;
        }
        int i10 = i9;
        while (iZza < i8) {
            int i11 = iZza + 1;
            byte b5 = bArr[iZza];
            if (zzop.zza(b5)) {
                cArr[i10] = (char) b5;
                i10++;
                iZza = i11;
                while (iZza < i8) {
                    byte b6 = bArr[iZza];
                    if (zzop.zza(b6)) {
                        iZza++;
                        cArr[i10] = (char) b6;
                        i10++;
                    }
                }
            } else {
                if (b5 < -32) {
                    if (i11 >= i8) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    i5 = i10 + 1;
                    iZza += 2;
                    zzop.zzb(b5, bArr[i11], cArr, i10);
                } else if (b5 < -16) {
                    if (i11 >= i8 - 1) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    i5 = i10 + 1;
                    int i12 = iZza + 2;
                    iZza += 3;
                    zzop.zzc(b5, bArr[i11], bArr[i12], cArr, i10);
                } else {
                    if (i11 >= i8 - 2) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    byte b7 = bArr[i11];
                    int i13 = iZza + 3;
                    byte b8 = bArr[iZza + 2];
                    iZza += 4;
                    zzop.zzd(b5, b7, b8, bArr[i13], cArr, i10);
                    i10 += 2;
                }
                i10 = i5;
            }
        }
        zzkvVar.zzc = new String(cArr, 0, i10);
        return i8;
    }

    public static int zzg(byte[] bArr, int i4, zzkv zzkvVar) throws zzmq {
        int iZza = zza(bArr, i4, zzkvVar);
        int i5 = zzkvVar.zza;
        if (i5 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i5 > bArr.length - iZza) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i5 == 0) {
            zzkvVar.zzc = zzlg.zzb;
            return iZza;
        }
        zzkvVar.zzc = zzlg.zzh(bArr, iZza, i5);
        return iZza + i5;
    }

    public static int zzh(zznw zznwVar, byte[] bArr, int i4, int i5, zzkv zzkvVar) throws zzmq {
        Object objZza = zznwVar.zza();
        int iZzj = zzj(objZza, zznwVar, bArr, i4, i5, zzkvVar);
        zznwVar.zzj(objZza);
        zzkvVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(zznw zznwVar, byte[] bArr, int i4, int i5, int i6, zzkv zzkvVar) throws zzmq {
        Object objZza = zznwVar.zza();
        int iZzk = zzk(objZza, zznwVar, bArr, i4, i5, i6, zzkvVar);
        zznwVar.zzj(objZza);
        zzkvVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(Object obj, zznw zznwVar, byte[] bArr, int i4, int i5, zzkv zzkvVar) throws zzmq {
        int iZzb = i4 + 1;
        int i6 = bArr[i4];
        if (i6 < 0) {
            iZzb = zzb(i6, bArr, iZzb, zzkvVar);
            i6 = zzkvVar.zza;
        }
        int i7 = iZzb;
        if (i6 < 0 || i6 > i5 - i7) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i8 = zzkvVar.zze + 1;
        zzkvVar.zze = i8;
        zzq(i8);
        int i9 = i7 + i6;
        zznwVar.zzi(obj, bArr, i7, i9, zzkvVar);
        zzkvVar.zze--;
        zzkvVar.zzc = obj;
        return i9;
    }

    public static int zzk(Object obj, zznw zznwVar, byte[] bArr, int i4, int i5, int i6, zzkv zzkvVar) throws zzmq {
        int i7 = zzkvVar.zze + 1;
        zzkvVar.zze = i7;
        zzq(i7);
        int iZzh = ((zzno) zznwVar).zzh(obj, bArr, i4, i5, i6, zzkvVar);
        zzkvVar.zze--;
        zzkvVar.zzc = obj;
        return iZzh;
    }

    public static int zzl(int i4, byte[] bArr, int i5, int i6, zzmn zzmnVar, zzkv zzkvVar) {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int iZza = zza(bArr, i5, zzkvVar);
        zzmfVar.zzh(zzkvVar.zza);
        while (iZza < i6) {
            int iZza2 = zza(bArr, iZza, zzkvVar);
            if (i4 != zzkvVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzkvVar);
            zzmfVar.zzh(zzkvVar.zza);
        }
        return iZza;
    }

    public static int zzm(byte[] bArr, int i4, zzmn zzmnVar, zzkv zzkvVar) throws zzmq {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int iZza = zza(bArr, i4, zzkvVar);
        int i5 = zzkvVar.zza + iZza;
        while (iZza < i5) {
            iZza = zza(bArr, iZza, zzkvVar);
            zzmfVar.zzh(zzkvVar.zza);
        }
        if (iZza == i5) {
            return iZza;
        }
        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzn(zznw zznwVar, int i4, byte[] bArr, int i5, int i6, zzmn zzmnVar, zzkv zzkvVar) throws zzmq {
        int iZzh = zzh(zznwVar, bArr, i5, i6, zzkvVar);
        zzmnVar.add(zzkvVar.zzc);
        while (iZzh < i6) {
            int iZza = zza(bArr, iZzh, zzkvVar);
            if (i4 != zzkvVar.zza) {
                break;
            }
            iZzh = zzh(zznwVar, bArr, iZza, i6, zzkvVar);
            zzmnVar.add(zzkvVar.zzc);
        }
        return iZzh;
    }

    public static int zzo(int i4, byte[] bArr, int i5, int i6, zzoi zzoiVar, zzkv zzkvVar) throws zzmq {
        if ((i4 >>> 3) == 0) {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            int iZzc = zzc(bArr, i5, zzkvVar);
            zzoiVar.zzk(i4, Long.valueOf(zzkvVar.zzb));
            return iZzc;
        }
        if (i7 == 1) {
            zzoiVar.zzk(i4, Long.valueOf(zze(bArr, i5)));
            return i5 + 8;
        }
        if (i7 == 2) {
            int iZza = zza(bArr, i5, zzkvVar);
            int i8 = zzkvVar.zza;
            if (i8 < 0) {
                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i8 > bArr.length - iZza) {
                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i8 == 0) {
                zzoiVar.zzk(i4, zzlg.zzb);
            } else {
                zzoiVar.zzk(i4, zzlg.zzh(bArr, iZza, i8));
            }
            return iZza + i8;
        }
        if (i7 != 3) {
            if (i7 != 5) {
                throw new zzmq("Protocol message contained an invalid tag (zero).");
            }
            zzoiVar.zzk(i4, Integer.valueOf(zzd(bArr, i5)));
            return i5 + 4;
        }
        int i9 = (i4 & (-8)) | 4;
        zzoi zzoiVarZzb = zzoi.zzb();
        int i10 = zzkvVar.zze + 1;
        zzkvVar.zze = i10;
        zzq(i10);
        int i11 = 0;
        while (true) {
            if (i5 >= i6) {
                break;
            }
            int iZza2 = zza(bArr, i5, zzkvVar);
            int i12 = zzkvVar.zza;
            if (i12 == i9) {
                i11 = i12;
                i5 = iZza2;
                break;
            }
            i5 = zzo(i12, bArr, iZza2, i6, zzoiVarZzb, zzkvVar);
            i11 = i12;
        }
        zzkvVar.zze--;
        if (i5 > i6 || i11 != i9) {
            throw new zzmq("Failed to parse the message.");
        }
        zzoiVar.zzk(i4, zzoiVarZzb);
        return i5;
    }

    public static int zzp(int i4, byte[] bArr, int i5, int i6, zzkv zzkvVar) throws zzmq {
        if ((i4 >>> 3) == 0) {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            return zzc(bArr, i5, zzkvVar);
        }
        if (i7 == 1) {
            return i5 + 8;
        }
        if (i7 == 2) {
            return zza(bArr, i5, zzkvVar) + zzkvVar.zza;
        }
        if (i7 != 3) {
            if (i7 == 5) {
                return i5 + 4;
            }
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i8 = (i4 & (-8)) | 4;
        int i9 = 0;
        while (i5 < i6) {
            i5 = zza(bArr, i5, zzkvVar);
            i9 = zzkvVar.zza;
            if (i9 == i8) {
                break;
            }
            i5 = zzp(i9, bArr, i5, i6, zzkvVar);
        }
        if (i5 > i6 || i9 != i8) {
            throw new zzmq("Failed to parse the message.");
        }
        return i5;
    }

    private static void zzq(int i4) throws zzmq {
        if (i4 >= zzb) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
