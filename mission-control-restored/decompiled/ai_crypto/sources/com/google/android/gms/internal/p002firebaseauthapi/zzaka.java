package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
final class zzaka extends zzakb {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() {
        int i7;
        int i8 = this.zzg;
        int i9 = this.zze;
        if (i9 != i8) {
            byte[] bArr = this.zzd;
            int i10 = i8 + 1;
            byte b7 = bArr[i8];
            if (b7 >= 0) {
                this.zzg = i10;
                return b7;
            }
            if (i9 - i10 >= 9) {
                int i11 = i8 + 2;
                int i12 = (bArr[i10] << 7) ^ b7;
                if (i12 < 0) {
                    i7 = i12 ^ (-128);
                } else {
                    int i13 = i8 + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        i7 = i14 ^ 16256;
                    } else {
                        int i15 = i8 + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            i7 = (-2080896) ^ i16;
                        } else {
                            i13 = i8 + 5;
                            byte b8 = bArr[i15];
                            int i17 = (i16 ^ (b8 << 28)) ^ 266354560;
                            if (b8 < 0) {
                                i15 = i8 + 6;
                                if (bArr[i13] < 0) {
                                    i13 = i8 + 7;
                                    if (bArr[i15] < 0) {
                                        i15 = i8 + 8;
                                        if (bArr[i13] < 0) {
                                            i13 = i8 + 9;
                                            if (bArr[i15] < 0) {
                                                int i18 = i8 + 10;
                                                if (bArr[i13] >= 0) {
                                                    i11 = i18;
                                                    i7 = i17;
                                                }
                                            }
                                        }
                                    }
                                }
                                i7 = i17;
                            }
                            i7 = i17;
                        }
                        i11 = i15;
                    }
                    i11 = i13;
                }
                this.zzg = i11;
                return i7;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws zzalf {
        int i7 = this.zzg;
        if (this.zze - i7 < 8) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i7 + 8;
        return ((((long) bArr[i7 + 7]) & 255) << 56) | (((long) bArr[i7]) & 255) | ((((long) bArr[i7 + 1]) & 255) << 8) | ((((long) bArr[i7 + 2]) & 255) << 16) | ((((long) bArr[i7 + 3]) & 255) << 24) | ((((long) bArr[i7 + 4]) & 255) << 32) | ((((long) bArr[i7 + 5]) & 255) << 40) | ((((long) bArr[i7 + 6]) & 255) << 48);
    }

