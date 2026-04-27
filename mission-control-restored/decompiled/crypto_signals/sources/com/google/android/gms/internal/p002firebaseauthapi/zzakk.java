package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.f;

/* JADX INFO: loaded from: classes.dex */
final class zzakk extends zzakh {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() {
        int i;
        int i6 = this.zzg;
        int i7 = this.zze;
        if (i7 != i6) {
            byte[] bArr = this.zzd;
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                this.zzg = i8;
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
                this.zzg = i9;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws zzall {
        int i = this.zzg;
        if (this.zze - i < 8) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzac() {
        long j4;
        long j6;
        long j7;
        int i = this.zzg;
        int i6 = this.zze;
        if (i6 != i) {
            byte[] bArr = this.zzd;
            int i7 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzg = i7;
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
                this.zzg = i8;
                return j4;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i6 = i - this.zzh;
        int i7 = this.zzj;
        if (i6 <= i7) {
            this.zzf = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzf = i8;
        this.zze = i - i8;
    }

    private final byte zzy() throws zzall {
        int i = this.zzg;
        if (i == this.zze) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 1;
        return bArr[i];
    }

    private final int zzz() throws zzall {
        int i = this.zzg;
        if (this.zze - i < 4) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
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
        return this.zzg - this.zzh;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzajv zzq() throws com.google.android.gms.internal.p002firebaseauthapi.zzall {
        /*
            r3 = this;
            int r0 = r3.zzaa()
            if (r0 <= 0) goto L19
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.firebase-auth-api.zzajv r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza(r1, r2, r0)
            int r2 = r3.zzg
            int r2 = r2 + r0
            r3.zzg = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzg = r0
            byte[] r1 = r3.zzd
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zzb
        L37:
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase-auth-api.zzall r0 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.firebase-auth-api.zzall r0 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakk.zzq():com.google.android.gms.internal.firebase-auth-api.zzajv");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzr() throws zzall {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i = this.zze;
            int i6 = this.zzg;
            if (iZzaa <= i - i6) {
                String str = new String(this.zzd, i6, iZzaa, zzalh.zza);
                this.zzg += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        throw zzall.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzs() throws zzall {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i = this.zze;
            int i6 = this.zzg;
            if (iZzaa <= i - i6) {
                String strZzb = zzaoa.zzb(this.zzd, i6, iZzaa);
                this.zzg += iZzaa;
                return strZzb;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa <= 0) {
            throw zzall.zzf();
        }
        throw zzall.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzw() {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzx() {
        return zzac() != 0;
    }

    private zzakk(byte[] bArr, int i, int i6, boolean z6) {
        super();
        this.zzj = f.API_PRIORITY_OTHER;
        this.zzd = bArr;
        this.zze = i6 + i;
        this.zzg = i;
        this.zzh = i;
    }

    private final void zzf(int i) throws zzall {
        if (i >= 0) {
            int i6 = this.zze;
            int i7 = this.zzg;
            if (i <= i6 - i7) {
                this.zzg = i7 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzall.zzj();
        }
        throw zzall.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzb(int i) throws zzall {
        if (i < 0) {
            throw zzall.zzf();
        }
        int iZzc = i + zzc();
        if (iZzc < 0) {
            throw zzall.zzi();
        }
        int i6 = this.zzj;
        if (iZzc > i6) {
            throw zzall.zzj();
        }
        this.zzj = iZzc;
        zzad();
        return i6;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzc(int i) throws zzall {
        if (this.zzi != i) {
            throw zzall.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzd(int i) {
        this.zzj = i;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zze(int i) throws zzall {
        int i6 = i & 7;
        int i7 = 0;
        if (i6 == 0) {
            if (this.zze - this.zzg < 10) {
                while (i7 < 10) {
                    if (zzy() < 0) {
                        i7++;
                    }
                }
                throw zzall.zze();
            }
            while (i7 < 10) {
                byte[] bArr = this.zzd;
                int i8 = this.zzg;
                this.zzg = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw zzall.zze();
            return true;
        }
        if (i6 == 1) {
            zzf(8);
            return true;
        }
        if (i6 == 2) {
            zzf(zzaa());
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
        zzf(4);
        return true;
    }
}
