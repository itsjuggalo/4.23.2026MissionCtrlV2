package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;
import com.google.android.gms.common.api.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzakj extends zzakh {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final int zzaa() {
        int i;
        int i6 = this.zzh;
        int i7 = this.zzf;
        if (i7 != i6) {
            byte[] bArr = this.zze;
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                this.zzh = i8;
                return b3;
            }
            if (i7 - i8 >= 9) {
                int i9 = i6 + 2;
                int i10 = (bArr[i8] << 7) ^ b3;
                if (i10 < 0) {
                    i = i10 ^ (-128);
                } else {
                    int i11 = i6 + 3;
                    int i12 = (bArr[i9] << 14) ^ i10;
                    if (i12 >= 0) {
                        i = i12 ^ 16256;
                    } else {
                        int i13 = i6 + 4;
                        int i14 = i12 ^ (bArr[i11] << 21);
                        if (i14 < 0) {
                            i = (-2080896) ^ i14;
                        } else {
                            i11 = i6 + 5;
                            byte b6 = bArr[i13];
                            int i15 = (i14 ^ (b6 << 28)) ^ 266354560;
                            if (b6 < 0) {
                                i13 = i6 + 6;
                                if (bArr[i11] < 0) {
                                    i11 = i6 + 7;
                                    if (bArr[i13] < 0) {
                                        i13 = i6 + 8;
                                        if (bArr[i11] < 0) {
                                            i11 = i6 + 9;
                                            if (bArr[i13] < 0) {
                                                int i16 = i6 + 10;
                                                if (bArr[i11] >= 0) {
                                                    i9 = i16;
                                                    i = i15;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i15;
                            }
                            i = i15;
                        }
                        i9 = i13;
                    }
                    i9 = i11;
                }
                this.zzh = i9;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws zzall {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            zzg(8);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzac() {
        long j4;
        long j6;
        long j7;
        int i = this.zzh;
        int i6 = this.zzf;
        if (i6 != i) {
            byte[] bArr = this.zze;
            int i7 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzh = i7;
                return b3;
            }
            if (i6 - i7 >= 9) {
                int i8 = i + 2;
                int i9 = (bArr[i7] << 7) ^ b3;
                if (i9 < 0) {
                    j4 = i9 ^ (-128);
                } else {
                    int i10 = i + 3;
                    int i11 = (bArr[i8] << 14) ^ i9;
                    if (i11 >= 0) {
                        j4 = i11 ^ 16256;
                        i8 = i10;
                    } else {
                        int i12 = i + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            long j8 = (-2080896) ^ i13;
                            i8 = i12;
                            j4 = j8;
                        } else {
                            long j9 = i13;
                            i8 = i + 5;
                            long j10 = j9 ^ (((long) bArr[i12]) << 28);
                            if (j10 >= 0) {
                                j7 = 266354560;
                            } else {
                                int i14 = i + 6;
                                long j11 = j10 ^ (((long) bArr[i8]) << 35);
                                if (j11 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i8 = i + 7;
                                    j10 = j11 ^ (((long) bArr[i14]) << 42);
                                    if (j10 >= 0) {
                                        j7 = 4363953127296L;
                                    } else {
                                        i14 = i + 8;
                                        j11 = j10 ^ (((long) bArr[i8]) << 49);
                                        if (j11 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i8 = i + 9;
                                            long j12 = (j11 ^ (((long) bArr[i14]) << 56)) ^ 71499008037633920L;
                                            if (j12 < 0) {
                                                int i15 = i + 10;
                                                if (bArr[i8] >= 0) {
                                                    i8 = i15;
                                                }
                                            }
                                            j4 = j12;
                                        }
                                    }
                                }
                                j4 = j11 ^ j6;
                                i8 = i14;
                            }
                            j4 = j10 ^ j7;
                        }
                    }
                }
                this.zzh = i8;
                return j4;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i6 = this.zzj + i;
        int i7 = this.zzk;
        if (i6 <= i7) {
            this.zzg = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzg = i8;
        this.zzf = i - i8;
    }

    private final byte zzy() throws zzall {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i = this.zzh;
        this.zzh = i + 1;
        return bArr[i];
    }

    private final int zzz() throws zzall {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            zzg(4);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final double zza() {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final float zzb() {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzc() {
        return this.zzj + this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzd() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zze() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzf() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzg() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzh() {
        return zzakh.zza(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzi() throws zzall {
        if (zzw()) {
            this.zzi = 0;
            return 0;
        }
        int iZzaa = zzaa();
        this.zzi = iZzaa;
        if ((iZzaa >>> 3) != 0) {
            return iZzaa;
        }
        throw zzall.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzj() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzk() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzl() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzm() throws zzall {
        long j4 = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzy = zzy();
            j4 |= ((long) (bZzy & 127)) << i;
            if ((bZzy & 128) == 0) {
                return j4;
            }
        }
        throw zzall.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzn() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzo() {
        return zzakh.zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzp() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final zzajv zzq() throws IOException {
        int iZzaa = zzaa();
        int i = this.zzf;
        int i6 = this.zzh;
        if (iZzaa <= i - i6 && iZzaa > 0) {
            zzajv zzajvVarZza = zzajv.zza(this.zze, i6, iZzaa);
            this.zzh += iZzaa;
            return zzajvVarZza;
        }
        if (iZzaa == 0) {
            return zzajv.zza;
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        byte[] bArrZzj = zzj(iZzaa);
        if (bArrZzj != null) {
            return zzajv.zza(bArrZzj);
        }
        int i7 = this.zzh;
        int i8 = this.zzf;
        int length = i8 - i7;
        this.zzj += i8;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(iZzaa - length);
        byte[] bArr = new byte[iZzaa];
        System.arraycopy(this.zze, i7, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzajv.zzb(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzr() throws zzall {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i = this.zzf;
            int i6 = this.zzh;
            if (iZzaa <= i - i6) {
                String str = new String(this.zze, i6, iZzaa, zzalh.zza);
                this.zzh += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        if (iZzaa > this.zzf) {
            return new String(zza(iZzaa, false), zzalh.zza);
        }
        zzg(iZzaa);
        String str2 = new String(this.zze, this.zzh, iZzaa, zzalh.zza);
        this.zzh += iZzaa;
        return str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzs() throws IOException {
        byte[] bArrZza;
        int iZzaa = zzaa();
        int i = this.zzh;
        int i6 = this.zzf;
        if (iZzaa <= i6 - i && iZzaa > 0) {
            bArrZza = this.zze;
            this.zzh = i + iZzaa;
        } else {
            if (iZzaa == 0) {
                return "";
            }
            if (iZzaa < 0) {
                throw zzall.zzf();
            }
            i = 0;
            if (iZzaa <= i6) {
                zzg(iZzaa);
                bArrZza = this.zze;
                this.zzh = iZzaa;
            } else {
                bArrZza = zza(iZzaa, false);
            }
        }
        return zzaoa.zzb(bArrZza, i, iZzaa);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzw() {
        return this.zzh == this.zzf && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzx() {
        return zzac() != 0;
    }

    private zzakj(InputStream inputStream, int i) {
        super();
        this.zzk = f.API_PRIORITY_OTHER;
        zzalh.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    private static int zza(InputStream inputStream) throws zzall {
        try {
            return inputStream.available();
        } catch (zzall e) {
            e.zzk();
            throw e;
        }
    }

    private final List<byte[]> zzf(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i6 = 0;
            while (i6 < iMin) {
                int i7 = this.zzd.read(bArr, i6, iMin - i6);
                if (i7 == -1) {
                    throw zzall.zzj();
                }
                this.zzj += i7;
                i6 += i7;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i) throws zzall {
        if (zzi(i)) {
            return;
        }
        if (i <= (this.zzb - this.zzj) - this.zzh) {
            throw zzall.zzj();
        }
        throw zzall.zzi();
    }

    private final void zzh(int i) throws zzall {
        int i6 = this.zzf;
        int i7 = this.zzh;
        if (i <= i6 - i7 && i >= 0) {
            this.zzh = i7 + i;
            return;
        }
        if (i < 0) {
            throw zzall.zzf();
        }
        int i8 = this.zzj;
        int i9 = i8 + i7 + i;
        int i10 = this.zzk;
        if (i9 > i10) {
            zzh((i10 - i8) - i7);
            throw zzall.zzj();
        }
        this.zzj = i8 + i7;
        int i11 = i6 - i7;
        this.zzf = 0;
        this.zzh = 0;
        while (i11 < i) {
            try {
                long j4 = i - i11;
                long jZza = zza(this.zzd, j4);
                if (jZza >= 0 && jZza <= j4) {
                    if (jZza == 0) {
                        break;
                    } else {
                        i11 += (int) jZza;
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + jZza + "\nThe InputStream implementation is buggy.");
                }
            } finally {
                this.zzj += i11;
                zzad();
            }
        }
        if (i11 >= i) {
            return;
        }
        int i12 = this.zzf;
        int i13 = i12 - this.zzh;
        this.zzh = i12;
        zzg(1);
        while (true) {
            int i14 = i - i13;
            int i15 = this.zzf;
            if (i14 <= i15) {
                this.zzh = i14;
                return;
            } else {
                i13 += i15;
                this.zzh = i15;
                zzg(1);
            }
        }
    }

    private final byte[] zzj(int i) throws zzall {
        if (i == 0) {
            return zzalh.zzb;
        }
        if (i < 0) {
            throw zzall.zzf();
        }
        int i6 = this.zzj;
        int i7 = this.zzh;
        int i8 = i6 + i7 + i;
        if (i8 - this.zzb > 0) {
            throw zzall.zzi();
        }
        int i9 = this.zzk;
        if (i8 > i9) {
            zzh((i9 - i6) - i7);
            throw zzall.zzj();
        }
        int i10 = this.zzf - i7;
        int i11 = i - i10;
        if (i11 >= 4096 && i11 > zza(this.zzd)) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zze, this.zzh, bArr, 0, i10);
        this.zzj += this.zzf;
        this.zzh = 0;
        this.zzf = 0;
        while (i10 < i) {
            int iZza = zza(this.zzd, bArr, i10, i - i10);
            if (iZza == -1) {
                throw zzall.zzj();
            }
            this.zzj += iZza;
            i10 += iZza;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzb(int i) throws zzall {
        if (i < 0) {
            throw zzall.zzf();
        }
        int i6 = this.zzj + this.zzh + i;
        if (i6 < 0) {
            throw zzall.zzi();
        }
        int i7 = this.zzk;
        if (i6 > i7) {
            throw zzall.zzj();
        }
        this.zzk = i6;
        zzad();
        return i7;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzc(int i) throws zzall {
        if (this.zzi != i) {
            throw zzall.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzd(int i) {
        this.zzk = i;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zze(int i) throws zzall {
        int i6 = i & 7;
        int i7 = 0;
        if (i6 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i7 < 10) {
                    if (zzy() < 0) {
                        i7++;
                    }
                }
                throw zzall.zze();
            }
            while (i7 < 10) {
                byte[] bArr = this.zze;
                int i8 = this.zzh;
                this.zzh = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw zzall.zze();
            return true;
        }
        if (i6 == 1) {
            zzh(8);
            return true;
        }
        if (i6 == 2) {
            zzh(zzaa());
            return true;
        }
        if (i6 == 3) {
            zzv();
            zzc(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i6 == 4) {
            zzu();
            return false;
        }
        if (i6 != 5) {
            throw zzall.zza();
        }
        zzh(4);
        return true;
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i6) throws zzall {
        try {
            return inputStream.read(bArr, i, i6);
        } catch (zzall e) {
            e.zzk();
            throw e;
        }
    }

    private final boolean zzi(int i) throws zzall {
        int i6 = this.zzh;
        int i7 = i6 + i;
        int i8 = this.zzf;
        if (i7 > i8) {
            int i9 = this.zzb;
            int i10 = this.zzj;
            if (i > (i9 - i10) - i6 || i10 + i6 + i > this.zzk) {
                return false;
            }
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.zze;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                this.zzj += i6;
                this.zzf -= i6;
                this.zzh = 0;
            }
            InputStream inputStream = this.zzd;
            byte[] bArr2 = this.zze;
            int i11 = this.zzf;
            int iZza = zza(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.zzb - this.zzj) - i11));
            if (iZza != 0 && iZza >= -1 && iZza <= this.zze.length) {
                if (iZza <= 0) {
                    return false;
                }
                this.zzf += iZza;
                zzad();
                return this.zzf >= i || zzi(i);
            }
            throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + iZza + "\nThe InputStream implementation is buggy.");
        }
        throw new IllegalStateException(d.i("refillBuffer() called when ", i, " bytes were already available in buffer"));
    }

    private static long zza(InputStream inputStream, long j4) throws zzall {
        try {
            return inputStream.skip(j4);
        } catch (zzall e) {
            e.zzk();
            throw e;
        }
    }

    private final byte[] zza(int i, boolean z6) throws IOException {
        byte[] bArrZzj = zzj(i);
        if (bArrZzj != null) {
            return bArrZzj;
        }
        int i6 = this.zzh;
        int i7 = this.zzf;
        int length = i7 - i6;
        this.zzj += i7;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zze, i6, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
