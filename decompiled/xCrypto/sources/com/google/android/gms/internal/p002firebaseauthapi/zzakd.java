package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzakd extends zzakb {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final int zzaa() {
        int i4;
        int i5 = this.zzh;
        int i6 = this.zzf;
        if (i6 != i5) {
            byte[] bArr = this.zze;
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                this.zzh = i7;
                return b4;
            }
            if (i6 - i7 >= 9) {
                int i8 = i5 + 2;
                int i9 = (bArr[i7] << 7) ^ b4;
                if (i9 < 0) {
                    i4 = i9 ^ (-128);
                } else {
                    int i10 = i5 + 3;
                    int i11 = (bArr[i8] << 14) ^ i9;
                    if (i11 >= 0) {
                        i4 = i11 ^ 16256;
                    } else {
                        int i12 = i5 + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            i4 = (-2080896) ^ i13;
                        } else {
                            i10 = i5 + 5;
                            byte b5 = bArr[i12];
                            int i14 = (i13 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i12 = i5 + 6;
                                if (bArr[i10] < 0) {
                                    i10 = i5 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i5 + 8;
                                        if (bArr[i10] < 0) {
                                            i10 = i5 + 9;
                                            if (bArr[i12] < 0) {
                                                int i15 = i5 + 10;
                                                if (bArr[i10] >= 0) {
                                                    i8 = i15;
                                                    i4 = i14;
                                                }
                                            }
                                        }
                                    }
                                }
                                i4 = i14;
                            }
                            i4 = i14;
                        }
                        i8 = i12;
                    }
                    i8 = i10;
                }
                this.zzh = i8;
                return i4;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws zzalf {
        int i4 = this.zzh;
        if (this.zzf - i4 < 8) {
            zzg(8);
            i4 = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i4 + 8;
        return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
    }

    private final long zzac() {
        long j4;
        long j5;
        long j6;
        int i4 = this.zzh;
        int i5 = this.zzf;
        if (i5 != i4) {
            byte[] bArr = this.zze;
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                this.zzh = i6;
                return b4;
            }
            if (i5 - i6 >= 9) {
                int i7 = i4 + 2;
                int i8 = (bArr[i6] << 7) ^ b4;
                if (i8 < 0) {
                    j4 = i8 ^ (-128);
                } else {
                    int i9 = i4 + 3;
                    int i10 = (bArr[i7] << 14) ^ i8;
                    if (i10 >= 0) {
                        j4 = i10 ^ 16256;
                        i7 = i9;
                    } else {
                        int i11 = i4 + 4;
                        int i12 = i10 ^ (bArr[i9] << 21);
                        if (i12 < 0) {
                            long j7 = (-2080896) ^ i12;
                            i7 = i11;
                            j4 = j7;
                        } else {
                            long j8 = i12;
                            i7 = i4 + 5;
                            long j9 = j8 ^ (((long) bArr[i11]) << 28);
                            if (j9 >= 0) {
                                j6 = 266354560;
                            } else {
                                int i13 = i4 + 6;
                                long j10 = j9 ^ (((long) bArr[i7]) << 35);
                                if (j10 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i7 = i4 + 7;
                                    j9 = j10 ^ (((long) bArr[i13]) << 42);
                                    if (j9 >= 0) {
                                        j6 = 4363953127296L;
                                    } else {
                                        i13 = i4 + 8;
                                        j10 = j9 ^ (((long) bArr[i7]) << 49);
                                        if (j10 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i7 = i4 + 9;
                                            long j11 = (j10 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                int i14 = i4 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i7 = i14;
                                                }
                                            }
                                            j4 = j11;
                                        }
                                    }
                                }
                                j4 = j10 ^ j5;
                                i7 = i13;
                            }
                            j4 = j9 ^ j6;
                        }
                    }
                }
                this.zzh = i7;
                return j4;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i4 = this.zzf + this.zzg;
        this.zzf = i4;
        int i5 = this.zzj + i4;
        int i6 = this.zzk;
        if (i5 <= i6) {
            this.zzg = 0;
            return;
        }
        int i7 = i5 - i6;
        this.zzg = i7;
        this.zzf = i4 - i7;
    }

    private final byte zzy() throws zzalf {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i4 = this.zzh;
        this.zzh = i4 + 1;
        return bArr[i4];
    }

    private final int zzz() throws zzalf {
        int i4 = this.zzh;
        if (this.zzf - i4 < 4) {
            zzg(4);
            i4 = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i4 + 4;
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final double zza() {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final float zzb() {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzc() {
        return this.zzj + this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzd() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zze() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzf() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzg() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzh() {
        return zzakb.zze(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzi() throws zzalf {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int iZzaa = zzaa();
        this.zzi = iZzaa;
        if ((iZzaa >>> 3) != 0) {
            return iZzaa;
        }
        throw zzalf.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzj() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzk() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzl() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzm() throws zzalf {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            byte bZzy = zzy();
            j4 |= ((long) (bZzy & 127)) << i4;
            if ((bZzy & 128) == 0) {
                return j4;
            }
        }
        throw zzalf.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzn() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzo() {
        return zzakb.zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzp() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final zzajp zzq() throws IOException {
        int iZzaa = zzaa();
        int i4 = this.zzf;
        int i5 = this.zzh;
        if (iZzaa <= i4 - i5 && iZzaa > 0) {
            zzajp zzajpVarZza = zzajp.zza(this.zze, i5, iZzaa);
            this.zzh += iZzaa;
            return zzajpVarZza;
        }
        if (iZzaa == 0) {
            return zzajp.zza;
        }
        if (iZzaa < 0) {
            throw zzalf.zzf();
        }
        byte[] bArrZzj = zzj(iZzaa);
        if (bArrZzj != null) {
            return zzajp.zza(bArrZzj);
        }
        int i6 = this.zzh;
        int i7 = this.zzf;
        int length = i7 - i6;
        this.zzj += i7;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(iZzaa - length);
        byte[] bArr = new byte[iZzaa];
        System.arraycopy(this.zze, i6, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzajp.zzb(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzr() throws zzalf {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (iZzaa <= i4 - i5) {
                String str = new String(this.zze, i5, iZzaa, zzalb.zza);
                this.zzh += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzalf.zzf();
        }
        if (iZzaa > this.zzf) {
            return new String(zza(iZzaa, false), zzalb.zza);
        }
        zzg(iZzaa);
        String str2 = new String(this.zze, this.zzh, iZzaa, zzalb.zza);
        this.zzh += iZzaa;
        return str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzs() throws IOException {
        byte[] bArrZza;
        int iZzaa = zzaa();
        int i4 = this.zzh;
        int i5 = this.zzf;
        if (iZzaa <= i5 - i4 && iZzaa > 0) {
            bArrZza = this.zze;
            this.zzh = i4 + iZzaa;
        } else {
            if (iZzaa == 0) {
                return "";
            }
            if (iZzaa < 0) {
                throw zzalf.zzf();
            }
            i4 = 0;
            if (iZzaa <= i5) {
                zzg(iZzaa);
                bArrZza = this.zze;
                this.zzh = iZzaa;
            } else {
                bArrZza = zza(iZzaa, false);
            }
        }
        return zzant.zzb(bArrZza, i4, iZzaa);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzt() {
        return this.zzh == this.zzf && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzu() {
        return zzac() != 0;
    }

    private zzakd(InputStream inputStream, int i4) {
        super();
        this.zzk = Integer.MAX_VALUE;
        zzalb.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    private static int zza(InputStream inputStream) throws zzalf {
        try {
            return inputStream.available();
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private final List<byte[]> zzf(int i4) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i4 > 0) {
            int iMin = Math.min(i4, 4096);
            byte[] bArr = new byte[iMin];
            int i5 = 0;
            while (i5 < iMin) {
                int i6 = this.zzd.read(bArr, i5, iMin - i5);
                if (i6 == -1) {
                    throw zzalf.zzj();
                }
                this.zzj += i6;
                i5 += i6;
            }
            i4 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i4) throws zzalf {
        if (zzi(i4)) {
            return;
        }
        if (i4 <= (this.zzb - this.zzj) - this.zzh) {
            throw zzalf.zzj();
        }
        throw zzalf.zzi();
    }

    private final void zzh(int i4) throws zzalf {
        int i5 = this.zzf;
        int i6 = this.zzh;
        if (i4 <= i5 - i6 && i4 >= 0) {
            this.zzh = i6 + i4;
            return;
        }
        if (i4 < 0) {
            throw zzalf.zzf();
        }
        int i7 = this.zzj;
        int i8 = i7 + i6 + i4;
        int i9 = this.zzk;
        if (i8 > i9) {
            zzh((i9 - i7) - i6);
            throw zzalf.zzj();
        }
        this.zzj = i7 + i6;
        int i10 = i5 - i6;
        this.zzf = 0;
        this.zzh = 0;
        while (i10 < i4) {
            try {
                long j4 = i4 - i10;
                long jZza = zza(this.zzd, j4);
                if (jZza >= 0 && jZza <= j4) {
                    if (jZza == 0) {
                        break;
                    } else {
                        i10 += (int) jZza;
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + jZza + "\nThe InputStream implementation is buggy.");
                }
            } finally {
                this.zzj += i10;
                zzad();
            }
        }
        if (i10 >= i4) {
            return;
        }
        int i11 = this.zzf;
        int i12 = i11 - this.zzh;
        this.zzh = i11;
        zzg(1);
        while (true) {
            int i13 = i4 - i12;
            int i14 = this.zzf;
            if (i13 <= i14) {
                this.zzh = i13;
                return;
            } else {
                i12 += i14;
                this.zzh = i14;
                zzg(1);
            }
        }
    }

    private final byte[] zzj(int i4) throws zzalf {
        if (i4 == 0) {
            return zzalb.zzb;
        }
        if (i4 < 0) {
            throw zzalf.zzf();
        }
        int i5 = this.zzj;
        int i6 = this.zzh;
        int i7 = i5 + i6 + i4;
        if (i7 - this.zzb > 0) {
            throw zzalf.zzi();
        }
        int i8 = this.zzk;
        if (i7 > i8) {
            zzh((i8 - i5) - i6);
            throw zzalf.zzj();
        }
        int i9 = this.zzf - i6;
        int i10 = i4 - i9;
        if (i10 >= 4096 && i10 > zza(this.zzd)) {
            return null;
        }
        byte[] bArr = new byte[i4];
        System.arraycopy(this.zze, this.zzh, bArr, 0, i9);
        this.zzj += this.zzf;
        this.zzh = 0;
        this.zzf = 0;
        while (i9 < i4) {
            int iZza = zza(this.zzd, bArr, i9, i4 - i9);
            if (iZza == -1) {
                throw zzalf.zzj();
            }
            this.zzj += iZza;
            i9 += iZza;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzb(int i4) throws zzalf {
        if (this.zzi != i4) {
            throw zzalf.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzc(int i4) {
        this.zzk = i4;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzd(int i4) throws zzalf {
        int i5 = i4 & 7;
        int i6 = 0;
        if (i5 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i6 < 10) {
                    if (zzy() < 0) {
                        i6++;
                    }
                }
                throw zzalf.zze();
            }
            while (i6 < 10) {
                byte[] bArr = this.zze;
                int i7 = this.zzh;
                this.zzh = i7 + 1;
                if (bArr[i7] < 0) {
                    i6++;
                }
            }
            throw zzalf.zze();
            return true;
        }
        if (i5 == 1) {
            zzh(8);
            return true;
        }
        if (i5 == 2) {
            zzh(zzaa());
            return true;
        }
        if (i5 == 3) {
            zzx();
            zzb(((i4 >>> 3) << 3) | 4);
            return true;
        }
        if (i5 == 4) {
            zzw();
            return false;
        }
        if (i5 != 5) {
            throw zzalf.zza();
        }
        zzh(4);
        return true;
    }

    private final boolean zzi(int i4) throws zzalf {
        do {
            int i5 = this.zzh;
            int i6 = i5 + i4;
            int i7 = this.zzf;
            if (i6 > i7) {
                int i8 = this.zzb;
                int i9 = this.zzj;
                if (i4 > (i8 - i9) - i5 || i9 + i5 + i4 > this.zzk) {
                    return false;
                }
                if (i5 > 0) {
                    if (i7 > i5) {
                        byte[] bArr = this.zze;
                        System.arraycopy(bArr, i5, bArr, 0, i7 - i5);
                    }
                    this.zzj += i5;
                    this.zzf -= i5;
                    this.zzh = 0;
                }
                InputStream inputStream = this.zzd;
                byte[] bArr2 = this.zze;
                int i10 = this.zzf;
                int iZza = zza(inputStream, bArr2, i10, Math.min(bArr2.length - i10, (this.zzb - this.zzj) - i10));
                if (iZza == 0 || iZza < -1 || iZza > this.zze.length) {
                    throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + iZza + "\nThe InputStream implementation is buggy.");
                }
                if (iZza <= 0) {
                    return false;
                }
                this.zzf += iZza;
                zzad();
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
            }
        } while (this.zzf < i4);
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza(int i4) throws zzalf {
        if (i4 >= 0) {
            int i5 = i4 + this.zzj + this.zzh;
            if (i5 >= 0) {
                int i6 = this.zzk;
                if (i5 <= i6) {
                    this.zzk = i5;
                    zzad();
                    return i6;
                }
                throw zzalf.zzj();
            }
            throw zzalf.zzi();
        }
        throw zzalf.zzf();
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i4, int i5) throws zzalf {
        try {
            return inputStream.read(bArr, i4, i5);
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private static long zza(InputStream inputStream, long j4) throws zzalf {
        try {
            return inputStream.skip(j4);
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private final byte[] zza(int i4, boolean z4) throws IOException {
        byte[] bArrZzj = zzj(i4);
        if (bArrZzj != null) {
            return bArrZzj;
        }
        int i5 = this.zzh;
        int i6 = this.zzf;
        int length = i6 - i5;
        this.zzj += i6;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(i4 - length);
        byte[] bArr = new byte[i4];
        System.arraycopy(this.zze, i5, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
