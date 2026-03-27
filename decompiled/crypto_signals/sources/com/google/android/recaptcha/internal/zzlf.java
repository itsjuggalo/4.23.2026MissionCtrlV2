package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.f;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzlf extends zzli {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    public /* synthetic */ zzlf(byte[] bArr, int i, int i6, boolean z6, zzlh zzlhVar) {
        super(null);
        this.zzj = f.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
    }

    private final void zzJ() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i6 = this.zzj;
        if (i <= i6) {
            this.zzg = 0;
            return;
        }
        int i7 = i - i6;
        this.zzg = i7;
        this.zzf = i - i7;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzA(int i) {
        this.zzj = i;
        zzJ();
    }

    public final void zzB(int i) throws zznn {
        if (i >= 0) {
            int i6 = this.zzf;
            int i7 = this.zzh;
            if (i <= i6 - i7) {
                this.zzh = i7 + i;
                return;
            }
        }
        if (i >= 0) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzC() {
        return this.zzh == this.zzf;
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
            if (this.zzf - this.zzh < 10) {
                while (i7 < 10) {
                    if (zza() < 0) {
                        i7++;
                    }
                }
                throw new zznn("CodedInputStream encountered a malformed varint.");
            }
            while (i7 < 10) {
                byte[] bArr = this.zze;
                int i8 = this.zzh;
                this.zzh = i8 + 1;
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
        int i = this.zzh;
        if (i == this.zzf) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zze;
        this.zzh = i + 1;
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
        return this.zzh;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zze(int i) {
        if (i < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = i + this.zzh;
        if (i6 < 0) {
            throw new zznn("Failed to parse the message.");
        }
        int i7 = this.zzj;
        if (i6 > i7) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzj = i6;
        zzJ();
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
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        int i6 = bArr[i] & 255;
        int i7 = bArr[i + 1] & 255;
        int i8 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public final int zzj() {
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
            this.zzi = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzi = iZzj;
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
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        long j4 = bArr[i];
        long j6 = (((long) bArr[i + 1]) & 255) << 8;
        long j7 = bArr[i + 2];
        long j8 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j4 & 255) | j6 | ((j7 & 255) << 16) | ((j8 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final long zzr() {
        long j4;
        long j6;
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
                this.zzh = i8;
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
    public final zzle zzw() throws zznn {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzf;
            int i6 = this.zzh;
            if (iZzj <= i - i6) {
                zzle zzleVarZzk = zzle.zzk(this.zze, i6, iZzj);
                this.zzh += iZzj;
                return zzleVarZzk;
            }
        }
        if (iZzj == 0) {
            return zzle.zzb;
        }
        if (iZzj > 0) {
            int i7 = this.zzf;
            int i8 = this.zzh;
            if (iZzj <= i7 - i8) {
                int i9 = iZzj + i8;
                this.zzh = i9;
                return new zzlc(Arrays.copyOfRange(this.zze, i8, i9));
            }
        }
        if (iZzj <= 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzx() throws zznn {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzf;
            int i6 = this.zzh;
            if (iZzj <= i - i6) {
                String str = new String(this.zze, i6, iZzj, zznl.zza);
                this.zzh += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzy() throws zznn {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzf;
            int i6 = this.zzh;
            if (iZzj <= i - i6) {
                String strZzd = zzpv.zzd(this.zze, i6, iZzj);
                this.zzh += iZzj;
                return strZzd;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj <= 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzz(int i) throws zznn {
        if (this.zzi != i) {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
    }
}
