package com.google.android.recaptcha.internal;

import a3.d;
import com.google.android.gms.common.api.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzlg extends zzli {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzlg(InputStream inputStream, int i, zzlh zzlhVar) {
        super(null);
        this.zzl = f.API_PRIORITY_OTHER;
        byte[] bArr = zznl.zzb;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzJ(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i6 = 0;
            while (i6 < iMin) {
                int i7 = this.zze.read(bArr, i6, iMin - i6);
                if (i7 == -1) {
                    throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i7;
                i6 += i7;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzK() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i6 = this.zzk + i;
        int i7 = this.zzl;
        if (i6 <= i7) {
            this.zzh = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzh = i8;
        this.zzg = i - i8;
    }

    private final void zzL(int i) throws zznn {
        if (zzM(i)) {
            return;
        }
        if (i <= (f.API_PRIORITY_OTHER - this.zzk) - this.zzi) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zznn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    private final boolean zzM(int i) throws IOException {
        int i6 = this.zzi;
        int i7 = i6 + i;
        int i8 = this.zzg;
        if (i7 <= i8) {
            throw new IllegalStateException(d.i("refillBuffer() called when ", i, " bytes were already available in buffer"));
        }
        int i9 = this.zzk;
        if (i > (f.API_PRIORITY_OTHER - i9) - i6 || i9 + i6 + i > this.zzl) {
            return false;
        }
        if (i6 > 0) {
            if (i8 > i6) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
            }
            i9 = this.zzk + i6;
            this.zzk = i9;
            i8 = this.zzg - i6;
            this.zzg = i8;
            this.zzi = 0;
        }
        try {
            int i10 = this.zze.read(this.zzf, i8, Math.min(4096 - i8, (f.API_PRIORITY_OTHER - i9) - i8));
            if (i10 == 0 || i10 < -1 || i10 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + i10 + "\nThe InputStream implementation is buggy.");
            }
            if (i10 <= 0) {
                return false;
            }
            this.zzg += i10;
            zzK();
            if (this.zzg >= i) {
                return true;
            }
            return zzM(i);
        } catch (zznn e) {
            e.zza();
            throw e;
        }
    }

    private final byte[] zzN(int i, boolean z6) throws IOException {
        byte[] bArrZzO = zzO(i);
        if (bArrZzO != null) {
            return bArrZzO;
        }
        int i6 = this.zzi;
        int i7 = this.zzg;
        int i8 = i7 - i6;
        this.zzk += i7;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzJ = zzJ(i - i8);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i6, bArr, 0, i8);
        for (byte[] bArr2 : listZzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i8, length);
            i8 += length;
        }
        return bArr;
    }

    private final byte[] zzO(int i) throws IOException {
        if (i == 0) {
            return zznl.zzb;
        }
        int i6 = this.zzk;
        int i7 = this.zzi;
        int i8 = i6 + i7 + i;
        if ((-2147483647) + i8 > 0) {
            throw new zznn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i9 = this.zzl;
        if (i8 > i9) {
            zzB((i9 - i6) - i7);
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i10 = this.zzg - i7;
        int i11 = i - i10;
        if (i11 >= 4096) {
            try {
                if (i11 > this.zze.available()) {
                    return null;
                }
            } catch (zznn e) {
                e.zza();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i10);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i10 < i) {
            try {
                int i12 = this.zze.read(bArr, i10, i - i10);
                if (i12 == -1) {
                    throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i12;
                i10 += i12;
            } catch (zznn e2) {
                e2.zza();
                throw e2;
            }
        }
        return bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzA(int i) {
        this.zzl = i;
        zzK();
    }

    public final void zzB(int i) throws zznn {
        int i6 = this.zzg;
        int i7 = this.zzi;
        int i8 = i6 - i7;
        if (i <= i8 && i >= 0) {
            this.zzi = i7 + i;
            return;
        }
        if (i < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i9 = this.zzk;
        int i10 = i9 + i7;
        int i11 = this.zzl;
        if (i10 + i > i11) {
            zzB((i11 - i9) - i7);
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = i10;
        this.zzg = 0;
        this.zzi = 0;
        while (i8 < i) {
            try {
                long j4 = i - i8;
                try {
                    long jSkip = this.zze.skip(j4);
                    if (jSkip < 0 || jSkip > j4) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i8 += (int) jSkip;
                    }
                } catch (zznn e) {
                    e.zza();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzk += i8;
                zzK();
                throw th;
            }
        }
        this.zzk += i8;
        zzK();
        if (i8 >= i) {
            return;
        }
        int i12 = this.zzg;
        int i13 = i12 - this.zzi;
        this.zzi = i12;
        zzL(1);
        while (true) {
            int i14 = i - i13;
            int i15 = this.zzg;
            if (i14 <= i15) {
                this.zzi = i14;
                return;
            } else {
                i13 += i15;
                this.zzi = i15;
                zzL(1);
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzC() {
        return this.zzi == this.zzg && !zzM(1);
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzD() {
        return zzr() != 0;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzE(int i) throws zznn {
        int i6 = i & 7;
        int i7 = 0;
        if (i6 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i7 < 10) {
                    if (zza() < 0) {
                        i7++;
                    }
                }
                throw new zznn("CodedInputStream encountered a malformed varint.");
            }
            while (i7 < 10) {
                byte[] bArr = this.zzf;
                int i8 = this.zzi;
                this.zzi = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw new zznn("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i6 == 1) {
            zzB(8);
            return true;
        }
        if (i6 == 2) {
            zzB(zzj());
            return true;
        }
        if (i6 == 3) {
            zzI();
            zzz(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i6 == 4) {
            return false;
        }
        if (i6 != 5) {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
        zzB(4);
        return true;
    }

    public final byte zza() throws zznn {
        if (this.zzi == this.zzg) {
            zzL(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final double zzb() {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final float zzc() {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zze(int i) throws zznn {
        if (i < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = this.zzk + this.zzi + i;
        if (i6 < 0) {
            throw new zznn("Failed to parse the message.");
        }
        int i7 = this.zzl;
        if (i6 > i7) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i6;
        zzK();
        return i7;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzf() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzg() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzh() {
        return zzj();
    }

    public final int zzi() throws zznn {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzL(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i6 = bArr[i] & 255;
        int i7 = bArr[i + 1] & 255;
        int i8 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public final int zzj() {
        int i;
        int i6 = this.zzi;
        int i7 = this.zzg;
        if (i7 != i6) {
            byte[] bArr = this.zzf;
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                this.zzi = i8;
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
                this.zzi = i9;
                return i;
            }
        }
        return (int) zzs();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzk() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzl() {
        return zzli.zzF(zzj());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzm() throws zznn {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzj = iZzj;
        if ((iZzj >>> 3) != 0) {
            return iZzj;
        }
        throw new zznn("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzn() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzo() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzp() {
        return zzr();
    }

    public final long zzq() throws zznn {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzL(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j4 = bArr[i];
        long j6 = (((long) bArr[i + 1]) & 255) << 8;
        long j7 = bArr[i + 2];
        long j8 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j4 & 255) | j6 | ((j7 & 255) << 16) | ((j8 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final long zzr() {
        long j4;
        long j6;
        int i = this.zzi;
        int i6 = this.zzg;
        if (i6 != i) {
            byte[] bArr = this.zzf;
            int i7 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzi = i7;
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
                    } else {
                        int i12 = i + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            long j7 = (-2080896) ^ i13;
                            i8 = i12;
                            j4 = j7;
                        } else {
                            i10 = i + 5;
                            long j8 = (((long) bArr[i12]) << 28) ^ ((long) i13);
                            if (j8 >= 0) {
                                j4 = j8 ^ 266354560;
                            } else {
                                i8 = i + 6;
                                long j9 = (((long) bArr[i10]) << 35) ^ j8;
                                if (j9 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    int i14 = i + 7;
                                    long j10 = j9 ^ (((long) bArr[i8]) << 42);
                                    if (j10 >= 0) {
                                        j4 = j10 ^ 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j9 = j10 ^ (((long) bArr[i14]) << 49);
                                        if (j9 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i14 = i + 9;
                                            long j11 = (j9 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                i8 = i + 10;
                                                if (bArr[i14] >= 0) {
                                                    j4 = j11;
                                                }
                                            } else {
                                                j4 = j11;
                                            }
                                        }
                                    }
                                    i8 = i14;
                                }
                                j4 = j9 ^ j6;
                            }
                        }
                    }
                    i8 = i10;
                }
                this.zzi = i8;
                return j4;
            }
        }
        return zzs();
    }

    public final long zzs() throws zznn {
        long j4 = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZza = zza();
            j4 |= ((long) (bZza & 127)) << i;
            if ((bZza & 128) == 0) {
                return j4;
            }
        }
        throw new zznn("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzt() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzu() {
        return zzli.zzG(zzr());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzv() {
        return zzr();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final zzle zzw() throws IOException {
        int iZzj = zzj();
        int i = this.zzg;
        int i6 = this.zzi;
        if (iZzj <= i - i6 && iZzj > 0) {
            zzle zzleVarZzk = zzle.zzk(this.zzf, i6, iZzj);
            this.zzi += iZzj;
            return zzleVarZzk;
        }
        if (iZzj == 0) {
            return zzle.zzb;
        }
        if (iZzj < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzO = zzO(iZzj);
        if (bArrZzO != null) {
            return zzle.zzk(bArrZzO, 0, bArrZzO.length);
        }
        int i7 = this.zzi;
        int i8 = this.zzg;
        int i9 = i8 - i7;
        this.zzk += i8;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzJ = zzJ(iZzj - i9);
        byte[] bArr = new byte[iZzj];
        System.arraycopy(this.zzf, i7, bArr, 0, i9);
        for (byte[] bArr2 : listZzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i9, length);
            i9 += length;
        }
        return new zzlc(bArr);
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzx() throws zznn {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzg;
            int i6 = this.zzi;
            if (iZzj <= i - i6) {
                String str = new String(this.zzf, i6, iZzj, zznl.zza);
                this.zzi += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iZzj > this.zzg) {
            return new String(zzN(iZzj, false), zznl.zza);
        }
        zzL(iZzj);
        String str2 = new String(this.zzf, this.zzi, iZzj, zznl.zza);
        this.zzi += iZzj;
        return str2;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzy() throws IOException {
        byte[] bArrZzN;
        int iZzj = zzj();
        int i = this.zzi;
        int i6 = this.zzg;
        if (iZzj <= i6 - i && iZzj > 0) {
            bArrZzN = this.zzf;
            this.zzi = i + iZzj;
        } else {
            if (iZzj == 0) {
                return "";
            }
            if (iZzj < 0) {
                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (iZzj <= i6) {
                zzL(iZzj);
                bArrZzN = this.zzf;
                this.zzi = iZzj;
            } else {
                bArrZzN = zzN(iZzj, false);
            }
        }
        return zzpv.zzd(bArrZzN, i, iZzj);
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzz(int i) throws zznn {
        if (this.zzj != i) {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
    }
}