    private final long zzac() {
        long j7;
        long j8;
        long j9;
        int i7 = this.zzg;
        int i8 = this.zze;
        if (i8 != i7) {
            byte[] bArr = this.zzd;
            int i9 = i7 + 1;
            byte b7 = bArr[i7];
            if (b7 >= 0) {
                this.zzg = i9;
                return b7;
            }
            if (i8 - i9 >= 9) {
                int i10 = i7 + 2;
                int i11 = (bArr[i9] << 7) ^ b7;
                if (i11 < 0) {
                    j7 = i11 ^ (-128);
                } else {
                    int i12 = i7 + 3;
                    int i13 = (bArr[i10] << 14) ^ i11;
                    if (i13 >= 0) {
                        j7 = i13 ^ 16256;
                        i10 = i12;
                    } else {
                        int i14 = i7 + 4;
                        int i15 = i13 ^ (bArr[i12] << 21);
                        if (i15 < 0) {
                            long j10 = (-2080896) ^ i15;
                            i10 = i14;
                            j7 = j10;
                        } else {
                            long j11 = i15;
                            i10 = i7 + 5;
                            long j12 = j11 ^ (((long) bArr[i14]) << 28);
                            if (j12 >= 0) {
                                j9 = 266354560;
                            } else {
                                int i16 = i7 + 6;
                                long j13 = j12 ^ (((long) bArr[i10]) << 35);
                                if (j13 < 0) {
                                    j8 = -34093383808L;
                                } else {
                                    i10 = i7 + 7;
                                    j12 = j13 ^ (((long) bArr[i16]) << 42);
                                    if (j12 >= 0) {
                                        j9 = 4363953127296L;
                                    } else {
                                        i16 = i7 + 8;
                                        j13 = j12 ^ (((long) bArr[i10]) << 49);
                                        if (j13 < 0) {
                                            j8 = -558586000294016L;
                                        } else {
                                            i10 = i7 + 9;
                                            long j14 = (j13 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j14 < 0) {
                                                int i17 = i7 + 10;
                                                if (bArr[i10] >= 0) {
                                                    i10 = i17;
                                                }
                                            }
                                            j7 = j14;
                                        }
                                    }
                                }
                                j7 = j13 ^ j8;
                                i10 = i16;
                            }
                            j7 = j12 ^ j9;
                        }
                    }
                }
                this.zzg = i10;
                return j7;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i7 = this.zze + this.zzf;
        this.zze = i7;
        int i8 = i7 - this.zzh;
        int i9 = this.zzj;
        if (i8 <= i9) {
            this.zzf = 0;
            return;
        }
        int i10 = i8 - i9;
        this.zzf = i10;
        this.zze = i7 - i10;
    }

    private final byte zzy() throws zzalf {
        int i7 = this.zzg;
        if (i7 == this.zze) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i7 + 1;
        return bArr[i7];
    }

    private final int zzz() throws zzalf {
        int i7 = this.zzg;
        if (this.zze - i7 < 4) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i7 + 4;
        return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
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
        return this.zzg - this.zzh;
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
        long j7 = 0;
        for (int i7 = 0; i7 < 64; i7 += 7) {
            byte bZzy = zzy();
            j7 |= ((long) (bZzy & 127)) << i7;
            if ((bZzy & 128) == 0) {
                return j7;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzajp zzq() throws com.google.android.gms.internal.p002firebaseauthapi.zzalf {
        /*
            r3 = this;
            int r0 = r3.zzaa()
            if (r0 <= 0) goto L19
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.firebase-auth-api.zzajp r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zza(r1, r2, r0)
            int r2 = r3.zzg
            int r2 = r2 + r0
            r3.zzg = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase-auth-api.zzajp r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zza
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
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalb.zzb
        L37:
            com.google.android.gms.internal.firebase-auth-api.zzajp r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzj()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzq():com.google.android.gms.internal.firebase-auth-api.zzajp");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzr() throws zzalf {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i7 = this.zze;
            int i8 = this.zzg;
            if (iZzaa <= i7 - i8) {
                String str = new String(this.zzd, i8, iZzaa, zzalb.zza);
                this.zzg += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzs() throws zzalf {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i7 = this.zze;
            int i8 = this.zzg;
            if (iZzaa <= i7 - i8) {
                String strZzb = zzant.zzb(this.zzd, i8, iZzaa);
                this.zzg += iZzaa;
                return strZzb;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa <= 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzt() {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzu() {
        return zzac() != 0;
    }

    private zzaka(byte[] bArr, int i7, int i8, boolean z7) {
        super();
        this.zzj = a.e.API_PRIORITY_OTHER;
        this.zzd = bArr;
        this.zze = i8 + i7;
        this.zzg = i7;
        this.zzh = i7;
    }

    private final void zzf(int i7) throws zzalf {
        if (i7 >= 0) {
            int i8 = this.zze;
            int i9 = this.zzg;
            if (i7 <= i8 - i9) {
                this.zzg = i9 + i7;
                return;
            }
        }
        if (i7 >= 0) {
            throw zzalf.zzj();
        }
        throw zzalf.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza(int i7) throws zzalf {
        if (i7 < 0) {
            throw zzalf.zzf();
        }
        int iZzc = i7 + zzc();
        if (iZzc < 0) {
            throw zzalf.zzi();
        }
        int i8 = this.zzj;
        if (iZzc > i8) {
            throw zzalf.zzj();
        }
        this.zzj = iZzc;
        zzad();
        return i8;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzb(int i7) throws zzalf {
        if (this.zzi != i7) {
            throw zzalf.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzc(int i7) {
        this.zzj = i7;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzd(int i7) throws zzalf {
        int i8 = i7 & 7;
        int i9 = 0;
        if (i8 == 0) {
            if (this.zze - this.zzg < 10) {
                while (i9 < 10) {
                    if (zzy() < 0) {
                        i9++;
                    }
                }
                throw zzalf.zze();
            }
            while (i9 < 10) {
                byte[] bArr = this.zzd;
                int i10 = this.zzg;
                this.zzg = i10 + 1;
                if (bArr[i10] < 0) {
                    i9++;
                }
            }
            throw zzalf.zze();
            return true;
        }
        if (i8 == 1) {
            zzf(8);
            return true;
        }
        if (i8 == 2) {
            zzf(zzaa());
            return true;
        }
        if (i8 == 3) {
            zzx();
            zzb(((i7 >>> 3) << 3) | 4);
            return true;
        }
        if (i8 == 4) {
            zzw();
            return false;
        }
        if (i8 != 5) {
            throw zzalf.zza();
        }
        zzf(4);
        return true;
    }
}
